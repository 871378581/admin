package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ThOrderManage implements Serializable {
    private Long id;

    private String operate_type;

    private String order_code;

    private String order_time;

    private String order_phone_number;

    private String prov;

    private String city;

    private String order_status;

    private String customer_name;

    private String certificate_type;

    private String certificate_num;

    private String customer_contact_num;

    private String good_name;

    private String address;

    private String active_status;

    private String cudian_code;

    private String shoucong_amt;

    private String shoucong_time;

    private String xiehaozhuanwang_type;

    private String zhuanhualvtichu_reason;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String description;

    private String channel_account;

    private String channel_code;

    private String picihao;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(String operate_type) {
        this.operate_type = operate_type == null ? null : operate_type.trim();
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code == null ? null : order_code.trim();
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time == null ? null : order_time.trim();
    }

    public String getOrder_phone_number() {
        return order_phone_number;
    }

    public void setOrder_phone_number(String order_phone_number) {
        this.order_phone_number = order_phone_number == null ? null : order_phone_number.trim();
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov == null ? null : prov.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status == null ? null : order_status.trim();
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name == null ? null : customer_name.trim();
    }

    public String getCertificate_type() {
        return certificate_type;
    }

    public void setCertificate_type(String certificate_type) {
        this.certificate_type = certificate_type == null ? null : certificate_type.trim();
    }

    public String getCertificate_num() {
        return certificate_num;
    }

    public void setCertificate_num(String certificate_num) {
        this.certificate_num = certificate_num == null ? null : certificate_num.trim();
    }

    public String getCustomer_contact_num() {
        return customer_contact_num;
    }

    public void setCustomer_contact_num(String customer_contact_num) {
        this.customer_contact_num = customer_contact_num == null ? null : customer_contact_num.trim();
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name == null ? null : good_name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getActive_status() {
        return active_status;
    }

    public void setActive_status(String active_status) {
        this.active_status = active_status == null ? null : active_status.trim();
    }

    public String getCudian_code() {
        return cudian_code;
    }

    public void setCudian_code(String cudian_code) {
        this.cudian_code = cudian_code == null ? null : cudian_code.trim();
    }

    public String getShoucong_amt() {
        return shoucong_amt;
    }

    public void setShoucong_amt(String shoucong_amt) {
        this.shoucong_amt = shoucong_amt == null ? null : shoucong_amt.trim();
    }

    public String getShoucong_time() {
        return shoucong_time;
    }

    public void setShoucong_time(String shoucong_time) {
        this.shoucong_time = shoucong_time == null ? null : shoucong_time.trim();
    }

    public String getXiehaozhuanwang_type() {
        return xiehaozhuanwang_type;
    }

    public void setXiehaozhuanwang_type(String xiehaozhuanwang_type) {
        this.xiehaozhuanwang_type = xiehaozhuanwang_type == null ? null : xiehaozhuanwang_type.trim();
    }

    public String getZhuanhualvtichu_reason() {
        return zhuanhualvtichu_reason;
    }

    public void setZhuanhualvtichu_reason(String zhuanhualvtichu_reason) {
        this.zhuanhualvtichu_reason = zhuanhualvtichu_reason == null ? null : zhuanhualvtichu_reason.trim();
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

    public String getChannel_account() {
        return channel_account;
    }

    public void setChannel_account(String channel_account) {
        this.channel_account = channel_account == null ? null : channel_account.trim();
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code == null ? null : channel_code.trim();
    }

    public String getPicihao() {
        return picihao;
    }

    public void setPicihao(String picihao) {
        this.picihao = picihao == null ? null : picihao.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", operate_type=").append(operate_type);
        sb.append(", order_code=").append(order_code);
        sb.append(", order_time=").append(order_time);
        sb.append(", order_phone_number=").append(order_phone_number);
        sb.append(", prov=").append(prov);
        sb.append(", city=").append(city);
        sb.append(", order_status=").append(order_status);
        sb.append(", customer_name=").append(customer_name);
        sb.append(", certificate_type=").append(certificate_type);
        sb.append(", certificate_num=").append(certificate_num);
        sb.append(", customer_contact_num=").append(customer_contact_num);
        sb.append(", good_name=").append(good_name);
        sb.append(", address=").append(address);
        sb.append(", active_status=").append(active_status);
        sb.append(", cudian_code=").append(cudian_code);
        sb.append(", shoucong_amt=").append(shoucong_amt);
        sb.append(", shoucong_time=").append(shoucong_time);
        sb.append(", xiehaozhuanwang_type=").append(xiehaozhuanwang_type);
        sb.append(", zhuanhualvtichu_reason=").append(zhuanhualvtichu_reason);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", description=").append(description);
        sb.append(", channel_account=").append(channel_account);
        sb.append(", channel_code=").append(channel_code);
        sb.append(", picihao=").append(picihao);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}