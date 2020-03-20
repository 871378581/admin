package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {
    private Long id;

    private Long order_id;

    private String order_string_id;

    private Date gmt_report_date;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private Boolean report_have_exception;

    private String report_items;

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

    public Date getGmt_report_date() {
        return gmt_report_date;
    }

    public void setGmt_report_date(Date gmt_report_date) {
        this.gmt_report_date = gmt_report_date;
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

    public Boolean getReport_have_exception() {
        return report_have_exception;
    }

    public void setReport_have_exception(Boolean report_have_exception) {
        this.report_have_exception = report_have_exception;
    }

    public String getReport_items() {
        return report_items;
    }

    public void setReport_items(String report_items) {
        this.report_items = report_items == null ? null : report_items.trim();
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
        sb.append(", gmt_report_date=").append(gmt_report_date);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", report_have_exception=").append(report_have_exception);
        sb.append(", report_items=").append(report_items);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}