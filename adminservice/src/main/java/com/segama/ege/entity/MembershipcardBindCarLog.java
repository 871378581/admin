package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class MembershipcardBindCarLog implements Serializable {
    private Long id;

    private String user_id;

    private String plate;

    private String membership_card_id;

    private String status;

    private Date gmt_bind;

    private Date gmt_activate;

    private Date gmt_take_effect;

    private Date gmt_lose_effect;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private Integer version;

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

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate == null ? null : plate.trim();
    }

    public String getMembership_card_id() {
        return membership_card_id;
    }

    public void setMembership_card_id(String membership_card_id) {
        this.membership_card_id = membership_card_id == null ? null : membership_card_id.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getGmt_bind() {
        return gmt_bind;
    }

    public void setGmt_bind(Date gmt_bind) {
        this.gmt_bind = gmt_bind;
    }

    public Date getGmt_activate() {
        return gmt_activate;
    }

    public void setGmt_activate(Date gmt_activate) {
        this.gmt_activate = gmt_activate;
    }

    public Date getGmt_take_effect() {
        return gmt_take_effect;
    }

    public void setGmt_take_effect(Date gmt_take_effect) {
        this.gmt_take_effect = gmt_take_effect;
    }

    public Date getGmt_lose_effect() {
        return gmt_lose_effect;
    }

    public void setGmt_lose_effect(Date gmt_lose_effect) {
        this.gmt_lose_effect = gmt_lose_effect;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user_id=").append(user_id);
        sb.append(", plate=").append(plate);
        sb.append(", membership_card_id=").append(membership_card_id);
        sb.append(", status=").append(status);
        sb.append(", gmt_bind=").append(gmt_bind);
        sb.append(", gmt_activate=").append(gmt_activate);
        sb.append(", gmt_take_effect=").append(gmt_take_effect);
        sb.append(", gmt_lose_effect=").append(gmt_lose_effect);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}