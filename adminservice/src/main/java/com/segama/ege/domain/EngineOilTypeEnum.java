package com.segama.ege.domain;

public enum EngineOilTypeEnum {
    //机油类型，平台上的机油or门店里的机油
    platform("1","平台"),
    shop("2","门店")
    ;
    private String code;
    private String desc;

    public static EngineOilTypeEnum parse(String code){
        for (EngineOilTypeEnum oilTypeEnum : EngineOilTypeEnum.values()) {
            if(oilTypeEnum.getCode().equals(code)){
                return oilTypeEnum;
            }
        }
        return null;
    }

    EngineOilTypeEnum(String code, String desc) {
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
