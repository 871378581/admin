package com.segama.ege.dto;

public class ShopOrderSumInfoResponseDTO {

    private String shop_name;

    private String user_name;

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    private int servicing_orders;//保养中

    private int added_service_orders;//附加服务中

    private int have_finished_orders;//已完成

    private int have_exception_orders;//检测异常

    public int getServicing_orders() {
        return servicing_orders;
    }

    public void setServicing_orders(int servicing_orders) {
        this.servicing_orders = servicing_orders;
    }

    public int getAdded_service_orders() {
        return added_service_orders;
    }

    public void setAdded_service_orders(int added_service_orders) {
        this.added_service_orders = added_service_orders;
    }

    public int getHave_finished_orders() {
        return have_finished_orders;
    }

    public void setHave_finished_orders(int have_finished_orders) {
        this.have_finished_orders = have_finished_orders;
    }

    public int getHave_exception_orders() {
        return have_exception_orders;
    }

    public void setHave_exception_orders(int have_exception_orders) {
        this.have_exception_orders = have_exception_orders;
    }
}
