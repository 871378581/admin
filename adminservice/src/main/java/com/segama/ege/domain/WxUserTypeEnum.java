package com.segama.ege.domain;

/**
 * 用户类型
 */
public enum WxUserTypeEnum {
    //支付状态
    normal(0, "正常用户"),
    black_list(1, "黑名单用户");

    private Integer code;
    private String desc;

    WxUserTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}