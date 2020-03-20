package com.segama.ege.domain;

public enum MemberCardTakeEffectEnum {
    //会员卡生效模式
    effect_after_x_days("1","激活后多少天生效"),
    effect_by_appointed("2","指定日期生效")
    ;
    private String code;
    private String desc;

    public static MemberCardTakeEffectEnum parse(String code){
        for (MemberCardTakeEffectEnum takeEffectEnum : MemberCardTakeEffectEnum.values()) {
            if(takeEffectEnum.getCode().equals(code)){
                return takeEffectEnum;
            }
        }
        return null;
    }

    MemberCardTakeEffectEnum(String code, String desc) {
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
