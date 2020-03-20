package com.segama.ege.dto;

public class OrderFeeDetailRequestDTO {
    private String each_item;

    private String each_fee;

    public String getEach_item() {
        return each_item;
    }

    public void setEach_item(String each_item) {
        this.each_item = each_item;
    }

    public String getEach_fee() {
        return each_fee;
    }

    public void setEach_fee(String each_fee) {
        this.each_fee = each_fee;
    }

    public OrderFeeDetailRequestDTO(String each_item, String each_fee){
        this.each_item = each_item;
        this.each_fee = each_fee;
    }
}
