package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ShopPhotoResource implements Serializable {
    private Long id;

    private String photo_url;

    private Long shop_id;

    private Integer order_id;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private Integer version;

    private Boolean verify_status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url == null ? null : photo_url.trim();
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getVerify_status() {
        return verify_status;
    }

    public void setVerify_status(Boolean verify_status) {
        this.verify_status = verify_status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", photo_url=").append(photo_url);
        sb.append(", shop_id=").append(shop_id);
        sb.append(", order_id=").append(order_id);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", version=").append(version);
        sb.append(", verify_status=").append(verify_status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}