package com.segama.ege.dto;

public class ShopConfirmOrderHavePayRequestDTO {
    private Long order_id;

    private Long shop_user_id;

    private boolean pay_status;

    public Long getShop_user_id() {
        return shop_user_id;
    }

    public void setShop_user_id(Long shop_user_id) {
        this.shop_user_id = shop_user_id;
    }

    public boolean isPay_status() {
        return pay_status;
    }

    public void setPay_status(boolean pay_status) {
        this.pay_status = pay_status;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
}
