package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ServiceOrderEvent implements Serializable {
    private Long id;

    private Long order_id;

    private String order_string_id;

    private String event_staff_id;

    private String event_staff_role;

    private String event_staff_name;

    private String event_desc;

    private Date gmt_event;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private Boolean result;

    private Boolean is_car_user_operate;

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

    public String getEvent_staff_id() {
        return event_staff_id;
    }

    public void setEvent_staff_id(String event_staff_id) {
        this.event_staff_id = event_staff_id == null ? null : event_staff_id.trim();
    }

    public String getEvent_staff_role() {
        return event_staff_role;
    }

    public void setEvent_staff_role(String event_staff_role) {
        this.event_staff_role = event_staff_role == null ? null : event_staff_role.trim();
    }

    public String getEvent_staff_name() {
        return event_staff_name;
    }

    public void setEvent_staff_name(String event_staff_name) {
        this.event_staff_name = event_staff_name == null ? null : event_staff_name.trim();
    }

    public String getEvent_desc() {
        return event_desc;
    }

    public void setEvent_desc(String event_desc) {
        this.event_desc = event_desc == null ? null : event_desc.trim();
    }

    public Date getGmt_event() {
        return gmt_event;
    }

    public void setGmt_event(Date gmt_event) {
        this.gmt_event = gmt_event;
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

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Boolean getIs_car_user_operate() {
        return is_car_user_operate;
    }

    public void setIs_car_user_operate(Boolean is_car_user_operate) {
        this.is_car_user_operate = is_car_user_operate;
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
        sb.append(", event_staff_id=").append(event_staff_id);
        sb.append(", event_staff_role=").append(event_staff_role);
        sb.append(", event_staff_name=").append(event_staff_name);
        sb.append(", event_desc=").append(event_desc);
        sb.append(", gmt_event=").append(gmt_event);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", result=").append(result);
        sb.append(", is_car_user_operate=").append(is_car_user_operate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}