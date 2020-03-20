package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class VerifyCommitRecord implements Serializable {
    private Long id;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String verify_account;

    private Long shop_id;

    private String shop_name;

    private Integer operate_type;

    private Integer status;

    private String remark;

    private String payment_voucher;

    private String amount;

    private String target_json;

    private String change_json;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getVerify_account() {
        return verify_account;
    }

    public void setVerify_account(String verify_account) {
        this.verify_account = verify_account == null ? null : verify_account.trim();
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

    public Integer getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(Integer operate_type) {
        this.operate_type = operate_type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPayment_voucher() {
        return payment_voucher;
    }

    public void setPayment_voucher(String payment_voucher) {
        this.payment_voucher = payment_voucher == null ? null : payment_voucher.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getTarget_json() {
        return target_json;
    }

    public void setTarget_json(String target_json) {
        this.target_json = target_json == null ? null : target_json.trim();
    }

    public String getChange_json() {
        return change_json;
    }

    public void setChange_json(String change_json) {
        this.change_json = change_json == null ? null : change_json.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", verify_account=").append(verify_account);
        sb.append(", shop_id=").append(shop_id);
        sb.append(", shop_name=").append(shop_name);
        sb.append(", operate_type=").append(operate_type);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", payment_voucher=").append(payment_voucher);
        sb.append(", amount=").append(amount);
        sb.append(", target_json=").append(target_json);
        sb.append(", change_json=").append(change_json);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}