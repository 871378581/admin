package com.segama.ege.domain;

public enum BusinessCooperateApplyStatus {
    //商务合作申请处理状态
    not_read("0","未阅"),
    have_read("1","已阅"),
    have_reply("2","已答复"),
    ;
    private String code;
    private String desc;

    public static BusinessCooperateApplyStatus parse(String code){
        for (BusinessCooperateApplyStatus applyStatus : BusinessCooperateApplyStatus.values()) {
            if(applyStatus.getCode().equals(code)){
                return applyStatus;
            }
        }
        return null;
    }

    BusinessCooperateApplyStatus(String code, String desc) {
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
