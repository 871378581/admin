package com.segama.ege.dto;
import java.io.Serializable;
/**
 * @author hxj
 * @version 1.0
 * @Description
 * @String 2019-12-01 00:13
 */
public class ReportDTO implements Serializable {
    private String user_name;

    private String car_plate;

    private String car_level;

    private String car_type;

    private String service_date;

    private String last_maintenance_miles;

    private String curr_maintenance_miles;

    private Long last_order_id;

    private String order_status;

    private String child_status;

    private String order_qr_code;

    public String getOrder_qr_code() {
        return order_qr_code;
    }

    public void setOrder_qr_code(String order_qr_code) {
        this.order_qr_code = order_qr_code;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getChild_status() {
        return child_status;
    }

    public void setChild_status(String child_status) {
        this.child_status = child_status;
    }

    public Long getLast_order_id() {
        return last_order_id;
    }

    public void setLast_order_id(Long last_order_id) {
        this.last_order_id = last_order_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public String getCar_level() {
        return car_level;
    }

    public void setCar_level(String car_level) {
        this.car_level = car_level;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getService_date() {
        return service_date;
    }

    public void setService_date(String service_date) {
        this.service_date = service_date;
    }

    public String getLast_maintenance_miles() {
        return last_maintenance_miles;
    }

    public void setLast_maintenance_miles(String last_maintenance_miles) {
        this.last_maintenance_miles = last_maintenance_miles;
    }

    public String getCurr_maintenance_miles() {
        return curr_maintenance_miles;
    }

    public void setCurr_maintenance_miles(String curr_maintenance_miles) {
        this.curr_maintenance_miles = curr_maintenance_miles;
    }

    private Long order_id;

    private String order_string_id;

    private Object report_items;

    private String gmt_report_String;

    private String gmt_create;

    private String gmt_modify;

    private String creator_account;

    private String modifier_account;

    private static final long serialVersionUID = 1L;


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

    public Object getReport_items() {
        return report_items;
    }

    public void setReport_items(Object report_items) {
        this.report_items = report_items;
    }

    public String getGmt_report_String() {
        return gmt_report_String;
    }

    public void setGmt_report_String(String gmt_report_String) {
        this.gmt_report_String = gmt_report_String;
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
        this.creator_account = creator_account == null ? null : creator_account.trim();
    }

    public String getModifier_account() {
        return modifier_account;
    }

    public void setModifier_account(String modifier_account) {
        this.modifier_account = modifier_account == null ? null : modifier_account.trim();
    }


}
