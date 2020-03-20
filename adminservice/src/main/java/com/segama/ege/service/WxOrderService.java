package com.segama.ege.service;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.constant.Constants;
import com.segama.ege.domain.*;
import com.segama.ege.dto.*;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import com.segama.ege.util.CommonUtil;
import com.segama.ege.util.PageCountUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.*;

import static com.segama.ege.constant.Constants.SYSTEM_CURRENT_API_HOST;

@Component
public class WxOrderService {
    @Resource
    private ServiceOrderMapper serviceOrderMapper;

    @Autowired
    CacheService cacheService;

    @Autowired
    RiskCheckService riskCheckService;

    @Autowired
    CapitalFlowService capitalFlowService;

    @Autowired
    CarService carService;

    @Autowired
    MessageDigestService messageDigestService;

    @Autowired
    FileSerivce fileSerivce;

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private RepeatServiceWxUsersMapper repeatServiceWxUsersMapper;

    @Resource
    private CarTypeMapper carTypeMapper;

    @Resource
    private WxUserMapper wxUserMapper;

    @Resource
    private CarMapper carMapper;

    @Resource
    private PayMapper payMapper;

    @Resource
    private OrderFeeDetailMapper orderFeeDetailMapper;

    @Resource
    private ShopAdminUserMapper shopAdminUserMapper;

    @Resource
    private ShopAdminUserDetailInfoMapper shopAdminUserDetailInfoMapper;

    @Resource
    private ServiceOrderEventMapper serviceOrderEventMapper;

    @Resource
    private EngineOilMapper engineOilMapper;

    @Resource
    private ShopEvaluateDetailMapper shopEvaluateDetailMapper;

    @Resource
    private ShopOilSupplyMapper shopOilSupplyMapper;

    @Autowired
    SmsService smsService;

    public ServiceOrderResponseListDTO getOrderList(WxUser currentLoginUser, String order_status,
                                                    String search_type, String keyword,
                                                    int currentPage, int showCount) {
        ServiceOrderExample example = new ServiceOrderExample();
        ServiceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUser_idEqualTo(currentLoginUser.getUser_id());
        if (StringUtils.isNotEmpty(search_type) && StringUtils.isNotEmpty(keyword)) {
            if (search_type.equals(KeywordTypeEnum.shop_name.getCode())) {
                criteria.andShop_nameLike("%" + keyword + "%");
            } else if (search_type.equals(KeywordTypeEnum.plate.getCode())) {
                criteria.andCar_plateLike("%" + keyword + "%");
            }
        }

        if (StringUtils.isNotEmpty(order_status)) {
            if (!order_status.equalsIgnoreCase("ALL")) {
                if (order_status.equals("1")) {
                    //预约中
                    criteria.andOrder_statusEqualTo(ServiceOrderStatus.ordering.getCode());
                    List<String> c_list = new ArrayList<String>();
                    c_list.add(ServiceOrderStatus.order_submit.getCode());
                    c_list.add(ServiceOrderStatus.order_succeed.getCode());
                    c_list.add(ServiceOrderStatus.order_modify.getCode());
                    c_list.add(ServiceOrderStatus.order_cancel.getCode());
                    c_list.add(ServiceOrderStatus.order_fail.getCode());
                    criteria.andChild_statusIn(c_list);
                } else if (order_status.equals("2")) {
                    //服务中
                    criteria.andOrder_statusEqualTo(ServiceOrderStatus.servicing.getCode());
                    List<String> c_list = new ArrayList<String>();
                    c_list.add(ServiceOrderStatus.order_taking.getCode());
                    c_list.add(ServiceOrderStatus.upkeep_servicing.getCode());
                    c_list.add(ServiceOrderStatus.report_no_exception.getCode());
                    c_list.add(ServiceOrderStatus.report_have_exception.getCode());
                    c_list.add(ServiceOrderStatus.value_added_services_mend_to_confirm.getCode());
                    c_list.add(ServiceOrderStatus.value_added_services_mending.getCode());
                    c_list.add(ServiceOrderStatus.value_added_services_mend_finish.getCode());
                    c_list.add(ServiceOrderStatus.exception_ignore.getCode());
                    c_list.add(ServiceOrderStatus.value_added_services_mend_pass.getCode());
                    criteria.andChild_statusIn(c_list);
                } else if (order_status.equals("3")) {
                    //待付款
                    criteria.andOrder_statusEqualTo(ServiceOrderStatus.to_pay.getCode());
                } else if (order_status.equals("4")) {
                    //待评价
                    List<String> s_list = new ArrayList<String>();
                    s_list.add(ServiceOrderStatus.to_evaluate.getCode());
                    criteria.andOrder_statusIn(s_list);
                } else if (order_status.equals("5")) {
                    //已完成
                    criteria.andOrder_statusEqualTo(ServiceOrderStatus.finish.getCode());
                }
            }
        }
        example.setOrderByClause("gmt_create desc");
        ServiceOrderResponseListDTO result = new ServiceOrderResponseListDTO();

        int totalRecord = serviceOrderMapper.countByExample(example);
        int totalPage = PageCountUtil.computeTotalPageByCount(totalRecord, showCount);
        result.addPageInfo(totalPage, currentPage);

        example.setPageIndex(currentPage);
        example.setPageCount(showCount);
        List<ServiceOrder> serviceOrders = serviceOrderMapper.selectByExample(example);
        Set<Long> shop_id_set = new HashSet<Long>();
        List<Long> shop_id_list = new ArrayList<Long>();

        Set<Long> car_id_set = new HashSet<Long>();
        List<Long> car_id_list = new ArrayList<Long>();
        if (!CollectionUtils.isEmpty(serviceOrders)) {
            for (int i = 0; i < serviceOrders.size(); ++i) {
                ServiceOrder eachOrder = serviceOrders.get(i);
                shop_id_set.add(eachOrder.getShop_id());
                car_id_set.add(eachOrder.getCar_id());
            }
        }

        ShopExample shopExample = new ShopExample();
        for (Long shopId : shop_id_set) {
            shop_id_list.add(shopId);
        }
        shopExample.createCriteria().andIdIn(shop_id_list);
        List<Shop> shops = this.shopMapper.selectByExample(shopExample);
        Map<Long, Shop> shop_map = new HashMap<Long, Shop>();
        for (Shop eachShop : shops) {
            shop_map.put(eachShop.getId(), eachShop);
        }

        CarExample carExample = new CarExample();
        for (Long carId : car_id_set) {
            car_id_list.add(carId);
        }
        carExample.createCriteria().andIdIn(car_id_list);
        List<Car> cars = this.carMapper.selectByExample(carExample);
        Map<Long, Car> car_map = new HashMap<Long, Car>();

        for (Car eachCar : cars) {
            car_map.put(eachCar.getId(), eachCar);
        }

        result.addServiceOrders(serviceOrders, shop_map, car_map, null);
        return result;
    }

