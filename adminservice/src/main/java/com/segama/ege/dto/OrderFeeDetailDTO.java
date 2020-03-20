package com.segama.ege.dto;

import com.segama.ege.entity.OrderFeeDetail;

public class OrderFeeDetailDTO {
    private Long id;

    private Long order_id;

    private Long pay_id;

    private String order_string_id;

    private Long each_item_id;

    private String each_item;

    private String each_fee;

    public Long getPay_id() {
        return pay_id;
    }

    public void setPay_id(Long pay_id) {
        this.pay_id = pay_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOrder_string_id() {
        return order_string_id;
    }

    public void setOrder_string_id(String order_string_id) {
        this.order_string_id = order_string_id;
    }

    public Long getEach_item_id() {
        return each_item_id;
    }

    public void setEach_item_id(Long each_item_id) {
        this.each_item_id = each_item_id;
    }

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

    public static OrderFeeDetailDTO build(OrderFeeDetail detail){
        OrderFeeDetailDTO dto = new OrderFeeDetailDTO();
        dto.setEach_fee(detail.getEach_fee());
        dto.setEach_item(detail.getEach_item());
        dto.setEach_item_id(detail.getEach_item_id());
        dto.setId(detail.getId());
        dto.setOrder_string_id(detail.getOrder_string_id());
        dto.setOrder_id(detail.getOrder_id());
        dto.setPay_id(detail.getPay_id());
        return dto;
    }
}
