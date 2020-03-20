package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class CapitalFlow implements Serializable {
    private Long id;

    private Long shop_id;

    private String account;

    private String real_name;

    private String amount;

    private String description;

    private String order_string_id;

    private String bank_card_num;

    private String payee;

    private String opening_bank;

    private Long operate_type;

    private Long order_id;

    private Long verify_id;

    private Date gmt_create;

    private String total_amount;

    private String freezing_amount;

    private String available_amount;

    private String shop_name;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name == null ? null : real_name.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getOrder_string_id() {
        return order_string_id;
    }

    public void setOrder_string_id(String order_string_id) {
        this.order_string_id = order_string_id == null ? null : order_string_id.trim();
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

    public String getOpening_bank() {
        return opening_bank;
    }

    public void setOpening_bank(String opening_bank) {
        this.opening_bank = opening_bank == null ? null : opening_bank.trim();
    }

    public Long getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(Long operate_type) {
        this.operate_type = operate_type;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getVerify_id() {
        return verify_id;
    }

    public void setVerify_id(Long verify_id) {
        this.verify_id = verify_id;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
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

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name == null ? null : shop_name.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shop_id=").append(shop_id);
        sb.append(", account=").append(account);
        sb.append(", real_name=").append(real_name);
        sb.append(", amount=").append(amount);
        sb.append(", description=").append(description);
        sb.append(", order_string_id=").append(order_string_id);
        sb.append(", bank_card_num=").append(bank_card_num);
        sb.append(", payee=").append(payee);
        sb.append(", opening_bank=").append(opening_bank);
        sb.append(", operate_type=").append(operate_type);
        sb.append(", order_id=").append(order_id);
        sb.append(", verify_id=").append(verify_id);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", total_amount=").append(total_amount);
        sb.append(", freezing_amount=").append(freezing_amount);
        sb.append(", available_amount=").append(available_amount);
        sb.append(", shop_name=").append(shop_name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}