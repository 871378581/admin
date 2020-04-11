package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ThTemplateManage implements Serializable {
    private Long id;

    private String template_name;

    private String template_code;

    private String banner1;

    private String banner2;

    private String sub_product;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemplate_name() {
        return template_name;
    }

    public void setTemplate_name(String template_name) {
        this.template_name = template_name == null ? null : template_name.trim();
    }

    public String getTemplate_code() {
        return template_code;
    }

    public void setTemplate_code(String template_code) {
        this.template_code = template_code == null ? null : template_code.trim();
    }

    public String getBanner1() {
        return banner1;
    }

    public void setBanner1(String banner1) {
        this.banner1 = banner1 == null ? null : banner1.trim();
    }

    public String getBanner2() {
        return banner2;
    }

    public void setBanner2(String banner2) {
        this.banner2 = banner2 == null ? null : banner2.trim();
    }

    public String getSub_product() {
        return sub_product;
    }

    public void setSub_product(String sub_product) {
        this.sub_product = sub_product == null ? null : sub_product.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", template_name=").append(template_name);
        sb.append(", template_code=").append(template_code);
        sb.append(", banner1=").append(banner1);
        sb.append(", banner2=").append(banner2);
        sb.append(", sub_product=").append(sub_product);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}