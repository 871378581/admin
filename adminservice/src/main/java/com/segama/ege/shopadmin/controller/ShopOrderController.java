package com.segama.ege.shopadmin.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.ServiceOrderVO;
import com.segama.ege.domain.ServiceOrderStatus;
import com.segama.ege.dto.BaseResult;
import com.segama.ege.dto.CancelOrderRequestDTO;
import com.segama.ege.dto.ShopConfirmOrderRequestDTO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import com.segama.ege.service.WxOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description 门店订单相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/shop_admin/order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopOrderController {
    @Resource
    private ServiceOrderMapper serviceOrderMapper;

    @Autowired
    private WxOrderService orderService;

    private static Logger LOG = LoggerFactory.getLogger(ShopOrderController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("shopId") Long shopId
            ,@RequestParam("status") String status
            ,@RequestParam("carCode") String carCode
            ,@RequestParam("user_name") String user_name
            ,@RequestParam("gmt_create") String gmt_create
            ,@RequestParam(value = "order_type",defaultValue = "") Integer order_type
            ,@RequestParam(value = "settle",required = false) Integer settle
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ServiceOrderExample example = new ServiceOrderExample();
            ServiceOrderExample.Criteria exampleCriteria = example.createCriteria();
            if(shopId==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }

                if(order_type!=null){
                    exampleCriteria.andOrder_typeEqualTo(order_type);
                }
            if(!StringUtils.isEmpty(gmt_create)) {
                String[] hours = gmt_create.split(" - ");
                String time_start_str = hours[0];
                String time_end_str = hours[1];
                Date time_start = DateUtils.parseDate(time_start_str, DateUtil.YYYY_MM_DD_HH_MM_SS);
                Date time_end = DateUtils.parseDate(time_end_str, DateUtil.YYYY_MM_DD_HH_MM_SS);
                exampleCriteria.andGmt_createBetween(time_start,time_end);
            }
            if(settle!=null){
                exampleCriteria.andSettleEqualTo(settle);
            }
            exampleCriteria.andShop_idEqualTo(shopId);
            if (StringUtils.isNotEmpty(status)) {
                exampleCriteria.andOrder_statusEqualTo(status );
            }
            if (StringUtils.isNotEmpty(user_name)) {
                exampleCriteria.andUser_nameEqualTo(user_name);
            }
            if (StringUtils.isNotEmpty(carCode)) {
                exampleCriteria.andCar_plateLike("%" + carCode + "%");
            }
            int count = serviceOrderMapper.countByExample(example);
            example.setPageCount(pageSize);
            example.setPageIndex(pageIndex);
            example.setOrderByClause("gmt_create desc");
            List<ServiceOrder> serviceOrders = serviceOrderMapper.selectByExample(example);
            List<ServiceOrderVO> serviceOrderVOS = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(serviceOrders)){
                for (ServiceOrder serviceOrder : serviceOrders) {
                    ServiceOrderVO serviceOrderVO = new ServiceOrderVO();
                    BeanUtils.copyProperties(serviceOrder,serviceOrderVO);
                    serviceOrderVO.setPhone(getPhone(serviceOrder.getUser_id()));
                    serviceOrderVOS.add(serviceOrderVO);
                }
            }
            baseVO.setData(serviceOrderVOS);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("OrderController#list error", e);
        }
        return baseVO;
    }

    @Resource
    WxUserMapper wxUserMapper;

    private String getPhone(String user_id){
        try {
            WxUserExample example = new WxUserExample();
            WxUserExample.Criteria criteria = example.createCriteria();
            criteria.andUser_idEqualTo(user_id);
            List<WxUser> wxUsers = wxUserMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(wxUsers)){
                WxUser wxUser = wxUsers.get(0);
                return wxUser.getPhone();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                       @RequestParam("gmt_change_service") String gmt_change_service,
                       @RequestParam("shopId") Long shopId,
                       @RequestParam("account") String account
    ) {
        BaseVO baseVO = new BaseVO();
        try {

            if (id==null || StringUtils.isEmpty(account)
                    || StringUtils.isEmpty(gmt_change_service) || shopId==null) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(id);
            if(serviceOrder!=null && shopId != serviceOrder.getShop_id()){
                baseVO.setErrorMsg("没有该数据操作权限！");
                baseVO.setSuccess(false);
                return baseVO;
            }

            if(!serviceOrder.getOrder_status().equals(ServiceOrderStatus.ordering.getCode())
                    && !serviceOrder.getChild_status().equals(ServiceOrderStatus.order_submit.getCode())){
                baseVO.setErrorMsg("该状态不允许改约！");
                baseVO.setSuccess(false);
                return baseVO;
            }

            ShopConfirmOrderRequestDTO dto = new ShopConfirmOrderRequestDTO();
            dto.setOrder_id(id);
            dto.setSuccess(false);

            //传入当前真实的操作员用户的id。
            dto.setShop_user_id(getUserId(account, serviceOrder.getShop_id()));
            if(StringUtils.isNotEmpty(gmt_change_service)){
                String[] time = gmt_change_service.split(" ");
                if(time.length > 1){
                    dto.setGmt_change_service_date(time[0]);
                    dto.setGmt_change_service_begin_time(time[1]);
                }
            }

            int ret = orderService.shopConfirmOrder(dto);
            if(ret > 0){
                baseVO.setSuccess(true);
                baseVO.setErrorMsg("ok");
                return baseVO;
            }else if(ret == -1){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("订单不存在，门店改单失败!");
                return baseVO;
            }else if(ret == -2){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("订单未在预约状态中，门店改单失败!");
                return baseVO;
            }else if(ret == -3){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("门店改单异常!");
                return baseVO;
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopController#edit error", e);
        }
        return baseVO;
    }

    @Resource
    ShopAdminUserMapper shopAdminUserMapper;
    private Long getUserId(String account, Long shop_id){
        try {
            ShopAdminUserExample example = new ShopAdminUserExample();
            ShopAdminUserExample.Criteria criteria = example.createCriteria();
            criteria.andAccountEqualTo(account).andShop_idEqualTo(shop_id);
            List<ShopAdminUser> shopAdminUsers = shopAdminUserMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(shopAdminUsers)){
                return shopAdminUsers.get(0).getId();
            }
        } catch (Exception e) {
            LOG.error("ShopController#getUserId error account;{}",new Object[]{account}, e);
        }
        return 0L;
    }

    @Resource
    private WxOrderService wxOrderService;

    private void orderEvent(ServiceOrder serviceOrder,String event_desc){
        try {
            this.wxOrderService.saveServiceOrderEvent(new Date(), serviceOrder, serviceOrder.getShop_user_id(),
                    event_desc);
        } catch (Exception e) {
            LOG.error("OrderController#orderEvent error", e);
        }
    }

    @RequestMapping("/accept")
    public BaseVO accept(@RequestParam("id") Long id,
                       @RequestParam("shopId") Long shopId,
                       @RequestParam("account") String account
    ) {
        BaseVO baseVO = new BaseVO();
        try {

            if (id==null || StringUtils.isEmpty(account)
                    || shopId==null) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(id);
            if(serviceOrder!=null && shopId != serviceOrder.getShop_id()){
                baseVO.setErrorMsg("没有该数据操作权限！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            if(!serviceOrder.getOrder_status().equals(ServiceOrderStatus.ordering.getCode())){
                baseVO.setErrorMsg("订单状态不在预约中！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopConfirmOrderRequestDTO dto = new ShopConfirmOrderRequestDTO();
            dto.setShop_user_id(getUserId(account, serviceOrder.getShop_id()));
            dto.setOrder_id(id);
            dto.setSuccess(true);
            int ret = orderService.shopConfirmOrder(dto);
            if(ret > 0){
                baseVO.setSuccess(true);
                baseVO.setErrorMsg("ok");
                orderEvent(serviceOrder,ServiceOrderStatus.order_succeed.getDesc());
                return baseVO;
            }else if(ret == -1){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("订单不存在，门店确认订单失败!");
                return baseVO;
            }else if(ret == -2){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("订单未在预约状态中，门店确认订单失败!");
                return baseVO;
            }else if(ret == -3){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("订单生成二维码图片失败!");
                return baseVO;
            }

        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopController#edit error", e);
        }
        return baseVO;
    }

    @RequestMapping("/cancel")
    public BaseVO cancel(@RequestParam("id") Long id,
                         @RequestParam("shopId") Long shopId,
                         @RequestParam("account") String account
    ) {
        BaseVO baseVO = new BaseVO();
        try {

            if (id==null || StringUtils.isEmpty(account)
                    || shopId==null) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(id);
            if(serviceOrder!=null && shopId != serviceOrder.getShop_id()){
                baseVO.setErrorMsg("没有该数据操作权限！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            if(serviceOrder.getOrder_status().equals(ServiceOrderStatus.cancle.getCode())){
                baseVO.setErrorMsg("订单已取消请勿重复操作");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopConfirmOrderRequestDTO dto = new ShopConfirmOrderRequestDTO();
            dto.setShop_user_id(getUserId(account, serviceOrder.getShop_id()));
            dto.setOrder_id(id);
            dto.setSuccess(true);
            int ret = cancelOrder(id);
            if(ret > 0){
                baseVO.setSuccess(true);
                baseVO.setErrorMsg("ok");
                orderEvent(serviceOrder,ServiceOrderStatus.cancle.getDesc());
                return baseVO;
            }else if(ret == -1){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("订单不存在！");
                return baseVO;
            }else if(ret == -2){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("当前状态不允许取消订单！");
                return baseVO;
            }

        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopController#edit error", e);
        }
        return baseVO;
    }

    public int cancelOrder(Long orderId) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(orderId);
        if(serviceOrder == null){
            return -1;
        }

        if(!ServiceOrderStatus.parse(serviceOrder.getOrder_status()).isAllow_cancel()){
            return -2;
        }

        serviceOrder.setOrder_status(ServiceOrderStatus.cancle.getCode());
        serviceOrder.setChild_status(ServiceOrderStatus.order_cancel.getCode());
        Date now = new Date();
        serviceOrder.setGmt_modify(now);
        int ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
        return  ret;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id,
                      @RequestParam("shopId") Long shopId) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null) {
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            } else {
                ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(id);
                if(serviceOrder!=null && shopId != serviceOrder.getShop_id()){
                    baseVO.setErrorMsg("没有该数据操作权限！");
                    baseVO.setSuccess(false);
                    return baseVO;
                }
                baseVO.setData(serviceOrder);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }


    @Resource
    private PayMapper payMapper;
    /**
     * 获取支付订单信息
     * @param order_id
     * @return
     */
    @RequestMapping("/getPayInfo")
    public BaseVO getPayInfo(@RequestParam("order_id") Long order_id) {
        BaseVO baseVO = new BaseVO();
        try {
            if (order_id == null) {
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            } else {
                PayExample example = new PayExample();
                PayExample.Criteria criteria = example.createCriteria();
                criteria.andOrder_idEqualTo(order_id);
                List<Pay> pays = payMapper.selectByExample(example);
                if(!CollectionUtils.isEmpty(pays)){
                    Pay pay = pays.get(0);
                    baseVO.setData(pay);
                }
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("OrderController#get Exception input param is order_id:" + order_id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }


    @Resource
    private OrderFeeDetailMapper orderFeeDetailMapper;

    @RequestMapping("/payDetailList")
    public BaseVO payDetailList(
            @RequestParam("order_id") Long order_id
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            OrderFeeDetailExample example = new OrderFeeDetailExample();
            OrderFeeDetailExample.Criteria exampleCriteria = example.createCriteria();
            exampleCriteria.andOrder_idEqualTo(order_id);
            int count = orderFeeDetailMapper.countByExample(example);
            example.setPageCount(pageSize);
            example.setPageIndex(pageIndex);
            example.setOrderByClause("gmt_create desc");
            List<OrderFeeDetail> orderFeeDetails = orderFeeDetailMapper.selectByExample(example);
            baseVO.setData(orderFeeDetails);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("OrderController#list error", e);
        }
        return baseVO;
    }

    @RequestMapping("/editorder")
    public BaseVO editorder(@RequestParam("id") Long id,
                       @RequestParam("gmt_pay") String gmt_pay,
                       @RequestParam("service_item") String service_item,
                       @RequestParam("final_fee") String final_fee,
                       @RequestParam("user_name") String user_name,
                       @RequestParam("car_plate") String car_plate,
                       @RequestParam("estimated_fee") String estimated_fee,
                       @RequestParam("gmt_service_date") String gmt_service_date,
                       @RequestParam("gmt_service_begin_time") String gmt_service_begin_time,
                       @RequestParam("gmt_change_service_date") String gmt_change_service_date,
                       @RequestParam("gmt_change_service_begin_time") String gmt_change_service_begin_time,
                       @RequestParam("gmt_actual_service") String gmt_actual_service,
                       @RequestParam("account") String account
    ) {
        BaseVO baseVO = new BaseVO();
        try {

            if (id==null || StringUtils.isEmpty(account)) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(id);
            if(StringUtils.isNotEmpty(gmt_pay)){
                serviceOrder.setGmt_pay(DateUtil.getDateByStr(gmt_pay));
            }
            serviceOrder.setService_item(service_item);
            serviceOrder.setFinal_fee(final_fee);
            serviceOrder.setUser_name(user_name);
            serviceOrder.setCar_plate(car_plate);
            serviceOrder.setEstimated_fee(estimated_fee);
            serviceOrder.setGmt_service_date(gmt_service_date);
            serviceOrder.setGmt_service_begin_time(gmt_service_begin_time);
            serviceOrder.setGmt_change_service_date(gmt_change_service_date);
            serviceOrder.setGmt_change_service_begin_time(gmt_change_service_begin_time);
            if(StringUtils.isNotEmpty(gmt_actual_service)) {
                serviceOrder.setGmt_actual_service(DateUtil.getDateByStr(gmt_actual_service));
            }
            serviceOrder.setModifier_account(account);
            serviceOrder.setGmt_modify(new Date());
            int i = serviceOrderMapper.updateByPrimaryKey(serviceOrder);
            if(i>0){
                LOG.info("account edit order,"+ JSON.toJSONString(serviceOrder));
                if(StringUtils.isNotEmpty(service_item)){
                    orderEvent(serviceOrder,"修改服务项目");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将服务项从："+serviceOrder.getService_item()+"改为："+service_item);
                }
                if(StringUtils.isNotEmpty(final_fee)){

                    //orderEvent(serviceOrder,"系统管理员："+account+"将最终付款从："+serviceOrder.getFinal_fee()+"改为："+final_fee);
                }
                if(StringUtils.isNotEmpty(user_name)){
                    orderEvent(serviceOrder,"修改姓名");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将姓名从："+serviceOrder.getUser_name()+"改为："+user_name);
                }
                if(StringUtils.isNotEmpty(car_plate)){
                    orderEvent(serviceOrder,"修改车牌");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将车牌从："+serviceOrder.getCar_plate()+"改为："+car_plate);
                }
                if(StringUtils.isNotEmpty(estimated_fee)){
                    orderEvent(serviceOrder,"修改预估金额");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将预估金额从："+serviceOrder.getEstimated_fee()+"改为："+estimated_fee);
                }
                if(StringUtils.isNotEmpty(gmt_service_date)){
                    orderEvent(serviceOrder,"修改服务日期");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将服务日期从："+serviceOrder.getGmt_service_date()+"改为："+gmt_service_date);
                }
                if(StringUtils.isNotEmpty(gmt_service_begin_time)){
                    orderEvent(serviceOrder,"修改服务时间");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将服务时间从："+serviceOrder.getGmt_service_begin_time()+"改为："+gmt_service_begin_time);
                }
                if(StringUtils.isNotEmpty(gmt_change_service_date)){
                    orderEvent(serviceOrder,"修改服务改约日期");
                    // orderEvent(serviceOrder,"系统管理员："+account+"将服务改约日期从："+serviceOrder.getGmt_change_service_date()+"改为："+gmt_change_service_date);
                }
                if(StringUtils.isNotEmpty(gmt_change_service_begin_time)){
                    orderEvent(serviceOrder,"修改服务改约时间");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将服务改约时间从："+serviceOrder.getGmt_change_service_begin_time()+"改为："+gmt_change_service_begin_time);
                }
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopOrderController#edit error", e);
        }
        return baseVO;
    }

    @Resource
    private ReportMapper reportMapper;

    @RequestMapping("/get_report")
    public BaseVO get_report(@RequestParam(value = "id",required = false) Long id,
                             @RequestParam(value = "order_id",required = false) Long order_id) {
        BaseVO baseVO = new BaseVO();
        try {
            if (order_id == null) {
                baseVO.setErrorMsg("参数为不能为空！");
                baseVO.setSuccess(false);
            } else {
                ReportExample example = new ReportExample();
                ReportExample.Criteria criteria = example.createCriteria();
                criteria.andOrder_idEqualTo(order_id);
                List<Report> reports = reportMapper.selectByExampleWithBLOBs(example);
                if(reports.size()>0){
                    baseVO.setData(reports.get(0));
                    baseVO.setSuccess(true);
                }else {
                    baseVO.setErrorMsg("检测报告为空!");
                    baseVO.setSuccess(false);
                }
            }

        } catch (Exception e) {
            LOG.error("ShopOrderController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/total_amount")
    public BaseVO total_amount(
            @RequestParam("shopId") Long shopId
            , @RequestParam("status") String status
            , @RequestParam("carCode") String carCode
            , @RequestParam("user_name") String user_name
            , @RequestParam("gmt_create") String gmt_create
            , @RequestParam(value = "settle", required = false) Integer settle) {
        BaseVO baseVO = new BaseVO();
        try {
            ServiceOrderExample example = new ServiceOrderExample();
            ServiceOrderExample.Criteria exampleCriteria = example.createCriteria();

            if (!StringUtils.isEmpty(gmt_create)) {
                String[] hours = gmt_create.split(" - ");
                String time_start_str = hours[0];
                String time_end_str = hours[1];
                Date time_start = DateUtils.parseDate(time_start_str, DateUtil.YYYY_MM_DD_HH_MM_SS);
                Date time_end = DateUtils.parseDate(time_end_str, DateUtil.YYYY_MM_DD_HH_MM_SS);
                exampleCriteria.andGmt_createBetween(time_start, time_end);
            }
            if (settle != null) {
                exampleCriteria.andSettleEqualTo(settle);
            }
            if (shopId != null) {
                exampleCriteria.andShop_idEqualTo(shopId);
            }
            //审核通过订单
            exampleCriteria.andOrder_typeEqualTo(2);
            if (StringUtils.isNotEmpty(status)) {
                exampleCriteria.andOrder_statusEqualTo(status);
            }
            if (StringUtils.isNotEmpty(user_name)) {
                exampleCriteria.andUser_nameEqualTo(user_name);
            }
            if (StringUtils.isNotEmpty(carCode)) {
                exampleCriteria.andCar_plateLike("%" + carCode + "%");
            }
            int count = serviceOrderMapper.countByExample(example);
            Double amount = new Double(0);
            if(count>0){
                int page =  (count-1)/10+1;
                for(int i=1;i<=page;i++){
                    example.setPageIndex(i);
                    example.setPageCount(10);
                    List<ServiceOrder> serviceOrders = serviceOrderMapper.selectByExample(example);
                    if (!CollectionUtils.isEmpty(serviceOrders)) {
                        for (ServiceOrder serviceOrder : serviceOrders) {
                            if(StringUtils.isNotEmpty(serviceOrder.getSettle_amount())){
                                amount+=new Double(serviceOrder.getSettle_amount());
                            }
                        }
                    }
                }
            }

            baseVO.setData(amount);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("OrderController#list error", e);
        }
        return baseVO;
    }
}
