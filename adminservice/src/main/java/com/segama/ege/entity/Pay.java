package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class Pay implements Serializable {
    private Long id;

    private Long order_id;

    private String order_string_id;

    private String pay_string_id;

    private String pay_status;

    private String before_discount_fee;

    private String coupon_ids;

    private String discount_fee;

    private String pay_mode;

    private String final_fee;

    private Date gmt_pay_create;

    private Date gmt_pay_finish;

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

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOrder_string_id() {
        return order_string_id;
    }

    public void setOrder_string_id(String order_string_id) {
        this.order_string_id = order_string_id == null ? null : order_string_id.trim();
    }

    public String getPay_string_id() {
        return pay_string_id;
    }

    public void setPay_string_id(String pay_string_id) {
        this.pay_string_id = pay_string_id == null ? null : pay_string_id.trim();
    }

    public String getPay_status() {
        return pay_status;
    }

    public void setPay_status(String pay_status) {
        this.pay_status = pay_status == null ? null : pay_status.trim();
    }

    public String getBefore_discount_fee() {
        return before_discount_fee;
    }

    public void setBefore_discount_fee(String before_discount_fee) {
        this.before_discount_fee = before_discount_fee == null ? null : before_discount_fee.trim();
    }

    public String getCoupon_ids() {
        return coupon_ids;
    }

    public void setCoupon_ids(String coupon_ids) {
        this.coupon_ids = coupon_ids == null ? null : coupon_ids.trim();
    }

    public String getDiscount_fee() {
        return discount_fee;
    }

    public void setDiscount_fee(String discount_fee) {
        this.discount_fee = discount_fee == null ? null : discount_fee.trim();
    }

    public String getPay_mode() {
        return pay_mode;
    }

    public void setPay_mode(String pay_mode) {
        this.pay_mode = pay_mode == null ? null : pay_mode.trim();
    }

    public String getFinal_fee() {
        return final_fee;
    }

    public void setFinal_fee(String final_fee) {
        this.final_fee = final_fee == null ? null : final_fee.trim();
    }

    public Date getGmt_pay_create() {
        return gmt_pay_create;
    }

    public void setGmt_pay_create(Date gmt_pay_create) {
        this.gmt_pay_create = gmt_pay_create;
    }

    public Date getGmt_pay_finish() {
        return gmt_pay_finish;
    }

    public void setGmt_pay_finish(Date gmt_pay_finish) {
        this.gmt_pay_finish = gmt_pay_finish;
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
        sb.append(", order_id=").append(order_id);
        sb.append(", order_string_id=").append(order_string_id);
        sb.append(", pay_string_id=").append(pay_string_id);
        sb.append(", pay_status=").append(pay_status);
        sb.append(", before_discount_fee=").append(before_discount_fee);
        sb.append(", coupon_ids=").append(coupon_ids);
        sb.append(", discount_fee=").append(discount_fee);
        sb.append(", pay_mode=").append(pay_mode);
        sb.append(", final_fee=").append(final_fee);
        sb.append(", gmt_pay_create=").append(gmt_pay_create);
        sb.append(", gmt_pay_finish=").append(gmt_pay_finish);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}