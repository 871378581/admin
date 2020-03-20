package com.segama.ege.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WxUserLoginLog implements Serializable {
    private Long id;

    private String user_id;

    private Date gmt_login;

    private BigDecimal login_longitude;

    private BigDecimal login_latitude;

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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public Date getGmt_login() {
        return gmt_login;
    }

    public void setGmt_login(Date gmt_login) {
        this.gmt_login = gmt_login;
    }

    public BigDecimal getLogin_longitude() {
        return login_longitude;
    }

    public void setLogin_longitude(BigDecimal login_longitude) {
        this.login_longitude = login_longitude;
    }

    public BigDecimal getLogin_latitude() {
        return login_latitude;
    }

    public void setLogin_latitude(BigDecimal login_latitude) {
        this.login_latitude = login_latitude;
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
        sb.append(", user_id=").append(user_id);
        sb.append(", gmt_login=").append(gmt_login);
        sb.append(", login_longitude=").append(login_longitude);
        sb.append(", login_latitude=").append(login_latitude);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}