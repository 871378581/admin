package com.segama.ege.dto;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.domain.ServiceOrderStatus;
import com.segama.ege.entity.Car;
import com.segama.ege.entity.ServiceOrder;
import com.segama.ege.entity.Shop;
import com.segama.ege.entity.WxUser;

public class ServiceOrderResponseDTO {

    private Long id;

    private String order_string_id;

    private String user_id;

    private String user_name;

    private String phone;

    private Long car_id;

    private String car_plate;

    private String car_type_name;

    private String car_type_img_url;

    private String car_level;

    private Long shop_id;

    private String shop_name;

    private String shop_phone;

    private String longitude;

    private String latitude;

    private Long oil_id;

    private String oil_brand;

    private String service_item;

    private String order_status;

    private String child_status;

    private String gmt_service_date;

    private String gmt_service_begin_time;

    private String gmt_service_end_time;

    //private Long service_package_id;

    private Long report_id;

    private String final_fee;

    private Long pay_id;

    private String order_qr_code;

    private String gmt_create;

    private String gmt_confirm;

    private String gmt_change_service_date;

    private String gmt_change_service_begin_time;

    private String gmt_change_service_end_time;

    private String gmt_actual_service;

    private String gmt_pay;

    private Long evaluate_id;

    private String gmt_evaluate;

    private boolean allow_cancel = false;

    private String current_miles;

    private String next_miles;

    private String last_miles;

    public String getCar_type_img_url() {
        return car_type_img_url;
    }

    public void setCar_type_img_url(String car_type_img_url) {
        this.car_type_img_url = car_type_img_url;
    }

    public String getChild_status() {
        return child_status;
    }

    public void setChild_status(String child_status) {
        this.child_status = child_status;
    }

    public String getGmt_change_service_begin_time() {
        return gmt_change_service_begin_time;
    }

    public void setGmt_change_service_begin_time(String gmt_change_service_begin_time) {
        this.gmt_change_service_begin_time = gmt_change_service_begin_time;
    }

    public String getGmt_change_service_end_time() {
        return gmt_change_service_end_time;
    }

