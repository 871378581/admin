package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ThPhotosManage implements Serializable {
    private Long id;

    private String photo_name;

    private String photo_code;

    private String url;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto_name() {
        return photo_name;
    }

    public void setPhoto_name(String photo_name) {
        this.photo_name = photo_name == null ? null : photo_name.trim();
    }

    public String getPhoto_code() {
        return photo_code;
    }

    public void setPhoto_code(String photo_code) {
        this.photo_code = photo_code == null ? null : photo_code.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", photo_name=").append(photo_name);
        sb.append(", photo_code=").append(photo_code);
        sb.append(", url=").append(url);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}