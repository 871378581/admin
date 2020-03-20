package com.segama.ege.dto;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.entity.ServiceOrderEvent;

public class ServiceOrderEventDTO {
    private Long id;

    private Long order_id;

    private String order_string_id;

    private String event_staff_id;

    private String event_staff_role;

    private String event_staff_name;

    private String event_desc;

    private String gmt_event;

    private boolean result;

    private String gmt_create;

    private String gmt_modify;

    private String creator_account;

    private String modifier_account;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

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
        this.order_string_id = order_string_id;
    }

    public String getEvent_staff_id() {
        return event_staff_id;
    }

    public void setEvent_staff_id(String event_staff_id) {
        this.event_staff_id = event_staff_id;
    }

    public String getEvent_staff_role() {
        return event_staff_role;
    }

    public void setEvent_staff_role(String event_staff_role) {
        this.event_staff_role = event_staff_role;
    }

    public String getEvent_staff_name() {
        return event_staff_name;
    }

    public void setEvent_staff_name(String event_staff_name) {
        this.event_staff_name = event_staff_name;
    }

    public String getEvent_desc() {
        return event_desc;
    }

    public void setEvent_desc(String event_desc) {
        this.event_desc = event_desc;
    }

    public String getGmt_event() {
        return gmt_event;
    }

    public void setGmt_event(String gmt_event) {
        this.gmt_event = gmt_event;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getGmt_modify() {
        return gmt_modify;
    }

    public void setGmt_modify(String gmt_modify) {
        this.gmt_modify = gmt_modify;
    }

    public String getCreator_account() {
        return creator_account;
    }

    public void setCreator_account(String creator_account) {
        this.creator_account = creator_account;
    }

    public String getModifier_account() {
        return modifier_account;
    }

    public void setModifier_account(String modifier_account) {
        this.modifier_account = modifier_account;
    }

    public static ServiceOrderEventDTO build(ServiceOrderEvent serviceOrderEvent){
        ServiceOrderEventDTO dto = new ServiceOrderEventDTO();
        dto.setCreator_account(serviceOrderEvent.getCreator_account());
        dto.setEvent_desc(serviceOrderEvent.getEvent_desc());
        dto.setEvent_staff_id(serviceOrderEvent.getEvent_staff_id());
        dto.setEvent_staff_name(serviceOrderEvent.getEvent_staff_name());
        dto.setEvent_staff_role(serviceOrderEvent.getEvent_staff_role());
        dto.setGmt_create(DateUtil.parse(serviceOrderEvent.getGmt_create()));
        dto.setGmt_event(DateUtil.parse(serviceOrderEvent.getGmt_event()));
        dto.setGmt_modify(DateUtil.parse(serviceOrderEvent.getGmt_modify()));
        dto.setId(serviceOrderEvent.getId());
        dto.setOrder_id(serviceOrderEvent.getOrder_id());
        dto.setOrder_string_id(serviceOrderEvent.getOrder_string_id());
        dto.setModifier_account(serviceOrderEvent.getModifier_account());
        dto.setResult(serviceOrderEvent.getResult());
        return dto;
    }
}
