package com.segama.ege.dto;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.entity.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ScanOrderInfoResponseDTO {
    private Long order_id;//order_id

    private String order_string_id;//订单编号

    private String user_id;

    private String user_name;

    private String phone;

    private Long car_id;

    private String car_plate;//车辆车牌

    private String car_type_name;//车辆型号

    private String card_level;

    private Long oil_id;

    private String oil_brand;

    private String oil_img_url;

    private List<OilInfoResponseDTO> oils;

    public void addOil(OilInfoResponseDTO oil){
        if(this.oils == null){
            this.oils = new ArrayList<OilInfoResponseDTO>();
        }
        this.oils.add(oil);
    }

    public List<OilInfoResponseDTO> getOils() {
        return oils;
    }

    private String gmt_last_maintenance;

    private String gmt_service_date;

    private String gmt_service_begin_time;

    private String last_maintenance_miles;

    private String next_maintenance_miles;

    private boolean have_risk = false;

    private String risk_description = "无风险";

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOrder_string_id() {
        return order_string_id;
    }

    public void setOrder_string_id(String order_string_id) {
        this.order_string_id = order_string_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public String getCar_type_name() {
        return car_type_name;
    }

    public void setCar_type_name(String car_type_name) {
        this.car_type_name = car_type_name;
    }

    public String getCard_level() {
        return card_level;
    }

    public void setCard_level(String card_level) {
        this.card_level = card_level;
    }

    public Long getOil_id() {
        return oil_id;
    }

    public void setOil_id(Long oil_id) {
        this.oil_id = oil_id;
    }

    public String getOil_brand() {
        return oil_brand;
    }

    public void setOil_brand(String oil_brand) {
        this.oil_brand = oil_brand;
    }

    public String getGmt_last_maintenance() {
        return gmt_last_maintenance;
    }

    public void setGmt_last_maintenance(String gmt_last_maintenance) {
        this.gmt_last_maintenance = gmt_last_maintenance;
    }

    public String getOil_img_url() {
        return oil_img_url;
    }

    public void setOil_img_url(String oil_img_url) {
        this.oil_img_url = oil_img_url;
    }

    public String getGmt_service_date() {
        return gmt_service_date;
    }

    public void setGmt_service_date(String gmt_service_date) {
        this.gmt_service_date = gmt_service_date;
    }

    public String getGmt_service_begin_time() {
        return gmt_service_begin_time;
    }

    public void setGmt_service_begin_time(String gmt_service_begin_time) {
        this.gmt_service_begin_time = gmt_service_begin_time;
    }

    public String getLast_maintenance_miles() {
        return last_maintenance_miles;
    }

    public void setLast_maintenance_miles(String last_maintenance_miles) {
        this.last_maintenance_miles = last_maintenance_miles;
    }

    public String getNext_maintenance_miles() {
        return next_maintenance_miles;
    }

    public void setNext_maintenance_miles(String next_maintenance_miles) {
        this.next_maintenance_miles = next_maintenance_miles;
    }

    public boolean isHave_risk() {
        return have_risk;
    }

    public void setHave_risk(boolean have_risk) {
        this.have_risk = have_risk;
    }

    public String getRisk_description() {
        return risk_description;
    }

    public void setRisk_description(String risk_description) {

        this.risk_description = risk_description;
    }

    public static ScanOrderInfoResponseDTO build(ServiceOrder serviceOrder, Shop shop,
                                                      Car car, EngineOil oil, WxUser wxUser, boolean have_risk){
        ScanOrderInfoResponseDTO dto = new ScanOrderInfoResponseDTO();
        dto.setCar_id(car.getId());
        dto.setCar_plate(car.getPlate());
        dto.setCar_type_name(car.getCar_type_name());
        dto.setCard_level(serviceOrder.getCard_level());
        dto.setGmt_service_date(serviceOrder.getGmt_service_date());
        dto.setGmt_service_begin_time(serviceOrder.getGmt_service_begin_time());
        dto.setGmt_last_maintenance(DateUtil.parse(car.getGmt_last_maintenance()));
        dto.setLast_maintenance_miles(car.getCurr_maintenance_miles());
        dto.setNext_maintenance_miles(car.getNext_maintenance_miles());
        dto.setHave_risk(have_risk);
        if(have_risk){
            dto.setRisk_description("有风险");
        }else{
            dto.setRisk_description("无风险");
        }

        dto.setOrder_id(serviceOrder.getId());
        dto.setOrder_string_id(serviceOrder.getOrder_string_id());
        if(oil != null){
            dto.setOil_id(oil.getId());
            dto.setOil_brand(oil.getBrand());
            dto.setOil_img_url(oil.getPhoto_url());
        }
        if(wxUser != null){
            dto.setUser_id(wxUser.getUser_id());
            dto.setUser_name(wxUser.getUser_name());
            dto.setPhone(wxUser.getPhone());
        }

        return dto;
    }
}
