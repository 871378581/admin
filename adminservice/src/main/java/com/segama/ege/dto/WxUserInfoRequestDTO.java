package com.segama.ege.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WxUserInfoRequestDTO {
    private String level;

    private String user_id;

    private String account;

    private String sex;

    private String user_head;

    private String user_name;

    private String birth;

    private String place_city;

    private String phone;

    private String job;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUser_head() {
        return user_head;
    }

    public void setUser_head(String user_head) {
        this.user_head = user_head;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sex=").append(account);
        sb.append(", account=").append(account);
        sb.append(", user_id=").append(user_id);
        sb.append(", user_head=").append(user_head);
        sb.append(", user_name=").append(user_name);
        sb.append(", birth=").append(birth);
        sb.append(", phone=").append(phone);
        sb.append(", place_city=").append(place_city);
        sb.append(", job=").append(job);
        sb.append("]");
        return sb.toString();
    }
}