    public void setGmt_change_service_end_time(String gmt_change_service_end_time) {
        this.gmt_change_service_end_time = gmt_change_service_end_time;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Long getEvaluate_id() {
        return evaluate_id;
    }

    public void setEvaluate_id(Long evaluate_id) {
        this.evaluate_id = evaluate_id;
    }

    public String getGmt_service_begin_time() {
        return gmt_service_begin_time;
    }

    public void setGmt_service_begin_time(String gmt_service_begin_time) {
        this.gmt_service_begin_time = gmt_service_begin_time;
    }

    public String getGmt_service_end_time() {
        return gmt_service_end_time;
    }

    public void setGmt_service_end_time(String gmt_service_end_time) {
        this.gmt_service_end_time = gmt_service_end_time;
    }

    public boolean isAllow_cancel() {
        return allow_cancel;
    }

    public void setAllow_cancel(boolean allow_cancel) {
        this.allow_cancel = allow_cancel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
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

    public String getService_item() {
        return service_item;
    }

    public void setService_item(String service_item) {
        this.service_item = service_item;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getGmt_service_date() {
        return gmt_service_date;
    }

    public void setGmt_service_date(String gmt_service_date) {
        this.gmt_service_date = gmt_service_date;
    }

    public Long getReport_id() {
        return report_id;
    }

    public void setReport_id(Long report_id) {
        this.report_id = report_id;
    }

    public String getFinal_fee() {
        return final_fee;
    }

    public void setFinal_fee(String final_fee) {
        this.final_fee = final_fee;
    }

    public Long getPay_id() {
        return pay_id;
    }

    public void setPay_id(Long pay_id) {
        this.pay_id = pay_id;
    }

    public String getOrder_qr_code() {
        return order_qr_code;
    }

    public void setOrder_qr_code(String order_qr_code) {
        this.order_qr_code = order_qr_code;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getGmt_confirm() {
        return gmt_confirm;
    }

    public void setGmt_confirm(String gmt_confirm) {
        this.gmt_confirm = gmt_confirm;
    }

    public String getGmt_change_service_date() {
        return gmt_change_service_date;
    }

    public void setGmt_change_service_date(String gmt_change_service_date) {
        this.gmt_change_service_date = gmt_change_service_date;
    }

    public String getGmt_actual_service() {
        return gmt_actual_service;
    }

    public void setGmt_actual_service(String gmt_actual_service) {
        this.gmt_actual_service = gmt_actual_service;
    }

    public String getGmt_pay() {
        return gmt_pay;
    }

    public void setGmt_pay(String gmt_pay) {
        this.gmt_pay = gmt_pay;
    }

    public String getGmt_evaluate() {
        return gmt_evaluate;
    }

    public void setGmt_evaluate(String gmt_evaluate) {
        this.gmt_evaluate = gmt_evaluate;
    }

    public String getCar_level() {
        return car_level;
    }

    public void setCar_level(String car_level) {
        this.car_level = car_level;
    }


    public String getCurrent_miles() {
        return current_miles;
    }

    public void setCurrent_miles(String current_miles) {
        this.current_miles = current_miles;
    }

    public String getLast_miles() {
        return last_miles;
    }

    public void setLast_miles(String last_miles) {
        this.last_miles = last_miles;
    }

    public String getNext_miles() {
        return next_miles;
    }

    public void setNext_miles(String next_miles) {
        this.next_miles = next_miles;
    }

    public String getShop_phone() {
        return shop_phone;
    }

    public void setShop_phone(String shop_phone) {
        this.shop_phone = shop_phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static ServiceOrderResponseDTO build(ServiceOrder serviceOrder,
                                                Shop shop, Car car,
                                                String car_type_img_url,
                                                WxUser wxUser){
        ServiceOrderResponseDTO dto = new ServiceOrderResponseDTO();
        dto.setCar_id(serviceOrder.getCar_id());
        dto.setCar_plate(serviceOrder.getCar_plate());
        dto.setCar_type_name(serviceOrder.getCar_type_name());
        dto.setCar_type_img_url(car_type_img_url);
        dto.setFinal_fee(serviceOrder.getFinal_fee());
        dto.setGmt_actual_service(DateUtil.parse(serviceOrder.getGmt_actual_service()));
        dto.setGmt_change_service_date(serviceOrder.getGmt_change_service_date());
        dto.setGmt_change_service_begin_time(serviceOrder.getGmt_change_service_begin_time());
        dto.setGmt_change_service_end_time(serviceOrder.getGmt_change_service_end_time());
        dto.setGmt_confirm(DateUtil.parse(serviceOrder.getGmt_confirm()));
        dto.setGmt_create(DateUtil.parse(serviceOrder.getGmt_create()));
        dto.setEvaluate_id(serviceOrder.getEvaluate_id());
        dto.setGmt_evaluate(DateUtil.parse(serviceOrder.getGmt_evaluate()));
        dto.setGmt_pay(DateUtil.parse(serviceOrder.getGmt_pay()));
        dto.setGmt_service_date(serviceOrder.getGmt_service_date());
        dto.setGmt_service_begin_time(serviceOrder.getGmt_service_begin_time());
        dto.setGmt_service_end_time(serviceOrder.getGmt_service_end_time());
        dto.setId(serviceOrder.getId());
        dto.setOil_id(serviceOrder.getOil_id());
        dto.setOil_brand(serviceOrder.getOil_brand());
        dto.setOrder_qr_code(serviceOrder.getOrder_qr_code());
        dto.setOrder_status(serviceOrder.getOrder_status());
        dto.setChild_status(serviceOrder.getChild_status());
        if(ServiceOrderStatus.parse(dto.getOrder_status()) != null){
            dto.setAllow_cancel(ServiceOrderStatus.parse(dto.getOrder_status()).isAllow_cancel());
        }
        dto.setOrder_string_id(serviceOrder.getOrder_string_id());
        dto.setReport_id(serviceOrder.getReport_id());
        dto.setPay_id(serviceOrder.getPay_id());
        dto.setService_item(serviceOrder.getService_item());
        dto.setShop_id(serviceOrder.getShop_id());
        dto.setShop_name(serviceOrder.getShop_name());
        if(shop!=null) {
            dto.setShop_phone(shop.getPhone());
        }
        if(serviceOrder.getLongitude() != null){
            dto.setLongitude(String.valueOf(serviceOrder.getLongitude().doubleValue()));
        }
        if(serviceOrder.getLatitude() != null){
            dto.setLatitude(String.valueOf(serviceOrder.getLatitude().doubleValue()));
        }

        dto.setUser_id(serviceOrder.getUser_id());
        dto.setUser_name(serviceOrder.getUser_name());
        if(wxUser != null){
            dto.setPhone(wxUser.getPhone());
        }

        dto.setCar_type_img_url(car.getCar_type_image());

        dto.setCar_level(serviceOrder.getCard_level());
        dto.setLast_miles(car.getLast_maintenance_miles());
        dto.setNext_miles(car.getNext_maintenance_miles());
        dto.setCurrent_miles(car.getCurr_maintenance_miles());

        return dto;
    }
}
