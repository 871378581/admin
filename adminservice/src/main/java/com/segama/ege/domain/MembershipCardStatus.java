package com.segama.ege.domain;

public enum MembershipCardStatus {
    //会员卡状态
    not_make("0","未制卡"),
    card_making("1","制卡中"),
    have_maked("2","制卡完成"),
    activated("3","卡已激活"),
    take_effect("4","卡已生效"),
    expired("5","卡已失效")
    ;
    private String code;
    private String desc;

    public static MembershipCardStatus parse(String code){
        for (MembershipCardStatus cardStatus : MembershipCardStatus.values()) {
            if(cardStatus.getCode().equals(code)){
                return cardStatus;
            }
        }
        return MembershipCardStatus.not_make;
    }

    MembershipCardStatus(String code, String desc) {
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
