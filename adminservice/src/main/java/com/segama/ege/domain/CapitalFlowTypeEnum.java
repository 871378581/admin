package com.segama.ege.domain;

/**
 * 资金流水操作类型
 */
public enum CapitalFlowTypeEnum {
    //车的状态
    cashout(0L, "提现"),
    wx_collect(1L, "微信收款"),
    other_collect(1L, "其它收款"),
    freezing(2L, "冻结");

    private Long code;
    private String desc;

    CapitalFlowTypeEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
