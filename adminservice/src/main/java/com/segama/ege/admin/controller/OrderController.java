package com.segama.ege.admin.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.ServiceOrderVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import com.segama.ege.service.WxOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description 订单相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {
    @Resource
    private ServiceOrderMapper serviceOrderMapper;

    @Resource
    private ReportMapper reportMapper;


    @Resource
    CarMapper carMapper;

    private static Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("enterprise_name") String enterprise_name
            , @RequestParam("status") String status
            , @RequestParam("carCode") String carCode
            , @RequestParam("user_name") String user_name
            , @RequestParam(value = "order_string_id",required = false) String order_string_id
            , @RequestParam("gmt_create") String gmt_create
            , @RequestParam(value = "order_type", required = false) String order_type
            , @RequestParam(value = "order_status", required = false) String order_status
            , @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
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

            if (StringUtils.isNotEmpty(order_type)) {
                String[] split = order_type.split(",");
                exampleCriteria.andOrder_typeIn(Arrays.asList(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
            }
            if (StringUtils.isNotEmpty(order_status)) {
                String[] split = order_status.split(",");
                exampleCriteria.andOrder_statusIn(Arrays.asList(split[0], split[1]));
                exampleCriteria.andOrder_typeIsNull();
            }
            if(StringUtils.isNotEmpty(order_string_id)){
                exampleCriteria.andOrder_string_idLike("%" + order_string_id + "%");
            }
            if (StringUtils.isNotEmpty(enterprise_name)) {
                exampleCriteria.andShop_nameLike("%" + enterprise_name + "%");
            }
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
            example.setPageCount(pageSize);
            example.setPageIndex(pageIndex);
            example.setOrderByClause("gmt_create desc");
            List<ServiceOrder> serviceOrders = serviceOrderMapper.selectByExample(example);
            List<ServiceOrderVO> serviceOrderVOS = Lists.newArrayList();
            if (!CollectionUtils.isEmpty(serviceOrders)) {
                for (ServiceOrder serviceOrder : serviceOrders) {
                    ServiceOrderVO serviceOrderVO = new ServiceOrderVO();
                    BeanUtils.copyProperties(serviceOrder, serviceOrderVO);
                    String level;
                    if(StringUtils.isNotEmpty(serviceOrder.getCard_level())){
                        level=serviceOrder.getCard_level();
                    }else{
                        level = queryCarLevel(serviceOrder.getCar_id());
                    }
                    serviceOrderVO.setCardLevel(getCardLevel(level));
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


    private String queryCarLevel(Long car_id) {
        Car car = carMapper.selectByPrimaryKey(car_id);
        if (car != null) {
            return car.getCard_level();
        }
        return "0";
    }

    @RequestMapping("/list_verify")
    public BaseVO list_verify(
            @RequestParam("shopId") Long shopId
            , @RequestParam("status") String status
            , @RequestParam("carCode") String carCode
            , @RequestParam("user_name") String user_name
            , @RequestParam("gmt_create") String gmt_create
            , @RequestParam(value = "settle", required = false) Integer settle
            , @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
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
            example.setPageCount(pageSize);
            example.setPageIndex(pageIndex);
            example.setOrderByClause("gmt_create desc");
            List<ServiceOrder> serviceOrders = serviceOrderMapper.selectByExample(example);
            List<ServiceOrderVO> serviceOrderVOS = Lists.newArrayList();
            if (!CollectionUtils.isEmpty(serviceOrders)) {
                for (ServiceOrder serviceOrder : serviceOrders) {
                    ServiceOrderVO serviceOrderVO = new ServiceOrderVO();
                    BeanUtils.copyProperties(serviceOrder, serviceOrderVO);
                    String level;
                    if(StringUtils.isNotEmpty(serviceOrder.getCard_level())){
                        level=serviceOrder.getCard_level();
                    }else{
                        level = queryCarLevel(serviceOrder.getCar_id());
                    }
                    serviceOrderVO.setCardLevel(getCardLevel(level));

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

    String getCardLevel(String card_level){
        if ("0".equals(card_level)) {
            return "普通会员";
        } else if ("1".equals(card_level)) {
            return "银卡会员";
        } else if ("2".equals(card_level)) {
            return "金卡会员";
        } else if ("3".equals(card_level)) {
            return "黑卡会员";
        }
        return "普通会员";
    }
    String queryWxUser(String userId) {
        try {
            WxUserExample example = new WxUserExample();
            WxUserExample.Criteria criteria = example.createCriteria();
            criteria.andUser_idEqualTo(userId);
            List<WxUser> wxUsers = wxUserMapper.selectByExample(example);

            if (!CollectionUtils.isEmpty(wxUsers)) {
                WxUser wxUser = wxUsers.get(0);
                String card_level = wxUser.getCard_level();
                if ("0".equals(card_level)) {
                    return "普通会员";
                } else if ("1".equals(card_level)) {
                    return "银卡会员";
                } else if ("2".equals(card_level)) {
                    return "金卡会员";
                } else if ("3".equals(card_level)) {
                    return "黑卡会员";
                }
            }
        } catch (Exception e) {
        }
        return "普通会员";
    }

    String queryWxUserLevel(String userId) {
        try {
            WxUserExample example = new WxUserExample();
            WxUserExample.Criteria criteria = example.createCriteria();
            criteria.andUser_idEqualTo(userId);
            List<WxUser> wxUsers = wxUserMapper.selectByExample(example);

            if (!CollectionUtils.isEmpty(wxUsers)) {
                WxUser wxUser = wxUsers.get(0);
                return wxUser.getCard_level();
            }
        } catch (Exception e) {
        }
        return null;
    }

    @RequestMapping("/test")
    public void get() {
        Report report = reportMapper.selectByPrimaryKey(28L);
        String a = report.getReport_items();
        System.out.println(report.getReport_items());
        // reportMapper.updateByPrimaryKeyWithBLOBs(report);
        report.setReport_items("[{\"mainCategoryName\":\"dengguang\",\"mainCategoryDisplayName\":\"灯光\",\"result\":false,\"photos\":\"http://www.jinlingongyi.cn/egecarservice/repo/97dfe174-3762-45dc-9fd8-ad8e895965e6.jpg\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"xingchedeng\",\"entryDisplayName\":\"行车灯\",\"entryValue\":\"不正常\",\"title\":\"\",\"result\":false,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"jinguangdeng\",\"entryDisplayName\":\"近光灯\",\"title\":\"\",\"entryValue\":\"正常\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"yuanguangdeng\",\"entryDisplayName\":\"远光灯\",\"title\":\"\",\"entryValue\":\"正常\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"bianguang\",\"entryDisplayName\":\"变光\",\"title\":\"\",\"entryValue\":\"正常\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"zuoyouzhuanxiangdeng\",\"entryDisplayName\":\"左右转向灯\",\"title\":\"\",\"entryValue\":\"正常\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"shanshuobaojingzhishideng\",\"entryDisplayName\":\"闪烁报警指示灯\",\"title\":\"\",\"entryValue\":\"正常\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"qianwudeng\",\"entryDisplayName\":\"前雾灯\",\"title\":\"\",\"entryValue\":\"正常\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"qianzhucheleida\",\"entryDisplayName\":\"前驻车雷达\",\"title\":\"\",\"entryValue\":\"正常\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"yugua\",\"entryDisplayName\":\"雨刮\",\"title\":\"\",\"entryValue\":\"正常\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"dadengqingxizhuagnzhi\",\"entryDisplayName\":\"大灯清洗装置\",\"title\":\"\",\"entryValue\":\"正常\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"}]},{\"mainCategoryName\":\"jiyou\",\"mainCategoryDisplayName\":\"机油\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"fangyoulaing\",\"entryDisplayName\":\"放油量\",\"entryValue\":\"30\",\"title\":\"\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"jiajiyou\",\"entryDisplayName\":\"加机油\",\"entryValue\":\"40\",\"title\":\"\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"}]},{\"mainCategoryName\":\"jilv\",\"mainCategoryDisplayName\":\"机滤\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"jiujianpinpai\",\"entryDisplayName\":\"旧件品牌\",\"entryValue\":\"qwe\",\"title\":\"\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"xinjianpinpai\",\"entryDisplayName\":\"新件品牌\",\"entryValue\":\"asd\",\"title\":\"\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"}]},{\"mainCategoryName\":\"huohuasai\",\"mainCategoryDisplayName\":\"火花塞\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"mushijiance\",\"entryDisplayName\":\"目视检测\",\"entryValue\":\"正常\",\"title\":\"\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"dianhuoxianquan\",\"entryDisplayName\":\"点火线圈\",\"entryValue\":\"正常\",\"title\":\"\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"}]},{\"mainCategoryName\":\"fangdongye\",\"mainCategoryDisplayName\":\"防冻液\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"phzhi\",\"entryDisplayName\":\"PH值\",\"entryValue\":\"8\",\"title\":\"\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值7-9.5\"},{\"entryName\":\"bingdian\",\"entryDisplayName\":\"冰点\",\"entryValue\":\"-20\",\"title\":\"\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值-68摄氏度— -15摄氏度\"},{\"entryName\":\"feidian\",\"entryDisplayName\":\"沸点\",\"entryValue\":\"110\",\"title\":\"\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值>105摄氏度\"}]},{\"mainCategoryName\":\"jieqimen\",\"mainCategoryDisplayName\":\"节气门\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"kaidujiancha\",\"entryDisplayName\":\"开度检查\",\"title\":\"\",\"entryValue\":\"2\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考范围1.6—5.0\"}]},{\"mainCategoryName\":\"biansuxiangyou\",\"mainCategoryDisplayName\":\"变速箱油\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"lengtai\",\"entryDisplayName\":\"冷态\",\"title\":\"油尺刻度位置\",\"entryValue\":\"50\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"retai\",\"entryDisplayName\":\"热态\",\"title\":\"油尺刻度位置\",\"entryValue\":\"60\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"}]},{\"mainCategoryName\":\"shacheyou\",\"mainCategoryDisplayName\":\"刹车油\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"shuihanliang\",\"entryDisplayName\":\"水含量\",\"title\":\"\",\"entryValue\":\"2%\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值0.5%—2.5%\"},{\"entryName\":\"ganfeidian\",\"entryDisplayName\":\"干沸点\",\"title\":\"\",\"entryValue\":\"206\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值205-207摄氏度\"},{\"entryName\":\"shifeidian\",\"entryDisplayName\":\"湿沸点\",\"title\":\"\",\"entryValue\":\"180\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值170-190摄氏度\"}]},{\"mainCategoryName\":\"pidai\",\"mainCategoryDisplayName\":\"皮带\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"zhangjindu\",\"entryDisplayName\":\"张紧度\",\"title\":\"\",\"entryValue\":\"正常\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"}]},{\"mainCategoryName\":\"shachepan\",\"mainCategoryDisplayName\":\"刹车盘\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"zuoqianlun\",\"entryDisplayName\":\"左前轮\",\"title\":\"\",\"entryValue\":\"2\",\"result\":true,\"range\":\"\",\"standardRefer\":\">=3毫米为强制更换\"},{\"entryName\":\"zuohoulun\",\"entryDisplayName\":\"左后轮\",\"title\":\"\",\"entryValue\":\"1\",\"result\":true,\"range\":\"\",\"standardRefer\":\">=3毫米为强制更换\"},{\"entryName\":\"youqianlun\",\"entryDisplayName\":\"右前轮\",\"title\":\"\",\"entryValue\":\"1\",\"result\":true,\"range\":\"\",\"standardRefer\":\">=3毫米为强制更换\"},{\"entryName\":\"youhoulun\",\"entryDisplayName\":\"右后轮\",\"title\":\"\",\"entryValue\":\"2\",\"result\":true,\"range\":\"\",\"standardRefer\":\">=3毫米为强制更换\"}]},{\"mainCategoryName\":\"luntai\",\"mainCategoryDisplayName\":\"轮胎\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"zuoqianlun_neice\",\"entryDisplayName\":\"左前轮\",\"title\":\"内侧\",\"entryValue\":\"2\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"zuoqianlun_waice\",\"entryDisplayName\":\"左前轮\",\"title\":\"外侧\",\"entryValue\":\"3\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"zuohoulun_neice\",\"entryDisplayName\":\"左后轮\",\"title\":\"内侧\",\"entryValue\":\"2\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"zuohoulun_waice\",\"entryDisplayName\":\"左后轮\",\"title\":\"外侧\",\"entryValue\":\"3\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"youqianlun_neice\",\"entryDisplayName\":\"右前轮\",\"title\":\"内侧\",\"entryValue\":\"2\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"youqianlun_waice\",\"entryDisplayName\":\"右前轮\",\"title\":\"外侧\",\"entryValue\":\"2\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"youhoulun_neice\",\"entryDisplayName\":\"右后轮\",\"title\":\"内侧\",\"entryValue\":\"3\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"youhoulun_waice\",\"entryDisplayName\":\"右后轮\",\"title\":\"外侧\",\"entryValue\":\"3\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"},{\"entryName\":\"zuoqianlun3\",\"entryDisplayName\":\"左前轮\",\"title\":\"胎压\",\"entryValue\":\"2.4\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值：2.3-2.5之间\"},{\"entryName\":\"zuohoulun3\",\"entryDisplayName\":\"左后轮\",\"title\":\"胎压\",\"entryValue\":\"2.4\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值：2.3-2.5之间\"},{\"entryName\":\"youqianlun3\",\"entryDisplayName\":\"右前轮\",\"title\":\"胎压\",\"entryValue\":\"2.4\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值：2.3-2.5之间\"},{\"entryName\":\"youhoulun3\",\"entryDisplayName\":\"右后轮\",\"title\":\"胎压\",\"entryValue\":\"2.4\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值：2.3-2.5之间\"}]},{\"mainCategoryName\":\"shachepian\",\"mainCategoryDisplayName\":\"刹车片\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"zuoqianlun2\",\"entryDisplayName\":\"左前轮\",\"title\":\"\",\"entryValue\":\"2\",\"result\":true,\"range\":\"\",\"standardRefer\":\"<=1.6毫米为强制更换\"},{\"entryName\":\"zuohoulun2\",\"entryDisplayName\":\"左后轮\",\"title\":\"\",\"entryValue\":\"3\",\"result\":true,\"range\":\"\",\"standardRefer\":\"<=1.6毫米为强制更换\"},{\"entryName\":\"youqianlun2\",\"entryDisplayName\":\"右前轮\",\"title\":\"\",\"entryValue\":\"2\",\"result\":true,\"range\":\"\",\"standardRefer\":\"<=1.6毫米为强制更换\"},{\"entryName\":\"youhoulun2\",\"entryDisplayName\":\"右后轮\",\"title\":\"\",\"entryValue\":\"2\",\"result\":true,\"range\":\"\",\"standardRefer\":\"<=1.6毫米为强制更换\"}]},{\"mainCategoryName\":\"dianping\",\"mainCategoryDisplayName\":\"电瓶\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"dianya\",\"entryDisplayName\":\"电压\",\"title\":\"\",\"entryValue\":\"60\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"}]},{\"mainCategoryName\":\"kongtiao\",\"mainCategoryDisplayName\":\"空调\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"gaoya\",\"entryDisplayName\":\"高压\",\"title\":\"\",\"entryValue\":\"1500\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值1400-1600kpa\"},{\"entryName\":\"diya\",\"entryDisplayName\":\"低压\",\"title\":\"\",\"entryValue\":\"200\",\"result\":true,\"range\":\"\",\"standardRefer\":\"参考值150-250kpa\"}]},{\"mainCategoryName\":\"dipan\",\"mainCategoryDisplayName\":\"底盘\",\"result\":true,\"photos\":\"\",\"remark\":\"底盘的文字描述\",\"subCategoryList\":[{\"entryName\":\"dipan2\",\"entryDisplayName\":\"底盘\",\"title\":\"\",\"entryValue\":\"zxc\",\"result\":true,\"range\":\"\",\"standardRefer\":\"\"}]},{\"mainCategoryName\":\"baoyangjianyi\",\"mainCategoryDisplayName\":\"保养建议\",\"result\":true,\"photos\":\"\",\"remark\":\"\",\"subCategoryList\":[{\"entryName\":\"baoyangjianyi2\",\"entryDisplayName\":\"保养建议\",\"title\":\"\",\"entryValue\":\"40000\",\"result\":true,\"range\":\"\",\"standardRefer\":\"asd\"}]}]\n");
        //reportMapper.updateByPrimaryKey(report);
        // report.setReport_items(a);
        reportMapper.updateByPrimaryKeyWithBLOBs(report);
        System.out.println();
    }

    @Resource
    WxUserMapper wxUserMapper;

    private String getPhone(String user_id) {
        try {
            WxUserExample example = new WxUserExample();
            WxUserExample.Criteria criteria = example.createCriteria();
            criteria.andUser_idEqualTo(user_id);
            List<WxUser> wxUsers = wxUserMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(wxUsers)) {
                WxUser wxUser = wxUsers.get(0);
                return wxUser.getPhone();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Resource
    SettleConfigMapper settleConfigMapper;

    @RequestMapping("/verify_order")
    public BaseVO verify_order(@RequestParam("id") Long id,
                               @RequestParam("order_type") Integer order_type,
                               @RequestParam("verify_remark") String verify_remark
            , @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null || StringUtils.isEmpty(account) || order_type == null) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(id);
            if (StringUtils.isNotEmpty(verify_remark)) {
                serviceOrder.setVerify_remark(verify_remark);
            }
            serviceOrder.setGmt_modify(new Date());
            serviceOrder.setModifier_account(account);
            serviceOrder.setOrder_type(order_type);
            serviceOrder.setVerify_account(account);

            SettleConfigExample example = new SettleConfigExample();
            SettleConfigExample.Criteria criteria = example.createCriteria();
            String level = queryWxUserLevel(serviceOrder.getUser_id());
            if (level != null) {
                criteria.andCard_levelEqualTo(Integer.valueOf(level));
                List<SettleConfig> settleConfigs = settleConfigMapper.selectByExample(example);
                if (CollectionUtils.isEmpty(settleConfigs)) {
                    throw new RuntimeException("结算配置中未对该会员等级进行配置！");
                }
                SettleConfig settleConfig = settleConfigs.get(0);
                String fee = "0";
                if (order_type == 2) {
                    fee = settleConfig.getFee();
                }
                serviceOrder.setSettle_amount(fee);
                serviceOrderMapper.updateByPrimaryKey(serviceOrder);
            } else {
                throw new RuntimeException("会员等级为空！");
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("审核异常" + e.getMessage());
        }
        return baseVO;
    }

    @RequestMapping("/settle")
    public BaseVO settle(@RequestParam("id") Long id,
                         @RequestParam("settle") Integer settle
                         //, @RequestParam("settle_amount") String  settle_amount
            , @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null || StringUtils.isEmpty(account) || settle == null) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(id);
            serviceOrder.setGmt_modify(new Date());
            // serviceOrder.setSettle_amount(settle_amount);
            serviceOrder.setModifier_account(account);
            serviceOrder.setSettle(settle);
            int i = serviceOrderMapper.updateByPrimaryKey(serviceOrder);
            if (i > 0) {
                baseVO.setSuccess(true);
            } else {
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("操作失败");
            }
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("操作异常");
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
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

            if (id == null || StringUtils.isEmpty(account)) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(id);
            if (StringUtils.isNotEmpty(gmt_pay)) {
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
            if (StringUtils.isNotEmpty(gmt_actual_service)) {
                serviceOrder.setGmt_actual_service(DateUtil.getDateByStr(gmt_actual_service));
            }

            serviceOrder.setModifier_account(account);
            serviceOrder.setGmt_modify(new Date());
            int i = serviceOrderMapper.updateByPrimaryKey(serviceOrder);
            if (i > 0) {
                LOG.info("account edit order," + JSON.toJSONString(serviceOrder));
                if (StringUtils.isNotEmpty(service_item)) {
                    orderEvent(serviceOrder, "修改服务项目");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将服务项从："+serviceOrder.getService_item()+"改为："+service_item);
                }
                if (StringUtils.isNotEmpty(final_fee)) {

                    //orderEvent(serviceOrder,"系统管理员："+account+"将最终付款从："+serviceOrder.getFinal_fee()+"改为："+final_fee);
                }
                if (StringUtils.isNotEmpty(user_name)) {
                    orderEvent(serviceOrder, "修改姓名");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将姓名从："+serviceOrder.getUser_name()+"改为："+user_name);
                }
                if (StringUtils.isNotEmpty(car_plate)) {
                    orderEvent(serviceOrder, "修改车牌");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将车牌从："+serviceOrder.getCar_plate()+"改为："+car_plate);
                }
                if (StringUtils.isNotEmpty(estimated_fee)) {
                    orderEvent(serviceOrder, "修改预估金额");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将预估金额从："+serviceOrder.getEstimated_fee()+"改为："+estimated_fee);
                }
                if (StringUtils.isNotEmpty(gmt_service_date)) {
                    orderEvent(serviceOrder, "修改服务日期");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将服务日期从："+serviceOrder.getGmt_service_date()+"改为："+gmt_service_date);
                }
                if (StringUtils.isNotEmpty(gmt_service_begin_time)) {
                    orderEvent(serviceOrder, "修改服务时间");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将服务时间从："+serviceOrder.getGmt_service_begin_time()+"改为："+gmt_service_begin_time);
                }
                if (StringUtils.isNotEmpty(gmt_change_service_date)) {
                    orderEvent(serviceOrder, "修改服务改约日期");
                    // orderEvent(serviceOrder,"系统管理员："+account+"将服务改约日期从："+serviceOrder.getGmt_change_service_date()+"改为："+gmt_change_service_date);
                }
                if (StringUtils.isNotEmpty(gmt_change_service_begin_time)) {
                    orderEvent(serviceOrder, "修改服务改约时间");
                    //orderEvent(serviceOrder,"系统管理员："+account+"将服务改约时间从："+serviceOrder.getGmt_change_service_begin_time()+"改为："+gmt_change_service_begin_time);
                }
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("OrderController#edit error", e);
        }
        return baseVO;
    }

    @Resource
    private WxOrderService wxOrderService;

    private void orderEvent(ServiceOrder serviceOrder, String event_desc) {
        try {
            this.wxOrderService.saveServiceOrderEvent(new Date(), serviceOrder, serviceOrder.getShop_user_id(),
                    event_desc);
        } catch (Exception e) {
            LOG.error("OrderController#orderEvent error", e);
        }
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null) {
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            } else {
                ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(id);
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

    @RequestMapping("/get_report")
    public BaseVO get_report(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "order_id", required = false) Long order_id) {
        BaseVO baseVO = new BaseVO();
        try {
            if (order_id == null) {
                baseVO.setErrorMsg("参数不能为空！");
                baseVO.setSuccess(false);
            } else {
                ReportExample example = new ReportExample();
                ReportExample.Criteria criteria = example.createCriteria();
                criteria.andOrder_idEqualTo(order_id);
                List<Report> reports = reportMapper.selectByExampleWithBLOBs(example);
                if (reports.size() > 0) {
                    baseVO.setData(reports.get(0));
                    baseVO.setSuccess(true);
                } else {
                    baseVO.setErrorMsg("检测报告为空!");
                    baseVO.setSuccess(false);
                }
            }

        } catch (Exception e) {
            LOG.error("OrderController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @Resource
    private PayMapper payMapper;

    /**
     * 获取支付订单信息
     *
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
                if (!CollectionUtils.isEmpty(pays)) {
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
            , @RequestParam("limit") Integer pageSize,
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
}
