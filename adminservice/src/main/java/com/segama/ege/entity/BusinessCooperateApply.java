package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class BusinessCooperateApply implements Serializable {
    private Long id;

    private String user_name;

    private String phone_num;

    private String expect_contact_time;

    private String project_description;

    private String contacter_status;

    private String remark;

    private String operator;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String user_id;

    private String shop_name;

    private String shop_area_size;

    private String shop_address;

    private String merchant_type;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num == null ? null : phone_num.trim();
    }

    public String getExpect_contact_time() {
        return expect_contact_time;
    }

    public void setExpect_contact_time(String expect_contact_time) {
        this.expect_contact_time = expect_contact_time == null ? null : expect_contact_time.trim();
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description == null ? null : project_description.trim();
    }

    public String getContacter_status() {
        return contacter_status;
    }

    public void setContacter_status(String contacter_status) {
        this.contacter_status = contacter_status == null ? null : contacter_status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name == null ? null : shop_name.trim();
    }

    public String getShop_area_size() {
        return shop_area_size;
    }

    public void setShop_area_size(String shop_area_size) {
        this.shop_area_size = shop_area_size == null ? null : shop_area_size.trim();
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address == null ? null : shop_address.trim();
    }

    public String getMerchant_type() {
        return merchant_type;
    }

    public void setMerchant_type(String merchant_type) {
        this.merchant_type = merchant_type == null ? null : merchant_type.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user_name=").append(user_name);
        sb.append(", phone_num=").append(phone_num);
        sb.append(", expect_contact_time=").append(expect_contact_time);
        sb.append(", project_description=").append(project_description);
        sb.append(", contacter_status=").append(contacter_status);
        sb.append(", remark=").append(remark);
        sb.append(", operator=").append(operator);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", user_id=").append(user_id);
        sb.append(", shop_name=").append(shop_name);
        sb.append(", shop_area_size=").append(shop_area_size);
        sb.append(", shop_address=").append(shop_address);
        sb.append(", merchant_type=").append(merchant_type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}