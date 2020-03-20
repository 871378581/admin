package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class CapitalAccount implements Serializable {
    private Long id;

    private String account_no;

    private String account_type;

    private String total_amount;

    private String freezing_amount;

    private String available_amount;

    private String mac;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String opening_bank;

    private String bank_card_num;

    private String payee;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no == null ? null : account_no.trim();
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type == null ? null : account_type.trim();
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount == null ? null : total_amount.trim();
    }

    public String getFreezing_amount() {
        return freezing_amount;
    }

    public void setFreezing_amount(String freezing_amount) {
        this.freezing_amount = freezing_amount == null ? null : freezing_amount.trim();
    }

    public String getAvailable_amount() {
        return available_amount;
    }

    public void setAvailable_amount(String available_amount) {
        this.available_amount = available_amount == null ? null : available_amount.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
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

    public String getOpening_bank() {
        return opening_bank;
    }

    public void setOpening_bank(String opening_bank) {
        this.opening_bank = opening_bank == null ? null : opening_bank.trim();
    }

    public String getBank_card_num() {
        return bank_card_num;
    }

    public void setBank_card_num(String bank_card_num) {
        this.bank_card_num = bank_card_num == null ? null : bank_card_num.trim();
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee == null ? null : payee.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account_no=").append(account_no);
        sb.append(", account_type=").append(account_type);
        sb.append(", total_amount=").append(total_amount);
        sb.append(", freezing_amount=").append(freezing_amount);
        sb.append(", available_amount=").append(available_amount);
        sb.append(", mac=").append(mac);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", opening_bank=").append(opening_bank);
        sb.append(", bank_card_num=").append(bank_card_num);
        sb.append(", payee=").append(payee);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}