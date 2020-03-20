package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class CarType implements Serializable {
    private Long id;

    private String brand;

    private String brand_code;

    private String car_type;

    private String car_type_code;

    private String car_style;

    private String car_style_code;

    private String brand_first_letter;

    private String category_code;

    private String category_name;

    private Long category_level;

    private String parent_category_code;

    private String logo_url;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getBrand_code() {
        return brand_code;
    }

    public void setBrand_code(String brand_code) {
        this.brand_code = brand_code == null ? null : brand_code.trim();
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type == null ? null : car_type.trim();
    }

    public String getCar_type_code() {
        return car_type_code;
    }

    public void setCar_type_code(String car_type_code) {
        this.car_type_code = car_type_code == null ? null : car_type_code.trim();
    }

    public String getCar_style() {
        return car_style;
    }

    public void setCar_style(String car_style) {
        this.car_style = car_style == null ? null : car_style.trim();
    }

    public String getCar_style_code() {
        return car_style_code;
    }

    public void setCar_style_code(String car_style_code) {
        this.car_style_code = car_style_code == null ? null : car_style_code.trim();
    }

    public String getBrand_first_letter() {
        return brand_first_letter;
    }

    public void setBrand_first_letter(String brand_first_letter) {
        this.brand_first_letter = brand_first_letter == null ? null : brand_first_letter.trim();
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code == null ? null : category_code.trim();
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name == null ? null : category_name.trim();
    }

    public Long getCategory_level() {
        return category_level;
    }

    public void setCategory_level(Long category_level) {
        this.category_level = category_level;
    }

    public String getParent_category_code() {
        return parent_category_code;
    }

    public void setParent_category_code(String parent_category_code) {
        this.parent_category_code = parent_category_code == null ? null : parent_category_code.trim();
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url == null ? null : logo_url.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brand=").append(brand);
        sb.append(", brand_code=").append(brand_code);
        sb.append(", car_type=").append(car_type);
        sb.append(", car_type_code=").append(car_type_code);
        sb.append(", car_style=").append(car_style);
        sb.append(", car_style_code=").append(car_style_code);
        sb.append(", brand_first_letter=").append(brand_first_letter);
        sb.append(", category_code=").append(category_code);
        sb.append(", category_name=").append(category_name);
        sb.append(", category_level=").append(category_level);
        sb.append(", parent_category_code=").append(parent_category_code);
        sb.append(", logo_url=").append(logo_url);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}