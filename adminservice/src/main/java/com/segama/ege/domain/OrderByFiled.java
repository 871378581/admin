package com.segama.ege.domain;

public enum OrderByFiled {
    //查询门店信息排序字段
    distance_near("1","距离从近到远"),
    distance_far("2","距离从远到近"),
    high_score("3","好评得分从高到低"),
    low_score("4","好评得分从低到高")
    ;
    private String code;
    private String desc;

    public static OrderByFiled parse(String code){
        for (OrderByFiled orderByFiled : OrderByFiled.values()) {
            if(orderByFiled.getCode().equals(code)){
                return orderByFiled;
            }
        }
        return null;
    }

    OrderByFiled(String code, String desc) {
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