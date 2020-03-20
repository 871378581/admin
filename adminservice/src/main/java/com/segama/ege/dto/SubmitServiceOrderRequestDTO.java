package com.segama.ege.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitServiceOrderRequestDTO {

    private String user_id;

    private String user_name;

    private Long car_id;

    private Long shop_id;

    private Long oil_id;

    private String service_item;

    private String gmt_service_date;

    private String gmt_service_begin_time;

    //private String gmt_service_end_time;

    public String getGmt_service_begin_time() {
        return gmt_service_begin_time;
    }

    public void setGmt_service_begin_time(String gmt_service_begin_time) {
        this.gmt_service_begin_time = gmt_service_begin_time;
    }

    /*public String getGmt_service_end_time() {
        return gmt_service_end_time;
    }
    public void setGmt_service_end_time(String gmt_service_end_time) {
        this.gmt_service_end_time = gmt_service_end_time;
    }*/

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

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public Long getOil_id() {
        return oil_id;
    }

    public void setOil_id(Long oil_id) {
        this.oil_id = oil_id;
    }

    public String getService_item() {
        return service_item;
    }

    public void setService_item(String service_item) {
        this.service_item = service_item;
    }

    public String getGmt_service_date() {
        return gmt_service_date;
    }

    public void setGmt_service_date(String gmt_service_date) {
        this.gmt_service_date = gmt_service_date;
    }
}