    public ServiceOrderDetailResponseDTO getOrderInfo(WxUser currentLoginUser, Long order_id) {
        ServiceOrderExample example = new ServiceOrderExample();
        ServiceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUser_idEqualTo(currentLoginUser.getUser_id());
        example.setOrderByClause("gmt_create desc");
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(order_id);

        if (serviceOrder == null || !serviceOrder.getUser_id().equals(currentLoginUser.getUser_id())) {
            return null;
        }

        Shop shop = this.shopMapper.selectByPrimaryKey(serviceOrder.getShop_id());
        if (shop == null) {
            return null;
        }
        Car car = this.carMapper.selectByPrimaryKey(serviceOrder.getCar_id());
        if (car == null) {
            return null;
        }

        String car_type_img_url = null;
        if (!StringUtils.isNotEmpty(car.getCar_type_name())) {
            CarTypeExample carTypeExample = new CarTypeExample();
            carTypeExample.createCriteria().andCar_typeEqualTo(car.getCar_type_name());
            List<CarType> carTypes = this.carTypeMapper.selectByExample(carTypeExample);
            if (!CollectionUtils.isEmpty(carTypes)) {
                car_type_img_url = String.format("%s/adminservice/demo/car/%s.png", cacheService.get(SYSTEM_CURRENT_API_HOST), carTypes.get(0).getBrand_code());
            }
        }
        Pay pay = this.payMapper.selectByPrimaryKey(serviceOrder.getPay_id());
        ServiceOrderDetailResponseDTO result = ServiceOrderDetailResponseDTO.build(serviceOrder, shop,
                car, pay, car_type_img_url);
        if (serviceOrder.getPay_id() != null) {
            OrderFeeDetailExample feeDetailExample = new OrderFeeDetailExample();
            feeDetailExample.createCriteria().andOrder_idEqualTo(order_id).andPay_idEqualTo(serviceOrder.getPay_id());
            List<OrderFeeDetail> feeDetails = this.orderFeeDetailMapper.selectByExample(feeDetailExample);
            if (!CollectionUtils.isEmpty(feeDetails)) {
                result.addOrderFeeDetails(feeDetails);
            }
        }

        ServiceOrderEventExample eventExample = new ServiceOrderEventExample();
        eventExample.createCriteria().andOrder_idEqualTo(order_id);
        List<ServiceOrderEvent> events = this.serviceOrderEventMapper.selectByExample(eventExample);
        if (!CollectionUtils.isEmpty(events)) {
            result.addServiceOrderEvents(events);
        }

        return result;
    }

