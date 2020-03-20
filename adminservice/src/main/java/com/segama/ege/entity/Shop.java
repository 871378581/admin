package com.segama.ege.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Shop implements Serializable {
    private Long id;

    private String enterprise_name;

    private String person_liable_name;

    private String phone;

    private String mobile;

    private String address;

    private String business_license_img_url;

    private String door_img_url;

    private String logo_img_url;

    private String introduce;

    private String service;

    private String score;

    private Boolean is_disable;

    private Long workstation_num;

    private String business_hour_start;

    private String business_hour_end;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Integer version;

    private Boolean is_recommend;

    private Date gmt_recommend;

    private String disable_reason;

    private Integer disable_days;

    private String small_img_url;

    private String miles_last_maintenance;

    private Long capital_account_id;

    private String capital_account_str;

    private String evaluate_tags;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name == null ? null : enterprise_name.trim();
    }

    public String getPerson_liable_name() {
        return person_liable_name;
    }

    public void setPerson_liable_name(String person_liable_name) {
        this.person_liable_name = person_liable_name == null ? null : person_liable_name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBusiness_license_img_url() {
        return business_license_img_url;
    }

    public void setBusiness_license_img_url(String business_license_img_url) {
        this.business_license_img_url = business_license_img_url == null ? null : business_license_img_url.trim();
    }

    public String getDoor_img_url() {
        return door_img_url;
    }

    public void setDoor_img_url(String door_img_url) {
        this.door_img_url = door_img_url == null ? null : door_img_url.trim();
    }

    public String getLogo_img_url() {
        return logo_img_url;
    }

    public void setLogo_img_url(String logo_img_url) {
        this.logo_img_url = logo_img_url == null ? null : logo_img_url.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public Boolean getIs_disable() {
        return is_disable;
    }

    public void setIs_disable(Boolean is_disable) {
        this.is_disable = is_disable;
    }

    public Long getWorkstation_num() {
        return workstation_num;
    }

    public void setWorkstation_num(Long workstation_num) {
        this.workstation_num = workstation_num;
    }

    public String getBusiness_hour_start() {
        return business_hour_start;
    }

    public void setBusiness_hour_start(String business_hour_start) {
        this.business_hour_start = business_hour_start == null ? null : business_hour_start.trim();
    }

    public String getBusiness_hour_end() {
        return business_hour_end;
    }

    public void setBusiness_hour_end(String business_hour_end) {
        this.business_hour_end = business_hour_end == null ? null : business_hour_end.trim();
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modify() {
        return gmt_modify;
    }

    public void setGmt_modify(Date gmt_modify) {
        this.gmt_modify = gmt_modify;
    }

    public String getCreator_account() {
        return creator_account;
    }

    public void setCreator_account(String creator_account) {
        this.creator_account = creator_account == null ? null : creator_account.trim();
    }

    public String getModifier_account() {
        return modifier_account;
    }

    public void setModifier_account(String modifier_account) {
        this.modifier_account = modifier_account == null ? null : modifier_account.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(Boolean is_recommend) {
        this.is_recommend = is_recommend;
    }

    public Date getGmt_recommend() {
        return gmt_recommend;
    }

    public void setGmt_recommend(Date gmt_recommend) {
        this.gmt_recommend = gmt_recommend;
    }

    public String getDisable_reason() {
        return disable_reason;
    }

    public void setDisable_reason(String disable_reason) {
        this.disable_reason = disable_reason == null ? null : disable_reason.trim();
    }

    public Integer getDisable_days() {
        return disable_days;
    }

    public void setDisable_days(Integer disable_days) {
        this.disable_days = disable_days;
    }

    public String getSmall_img_url() {
        return small_img_url;
    }

    public void setSmall_img_url(String small_img_url) {
        this.small_img_url = small_img_url == null ? null : small_img_url.trim();
    }

    public String getMiles_last_maintenance() {
        return miles_last_maintenance;
    }

    public void setMiles_last_maintenance(String miles_last_maintenance) {
        this.miles_last_maintenance = miles_last_maintenance == null ? null : miles_last_maintenance.trim();
    }

    public Long getCapital_account_id() {
        return capital_account_id;
    }

    public void setCapital_account_id(Long capital_account_id) {
        this.capital_account_id = capital_account_id;
    }

    public String getCapital_account_str() {
        return capital_account_str;
    }

    public void setCapital_account_str(String capital_account_str) {
        this.capital_account_str = capital_account_str == null ? null : capital_account_str.trim();
    }

    public String getEvaluate_tags() {
        return evaluate_tags;
    }

    public void setEvaluate_tags(String evaluate_tags) {
        this.evaluate_tags = evaluate_tags == null ? null : evaluate_tags.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", enterprise_name=").append(enterprise_name);
        sb.append(", person_liable_name=").append(person_liable_name);
        sb.append(", phone=").append(phone);
        sb.append(", mobile=").append(mobile);
        sb.append(", address=").append(address);
        sb.append(", business_license_img_url=").append(business_license_img_url);
        sb.append(", door_img_url=").append(door_img_url);
        sb.append(", logo_img_url=").append(logo_img_url);
        sb.append(", introduce=").append(introduce);
        sb.append(", service=").append(service);
        sb.append(", score=").append(score);
        sb.append(", is_disable=").append(is_disable);
        sb.append(", workstation_num=").append(workstation_num);
        sb.append(", business_hour_start=").append(business_hour_start);
        sb.append(", business_hour_end=").append(business_hour_end);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", version=").append(version);
        sb.append(", is_recommend=").append(is_recommend);
        sb.append(", gmt_recommend=").append(gmt_recommend);
        sb.append(", disable_reason=").append(disable_reason);
        sb.append(", disable_days=").append(disable_days);
        sb.append(", small_img_url=").append(small_img_url);
        sb.append(", miles_last_maintenance=").append(miles_last_maintenance);
        sb.append(", capital_account_id=").append(capital_account_id);
        sb.append(", capital_account_str=").append(capital_account_str);
        sb.append(", evaluate_tags=").append(evaluate_tags);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}