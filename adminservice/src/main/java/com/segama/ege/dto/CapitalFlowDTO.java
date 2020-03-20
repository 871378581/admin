package com.segama.ege.dto;

public class CapitalFlowDTO {

    private String account;//提现用：提现人门店登录账号

    private String real_name;//提现用：提现人真实姓名

    private String amount;//本次操作的金额 收款金额 或 冻结金额 或 提现金额 。。。

    private String description;//描述

    private String order_string_id;//收款：订单stringid

    /**必填
     * @see com.segama.ege.domain.CapitalFlowTypeEnum
     */
    private Long operate_type;//操作类型

    private Long order_id; //收款：订单id

    private Long verify_id;//提现用：申请id

    private static final long serialVersionUID = 1L;

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

}