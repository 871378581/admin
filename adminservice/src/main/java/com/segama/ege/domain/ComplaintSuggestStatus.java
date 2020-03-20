package com.segama.ege.domain;
public enum ComplaintSuggestStatus {
    //投诉建议处理的状态
    not_read("0","未阅"),
    have_read("1","已阅"),
    have_reply("2","已答复"),
    have_solved("3","已解决"),
    ;
    private String code;
    private String desc;

    public static ComplaintSuggestStatus parse(String code){
        for (ComplaintSuggestStatus suggestStatus : ComplaintSuggestStatus.values()) {
            if(suggestStatus.getCode().equals(code)){
                return suggestStatus;
            }
        }
        return null;
    }

    ComplaintSuggestStatus(String code, String desc) {
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
