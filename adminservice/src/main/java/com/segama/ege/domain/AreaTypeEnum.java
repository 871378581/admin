package com.segama.ege.domain;

public enum AreaTypeEnum {
    //省区市类型
    province("0","省"),
    city("1","地级市"),
    district("2","区县"),
    ;
    private String code;
    private String desc;

    public static AreaTypeEnum parse(String code){
        for (AreaTypeEnum areaTypeEnum : AreaTypeEnum.values()) {
            if(areaTypeEnum.getCode().equals(code)){
                return areaTypeEnum;
            }
        }
        return null;
    }

    AreaTypeEnum(String code, String desc) {
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
