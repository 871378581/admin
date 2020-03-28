package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ThSaleExtensionManage implements Serializable {
    private Long id;

    private String code;

    private String share_url_code;

    private String product_name;

    private String product_code;

    private String request_url;

    private String source_url;

    private String phone;

    private String owner_account;

    private String create_account;

    private String user_name;

    private String address;

    private Date gmt_create;

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

    public String getShare_url_code() {
        return share_url_code;
    }

    public void setShare_url_code(String share_url_code) {
        this.share_url_code = share_url_code == null ? null : share_url_code.trim();
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name == null ? null : product_name.trim();
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code == null ? null : product_code.trim();
    }

    public String getRequest_url() {
        return request_url;
    }

    public void setRequest_url(String request_url) {
        this.request_url = request_url == null ? null : request_url.trim();
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url == null ? null : source_url.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOwner_account() {
        return owner_account;
    }

    public void setOwner_account(String owner_account) {
        this.owner_account = owner_account == null ? null : owner_account.trim();
    }

    public String getCreate_account() {
        return create_account;
    }

    public void setCreate_account(String create_account) {
        this.create_account = create_account == null ? null : create_account.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", share_url_code=").append(share_url_code);
        sb.append(", product_name=").append(product_name);
        sb.append(", product_code=").append(product_code);
        sb.append(", request_url=").append(request_url);
        sb.append(", source_url=").append(source_url);
        sb.append(", phone=").append(phone);
        sb.append(", owner_account=").append(owner_account);
        sb.append(", create_account=").append(create_account);
        sb.append(", user_name=").append(user_name);
        sb.append(", address=").append(address);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}