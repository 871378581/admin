package com.segama.ege.domain;

public enum KeywordTypeEnum {
    //门店列表，订单列表。搜索的关键字名称是门店名称、机油品牌名称、车牌号码、车型
    shop_name("1","根据门店名称进行关键字搜索"),
    oil_brand_name("2","根据机油品牌进行关键字搜索"),
    plate("3","根据车牌号码进行关键字搜索"),
    car_type("4","根据车型进行关键字搜索")
    ;
    private String code;
    private String desc;

    public static KeywordTypeEnum parse(String code){
        for (KeywordTypeEnum typeEnum : KeywordTypeEnum.values()) {
            if(typeEnum.getCode().equals(code)){
                return typeEnum;
            }
        }
        return null;
    }

    KeywordTypeEnum(String code, String desc) {
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