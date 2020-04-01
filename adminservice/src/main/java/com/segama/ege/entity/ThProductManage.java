package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ThProductManage implements Serializable {
    private Long id;

    private String business_name;

    private String product_name;

    private String product_code;

    private String product_type;

    private String url;

    private Integer product_status;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String description;

    private String source_url;

    private String business_code;

    private String type;

    private String shifou_2_kaifa;

    private String settle_mode;

    private String settle_column;

    private String settle_value;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name == null ? null : business_name.trim();
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name == null ? null : product_name.trim();
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code == null ? null : product_code.trim();
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type == null ? null : product_type.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getProduct_status() {
        return product_status;
    }

    public void setProduct_status(Integer product_status) {
        this.product_status = product_status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url == null ? null : source_url.trim();
    }

    public String getBusiness_code() {
        return business_code;
    }

    public void setBusiness_code(String business_code) {
        this.business_code = business_code == null ? null : business_code.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getShifou_2_kaifa() {
        return shifou_2_kaifa;
    }

    public void setShifou_2_kaifa(String shifou_2_kaifa) {
        this.shifou_2_kaifa = shifou_2_kaifa == null ? null : shifou_2_kaifa.trim();
    }

    public String getSettle_mode() {
        return settle_mode;
    }

    public void setSettle_mode(String settle_mode) {
        this.settle_mode = settle_mode == null ? null : settle_mode.trim();
    }

    public String getSettle_column() {
        return settle_column;
    }

    public void setSettle_column(String settle_column) {
        this.settle_column = settle_column == null ? null : settle_column.trim();
    }

    public String getSettle_value() {
        return settle_value;
    }

    public void setSettle_value(String settle_value) {
        this.settle_value = settle_value == null ? null : settle_value.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", business_name=").append(business_name);
        sb.append(", product_name=").append(product_name);
        sb.append(", product_code=").append(product_code);
        sb.append(", product_type=").append(product_type);
        sb.append(", url=").append(url);
        sb.append(", product_status=").append(product_status);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", description=").append(description);
        sb.append(", source_url=").append(source_url);
        sb.append(", business_code=").append(business_code);
        sb.append(", type=").append(type);
        sb.append(", shifou_2_kaifa=").append(shifou_2_kaifa);
        sb.append(", settle_mode=").append(settle_mode);
        sb.append(", settle_column=").append(settle_column);
        sb.append(", settle_value=").append(settle_value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}