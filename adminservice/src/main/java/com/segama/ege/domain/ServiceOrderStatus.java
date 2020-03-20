package com.segama.ege.domain;

import org.apache.commons.lang3.StringUtils;

public enum ServiceOrderStatus {
    //订单的主状态，放在order_status字段。
    ordering("A", "预约中", true, false),//主状态1
    servicing("B", "服务中", false, true),//主状态2
    to_pay("C", "订单费用明细已产生,车主待支付", false, true),//主状态3
    no_pay_and_to_evaluate("D", "订单无需支付,车主待评价", false, false),//主状态4
    to_evaluate("U", "车主待评价", false, false),//主状态5
    finish("E", "已完成", false, false),//主状态6
    cancle("I", "已取消", false, false),//主状态7
    //仅现金支付的时候，才需要门店确认已收款
    shop_to_confirm_have_pay("W", "订单支付完成,门店待确认", false, false),//主状态7


    //以下为子状态，放在child_status字段。
    order_submit("F", "预约已提交", true, false),//主A
    order_succeed("G", "预约成功", true, false),//主A
    order_modify("H", "门店已修改预约时间,车主待确认", true, false),//主A
    order_cancel("I", "预约取消", false, false),//主I
    order_taking("J", "扫码确认订单、会员身份、验证服务资格", true, false),//主B
    upkeep_servicing("K", "开始标准化保养服务", false, true),//主B
    report_generating("L", "保养服务结束,生成检测报告", false, false),//主B
    report_no_exception("M", "保养服务检测无异常", false, false),//主B
    report_have_exception("N", "保养服务检测有异常", false, true),//主B和C
    value_added_services_mend_to_confirm("P", "增值服务待确认", false, true),//主B
    value_added_services_mending("Q", "增值服务处理中", false, true),//主B
    value_added_services_mend_finish("R", "增值服务维修完成", false, true),//主B
    exception_ignore("S", "检测异常已忽略", false, false),//主B
    value_added_services_mend_pass("T", "增值服务检测通过", false, true),//主B
    order_fail("V", "预约失败", false, false),//主A
    pay_fail("X", "付款失败", false, false);//主C和W

    private String code;
    private String desc;
    private boolean allow_cancel;
    private boolean allowEditReport;

    public static ServiceOrderStatus parseFromCode(String code){
        if(StringUtils.isBlank(code)){
            return ServiceOrderStatus.cancle;
        }
        ServiceOrderStatus[] values = ServiceOrderStatus.values();
        for (ServiceOrderStatus value : values) {
            if(value.getCode().equals(code)){
                return value;
            }
        }
        return ServiceOrderStatus.cancle;
    }

    public boolean isAllow_cancel() {
        return allow_cancel;
    }

    public void setAllow_cancel(boolean allow_cancel) {
        this.allow_cancel = allow_cancel;
    }

    public static ServiceOrderStatus parse(String code) {
        for (ServiceOrderStatus status : ServiceOrderStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

    ServiceOrderStatus(String code, String desc, boolean allow_cancel, boolean allowEditReport) {
        this.code = code;
        this.desc = desc;
        this.allow_cancel = allow_cancel;
        this.allowEditReport = allowEditReport;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isAllowEditReport() {
        return allowEditReport;
    }

    public void setAllowEditReport(boolean allowEditReport) {
        this.allowEditReport = allowEditReport;
    }
}

