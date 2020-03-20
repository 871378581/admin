package com.segama.ege.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ServiceOrder implements Serializable {
    private Long id;

    private String order_string_id;

    private String user_id;

    private String user_name;

    private Long car_id;

    private String car_plate;

    private String car_type_name;

    private Long shop_id;

    private String shop_name;

    private Long oil_id;

    private String oil_brand;

    private String service_item;

    private String order_status;

    private Long service_pacakge_id;

    private Long report_id;

    private String estimated_fee;

    private String final_fee;

    private Long pay_id;

    private String order_qr_code;

    private Date gmt_create;

    private Date gmt_confirm;

    private String gmt_service_date;

    private String gmt_change_service_date;

    private Date gmt_actual_service;

    private Date gmt_pay;

    private Date gmt_evaluate;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String car_logo_url;

    private Long evaluate_id;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String gmt_service_begin_time;

    private String gmt_service_end_time;

    private String gmt_change_service_end_time;

    private String gmt_change_service_begin_time;

    private String child_status;

    private Long shop_user_id;

    private String shop_user_account;

    private String shop_user_name;

    private String curr_maintenance_miles;

    private String car_front_photo_url;

    private String car_dashboard_photo_url;

    private Integer order_type;

    private String verify_remark;

    private Integer settle;

    private String settle_amount;

    private String verify_account;

    private String card_level;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder_string_id() {
        return order_string_id;
    }

    public void setOrder_string_id(String order_string_id) {
        this.order_string_id = order_string_id == null ? null : order_string_id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate == null ? null : car_plate.trim();
    }

    public String getCar_type_name() {
        return car_type_name;
    }

    public void setCar_type_name(String car_type_name) {
        this.car_type_name = car_type_name == null ? null : car_type_name.trim();
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name == null ? null : shop_name.trim();
    }

    public Long getOil_id() {
        return oil_id;
    }

    public void setOil_id(Long oil_id) {
        this.oil_id = oil_id;
    }

    public String getOil_brand() {
        return oil_brand;
    }

    public void setOil_brand(String oil_brand) {
        this.oil_brand = oil_brand == null ? null : oil_brand.trim();
    }

    public String getService_item() {
        return service_item;
    }

    public void setService_item(String service_item) {
        this.service_item = service_item == null ? null : service_item.trim();
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status == null ? null : order_status.trim();
    }

    public Long getService_pacakge_id() {
        return service_pacakge_id;
    }

    public void setService_pacakge_id(Long service_pacakge_id) {
        this.service_pacakge_id = service_pacakge_id;
    }

    public Long getReport_id() {
        return report_id;
    }

    public void setReport_id(Long report_id) {
        this.report_id = report_id;
    }

    public String getEstimated_fee() {
        return estimated_fee;
    }

    public void setEstimated_fee(String estimated_fee) {
        this.estimated_fee = estimated_fee == null ? null : estimated_fee.trim();
    }

    public String getFinal_fee() {
        return final_fee;
    }

    public void setFinal_fee(String final_fee) {
        this.final_fee = final_fee == null ? null : final_fee.trim();
    }

    public Long getPay_id() {
        return pay_id;
    }

    public void setPay_id(Long pay_id) {
        this.pay_id = pay_id;
    }

    public String getOrder_qr_code() {
        return order_qr_code;
    }

    public void setOrder_qr_code(String order_qr_code) {
        this.order_qr_code = order_qr_code == null ? null : order_qr_code.trim();
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_confirm() {
        return gmt_confirm;
    }

    public void setGmt_confirm(Date gmt_confirm) {
        this.gmt_confirm = gmt_confirm;
    }

    public String getGmt_service_date() {
        return gmt_service_date;
    }

    public void setGmt_service_date(String gmt_service_date) {
        this.gmt_service_date = gmt_service_date == null ? null : gmt_service_date.trim();
    }

    public String getGmt_change_service_date() {
        return gmt_change_service_date;
    }

    public void setGmt_change_service_date(String gmt_change_service_date) {
        this.gmt_change_service_date = gmt_change_service_date == null ? null : gmt_change_service_date.trim();
    }

    public Date getGmt_actual_service() {
        return gmt_actual_service;
    }

    public void setGmt_actual_service(Date gmt_actual_service) {
        this.gmt_actual_service = gmt_actual_service;
    }

    public Date getGmt_pay() {
        return gmt_pay;
    }

    public void setGmt_pay(Date gmt_pay) {
        this.gmt_pay = gmt_pay;
    }

    public Date getGmt_evaluate() {
        return gmt_evaluate;
    }

    public void setGmt_evaluate(Date gmt_evaluate) {
        this.gmt_evaluate = gmt_evaluate;
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

    public String getCar_logo_url() {
        return car_logo_url;
    }

    public void setCar_logo_url(String car_logo_url) {
        this.car_logo_url = car_logo_url == null ? null : car_logo_url.trim();
    }

    public Long getEvaluate_id() {
        return evaluate_id;
    }

    public void setEvaluate_id(Long evaluate_id) {
        this.evaluate_id = evaluate_id;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getGmt_service_begin_time() {
        return gmt_service_begin_time;
    }

    public void setGmt_service_begin_time(String gmt_service_begin_time) {
        this.gmt_service_begin_time = gmt_service_begin_time == null ? null : gmt_service_begin_time.trim();
    }

    public String getGmt_service_end_time() {
        return gmt_service_end_time;
    }

    public void setGmt_service_end_time(String gmt_service_end_time) {
        this.gmt_service_end_time = gmt_service_end_time == null ? null : gmt_service_end_time.trim();
    }

    public String getGmt_change_service_end_time() {
        return gmt_change_service_end_time;
    }

    public void setGmt_change_service_end_time(String gmt_change_service_end_time) {
        this.gmt_change_service_end_time = gmt_change_service_end_time == null ? null : gmt_change_service_end_time.trim();
    }

    public String getGmt_change_service_begin_time() {
        return gmt_change_service_begin_time;
    }

    public void setGmt_change_service_begin_time(String gmt_change_service_begin_time) {
        this.gmt_change_service_begin_time = gmt_change_service_begin_time == null ? null : gmt_change_service_begin_time.trim();
    }

    public String getChild_status() {
        return child_status;
    }

    public void setChild_status(String child_status) {
        this.child_status = child_status == null ? null : child_status.trim();
    }

    public Long getShop_user_id() {
        return shop_user_id;
    }

    public void setShop_user_id(Long shop_user_id) {
        this.shop_user_id = shop_user_id;
    }

    public String getShop_user_account() {
        return shop_user_account;
    }

    public void setShop_user_account(String shop_user_account) {
        this.shop_user_account = shop_user_account == null ? null : shop_user_account.trim();
    }

    public String getShop_user_name() {
        return shop_user_name;
    }

    public void setShop_user_name(String shop_user_name) {
        this.shop_user_name = shop_user_name == null ? null : shop_user_name.trim();
    }

    public String getCurr_maintenance_miles() {
        return curr_maintenance_miles;
    }

    public void setCurr_maintenance_miles(String curr_maintenance_miles) {
        this.curr_maintenance_miles = curr_maintenance_miles == null ? null : curr_maintenance_miles.trim();
    }

    public String getCar_front_photo_url() {
        return car_front_photo_url;
    }

    public void setCar_front_photo_url(String car_front_photo_url) {
        this.car_front_photo_url = car_front_photo_url == null ? null : car_front_photo_url.trim();
    }

    public String getCar_dashboard_photo_url() {
        return car_dashboard_photo_url;
    }

    public void setCar_dashboard_photo_url(String car_dashboard_photo_url) {
        this.car_dashboard_photo_url = car_dashboard_photo_url == null ? null : car_dashboard_photo_url.trim();
    }

    public Integer getOrder_type() {
        return order_type;
    }

    public void setOrder_type(Integer order_type) {
        this.order_type = order_type;
    }

    public String getVerify_remark() {
        return verify_remark;
    }

    public void setVerify_remark(String verify_remark) {
        this.verify_remark = verify_remark == null ? null : verify_remark.trim();
    }

    public Integer getSettle() {
        return settle;
    }

    public void setSettle(Integer settle) {
        this.settle = settle;
    }

    public String getSettle_amount() {
        return settle_amount;
    }

    public void setSettle_amount(String settle_amount) {
        this.settle_amount = settle_amount == null ? null : settle_amount.trim();
    }

    public String getVerify_account() {
        return verify_account;
    }

    public void setVerify_account(String verify_account) {
        this.verify_account = verify_account == null ? null : verify_account.trim();
    }

    public String getCard_level() {
        return card_level;
    }

    public void setCard_level(String card_level) {
        this.card_level = card_level == null ? null : card_level.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", order_string_id=").append(order_string_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", user_name=").append(user_name);
        sb.append(", car_id=").append(car_id);
        sb.append(", car_plate=").append(car_plate);
        sb.append(", car_type_name=").append(car_type_name);
        sb.append(", shop_id=").append(shop_id);
        sb.append(", shop_name=").append(shop_name);
        sb.append(", oil_id=").append(oil_id);
        sb.append(", oil_brand=").append(oil_brand);
        sb.append(", service_item=").append(service_item);
        sb.append(", order_status=").append(order_status);
        sb.append(", service_pacakge_id=").append(service_pacakge_id);
        sb.append(", report_id=").append(report_id);
        sb.append(", estimated_fee=").append(estimated_fee);
        sb.append(", final_fee=").append(final_fee);
        sb.append(", pay_id=").append(pay_id);
        sb.append(", order_qr_code=").append(order_qr_code);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_confirm=").append(gmt_confirm);
        sb.append(", gmt_service_date=").append(gmt_service_date);
        sb.append(", gmt_change_service_date=").append(gmt_change_service_date);
        sb.append(", gmt_actual_service=").append(gmt_actual_service);
        sb.append(", gmt_pay=").append(gmt_pay);
        sb.append(", gmt_evaluate=").append(gmt_evaluate);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", car_logo_url=").append(car_logo_url);
        sb.append(", evaluate_id=").append(evaluate_id);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", gmt_service_begin_time=").append(gmt_service_begin_time);
        sb.append(", gmt_service_end_time=").append(gmt_service_end_time);
        sb.append(", gmt_change_service_end_time=").append(gmt_change_service_end_time);
        sb.append(", gmt_change_service_begin_time=").append(gmt_change_service_begin_time);
        sb.append(", child_status=").append(child_status);
        sb.append(", shop_user_id=").append(shop_user_id);
        sb.append(", shop_user_account=").append(shop_user_account);
        sb.append(", shop_user_name=").append(shop_user_name);
        sb.append(", curr_maintenance_miles=").append(curr_maintenance_miles);
        sb.append(", car_front_photo_url=").append(car_front_photo_url);
        sb.append(", car_dashboard_photo_url=").append(car_dashboard_photo_url);
        sb.append(", order_type=").append(order_type);
        sb.append(", verify_remark=").append(verify_remark);
        sb.append(", settle=").append(settle);
        sb.append(", settle_amount=").append(settle_amount);
        sb.append(", verify_account=").append(verify_account);
        sb.append(", card_level=").append(card_level);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}