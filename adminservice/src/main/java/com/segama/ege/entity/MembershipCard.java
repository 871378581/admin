package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class MembershipCard implements Serializable {
    private Long id;

    private String card_id;

    private String password;

    private String batch_num;

    private String status;

    private Integer effective_days;

    private Date effective_date;

    private Date expire_date;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String take_effect_type;

    private String card_level;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id == null ? null : card_id.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getBatch_num() {
        return batch_num;
    }

    public void setBatch_num(String batch_num) {
        this.batch_num = batch_num == null ? null : batch_num.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getEffective_days() {
        return effective_days;
    }

    public void setEffective_days(Integer effective_days) {
        this.effective_days = effective_days;
    }

    public Date getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(Date effective_date) {
        this.effective_date = effective_date;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
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

    public String getTake_effect_type() {
        return take_effect_type;
    }

    public void setTake_effect_type(String take_effect_type) {
        this.take_effect_type = take_effect_type == null ? null : take_effect_type.trim();
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
        sb.append(", card_id=").append(card_id);
        sb.append(", password=").append(password);
        sb.append(", batch_num=").append(batch_num);
        sb.append(", status=").append(status);
        sb.append(", effective_days=").append(effective_days);
        sb.append(", effective_date=").append(effective_date);
        sb.append(", expire_date=").append(expire_date);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", take_effect_type=").append(take_effect_type);
        sb.append(", card_level=").append(card_level);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}