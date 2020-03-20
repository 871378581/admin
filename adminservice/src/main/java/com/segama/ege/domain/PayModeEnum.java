package com.segama.ege.domain;

public enum PayModeEnum {
    //支付渠道
    pay_by_wechat("1", "微信支付"),
    pay_by_other("2", "其他支付");
    private String code;
    private String desc;

    public static PayModeEnum parse(String code) {
        for (PayModeEnum modeEnum : PayModeEnum.values()) {
            if (modeEnum.getCode().equals(code)) {
                return modeEnum;
            }
        }
        return null;
    }

    PayModeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
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
}