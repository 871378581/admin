package com.segama.ege.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadPhotoAndStartServiceRequestDTO {
    private Long order_id;

    private Long shop_user_id;

    private String car_front_photo_url;

    private String car_dashboard_photo_url;

    private String curr_miles;

    private Long new_oil_id;

    private String new_oil_brand;

    public Long getNew_oil_id() {
        return new_oil_id;
    }

    public void setNew_oil_id(Long new_oil_id) {
        this.new_oil_id = new_oil_id;
    }

    public String getNew_oil_brand() {
        return new_oil_brand;
    }

    public void setNew_oil_brand(String new_oil_brand) {
        this.new_oil_brand = new_oil_brand;
    }

    public String getCar_front_photo_url() {
        return car_front_photo_url;
    }

    public void setCar_front_photo_url(String car_front_photo_url) {
        this.car_front_photo_url = car_front_photo_url;
    }

    public String getCar_dashboard_photo_url() {
        return car_dashboard_photo_url;
    }

    public void setCar_dashboard_photo_url(String car_dashboard_photo_url) {
        this.car_dashboard_photo_url = car_dashboard_photo_url;
    }

    public String getCurr_miles() {
        return curr_miles;
    }

    public void setCurr_miles(String curr_miles) {
        this.curr_miles = curr_miles;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getShop_user_id() {
        return shop_user_id;
    }

    public void setShop_user_id(Long shop_user_id) {
        this.shop_user_id = shop_user_id;
    }
}
