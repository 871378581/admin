package com.segama.ege.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.domain.ServiceOrderStatus;
import com.segama.ege.dto.ReportDTO;
import com.segama.ege.dto.ReportRequestDTO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.CarMapper;
import com.segama.ege.repository.ReportMapper;
import com.segama.ege.repository.ServiceOrderMapper;
import com.segama.ege.repository.ShopMapper;
import com.segama.ege.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.MapUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.segama.ege.domain.ServiceOrderStatus.parseFromCode;

@Component
public class WxTestItemService {

    @Resource
    private ReportMapper reportMapper;

    @Resource
    private ServiceOrderMapper serviceOrderMapper;

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private CarMapper carMapper;

    @Autowired
    private WxOrderService wxOrderService;

    private Logger log = LoggerFactory.getLogger(WxTestItemService.class);

    /**
     * 返回检测项目
     *
     * @param user
     * @param reportRequestDTO
     * @return
     */
    public ReportDTO getTestItem(WxUser user, ReportRequestDTO reportRequestDTO) {

        ServiceOrder serviceOrder = this.serviceOrderMapper.selectByPrimaryKey(reportRequestDTO.getOrder_id());
        if (serviceOrder == null
//                || !serviceOrder.getUser_id().equals(user.getUser_id())
        ) {
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

        ReportDTO reportDTO = new ReportDTO();

        //查询上一次保养记录
        List<String> status = new ArrayList<String>();
        status.add(ServiceOrderStatus.to_evaluate.getCode());
        status.add(ServiceOrderStatus.finish.getCode());
        ServiceOrderExample serviceOrderExample = new ServiceOrderExample();
        serviceOrderExample.createCriteria().andUser_idEqualTo(serviceOrder.getUser_id())
                .andCar_plateEqualTo(serviceOrder.getCar_plate())
                .andIdNotEqualTo(serviceOrder.getId()).andOrder_statusIn(status);
        serviceOrderExample.setOrderByClause("gmt_actual_service desc");
        List<ServiceOrder> serviceOrders = this.serviceOrderMapper.selectByExample(serviceOrderExample);

        if (!CollectionUtils.isEmpty(serviceOrders)) {
            reportDTO.setLast_order_id(serviceOrders.get(0).getId());
        }

        reportDTO.setUser_name(user.getUser_name());
        reportDTO.setCar_plate(car.getPlate());
        reportDTO.setCar_level(car.getCard_level());
        reportDTO.setCar_type(car.getCar_type_name());
        reportDTO.setService_date(DateUtil.parse(serviceOrder.getGmt_actual_service()));
        reportDTO.setLast_maintenance_miles(car.getLast_maintenance_miles());
        reportDTO.setCurr_maintenance_miles(car.getCurr_maintenance_miles());
        reportDTO.setOrder_status(serviceOrder.getOrder_status());
        reportDTO.setChild_status(serviceOrder.getChild_status());
        reportDTO.setOrder_qr_code(serviceOrder.getOrder_qr_code());

        ReportExample example = new ReportExample();
        ReportExample.Criteria criteria = example.createCriteria();
        //订单id
        criteria.andOrder_idEqualTo(reportRequestDTO.getOrder_id());
        List<Report> reports = reportMapper.selectByExampleWithBLOBs(example);
        if (!CollectionUtils.isEmpty(reports)) {
            Report report = reports.get(0);
            if (report != null) {
                BeanUtils.copyProperties(report, reportDTO, "report_items", "gmt_report_date", "gmt_create", "gmt_modify");
                reportDTO.setGmt_report_String(DateUtil.parse(report.getGmt_report_date()));
                reportDTO.setReport_items(JSON.parse(report.getReport_items()));
            }
        }
        return reportDTO;
    }

    /**
     * 新增检测项
     *
     * @param user
     * @param reportRequestDTO
     */
    public void submitTestItem(WxUser user, ReportRequestDTO reportRequestDTO) {
        Report record = new Report();
        BeanUtils.copyProperties(reportRequestDTO, record, "gmt_report_date", "gmt_create", "gmt_modify");
        Date now = new Date();
        record.setGmt_modify(now);
        record.setGmt_create(now);
        record.setGmt_report_date(now);
        if (user != null) {
            record.setCreator_account(user.getAccount());
            record.setModifier_account(user.getAccount());
        }

        //通过订单id反查order_string_id
        ServiceOrderExample example = new ServiceOrderExample();
        ServiceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(reportRequestDTO.getOrder_id());
        List<ServiceOrder> serviceOrders = serviceOrderMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(serviceOrders)) {
            ServiceOrder serviceOrder = serviceOrders.get(0);
            if (!allowModifyReport(serviceOrder)) {
                CommonUtil.info("submitTestItem", "ignore", new String[]{"orderId=" + serviceOrder.getOrder_string_id(),
                        ",orderStatus=" + serviceOrder.getOrder_status(), ", childStatus=" + serviceOrder.getChild_status()}, reportRequestDTO);
                return;
            }
            record.setOrder_string_id(serviceOrder.getOrder_string_id());
            record.setReport_have_exception(reportRequestDTO.isReport_have_exception());

            int ret = 0;
            ReportExample reportExample = new ReportExample();
            ReportExample.Criteria criteria1 = reportExample.createCriteria();
            criteria1.andOrder_idEqualTo(reportRequestDTO.getOrder_id());
            List<Report> reports = reportMapper.selectByExample(reportExample);
            if (!CollectionUtils.isEmpty(reports)) {
                Report report = reports.get(0);
                report.setReport_items(reportRequestDTO.getReport_items());
                report.setReport_have_exception(reportRequestDTO.isReport_have_exception());
                if (user != null) {
                    report.setModifier_account(user.getAccount());
                }
                ret = reportMapper.updateByPrimaryKeyWithBLOBs(report);
            } else {
                ret = reportMapper.insert(record);
            }

            if (ret > 0) {

                if (isReportComplelted(reportRequestDTO.getReport_items())) {


                    serviceOrder.setReport_id(record.getId());
                    if (reportRequestDTO.isReport_have_exception()) {
                        if (!serviceOrder.getChild_status().equals(ServiceOrderStatus.report_have_exception.getCode())) {
                            serviceOrder.setChild_status(ServiceOrderStatus.report_have_exception.getCode());
                            this.wxOrderService.saveServiceOrderEvent(now, serviceOrder, serviceOrder.getShop_user_id(),
                                    ServiceOrderStatus.report_have_exception.getDesc());
                        }
                    } else {
                        if (!serviceOrder.getChild_status().equals(ServiceOrderStatus.report_no_exception.getCode())) {
                            serviceOrder.setChild_status(ServiceOrderStatus.report_no_exception.getCode());
                            this.wxOrderService.saveServiceOrderEvent(now, serviceOrder, serviceOrder.getShop_user_id(),
                                    ServiceOrderStatus.report_no_exception.getDesc());
                        }

                    }
                    serviceOrder.setGmt_modify(now);
                    this.serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);

                    //解析下次保养建议公里数
                    Car myCar = this.carMapper.selectByPrimaryKey(serviceOrder.getCar_id());
                    if (myCar != null) {
                        String next_maintenance_miles = suggestGetMiles(reportRequestDTO.getReport_items());
                        if (!StringUtils.isEmpty(next_maintenance_miles)) {
                            myCar.setNext_maintenance_miles(next_maintenance_miles);
                            myCar.setGmt_last_maintenance(now);
                            myCar.setGmt_modify(now);
                            carMapper.updateByPrimaryKeySelective(myCar);
                        }
                    }
                }
            }
        }
    }

    private boolean allowModifyReport(ServiceOrder serviceOrder) {
        if (serviceOrder == null) {
            return false;
        }
        if (StringUtils.isEmpty(serviceOrder.getOrder_status())) {
            return false;
        }
        ServiceOrderStatus serviceOrderStatus = parseFromCode(serviceOrder.getOrder_status());
        ServiceOrderStatus childStatus = parseFromCode(serviceOrder.getChild_status());
        return serviceOrderStatus.isAllowEditReport() && childStatus.isAllowEditReport();
    }

    private static boolean isReportComplelted(String report_items) {
        if (StringUtils.isEmpty(report_items)) {
            return false;
        }

        JSONArray jsonArray = JSON.parseArray(report_items);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Boolean result = jsonObject.getBoolean("result");
            if (result == null) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isReportComplelted("[{\"result\":null,\"mainCategoryName\":\"dengguang\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"行车灯\",\"entryName\":\"xingchedeng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"近光灯\",\"entryName\":\"jinguangdeng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"远光灯\",\"entryName\":\"yuanguangdeng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"变光\",\"entryName\":\"bianguang\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"左右转向灯\",\"entryName\":\"zuoyouzhuanxiangdeng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"闪烁报警指示灯\",\"entryName\":\"shanshuobaojingzhishideng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"前雾灯\",\"entryName\":\"qianwudeng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"前驻车雷达\",\"entryName\":\"qianzhucheleida\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"雨刮\",\"entryName\":\"yugua\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"大灯清洗装置\",\"entryName\":\"dadengqingxizhuagnzhi\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"灯光\",\"photos\":\"\"},{\"result\":true,\"mainCategoryName\":\"jiyou\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"放油量\",\"entryName\":\"fangyoulaing\",\"range\":\"\",\"entryValue\":\"2\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"加机油\",\"entryName\":\"jiajiyou\",\"range\":\"\",\"entryValue\":\"2\",\"title\":\"\",\"standardRefer\":\"\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"机油\",\"photos\":\"http://www.jinlingongyi.cn/adminservice/repo/4ca3e0d9-7c3d-4df6-9ae4-04cf6982c13a.jpg\"},{\"result\":null,\"mainCategoryName\":\"jilv\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"旧件品牌\",\"entryName\":\"jiujianpinpai\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"新件品牌\",\"entryName\":\"xinjianpinpai\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"\",\"standardRefer\":\"\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"机滤\",\"photos\":\"\"},{\"result\":true,\"mainCategoryName\":\"huohuasai\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"目视检测\",\"entryName\":\"mushijiance\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"点火线圈\",\"entryName\":\"dianhuoxianquan\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"火花塞\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"fangdongye\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"PH值\",\"entryName\":\"phzhi\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"参考值7-9.5\"},{\"result\":true,\"entryDisplayName\":\"冰点\",\"entryName\":\"bingdian\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"参考值-68摄氏度— -15摄氏度\"},{\"result\":true,\"entryDisplayName\":\"沸点\",\"entryName\":\"feidian\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"参考值>105摄氏度\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"防冻液\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"jieqimen\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"开度检查\",\"entryName\":\"kaidujiancha\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"\",\"standardRefer\":\"参考范围1.6—5.0\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"节气门\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"biansuxiangyou\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"冷态\",\"entryName\":\"lengtai\",\"range\":\"\",\"entryValue\":null,\"title\":\"油尺刻度位置\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"热态\",\"entryName\":\"retai\",\"range\":\"\",\"entryValue\":null,\"title\":\"油尺刻度位置\",\"standardRefer\":\"\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"变速箱油\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"shacheyou\",\"subCategoryList\":[{\"result\":false,\"entryDisplayName\":\"水含量\",\"entryName\":\"shuihanliang\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"参考值0.5%—2.5%\"},{\"result\":true,\"entryDisplayName\":\"干沸点\",\"entryName\":\"ganfeidian\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"参考值205-207摄氏度\"},{\"result\":true,\"entryDisplayName\":\"湿沸点\",\"entryName\":\"shifeidian\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"参考值170-190摄氏度\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"刹车油\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"pidai\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"张紧度\",\"entryName\":\"zhangjindu\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"皮带\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"shachepan\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"左前轮\",\"entryName\":\"zuoqianlun\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\">=3毫米为强制更换\"},{\"result\":true,\"entryDisplayName\":\"左后轮\",\"entryName\":\"zuohoulun\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\">=3毫米为强制更换\"},{\"result\":true,\"entryDisplayName\":\"右前轮\",\"entryName\":\"youqianlun\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\">=3毫米为强制更换\"},{\"result\":true,\"entryDisplayName\":\"右后轮\",\"entryName\":\"youhoulun\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\">=3毫米为强制更换\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"刹车盘\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"luntai\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"左前轮\",\"entryName\":\"zuoqianlun_neice\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"内侧\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"左前轮\",\"entryName\":\"zuoqianlun_waice\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"外侧\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"左后轮\",\"entryName\":\"zuohoulun_neice\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"内侧\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"左后轮\",\"entryName\":\"zuohoulun_waice\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"外侧\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"右前轮\",\"entryName\":\"youqianlun_neice\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"内侧\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"右前轮\",\"entryName\":\"youqianlun_waice\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"外侧\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"右后轮\",\"entryName\":\"youhoulun_neice\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"内侧\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"右后轮\",\"entryName\":\"youhoulun_waice\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"外侧\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"左前轮\",\"entryName\":\"zuoqianlun3\",\"range\":\"\",\"entryValue\":null,\"title\":\"胎压\",\"standardRefer\":\"参考值：2.3-2.5之间\"},{\"result\":true,\"entryDisplayName\":\"左后轮\",\"entryName\":\"zuohoulun3\",\"range\":\"\",\"entryValue\":null,\"title\":\"胎压\",\"standardRefer\":\"参考值：2.3-2.5之间\"},{\"result\":true,\"entryDisplayName\":\"右前轮\",\"entryName\":\"youqianlun3\",\"range\":\"\",\"entryValue\":null,\"title\":\"胎压\",\"standardRefer\":\"参考值：2.3-2.5之间\"},{\"result\":false,\"entryDisplayName\":\"右后轮\",\"entryName\":\"youhoulun3\",\"range\":\"\",\"entryValue\":null,\"title\":\"胎压\",\"standardRefer\":\"参考值：2.3-2.5之间\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"轮胎\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"shachepian\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"左前轮\",\"entryName\":\"zuoqianlun2\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"<=1.6毫米为强制更换\"},{\"result\":true,\"entryDisplayName\":\"左后轮\",\"entryName\":\"zuohoulun2\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"<=1.6毫米为强制更换\"},{\"result\":true,\"entryDisplayName\":\"右前轮\",\"entryName\":\"youqianlun2\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"<=1.6毫米为强制更换\"},{\"result\":true,\"entryDisplayName\":\"右后轮\",\"entryName\":\"youhoulun2\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"<=1.6毫米为强制更换\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"刹车片\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"dianping\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"电压\",\"entryName\":\"dianya\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"\",\"standardRefer\":\"\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"电瓶\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"kongtiao\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"高压\",\"entryName\":\"gaoya\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"参考值1400-1600kpa\"},{\"result\":true,\"entryDisplayName\":\"低压\",\"entryName\":\"diya\",\"range\":\"\",\"entryValue\":null,\"title\":\"\",\"standardRefer\":\"参考值150-250kpa\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"空调\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"dipan\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"底盘\",\"entryName\":\"dipan2\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"\",\"standardRefer\":\"\"}],\"remark\":\"底盘的文字描述\",\"mainCategoryDisplayName\":\"底盘\",\"photos\":\"\"},{\"result\":null,\"mainCategoryName\":\"baoyangjianyi\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"保养建议\",\"entryName\":\"baoyangjianyi2\",\"range\":\"\",\"entryValue\":\"\",\"title\":\"\",\"standardRefer\":\"\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"保养建议\",\"photos\":\"\"}]"));
        System.out.println(isReportComplelted("[{\"result\":true,\"mainCategoryName\":\"dengguang\",\"subCategoryList\":[{\"result\":true,\"entryDisplayName\":\"行车灯\",\"entryName\":\"xingchedeng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"近光灯\",\"entryName\":\"jinguangdeng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"远光灯\",\"entryName\":\"yuanguangdeng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"变光\",\"entryName\":\"bianguang\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"左右转向灯\",\"entryName\":\"zuoyouzhuanxiangdeng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"闪烁报警指示灯\",\"entryName\":\"shanshuobaojingzhishideng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"前雾灯\",\"entryName\":\"qianwudeng\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"前驻车雷达\",\"entryName\":\"qianzhucheleida\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"雨刮\",\"entryName\":\"yugua\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"},{\"result\":true,\"entryDisplayName\":\"大灯清洗装置\",\"entryName\":\"dadengqingxizhuagnzhi\",\"range\":\"\",\"entryValue\":\"正常\",\"title\":\"\",\"standardRefer\":\"\"}],\"remark\":\"\",\"mainCategoryDisplayName\":\"灯光\",\"photos\":\"\"}]"));

    }

    /**
     * 获取下次保养公里数
     *
     * @param json
     * @return
     */
    public String suggestGetMiles(String json) {
        String entryValue = "";
        try {
            List list = JSON.parseObject(json, List.class);
            if (!CollectionUtils.isEmpty(list)) {
                for (Object o : list) {
                    Map map = (Map) o;
                    if (!MapUtils.isEmpty(map) && String.valueOf(map.get("mainCategoryName")).equals("baoyangjianyi")) {
                        List subCategoryList = (List) map.get("subCategoryList");
                        if (!CollectionUtils.isEmpty(subCategoryList)) {
                            for (Object o2 : subCategoryList) {
                                Map map2 = (Map) o2;
                                if (!MapUtils.isEmpty(map2) && String.valueOf(map2.get("entryName")).equals("baoyangjianyi2")) {
                                    entryValue = String.valueOf(map2.get("entryValue"));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("WxTestItemService#suggestGetMiles json={}", new Object[]{json});
        }
        return entryValue;
    }

    /**
     * 编辑检测项
     *
     * @param user
     * @param reportRequestDTO
     */
    public void editTestItem(WxUser user, ReportRequestDTO reportRequestDTO) {
        ReportExample example = new ReportExample();
        ReportExample.Criteria criteria = example.createCriteria();
        //订单id
        criteria.andOrder_idEqualTo(reportRequestDTO.getOrder_id());
        List<Report> reports = reportMapper.selectByExampleWithBLOBs(example);
        if (!CollectionUtils.isEmpty(reports)) {
            Report report = reports.get(0);
            if (report != null) {
                if (!StringUtils.isEmpty(reportRequestDTO.getReport_items())) {
                    String report_items = reportRequestDTO.getReport_items();
                    report.setGmt_modify(new Date());
                    if (user != null) {
                        report.setModifier_account(user.getAccount());
                    }
                    report.setReport_items(report_items);
                    reportMapper.updateByPrimaryKey(report);
                }
            }
        }
    }
}
