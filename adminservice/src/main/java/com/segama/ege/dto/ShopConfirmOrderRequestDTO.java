package com.segama.ege.dto;


public class ShopConfirmOrderRequestDTO {
    private Long order_id;

    private Long shop_user_id;

    private boolean success;

    private String gmt_change_service_begin_time;

    private String gmt_change_service_date;

    public String getGmt_change_service_begin_time() {
        return gmt_change_service_begin_time;
    }

    public void setGmt_change_service_begin_time(String gmt_change_service_begin_time) {
        this.gmt_change_service_begin_time = gmt_change_service_begin_time;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getGmt_change_service_date() {
        return gmt_change_service_date;
    }

    public void setGmt_change_service_date(String gmt_change_service_date) {
        this.gmt_change_service_date = gmt_change_service_date;
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
