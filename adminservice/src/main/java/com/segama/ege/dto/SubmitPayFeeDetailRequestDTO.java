package com.segama.ege.dto;

import java.util.ArrayList;
import java.util.List;

public class SubmitPayFeeDetailRequestDTO {
    private Long order_id;//id

    private Long shop_user_id;

    private List<OrderFeeDetailRequestDTO> feeDetails;

    public SubmitPayFeeDetailRequestDTO(){
        if(this.feeDetails == null){
            this.feeDetails = new ArrayList<OrderFeeDetailRequestDTO>();
        }
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getShop_user_id() {
        return shop_user_id;
    }

    public void setShop_user_id(Long shop_user_id) {
        this.shop_user_id = shop_user_id;
    }

    public void addOrderFeeDetail(String each_item, String each_fee){
        if(this.feeDetails == null){
            this.feeDetails = new ArrayList<OrderFeeDetailRequestDTO>();
        }
        this.feeDetails.add(new OrderFeeDetailRequestDTO(each_item, each_fee));
    }

    public List<OrderFeeDetailRequestDTO> getFeeDetails() {
        return feeDetails;
    }
}
