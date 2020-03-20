package com.segama.ege.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessCooperateApplyRequestDTO {
    private String name;
    private String phone;
    private String expect_contact_time;
    private String cooperate_type_description;
    private String user_id;
    private String shop_name;
    private String shop_area_size;
    private String shop_address;
    private String merchant_type;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExpect_contact_time() {
        return expect_contact_time;
    }

    public void setExpect_contact_time(String expect_contact_time) {
        this.expect_contact_time = expect_contact_time;
    }

    public String getCooperate_type_description() {
        return cooperate_type_description;
    }

    public void setCooperate_type_description(String cooperate_type_description) {
        this.cooperate_type_description = cooperate_type_description;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_area_size() {
        return shop_area_size;
    }

    public void setShop_area_size(String shop_area_size) {
        this.shop_area_size = shop_area_size;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getMerchant_type() {
        return merchant_type;
    }

    public void setMerchant_type(String merchant_type) {
        this.merchant_type = merchant_type;
    }
}
