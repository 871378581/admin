package com.segama.ege.domain;

public enum MembershipLevel {
    //会员卡等级
    common_card("0","普通会员"),
    silver_card("1","银卡会员-4缸车"),
    golden_member("2","金卡会员-6缸车"),
    black_member("3","黑卡会员-8缸车"),
    ;
    private String code;
    private String desc;

    public static MembershipLevel parse(String code){
        for (MembershipLevel membershipLevel : MembershipLevel.values()) {
            if(membershipLevel.getCode().equals(code)){
                return membershipLevel;
            }
        }
        return null;
    }

    MembershipLevel(String code, String desc) {
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
