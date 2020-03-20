package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderFeeDetail implements Serializable {
    private Long id;

    private Long order_id;

    private String order_string_id;

    private Long each_item_id;

    private String each_item;

    private String each_fee;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private Long pay_id;

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

    public Long getEach_item_id() {
        return each_item_id;
    }

    public void setEach_item_id(Long each_item_id) {
        this.each_item_id = each_item_id;
    }

    public String getEach_item() {
        return each_item;
    }

    public void setEach_item(String each_item) {
        this.each_item = each_item == null ? null : each_item.trim();
    }

    public String getEach_fee() {
        return each_fee;
    }

    public void setEach_fee(String each_fee) {
        this.each_fee = each_fee == null ? null : each_fee.trim();
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

    public Long getPay_id() {
        return pay_id;
    }

    public void setPay_id(Long pay_id) {
        this.pay_id = pay_id;
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
        sb.append(", each_item_id=").append(each_item_id);
        sb.append(", each_item=").append(each_item);
        sb.append(", each_fee=").append(each_fee);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", pay_id=").append(pay_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}