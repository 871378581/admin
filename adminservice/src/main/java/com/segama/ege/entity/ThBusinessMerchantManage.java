package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ThBusinessMerchantManage implements Serializable {
    private Long id;

    private String business_name;

    private String business_short_name;

    private String business_code;

    private String contact_phone;

    private String contact_name;

    private String contact_email;

    private Integer business_status;

    private String description;

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

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name == null ? null : business_name.trim();
    }

    public String getBusiness_short_name() {
        return business_short_name;
    }

    public void setBusiness_short_name(String business_short_name) {
        this.business_short_name = business_short_name == null ? null : business_short_name.trim();
    }

    public String getBusiness_code() {
        return business_code;
    }

    public void setBusiness_code(String business_code) {
        this.business_code = business_code == null ? null : business_code.trim();
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone == null ? null : contact_phone.trim();
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name == null ? null : contact_name.trim();
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email == null ? null : contact_email.trim();
    }

    public Integer getBusiness_status() {
        return business_status;
    }

    public void setBusiness_status(Integer business_status) {
        this.business_status = business_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
        sb.append(", business_name=").append(business_name);
        sb.append(", business_short_name=").append(business_short_name);
        sb.append(", business_code=").append(business_code);
        sb.append(", contact_phone=").append(contact_phone);
        sb.append(", contact_name=").append(contact_name);
        sb.append(", contact_email=").append(contact_email);
        sb.append(", business_status=").append(business_status);
        sb.append(", description=").append(description);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}