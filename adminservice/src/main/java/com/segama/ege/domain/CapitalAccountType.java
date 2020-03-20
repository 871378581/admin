package com.segama.ege.domain;

public enum CapitalAccountType {
    //虚拟资金账户类型
    shop_capital_account("1", "门店资金账户"),
    car_user_capital_account("2", "车主资金账户");
    private String code;
    private String desc;

    public static CapitalAccountType parse(String code) {
        for (CapitalAccountType type : CapitalAccountType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    CapitalAccountType(String code, String desc) {
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