package com.segama.ege.dto;

import com.segama.ege.entity.ServiceOrder;
import com.segama.ege.entity.Shop;

public class ShopServiceOrderResponseDTO {
    private Long order_id;

    private String order_string_id;

    private String user_id;

    private String user_name;

    private Long shop_id;

    private String shop_name;

    private Long shop_user_id;

    private String shop_user_account;

    private String shop_user_name;

    private String order_status;

    private String child_status;

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

    public Long getShop_user_id() {
        return shop_user_id;
    }

    public void setShop_user_id(Long shop_user_id) {
        this.shop_user_id = shop_user_id;
    }

    public String getShop_user_account() {
        return shop_user_account;
    }

    public void setShop_user_account(String shop_user_account) {
        this.shop_user_account = shop_user_account;
    }

    public String getShop_user_name() {
        return shop_user_name;
    }

    public void setShop_user_name(String shop_user_name) {
        this.shop_user_name = shop_user_name;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getChild_status() {
        return child_status;
    }

    public void setChild_status(String child_status) {
        this.child_status = child_status;
    }

    public static ShopServiceOrderResponseDTO build(ServiceOrder serviceOrder, Shop shop){
        ShopServiceOrderResponseDTO dto = new ShopServiceOrderResponseDTO();
        dto.setShop_id(serviceOrder.getShop_id());
        dto.setOrder_string_id(serviceOrder.getOrder_string_id());
        dto.setUser_id(serviceOrder.getUser_id());
        dto.setUser_name(serviceOrder.getUser_name());

        dto.setOrder_id(serviceOrder.getId());
        dto.setOrder_string_id(serviceOrder.getOrder_string_id());

        dto.setOrder_status(serviceOrder.getOrder_status());
        dto.setChild_status(serviceOrder.getChild_status());

        dto.setShop_id(shop.getId());
        dto.setShop_name(shop.getEnterprise_name());
        dto.setShop_user_id(serviceOrder.getShop_user_id());
        dto.setShop_user_account(serviceOrder.getShop_user_account());
        dto.setShop_user_name(serviceOrder.getShop_user_name());

        return dto;
    }
}
