package com.segama.ege.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopAdminUserInfoRequestDTO {

    private Long shop_id;

    private Long shop_user_id;

    private String shop_user_account;

    private String sex;

    private String user_head;

    private String shop_user_name;

    private String birth;

    private String place_city;

    private String phone;

    private String job;

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUser_head() {
        return user_head;
    }

    public void setUser_head(String user_head) {
        this.user_head = user_head;
    }

    public String getShop_user_name() {
        return shop_user_name;
    }

    public void setShop_user_name(String shop_user_name) {
        this.shop_user_name = shop_user_name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPlace_city() {
        return place_city;
    }

    public void setPlace_city(String place_city) {
        this.place_city = place_city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
