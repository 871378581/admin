package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    private Long id;

    private String user_id;

    private String plate;

    private Long car_type_id;

    private String car_type_name;

    private String car_type_color;

    private String car_logo_url;

    private Date gmt_last_maintenance;

    private String membership_card_id;

    private String car_status;

    private Date gmt_activate;

    private Date gmt_take_effect;

    private Date gmt_lose_effect;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private Integer version;

    private Boolean is_default;

    private String color;

    private String vin;

    private String card_level;

    private String last_maintenance_miles;

    private String next_maintenance_miles;

    private String curr_maintenance_miles;

    private String car_type_image;

    private String car_type_code;

    private String car_brand_code;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate == null ? null : plate.trim();
    }

    public Long getCar_type_id() {
        return car_type_id;
    }

    public void setCar_type_id(Long car_type_id) {
        this.car_type_id = car_type_id;
    }

    public String getCar_type_name() {
        return car_type_name;
    }

    public void setCar_type_name(String car_type_name) {
        this.car_type_name = car_type_name == null ? null : car_type_name.trim();
    }

    public String getCar_type_color() {
        return car_type_color;
    }

    public void setCar_type_color(String car_type_color) {
        this.car_type_color = car_type_color == null ? null : car_type_color.trim();
    }

    public String getCar_logo_url() {
        return car_logo_url;
    }

    public void setCar_logo_url(String car_logo_url) {
        this.car_logo_url = car_logo_url == null ? null : car_logo_url.trim();
    }

    public Date getGmt_last_maintenance() {
        return gmt_last_maintenance;
    }

    public void setGmt_last_maintenance(Date gmt_last_maintenance) {
        this.gmt_last_maintenance = gmt_last_maintenance;
    }

    public String getMembership_card_id() {
        return membership_card_id;
    }

    public void setMembership_card_id(String membership_card_id) {
        this.membership_card_id = membership_card_id == null ? null : membership_card_id.trim();
    }

    public String getCar_status() {
        return car_status;
    }

    public void setCar_status(String car_status) {
        this.car_status = car_status == null ? null : car_status.trim();
    }

    public Date getGmt_activate() {
        return gmt_activate;
    }

    public void setGmt_activate(Date gmt_activate) {
        this.gmt_activate = gmt_activate;
    }

    public Date getGmt_take_effect() {
        return gmt_take_effect;
    }

    public void setGmt_take_effect(Date gmt_take_effect) {
        this.gmt_take_effect = gmt_take_effect;
    }

    public Date getGmt_lose_effect() {
        return gmt_lose_effect;
    }

    public void setGmt_lose_effect(Date gmt_lose_effect) {
        this.gmt_lose_effect = gmt_lose_effect;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getIs_default() {
        return is_default;
    }

    public void setIs_default(Boolean is_default) {
        this.is_default = is_default;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getCard_level() {
        return card_level;
    }

    public void setCard_level(String card_level) {
        this.card_level = card_level == null ? null : card_level.trim();
    }

    public String getLast_maintenance_miles() {
        return last_maintenance_miles;
    }

    public void setLast_maintenance_miles(String last_maintenance_miles) {
        this.last_maintenance_miles = last_maintenance_miles == null ? null : last_maintenance_miles.trim();
    }

    public String getNext_maintenance_miles() {
        return next_maintenance_miles;
    }

    public void setNext_maintenance_miles(String next_maintenance_miles) {
        this.next_maintenance_miles = next_maintenance_miles == null ? null : next_maintenance_miles.trim();
    }

    public String getCurr_maintenance_miles() {
        return curr_maintenance_miles;
    }

    public void setCurr_maintenance_miles(String curr_maintenance_miles) {
        this.curr_maintenance_miles = curr_maintenance_miles == null ? null : curr_maintenance_miles.trim();
    }

    public String getCar_type_image() {
        return car_type_image;
    }

    public void setCar_type_image(String car_type_image) {
        this.car_type_image = car_type_image == null ? null : car_type_image.trim();
    }

    public String getCar_type_code() {
        return car_type_code;
    }

    public void setCar_type_code(String car_type_code) {
        this.car_type_code = car_type_code == null ? null : car_type_code.trim();
    }

    public String getCar_brand_code() {
        return car_brand_code;
    }

    public void setCar_brand_code(String car_brand_code) {
        this.car_brand_code = car_brand_code == null ? null : car_brand_code.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user_id=").append(user_id);
        sb.append(", plate=").append(plate);
        sb.append(", car_type_id=").append(car_type_id);
        sb.append(", car_type_name=").append(car_type_name);
        sb.append(", car_type_color=").append(car_type_color);
        sb.append(", car_logo_url=").append(car_logo_url);
        sb.append(", gmt_last_maintenance=").append(gmt_last_maintenance);
        sb.append(", membership_card_id=").append(membership_card_id);
        sb.append(", car_status=").append(car_status);
        sb.append(", gmt_activate=").append(gmt_activate);
        sb.append(", gmt_take_effect=").append(gmt_take_effect);
        sb.append(", gmt_lose_effect=").append(gmt_lose_effect);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", version=").append(version);
        sb.append(", is_default=").append(is_default);
        sb.append(", color=").append(color);
        sb.append(", vin=").append(vin);
        sb.append(", card_level=").append(card_level);
        sb.append(", last_maintenance_miles=").append(last_maintenance_miles);
        sb.append(", next_maintenance_miles=").append(next_maintenance_miles);
        sb.append(", curr_maintenance_miles=").append(curr_maintenance_miles);
        sb.append(", car_type_image=").append(car_type_image);
        sb.append(", car_type_code=").append(car_type_code);
        sb.append(", car_brand_code=").append(car_brand_code);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}