    public Long submitOrder(WxUser user, SubmitServiceOrderRequestDTO dto) {
        if (this.riskCheckService.checkCarUserHaveRisk(user)) {
            return -5L;
        }
        Shop shop = this.shopMapper.selectByPrimaryKey(dto.getShop_id());
        if (shop == null || shop.getIs_disable()) {
            return -2L;
        }

        Car car = this.carMapper.selectByPrimaryKey(dto.getCar_id());
        if (car == null) {
            return -3L;
        }

        EngineOil engineOil = null;
        if (dto.getOil_id() != null) {
            engineOil = this.engineOilMapper.selectByPrimaryKey(dto.getOil_id());
        }

        ServiceOrderExample example = new ServiceOrderExample();
        ServiceOrderExample.Criteria criteria = example.createCriteria();

        List<String> statusList = new ArrayList<String>();
        statusList.add(ServiceOrderStatus.cancle.getCode());
        statusList.add(ServiceOrderStatus.to_evaluate.getCode());
        statusList.add(ServiceOrderStatus.finish.getCode());

        List<String> child_statusList = new ArrayList<String>();
        child_statusList.add(ServiceOrderStatus.order_fail.getCode());

        criteria.andCar_idEqualTo(dto.getCar_id()).andUser_idEqualTo(dto.getUser_id()).andOrder_statusNotIn(statusList)
                .andChild_statusNotIn(child_statusList);
        List<ServiceOrder> existOrders = this.serviceOrderMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(existOrders)) {
            return -1L;
        }

        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setUser_id(dto.getUser_id());
        serviceOrder.setUser_name(dto.getUser_name());
        serviceOrder.setCar_id(dto.getCar_id());
        serviceOrder.setCar_plate(car.getPlate());
        serviceOrder.setCar_type_name(car.getCar_type_name());
        serviceOrder.setCar_logo_url(car.getCar_logo_url());
        serviceOrder.setShop_id(dto.getShop_id());
        serviceOrder.setShop_name(shop.getEnterprise_name());
        serviceOrder.setCard_level(car.getCard_level());
        if (dto.getOil_id() != null) {
            serviceOrder.setOil_id(dto.getOil_id());
        }
        if (engineOil != null) {
            serviceOrder.setOil_brand(engineOil.getBrand_name());
        }
        serviceOrder.setService_item(dto.getService_item());
        serviceOrder.setGmt_service_date((dto.getGmt_service_date()));
        serviceOrder.setGmt_service_begin_time(dto.getGmt_service_begin_time());
        Date now = new Date();
        serviceOrder.setGmt_create(now);
        serviceOrder.setOrder_status(ServiceOrderStatus.ordering.getCode());
        serviceOrder.setChild_status(ServiceOrderStatus.order_submit.getCode());
        serviceOrder.setCreator_account(user.getNick_name());
        int ret = this.serviceOrderMapper.insert(serviceOrder);
        if (ret > 0) {
            Long order_id = serviceOrder.getId();
            DecimalFormat df = new DecimalFormat("800000000000000");
            serviceOrder.setOrder_string_id(df.format(order_id));
            serviceOrder.setGmt_modify(new Date());
            ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
            if (ret > 0) {
                saveCarUserServiceOrderEvent(now, serviceOrder, ServiceOrderStatus.order_submit.getDesc());
                //您有新的预约订单,车牌${car_plate}，请注意查收！
                smsService.sendSMSNotifyRetry("SMS_181200005", shop.getPhone(), serviceOrder.getCar_plate());
            }
            return order_id;
        }
        return 0L;
    }

    private int updateShopTagEvaluateTag(Shop shop, String new_tags) {
        Set<String> tag_set = new HashSet<String>();
        if (StringUtils.isNotEmpty(shop.getEvaluate_tags())) {
            String[] arr_old = shop.getEvaluate_tags().split(",");
            for (int i = 0; i < arr_old.length; ++i) {
                tag_set.add(arr_old[i]);
            }
        }
        String[] arr_new = new_tags.split(",");
        for (int j = 0; j < arr_new.length; ++j) {
            tag_set.add(arr_new[j]);
        }
        String update_tags = "";
        Iterator<String> it = tag_set.iterator();
        while (it.hasNext()) {
            String tag = it.next();
            update_tags = update_tags + tag + ",";
        }
        String result_tags = update_tags.substring(0, update_tags.length() - 1);
        shop.setEvaluate_tags(result_tags);
        int ret = this.shopMapper.updateByPrimaryKeySelective(shop);
        return ret;
    }

    public int submitEvaluate(WxUser user, ShopEvaluateRequestDTO dto) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(dto.getOrder_id());
        if (serviceOrder == null) {
            return -1;
        }

        if (serviceOrder.getOrder_status().equals(ServiceOrderStatus.finish.getCode())) {
            return 0;
        }

        if (!((serviceOrder.getOrder_status().equals(ServiceOrderStatus.servicing.getCode())
                && serviceOrder.getChild_status().equals(ServiceOrderStatus.exception_ignore.getCode()))
                || (serviceOrder.getOrder_status().equals(ServiceOrderStatus.servicing.getCode())
                && serviceOrder.getChild_status().equals(ServiceOrderStatus.report_no_exception.getCode()))
                || serviceOrder.getOrder_status().equals(ServiceOrderStatus.to_evaluate.getCode()))) {
            return 0;
        }

        Shop shop = this.shopMapper.selectByPrimaryKey(serviceOrder.getShop_id());
        if (shop == null || shop.getIs_disable()) {
            return -2;
        }

        Car car = this.carMapper.selectByPrimaryKey(serviceOrder.getCar_id());
        if (car == null) {
            return -3;
        }

        WxUserExample wxUserExample = new WxUserExample();
        wxUserExample.createCriteria().andUser_idEqualTo(dto.getUser_id());
        List<WxUser> wxUsers = this.wxUserMapper.selectByExample(wxUserExample);
        if (CollectionUtils.isEmpty(wxUsers)) {
            return -4;
        }

        ShopEvaluateDetail detail = new ShopEvaluateDetail();
        detail.setCar_type(car.getCar_type_name());
        detail.setEvaluate_content(dto.getEvaluate_content());
        detail.setEvaluate_score(dto.getEvaluate_score());
        Date now = new Date();
        detail.setGmt_create(now);
        detail.setGmt_evaluate_commit(now);
        detail.setGmt_repair(serviceOrder.getGmt_actual_service());
        detail.setNick_name(user.getNick_name());
        detail.setUser_id(user.getUser_id());
        detail.setShop_id(shop.getId());
        detail.setOrder_id(dto.getOrder_id());
        detail.setUser_head(wxUsers.get(0).getUser_head());
        detail.setIs_invalid(false);
        detail.setVersion(0);

        int ret = this.shopEvaluateDetailMapper.insert(detail);
        if (ret > 0) {
            serviceOrder.setEvaluate_id(detail.getId());
            serviceOrder.setGmt_evaluate(now);
            serviceOrder.setOrder_status(ServiceOrderStatus.finish.getCode());
            serviceOrder.setChild_status(ServiceOrderStatus.finish.getCode());
            ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
            if (ret > 0) {
                if (StringUtils.isNotEmpty(dto.getEvaluate_tags())) {
                    ret = updateShopTagEvaluateTag(shop, dto.getEvaluate_tags());
                }
                if (ret > 0) {
                    ret = saveCarUserServiceOrderEvent(now, serviceOrder, "车主已评价");
                }
            }
        }
        return ret;
    }

    public PayFeeDetailDTO getPayInfo(WxUser currentLoginUser, Long order_id) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(order_id);
        if (serviceOrder == null
//                || !serviceOrder.getUser_id().equals(currentLoginUser.getUser_id())
        ) {
            return null;
        }

        PayFeeDetailDTO result = new PayFeeDetailDTO();
        result.setOrder_id(serviceOrder.getId());
        result.setOrder_string_id(serviceOrder.getOrder_string_id());
        if (serviceOrder.getPay_id() != null) {
            Pay pay = this.payMapper.selectByPrimaryKey(serviceOrder.getPay_id());
            if (pay != null) {
                result = PayFeeDetailDTO.build(serviceOrder, pay);
                OrderFeeDetailExample feeDetailExample = new OrderFeeDetailExample();
                feeDetailExample.createCriteria().andOrder_idEqualTo(order_id).andPay_idEqualTo(serviceOrder.getPay_id());
                List<OrderFeeDetail> feeDetails = this.orderFeeDetailMapper.selectByExample(feeDetailExample);
                if (!CollectionUtils.isEmpty(feeDetails)) {
                    result.addOrderFeeDetails(feeDetails);
                }
            }
        }
        return result;
    }

    public int cancelOrder(WxUser currentLoginUser, CancelOrderRequestDTO dto) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(dto.getOrder_id());
        if (serviceOrder == null || !serviceOrder.getUser_id().equals(currentLoginUser.getUser_id())) {
            return -1;
        }

        if (!ServiceOrderStatus.parse(serviceOrder.getOrder_status()).isAllow_cancel()) {
            return -2;
        }

        serviceOrder.setOrder_status(ServiceOrderStatus.cancle.getCode());
        serviceOrder.setChild_status(ServiceOrderStatus.order_cancel.getCode());
        Date now = new Date();
        serviceOrder.setGmt_modify(now);
        int ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
        return ret;
    }

    public ShopOrderSumInfoResponseDTO getShopOrderSumInfo(Long shop_user_id, Long shop_id) {
        Shop shop = this.shopMapper.selectByPrimaryKey(shop_id);
        if (shop == null || shop.getIs_disable()) {
            return null;
        }

        ShopAdminUserExample example = new ShopAdminUserExample();
        example.createCriteria().andShop_idEqualTo(shop_id).andIdEqualTo(shop_user_id);
        List<ShopAdminUser> adminUsers = this.shopAdminUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(adminUsers)) {
            return null;
        }
        ShopAdminUser adminUser = adminUsers.get(0);
        ShopAdminUserDetailInfoExample example1 = new ShopAdminUserDetailInfoExample();
        example1.createCriteria().andAccountEqualTo(adminUser.getAccount()).andShop_idEqualTo(adminUser.getShop_id());
        List<ShopAdminUserDetailInfo> detailInfos = this.shopAdminUserDetailInfoMapper.selectByExample(example1);
        ShopOrderSumInfoResponseDTO dto = new ShopOrderSumInfoResponseDTO();
        if (!CollectionUtils.isEmpty(detailInfos)) {
            ShopAdminUserDetailInfo detailInfo = detailInfos.get(0);
            dto.setUser_name(detailInfo.getReal_name());
            dto.setShop_name(shop.getEnterprise_name());
        }

        ServiceOrderExample serviceOrderExample = new ServiceOrderExample();
        serviceOrderExample.createCriteria().andShop_idEqualTo(shop_id);
        List<ServiceOrder> serviceOrders = this.serviceOrderMapper.selectByExample(serviceOrderExample);

        int servicing_orders = 0;//保养中
        int have_exception_orders = 0;//检测异常
        int added_service_orders = 0;//附加服务中
        int have_finished_orders = 0;//已完成

        if (!CollectionUtils.isEmpty(serviceOrders)) {
            for (int i = 0; i < serviceOrders.size(); ++i) {
                ServiceOrder eachOrder = serviceOrders.get(i);
                if (eachOrder.getOrder_status().equals(ServiceOrderStatus.servicing.getCode())
                        && eachOrder.getChild_status().equals(ServiceOrderStatus.report_have_exception.getCode())) {
                    have_exception_orders++;//检测异常
                    break;
                }


                if (eachOrder.getOrder_status().equals(ServiceOrderStatus.servicing.getCode())
                        && (eachOrder.getOrder_status().equals(ServiceOrderStatus.value_added_services_mending.getCode())
                        || eachOrder.getOrder_status().equals(ServiceOrderStatus.value_added_services_mend_finish.getCode())
                        || eachOrder.getOrder_status().equals(ServiceOrderStatus.value_added_services_mend_pass.getCode()))) {
                    added_service_orders++;//附加服务中
                    break;
                }

                if (eachOrder.getOrder_status().equals(ServiceOrderStatus.servicing.getCode())) {
                    servicing_orders++;//保养中
                    break;
                }


                if (eachOrder.getOrder_status().equals(ServiceOrderStatus.finish.getCode())
                        || eachOrder.getOrder_status().equals(ServiceOrderStatus.to_evaluate.getCode())) {
                    have_finished_orders++;//已完成
                }
            }
        }

        dto.setServicing_orders(servicing_orders);
        dto.setHave_exception_orders(have_exception_orders);
        dto.setAdded_service_orders(added_service_orders);
        dto.setHave_finished_orders(have_finished_orders);
        return dto;
    }

    public ScanOrderInfoResponseDTO getScanOrderInfo(Long order_id, Long shop_user_id) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(order_id);
        if (serviceOrder == null) {
            return null;
        }

        WxUserExample wxUserExample = new WxUserExample();
        wxUserExample.createCriteria().andUser_idEqualTo(serviceOrder.getUser_id());
        List<WxUser> wxUsers = this.wxUserMapper.selectByExample(wxUserExample);
        WxUser wxUser = null;
        if (!CollectionUtils.isEmpty(wxUsers)) {
            wxUser = wxUsers.get(0);
        }

        Shop shop = this.shopMapper.selectByPrimaryKey(serviceOrder.getShop_id());
        if (shop == null || shop.getIs_disable()) {
            return null;
        }

        ShopAdminUser shopAdminUser = this.shopAdminUserMapper.selectByPrimaryKey(shop_user_id);
        if (shopAdminUser == null) {
            return null;
        }

        if (serviceOrder.getShop_id() != shopAdminUser.getShop_id()) {
            return null;
        }

        Car car = this.carMapper.selectByPrimaryKey(serviceOrder.getCar_id());
        if (car == null) {
            return null;
        }

        EngineOil engineOil = this.engineOilMapper.selectByPrimaryKey(serviceOrder.getOil_id());

        Date now = new Date();
        int ret = 0;
        ShopAdminUserDetailInfoExample shopAdminUserDetailInfoExample = new ShopAdminUserDetailInfoExample();
        shopAdminUserDetailInfoExample.createCriteria().andShop_idEqualTo(serviceOrder.getShop_id()).andAccountEqualTo(shopAdminUser.getAccount());
        List<ShopAdminUserDetailInfo> detailInfos = this.shopAdminUserDetailInfoMapper.selectByExample(shopAdminUserDetailInfoExample);
        if (!CollectionUtils.isEmpty(detailInfos)) {
            ShopAdminUserDetailInfo info = detailInfos.get(0);
            serviceOrder.setShop_user_id(shopAdminUser.getId());
            serviceOrder.setShop_user_account(shopAdminUser.getAccount());
            serviceOrder.setShop_user_name(info.getReal_name());
            ret = saveServiceOrderEvent(now, serviceOrder, shop_user_id,
                    ServiceOrderStatus.order_taking.getDesc());
        }

        if (ret < 0) {
            return null;
        }

        serviceOrder.setChild_status(ServiceOrderStatus.order_taking.getCode());
        serviceOrder.setGmt_actual_service(now);
        serviceOrder.setGmt_modify(now);
        ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);

        if (ret < 0) {
            return null;
        }

        ScanOrderInfoResponseDTO dto = ScanOrderInfoResponseDTO.build(serviceOrder, shop,
                car, engineOil, wxUser, riskCheckService.checkCarUserHaveRisk(wxUser));

        ShopOilSupplyExample oilSupplyExample = new ShopOilSupplyExample();
        oilSupplyExample.createCriteria().andShop_idEqualTo(serviceOrder.getShop_id());
        List<ShopOilSupply> oilSupplies = this.shopOilSupplyMapper.selectByExample(oilSupplyExample);
        Set<Long> oil_ids = new HashSet<Long>();
        for (int k = 0; k < oilSupplies.size(); ++k) {
            oil_ids.add(oilSupplies.get(k).getOil_id());
        }

        List<Long> oil_id_list = new ArrayList<Long>();
        for (Long value : oil_ids) {
            oil_id_list.add(value);
        }

        if (oil_id_list.size() > 0) {
            EngineOilExample oilExample = new EngineOilExample();
            oilExample.createCriteria().andIdIn(oil_id_list);
            oilExample.setOrderByClause("oil_type desc,gmt_create desc");
            List<EngineOil> engineOils = this.engineOilMapper.selectByExample(oilExample);
            for (EngineOil oil : engineOils) {
                dto.addOil(new OilInfoResponseDTO(oil));
            }
        }

        return dto;
    }

    public int uploadPhotoAndStartService(UploadPhotoAndStartServiceRequestDTO dto) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(dto.getOrder_id());
        if (serviceOrder == null) {
            return -1;
        }

        Car myCar = this.carMapper.selectByPrimaryKey(serviceOrder.getCar_id());
        if (myCar == null) {
            return -3;
        }

        /**
         * 如果已经存在上次维修记录
         */
        if (StringUtils.isNoneBlank(myCar.getNext_maintenance_miles())) {
            String curr_miles = dto.getCurr_miles();
            //如果当前输入的公里数为空则报错
            if (StringUtils.isBlank(curr_miles)) {
                return -401;
            }
            //如果当前输入的公里数，还没有达到预计可以维修的公里数
            if ((Double.parseDouble(curr_miles) + 1000) < Double.parseDouble(myCar.getNext_maintenance_miles())) {
                return -402;
            }
        }

        serviceOrder.setOrder_status(ServiceOrderStatus.servicing.getCode());
        serviceOrder.setChild_status(ServiceOrderStatus.upkeep_servicing.getCode());

        Date now = new Date();
        int ret = 0;
        ret = saveServiceOrderEvent(now, serviceOrder, dto.getShop_user_id(),
                ServiceOrderStatus.upkeep_servicing.getDesc());
        if (ret < 0) {
            return ret;
        }

        myCar.setLast_maintenance_miles(myCar.getCurr_maintenance_miles());
        myCar.setCurr_maintenance_miles(dto.getCurr_miles());
        myCar.setGmt_modify(now);
        ret = this.carMapper.updateByPrimaryKeySelective(myCar);
        if (ret < 0) {
            return ret;
        }

        serviceOrder.setGmt_modify(now);
        serviceOrder.setGmt_actual_service(now);
        serviceOrder.setCurr_maintenance_miles(dto.getCurr_miles());
        serviceOrder.setCar_front_photo_url(dto.getCar_front_photo_url());
        serviceOrder.setCar_dashboard_photo_url(dto.getCar_dashboard_photo_url());
        if(dto.getNew_oil_id() != null && StringUtils.isNotEmpty(dto.getNew_oil_brand())){
            serviceOrder.setOil_id(dto.getNew_oil_id());
            serviceOrder.setOil_brand(dto.getNew_oil_brand());
        }
        ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);

        return ret;
    }


    public int shopConfirmOrder(ShopConfirmOrderRequestDTO dto) {
        int ret = 0;
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(dto.getOrder_id());
        if (serviceOrder == null) {
            return -1;
        }
        Date now = new Date();
        serviceOrder.setGmt_confirm(now);
        serviceOrder.setGmt_modify(now);
        if (dto.isSuccess()) {
            if (serviceOrder.getOrder_status().equals(ServiceOrderStatus.ordering.getCode())
                    && serviceOrder.getChild_status().equals(ServiceOrderStatus.order_submit.getCode())) {
                serviceOrder.setChild_status(ServiceOrderStatus.order_succeed.getCode());
                try {
                    String prefix = cacheService.getConfig(Constants.SYSTEM_CURRENT_API_HOST);
                    String url = prefix + "/adminservice/h5/merchant/indexMerchant.html#/tab/scan?orderId=" + serviceOrder.getId();
                    String img_url = fileSerivce.generateQRCodeImage(url);
                    serviceOrder.setOrder_qr_code(img_url);
                    ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
                    if (ret > 0) {
                        ret = saveServiceOrderEvent(now, serviceOrder, dto.getShop_user_id(), "门店确认预约成功");
                        //亲爱的${car_plate}会员，您已经预约成功，请按约定时间前往维修。
                        WxUserExample example = new WxUserExample();
                        example.createCriteria().andUser_idEqualTo(serviceOrder.getUser_id());
                        List<WxUser> wxUsers = wxUserMapper.selectByExample(example);
                        if (!CollectionUtils.isEmpty(wxUsers)) {
                            smsService.sendSMSNotifyRetry("SMS_181195016", wxUsers.get(0).getPhone(), serviceOrder.getCar_plate());
                        }


                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return -3;
                }
            } else {
                return -2;
            }
        } else {
            if (StringUtils.isEmpty(dto.getGmt_change_service_date())) {
                serviceOrder.setChild_status(ServiceOrderStatus.order_fail.getCode());
            } else if (StringUtils.isNotEmpty(dto.getGmt_change_service_begin_time())) {
                serviceOrder.setChild_status(ServiceOrderStatus.order_modify.getCode());
                serviceOrder.setGmt_change_service_date(dto.getGmt_change_service_date());
                serviceOrder.setGmt_change_service_begin_time(dto.getGmt_change_service_begin_time());
            }
            ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
            if (ret > 0) {
                if (StringUtils.isEmpty(dto.getGmt_change_service_date())) {
                    ret = saveServiceOrderEvent(now, serviceOrder, dto.getShop_user_id(), "门店确认预约失败");
                } else if (StringUtils.isNotEmpty(dto.getGmt_change_service_begin_time())) {
                    ret = saveServiceOrderEvent(now, serviceOrder, dto.getShop_user_id(), ServiceOrderStatus.order_modify.getDesc());
                    WxUserExample example = new WxUserExample();
                    example.createCriteria().andUser_idEqualTo(serviceOrder.getUser_id());
                    List<WxUser> wxUsers = wxUserMapper.selectByExample(example);
                    if (!CollectionUtils.isEmpty(wxUsers)) {
                        //亲爱的${car_plate}会员，您的预约订单时间已被修改，请登陆EGE公众号确认。
                        smsService.sendSMSNotifyRetry("SMS_181195017", wxUsers.get(0).getPhone(), serviceOrder.getCar_plate());
                    }
                }
            }
        }

        return ret;
    }

    public int carUserConfirmOrder(CarUserConfirmOrderRequestDTO dto, WxUser wxUser) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(dto.getOrder_id());
        if (serviceOrder == null) {
            return -1;
        }

        if (serviceOrder.getUser_id() == null
                || !serviceOrder.getUser_id().equals(wxUser.getUser_id())) {
            return -3;
        }

        if (!(serviceOrder.getOrder_status().equals(ServiceOrderStatus.ordering.getCode())
                && serviceOrder.getChild_status().equals(ServiceOrderStatus.order_modify.getCode()))) {
            return -2;
        }

        Date now = new Date();
        int ret = 0;
        if (dto.isSuccess()) {
            serviceOrder.setChild_status(ServiceOrderStatus.order_succeed.getCode());
            try {
                String prefix = cacheService.getConfig(Constants.SYSTEM_CURRENT_API_HOST);
                String url = prefix + "/adminservice/h5/merchant/indexMerchant.html#/tab/scan?orderId=" + serviceOrder.getId();
                serviceOrder.setGmt_service_date(serviceOrder.getGmt_change_service_date());
                serviceOrder.setGmt_service_begin_time(serviceOrder.getGmt_change_service_begin_time());
                serviceOrder.setGmt_service_end_time(serviceOrder.getGmt_change_service_end_time());
                serviceOrder.setOrder_qr_code(fileSerivce.generateQRCodeImage(url));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -4;
            }
        } else {
            serviceOrder.setChild_status(ServiceOrderStatus.order_fail.getCode());
        }
        serviceOrder.setGmt_confirm(now);
        serviceOrder.setGmt_modify(now);
        ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
        if (ret > 0) {
            if (dto.isSuccess()) {
                ret = saveCarUserServiceOrderEvent(now, serviceOrder, "车主确认改约成功");
            } else {
                ret = saveCarUserServiceOrderEvent(now, serviceOrder, "车主确认改约失败");
            }
        }
        return ret;
    }

    public int shopConfirmOrderHavePay(ShopConfirmOrderHavePayRequestDTO dto) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(dto.getOrder_id());
        if (serviceOrder == null) {
            return -1;
        }
        if (serviceOrder.getOrder_status().equals(ServiceOrderStatus.to_evaluate.getCode())
                || serviceOrder.getOrder_status().equals(ServiceOrderStatus.finish.getCode())) {
            CommonUtil.info("shopConfirmOrderHavePay", "alreadyPaid",
                    new String[]{"orderStatus=" + serviceOrder.getOrder_status(), ",orderId=" + serviceOrder.getOrder_string_id()}, null);
            return 0;
        }
        Date now = new Date();
        serviceOrder.setGmt_confirm(now);
        serviceOrder.setGmt_modify(now);

        if (serviceOrder.getPay_id() == null) {
            return -3;
        }

        Pay pay = this.payMapper.selectByPrimaryKey(serviceOrder.getPay_id());
        if (pay == null) {
            return -3;
        }
        pay.setGmt_modify(now);
        pay.setGmt_pay_finish(now);

        int ret = 0;
        if (dto.isPay_status()) {
            if (serviceOrder.getOrder_status().equals(ServiceOrderStatus.shop_to_confirm_have_pay.getCode())
                    && pay.getPay_mode().equals(PayModeEnum.pay_by_other.getCode())
                    && !pay.getPay_status().equals(PayStatusEnum.succeed.getCode())) {
                serviceOrder.setOrder_status(ServiceOrderStatus.to_evaluate.getCode());
                serviceOrder.setChild_status(ServiceOrderStatus.to_evaluate.getCode());
                ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
                if (ret > 0) {
                    pay.setPay_status(PayStatusEnum.succeed.getCode());
                    ret = this.payMapper.updateByPrimaryKeySelective(pay);
                    if (ret > 0) {
                        ret = saveServiceOrderEvent(now, serviceOrder, dto.getShop_user_id(),
                                "门店确认车主支付成功," + ServiceOrderStatus.to_evaluate.getDesc());
                        Shop shop = this.shopMapper.selectByPrimaryKey(serviceOrder.getShop_id());
                        if ((ret > 0) && (shop != null)) {
                            ShopAdminUser shopAdminUser = this.shopAdminUserMapper.selectByPrimaryKey(dto.getShop_user_id());
                            ShopAdminUserDetailInfoExample shopAdminUserDetailInfoExample = new ShopAdminUserDetailInfoExample();
                            shopAdminUserDetailInfoExample.createCriteria().andShop_idEqualTo(serviceOrder.getShop_id()).andAccountEqualTo(shopAdminUser.getAccount());
                            List<ShopAdminUserDetailInfo> detailInfos = this.shopAdminUserDetailInfoMapper.selectByExample(shopAdminUserDetailInfoExample);
                            if (!CollectionUtils.isEmpty(detailInfos)) {
                                ShopAdminUserDetailInfo detailInfo = detailInfos.get(0);
                                CapitalFlowDTO capitalFlowDTO = new CapitalFlowDTO();
                                capitalFlowDTO.setAccount(shopAdminUser.getAccount());
                                capitalFlowDTO.setReal_name(detailInfo.getReal_name());
                                capitalFlowDTO.setAmount(pay.getFinal_fee());
                                if (pay.getPay_mode().equals(PayModeEnum.pay_by_wechat.getCode())) {
                                    capitalFlowDTO.setOperate_type(CapitalFlowTypeEnum.wx_collect.getCode());
                                    capitalFlowDTO.setDescription(CapitalFlowTypeEnum.wx_collect.getDesc());
                                } else if (pay.getPay_mode().equals(PayModeEnum.pay_by_other.getCode())) {
                                    capitalFlowDTO.setOperate_type(CapitalFlowTypeEnum.other_collect.getCode());
                                    capitalFlowDTO.setDescription(CapitalFlowTypeEnum.other_collect.getDesc());
                                }
                                capitalFlowDTO.setOrder_id(serviceOrder.getId());
                                capitalFlowDTO.setOrder_string_id(serviceOrder.getOrder_string_id());
                                ret = this.capitalFlowService.insertFlow(capitalFlowDTO, shop);
                                CommonUtil.info("shopConfirmOrderHavePay", "paySuccess",
                                        new String[]{"orderStatus=" + serviceOrder.getOrder_status(), ",orderId=" + serviceOrder.getOrder_string_id(),
                                                ",payMode=" + pay.getPay_mode(), ",payStatus=" + pay.getPay_status(), ",payId=" + pay.getId()}, ret);
                            }
                        }
                    }
                }
            } else {
                CommonUtil.info("shopConfirmOrderHavePay", "statusConflict",
                        new String[]{"orderStatus=" + serviceOrder.getOrder_status(), ",orderId=" + serviceOrder.getOrder_string_id(),
                                ",payMode=" + pay.getPay_mode(), ",payStatus=" + pay.getPay_status(), ",payId=" + pay.getId()}, null);
                return -2;
            }
        } else {
            if (serviceOrder.getOrder_status().equals(ServiceOrderStatus.shop_to_confirm_have_pay.getCode())
                    && pay.getPay_mode().equals(PayModeEnum.pay_by_other.getCode())) {
                pay.setPay_status(PayStatusEnum.fail.getCode());
                ret = this.payMapper.updateByPrimaryKeySelective(pay);
                if (ret > 0) {
                    ret = saveServiceOrderEvent(now, serviceOrder, dto.getShop_user_id(),
                            "门店确认车主支付失败");
                }
            }
        }
        return ret;
    }

    public int carUserPay(CarUserPayRequestDTO dto, WxUser wxUser) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(dto.getOrder_id());
        if (serviceOrder == null) {
            return -1;
        }

        if (!serviceOrder.getUser_id().equals(wxUser.getUser_id())) {
            return -4;
        }

        Date now = new Date();
        serviceOrder.setGmt_pay(now);
        serviceOrder.setGmt_modify(now);

        if (serviceOrder.getPay_id() == null) {
            return -3;
        }

        Pay pay = this.payMapper.selectByPrimaryKey(serviceOrder.getPay_id());
        if (pay == null) {
            return -3;
        }
        if (pay.getPay_status().equals(PayStatusEnum.succeed.getCode())) {
            return -2;
        }
        pay.setGmt_modify(now);
        pay.setGmt_pay_finish(now);

        int ret = 0;
        if (dto.getPay_mode().equals(PayModeEnum.pay_by_wechat)) {
            pay.setPay_mode(PayModeEnum.pay_by_wechat.getCode());
            //todo 调用微信支付 入资金账户  入资金流水表 更新订单状态及支付订单信息
            pay.setPay_status(PayStatusEnum.succeed.getCode());
            serviceOrder.setOrder_status(ServiceOrderStatus.to_evaluate.getCode());
        } else if (dto.getPay_mode().equals(PayModeEnum.pay_by_other.getCode())) {
            pay.setPay_mode(PayModeEnum.pay_by_other.getCode());
            pay.setPay_status(PayStatusEnum.to_be_confirm_by_shop.getCode());
            serviceOrder.setChild_status(ServiceOrderStatus.shop_to_confirm_have_pay.getCode());
            serviceOrder.setOrder_status(ServiceOrderStatus.shop_to_confirm_have_pay.getCode());
        }
        ret = this.payMapper.updateByPrimaryKeySelective(pay);
        if (ret > 0) {
            ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
            if (ret > 0) {
                if (dto.getPay_mode().equals(PayModeEnum.pay_by_wechat.getCode()) && pay.getPay_status().equals(PayStatusEnum.succeed.getCode())) {
                    ret = saveCarUserServiceOrderEvent(now, serviceOrder,
                            PayModeEnum.pay_by_wechat.getDesc() + "成功," + ServiceOrderStatus.to_evaluate.getDesc());
                }
                if (dto.getPay_mode().equals(PayModeEnum.pay_by_wechat.getCode()) && pay.getPay_status().equals(PayStatusEnum.fail.getCode())) {
                    ret = saveCarUserServiceOrderEvent(now, serviceOrder, PayModeEnum.pay_by_wechat.getDesc() + "失败");
                } else if (dto.getPay_mode().equals(PayModeEnum.pay_by_other.getCode()) && pay.getPay_status().equals(PayStatusEnum.to_be_confirm_by_shop.getCode())) {
                    ret = saveCarUserServiceOrderEvent(now, serviceOrder, ServiceOrderStatus.shop_to_confirm_have_pay.getDesc());
                }
            }
        }
        return ret;
    }

    public int saveCarUserServiceOrderEvent(Date now, ServiceOrder serviceOrder, String event_desc) {
        int ret = 0;
        WxUserExample wxUserExample = new WxUserExample();
        wxUserExample.createCriteria().andUser_idEqualTo(serviceOrder.getUser_id());
        List<WxUser> wxUsers = this.wxUserMapper.selectByExample(wxUserExample);
        if (!CollectionUtils.isEmpty(wxUsers)) {
            WxUser wxUser = wxUsers.get(0);
            ServiceOrderEvent serviceOrderEvent = new ServiceOrderEvent();
            serviceOrderEvent.setEvent_staff_id(String.valueOf(wxUser.getId()));
            serviceOrderEvent.setIs_car_user_operate(true);
            if (StringUtils.isEmpty(wxUser.getUser_name())) {
                serviceOrderEvent.setEvent_staff_name(wxUser.getNick_name());
            } else {
                serviceOrderEvent.setEvent_staff_name(wxUser.getUser_name());
            }
            serviceOrderEvent.setGmt_event(now);
            serviceOrderEvent.setGmt_create(now);
            serviceOrderEvent.setOrder_id(serviceOrder.getId());
            serviceOrderEvent.setOrder_string_id(serviceOrder.getOrder_string_id());
            serviceOrderEvent.setResult(true);
            serviceOrderEvent.setEvent_desc(event_desc);
            ret = this.serviceOrderEventMapper.insert(serviceOrderEvent);
        }
        return ret;
    }

    public int saveServiceOrderEvent(Date now, ServiceOrder serviceOrder, Long shop_user_id, String event_desc) {
        ShopAdminUser shopAdminUser = this.shopAdminUserMapper.selectByPrimaryKey(shop_user_id);
        if (shopAdminUser == null) {
            return -2;
        }
        int ret = 0;
        ShopAdminUserDetailInfoExample shopAdminUserDetailInfoExample = new ShopAdminUserDetailInfoExample();
        shopAdminUserDetailInfoExample.createCriteria().andShop_idEqualTo(serviceOrder.getShop_id()).andAccountEqualTo(shopAdminUser.getAccount());
        List<ShopAdminUserDetailInfo> detailInfos = this.shopAdminUserDetailInfoMapper.selectByExample(shopAdminUserDetailInfoExample);
        if (!CollectionUtils.isEmpty(detailInfos)) {
            ShopAdminUserDetailInfo info = detailInfos.get(0);
            ServiceOrderEvent serviceOrderEvent = new ServiceOrderEvent();
            serviceOrderEvent.setEvent_staff_id(String.valueOf(shopAdminUser.getId()));
            serviceOrderEvent.setEvent_staff_name(info.getReal_name());
            serviceOrderEvent.setEvent_staff_role(shopAdminUser.getRole_type());
            serviceOrderEvent.setIs_car_user_operate(false);
            serviceOrderEvent.setGmt_event(now);
            serviceOrderEvent.setGmt_create(now);
            serviceOrderEvent.setOrder_id(serviceOrder.getId());
            serviceOrderEvent.setOrder_string_id(serviceOrder.getOrder_string_id());
            serviceOrderEvent.setResult(true);
            serviceOrderEvent.setEvent_desc(event_desc);
            ret = this.serviceOrderEventMapper.insert(serviceOrderEvent);
        }
        return ret;
    }

    public int submitPayFeeDetail(SubmitPayFeeDetailRequestDTO dto) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(dto.getOrder_id());
        if (serviceOrder == null) {
            return -1;
        }

        if (serviceOrder.getOrder_status().equals(ServiceOrderStatus.to_evaluate.getCode())
                || serviceOrder.getOrder_status().equals(ServiceOrderStatus.finish.getCode())
                || serviceOrder.getOrder_status().equals(ServiceOrderStatus.shop_to_confirm_have_pay.getCode())
                || serviceOrder.getOrder_status().equals(ServiceOrderStatus.cancle.getCode())) {
            return -2;
        }

        if (serviceOrder.getPay_id() != null) {
            this.payMapper.deleteByPrimaryKey(serviceOrder.getPay_id());
            OrderFeeDetailExample orderFeeDetailExample = new OrderFeeDetailExample();
            orderFeeDetailExample.createCriteria().andPay_idEqualTo(serviceOrder.getPay_id()).andOrder_idEqualTo(serviceOrder.getId());
            this.orderFeeDetailMapper.deleteByExample(orderFeeDetailExample);
        }

        Date now = new Date();

        Pay pay = new Pay();
        pay.setPay_status(PayStatusEnum.not_pay.getCode());
        pay.setGmt_pay_create(now);
        pay.setGmt_create(now);
        pay.setOrder_id(serviceOrder.getId());
        pay.setOrder_string_id(serviceOrder.getOrder_string_id());
        pay.setBefore_discount_fee("0");
        this.payMapper.insert(pay);

        double before_discount_fee = 0;
        int ret = 0;
        List<OrderFeeDetailRequestDTO> feeDetails = dto.getFeeDetails();
        if (CollectionUtils.isEmpty(feeDetails)) {
            pay.setBefore_discount_fee("0");
            pay.setFinal_fee("0");
            pay.setCoupon_ids("");
            pay.setDiscount_fee("0");
        } else {
            for (int i = 0; i < feeDetails.size(); ++i) {
                OrderFeeDetailRequestDTO eachFee = feeDetails.get(i);
                OrderFeeDetail detail = new OrderFeeDetail();
                detail.setEach_fee(eachFee.getEach_fee());
                detail.setEach_item(eachFee.getEach_item());
                detail.setOrder_id(serviceOrder.getId());
                detail.setOrder_string_id(serviceOrder.getOrder_string_id());
                detail.setGmt_create(now);
                detail.setPay_id(pay.getId());
                before_discount_fee += Double.parseDouble(eachFee.getEach_fee());
                ret = this.orderFeeDetailMapper.insert(detail);
                if (ret <= 0) {
                    return 0;
                }
            }
            pay.setBefore_discount_fee(String.valueOf(before_discount_fee));
            //todo 暂时不考虑优惠信息
            pay.setFinal_fee(String.valueOf(before_discount_fee));
            pay.setCoupon_ids("");
            pay.setDiscount_fee("0");
        }

        Date now2 = new Date();
        pay.setGmt_modify(now2);
        if (Double.parseDouble(pay.getFinal_fee()) > 0) {
            pay.setPay_status(PayStatusEnum.not_pay.getCode());
        } else {
            pay.setPay_status(PayStatusEnum.succeed.getCode());
        }
        ret = this.payMapper.updateByPrimaryKeySelective(pay);
        if (ret > 0) {
            serviceOrder.setPay_id(pay.getId());
            serviceOrder.setFinal_fee(String.valueOf(before_discount_fee));//优惠券只在车主端计算
            serviceOrder.setGmt_modify(now2);

            String desc = "";
            if (Double.parseDouble(serviceOrder.getFinal_fee()) > 0) {
                serviceOrder.setOrder_status(ServiceOrderStatus.to_pay.getCode());
                desc = ServiceOrderStatus.to_pay.getDesc();
            } else {
                serviceOrder.setOrder_status(ServiceOrderStatus.to_evaluate.getCode());
                desc = ServiceOrderStatus.to_evaluate.getDesc();
            }

            ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
            if (ret > 0) {
                ret = saveServiceOrderEvent(now, serviceOrder, dto.getShop_user_id(), desc);
            }
        }
        return ret;
    }

    public CarUserIgnoreExceptionResponseDTO carUserIgnoreException(CarUserIgnoreExceptionRequestDTO dto) {
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(dto.getOrder_id());
        if (serviceOrder == null) {
            return null;
        }

        Date now = new Date();
        int ret = 0;
        boolean f1 = serviceOrder.getOrder_status().equals(ServiceOrderStatus.servicing.getCode());
        boolean f2 = serviceOrder.getChild_status().equals(ServiceOrderStatus.report_have_exception.getCode());
        if (f1 && f2) {
            serviceOrder.setGmt_modify(now);
            serviceOrder.setChild_status(ServiceOrderStatus.exception_ignore.getCode());
            ret = this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
            if (ret > 0) {
                ret = saveCarUserServiceOrderEvent(now, serviceOrder, ServiceOrderStatus.exception_ignore.getDesc());
                if (ret > 0) {
                    if ((serviceOrder.getPay_id() != null)
                            && (StringUtils.isNotEmpty(serviceOrder.getFinal_fee()))
                            && (Double.parseDouble(serviceOrder.getFinal_fee()) > 0)) {
                        serviceOrder.setOrder_status(ServiceOrderStatus.to_pay.getCode());
                    } else {
                        serviceOrder.setOrder_status(ServiceOrderStatus.to_evaluate.getCode());
                    }
                    this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
                }
                CarUserIgnoreExceptionResponseDTO responseDTO = new CarUserIgnoreExceptionResponseDTO();
                responseDTO.setOrder_status(serviceOrder.getOrder_status());
                responseDTO.setChild_status(serviceOrder.getChild_status());
                return responseDTO;
            }
        } else {
            return null;
        }

        return null;
    }

    public ServiceOrderResponseListDTO getOrderListByShopId(Long shop_id, String order_status,
                                                            String search_type, String keyword,
                                                            int currentPage, int showCount) {
        ServiceOrderExample example = new ServiceOrderExample();
        ServiceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andShop_idEqualTo(shop_id);
        if (StringUtils.isNotEmpty(search_type) && StringUtils.isNotEmpty(keyword)) {
            if (search_type.equals(KeywordTypeEnum.car_type.getCode())) {
                criteria.andCar_type_nameLike("%" + keyword + "%");
            } else if (search_type.equals(KeywordTypeEnum.plate.getCode())) {
                criteria.andCar_plateLike("%" + keyword + "%");
            }
        }
        if (StringUtils.isNotEmpty(order_status)) {
            if (!order_status.equalsIgnoreCase("ALL")) {
                if (order_status.equals("1")) {
                    criteria.andOrder_statusEqualTo(ServiceOrderStatus.servicing.getCode());
                } else if (order_status.equals("2")) {
                    criteria.andOrder_statusEqualTo(ServiceOrderStatus.servicing.getCode()).andChild_statusEqualTo(ServiceOrderStatus.report_have_exception.getCode());
                } else if (order_status.equals("3")) {
                    List<String> child_statusL_added_service = new ArrayList<String>();
                    child_statusL_added_service.add(ServiceOrderStatus.value_added_services_mending.getCode());
                    child_statusL_added_service.add(ServiceOrderStatus.value_added_services_mend_finish.getCode());
                    child_statusL_added_service.add(ServiceOrderStatus.value_added_services_mend_pass.getCode());
                    criteria.andOrder_statusEqualTo(ServiceOrderStatus.servicing.getCode()).andChild_statusIn(child_statusL_added_service);
                } else if (order_status.equals("4")) {
                    List<String> order_status_list = new ArrayList<String>();
                    order_status_list.add(ServiceOrderStatus.to_evaluate.getCode());
                    order_status_list.add(ServiceOrderStatus.finish.getCode());
                    criteria.andOrder_statusIn(order_status_list);
                }
            }
        }
        example.setOrderByClause("gmt_create desc");
        ServiceOrderResponseListDTO result = new ServiceOrderResponseListDTO();

        int totalRecord = serviceOrderMapper.countByExample(example);
        int totalPage = PageCountUtil.computeTotalPageByCount(totalRecord, showCount);
        result.addPageInfo(totalPage, currentPage);

        example.setPageIndex(currentPage);
        example.setPageCount(showCount);
        List<ServiceOrder> serviceOrders = serviceOrderMapper.selectByExample(example);

        Shop shop = this.shopMapper.selectByPrimaryKey(shop_id);
        Map<Long, Shop> shop_map = new HashMap<Long, Shop>();
        shop_map.put(shop_id, shop);


        Set<Long> car_id_set = new HashSet<Long>();
        Set<String> user_id_set = new HashSet<String>();
        if (!CollectionUtils.isEmpty(serviceOrders)) {
            for (int i = 0; i < serviceOrders.size(); ++i) {
                ServiceOrder eachOrder = serviceOrders.get(i);
                car_id_set.add(eachOrder.getCar_id());
                user_id_set.add(eachOrder.getUser_id());
            }
        }

        List<Long> car_id_list = new ArrayList<Long>();
        for (Long carId : car_id_set) {
            car_id_list.add(carId);
        }

        List<String> car_user_id_list = new ArrayList<String>();
        for (String user_id : user_id_set) {
            car_user_id_list.add(user_id);
        }

        Map<String, WxUser> user_id_map = new HashMap<String, WxUser>();
        if (!CollectionUtils.isEmpty(car_user_id_list)) {
            WxUserExample userExample = new WxUserExample();
            userExample.createCriteria().andUser_idIn(car_user_id_list);
            List<WxUser> users = this.wxUserMapper.selectByExample(userExample);
            for (WxUser wxUser : users) {
                user_id_map.put(wxUser.getUser_id(), wxUser);
            }
        }

        Map<Long, Car> car_map = new HashMap<Long, Car>();
        if (!CollectionUtils.isEmpty(car_id_list)) {
            CarExample carExample = new CarExample();
            carExample.createCriteria().andIdIn(car_id_list);
            List<Car> cars = this.carMapper.selectByExample(carExample);
            for (Car eachCar : cars) {
                car_map.put(eachCar.getId(), eachCar);
            }
        }

        result.addServiceOrders(serviceOrders, shop_map, car_map, user_id_map);
        return result;
    }

    public ShopServiceOrderResponseDTO getShopOrderInfo(Long order_id) {
        ServiceOrderExample example = new ServiceOrderExample();
        ServiceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andShop_idEqualTo(order_id);
        example.setOrderByClause("gmt_create desc");
        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(order_id);

        if (serviceOrder == null) {
            return null;
        }

        Shop shop = this.shopMapper.selectByPrimaryKey(serviceOrder.getShop_id());
        if (shop == null) {
            return null;
        }

        ShopServiceOrderResponseDTO result = ShopServiceOrderResponseDTO.build(serviceOrder, shop);
        return result;
    }

    public void makeRepeatServiceWxUsers() {
        ServiceOrderExample example = new ServiceOrderExample();
        String currDateStr = DateUtil.getYYYYMMDDStrOfToday() + DateUtil.ZERO_TIME_STR;
        String agoDateStr = DateUtil.minusDay(Long.parseLong(cacheService.getConfig(Constants.repeat_service_days)), currDateStr);

        Date currDate = DateUtil.getDate(currDateStr, DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date agoDate = DateUtil.getDate(agoDateStr, DateUtil.YYYY_MM_DD_HH_MM_SS);
        ServiceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andGmt_actual_serviceBetween(agoDate, currDate);

        List<String> status = new ArrayList<String>();
        status.add(ServiceOrderStatus.finish.getCode());
        status.add(ServiceOrderStatus.to_evaluate.getCode());
        status.add(ServiceOrderStatus.no_pay_and_to_evaluate.getCode());
        criteria.andOrder_statusIn(status);

        example.setOrderByClause("user_id desc, car_plate desc, gmt_actual_service desc");
        List<ServiceOrder> serviceOrders = this.serviceOrderMapper.selectByExample(example);
        List<RepeatServiceWxUsersDTO> resultOrders = new ArrayList<RepeatServiceWxUsersDTO>();
        if(!CollectionUtils.isEmpty(serviceOrders)){
            for (int i = 0; i < serviceOrders.size(); ++i){
                ServiceOrder eachOrder = serviceOrders.get(i);
                int j = 0;
                for (; j < resultOrders.size(); ++j){
                    RepeatServiceWxUsersDTO eachResultOrder = resultOrders.get(j);
                    boolean f = (eachOrder.getUser_id().equals(eachResultOrder.getUser_id()))
                            && (eachOrder.getCar_id() == eachResultOrder.getCar_id())
                            && (eachOrder.getCar_plate().equals(eachResultOrder.getCar_plate()));
                    if(f){
                        eachResultOrder.add(eachOrder);
                        resultOrders.set(j, eachResultOrder);
                        break;
                    }
                }
                if(j == resultOrders.size()){
                    resultOrders.add(RepeatServiceWxUsersDTO.build(eachOrder));
                }
            }
        }

        RepeatServiceWxUsersExample repeatServiceWxUsersExample = new RepeatServiceWxUsersExample();
        repeatServiceWxUsersMapper.deleteByExample(repeatServiceWxUsersExample);
        for(int k = 0; k < resultOrders.size(); ++k){
            RepeatServiceWxUsersDTO eachDTO = resultOrders.get(k);
            if(eachDTO.size() > Integer.parseInt(cacheService.getConfig(Constants.repeat_service_counts))){
                RepeatServiceWxUsers repeatServiceWxUser = RepeatServiceWxUsersDTO.build(eachDTO);
                this.repeatServiceWxUsersMapper.insertSelective(repeatServiceWxUser);
            }
        }
    }
}
