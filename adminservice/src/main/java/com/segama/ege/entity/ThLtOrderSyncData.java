package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ThLtOrderSyncData implements Serializable {
    private Long id;

    private String code;

    private String channel_code;

    private String extend;

    private String city_name;

    private String pacakge_code;

    private String pacakge_name;

    private String contract_period;

    private String discount_amount;

    private String access_name;

    private String id_number;

    private String addressee;

    private String addressee_phone;

    private String district_name;

    private String address;

    private String selected_phone_num;

    private String freeze;

    private String freeze_amount;

    private String order_create_time;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code == null ? null : channel_code.trim();
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name == null ? null : city_name.trim();
    }

    public String getPacakge_code() {
        return pacakge_code;
    }

    public void setPacakge_code(String pacakge_code) {
        this.pacakge_code = pacakge_code == null ? null : pacakge_code.trim();
    }

    public String getPacakge_name() {
        return pacakge_name;
    }

    public void setPacakge_name(String pacakge_name) {
        this.pacakge_name = pacakge_name == null ? null : pacakge_name.trim();
    }

    public String getContract_period() {
        return contract_period;
    }

    public void setContract_period(String contract_period) {
        this.contract_period = contract_period == null ? null : contract_period.trim();
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(String discount_amount) {
        this.discount_amount = discount_amount == null ? null : discount_amount.trim();
    }

    public String getAccess_name() {
        return access_name;
    }

    public void setAccess_name(String access_name) {
        this.access_name = access_name == null ? null : access_name.trim();
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number == null ? null : id_number.trim();
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee == null ? null : addressee.trim();
    }

    public String getAddressee_phone() {
        return addressee_phone;
    }

    public void setAddressee_phone(String addressee_phone) {
        this.addressee_phone = addressee_phone == null ? null : addressee_phone.trim();
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name == null ? null : district_name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSelected_phone_num() {
        return selected_phone_num;
    }

    public void setSelected_phone_num(String selected_phone_num) {
        this.selected_phone_num = selected_phone_num == null ? null : selected_phone_num.trim();
    }

    public String getFreeze() {
        return freeze;
    }

    public void setFreeze(String freeze) {
        this.freeze = freeze == null ? null : freeze.trim();
    }

    public String getFreeze_amount() {
        return freeze_amount;
    }

    public void setFreeze_amount(String freeze_amount) {
        this.freeze_amount = freeze_amount == null ? null : freeze_amount.trim();
    }

    public String getOrder_create_time() {
        return order_create_time;
    }

    public void setOrder_create_time(String order_create_time) {
        this.order_create_time = order_create_time == null ? null : order_create_time.trim();
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
        sb.append(", code=").append(code);
        sb.append(", channel_code=").append(channel_code);
        sb.append(", extend=").append(extend);
        sb.append(", city_name=").append(city_name);
        sb.append(", pacakge_code=").append(pacakge_code);
        sb.append(", pacakge_name=").append(pacakge_name);
        sb.append(", contract_period=").append(contract_period);
        sb.append(", discount_amount=").append(discount_amount);
        sb.append(", access_name=").append(access_name);
        sb.append(", id_number=").append(id_number);
        sb.append(", addressee=").append(addressee);
        sb.append(", addressee_phone=").append(addressee_phone);
        sb.append(", district_name=").append(district_name);
        sb.append(", address=").append(address);
        sb.append(", selected_phone_num=").append(selected_phone_num);
        sb.append(", freeze=").append(freeze);
        sb.append(", freeze_amount=").append(freeze_amount);
        sb.append(", order_create_time=").append(order_create_time);
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