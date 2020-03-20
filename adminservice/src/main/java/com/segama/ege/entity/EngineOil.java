package com.segama.ege.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EngineOil implements Serializable {
    private Long id;

    private String brand;

    private String brand_name;

    private String code;

    private BigDecimal market_price;

    private BigDecimal member_price;

    private String photo_url;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String oil_type;

    private BigDecimal market_price_max;

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

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name == null ? null : brand_name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public BigDecimal getMarket_price() {
        return market_price;
    }

    public void setMarket_price(BigDecimal market_price) {
        this.market_price = market_price;
    }

    public BigDecimal getMember_price() {
        return member_price;
    }

    public void setMember_price(BigDecimal member_price) {
        this.member_price = member_price;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url == null ? null : photo_url.trim();
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

    public String getOil_type() {
        return oil_type;
    }

    public void setOil_type(String oil_type) {
        this.oil_type = oil_type == null ? null : oil_type.trim();
    }

    public BigDecimal getMarket_price_max() {
        return market_price_max;
    }

    public void setMarket_price_max(BigDecimal market_price_max) {
        this.market_price_max = market_price_max;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brand=").append(brand);
        sb.append(", brand_name=").append(brand_name);
        sb.append(", code=").append(code);
        sb.append(", market_price=").append(market_price);
        sb.append(", member_price=").append(member_price);
        sb.append(", photo_url=").append(photo_url);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", oil_type=").append(oil_type);
        sb.append(", market_price_max=").append(market_price_max);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}