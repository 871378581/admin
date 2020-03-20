package com.segama.ege.domain;

import org.apache.commons.lang3.StringUtils;

public enum PayStatusEnum {
    //支付状态
    not_pay("0", "未支付"),
    fail("1", "支付失败"),
    succeed("2", "支付成功"),
    to_be_confirm_by_shop("3", "车主已支付待门店确认"),;
    private String code;
    private String desc;

    public static PayStatusEnum parse(String code) {
        if(StringUtils.isBlank(code)){
            return PayStatusEnum.not_pay;
        }
        for (PayStatusEnum statusEnum : PayStatusEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
            }
        }
        return PayStatusEnum.not_pay;
    }

    PayStatusEnum(String code, String desc) {
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