package com.segama.ege.dto;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.entity.OrderFeeDetail;
import com.segama.ege.entity.Pay;
import com.segama.ege.entity.ServiceOrder;

import java.util.ArrayList;
import java.util.List;

public class PayFeeDetailDTO {
    private Long order_id;//id

    private String order_string_id;//订单编号

    private Long pay_id;

    private String pay_status;

    private String before_discount_fee;

    private List<String> coupon_ids;

    private String discount_fee;

    private String final_fee;

    private String pay_mode;

    private String gmt_pay_create;

    private String gmt_pay_finish;

    private List<OrderFeeDetailDTO> feeDetailList;

    public void addOrderFeeDetail(OrderFeeDetail orderFeeDetail){
        if(this.feeDetailList == null){
            this.feeDetailList = new ArrayList<OrderFeeDetailDTO>();
        }
        this.feeDetailList.add(OrderFeeDetailDTO.build(orderFeeDetail));
    }

    public void addOrderFeeDetails(List<OrderFeeDetail> orderFeeDetails){
        if(this.feeDetailList == null){
            this.feeDetailList = new ArrayList<OrderFeeDetailDTO>();
        }
        for(int i = 0; i < orderFeeDetails.size(); ++i){
            this.feeDetailList.add(OrderFeeDetailDTO.build(orderFeeDetails.get(i)));
        }
    }

    public void addOrderFeeDetail(OrderFeeDetailDTO dto){
        if(this.feeDetailList == null){
            this.feeDetailList = new ArrayList<OrderFeeDetailDTO>();
        }
        this.feeDetailList.add(dto);
    }

    public Long getPay_id() {
        return pay_id;
    }

    public void setPay_id(Long pay_id) {
        this.pay_id = pay_id;
    }

    public List<OrderFeeDetailDTO> getFeeDetailList() {
        return feeDetailList;
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

    public String getPay_status() {
        return pay_status;
    }

    public void setPay_status(String pay_status) {
        this.pay_status = pay_status;
    }

    public String getBefore_discount_fee() {
        return before_discount_fee;
    }

    public void setBefore_discount_fee(String before_discount_fee) {
        this.before_discount_fee = before_discount_fee;
    }

    public List<String> getCoupon_ids() {
        return coupon_ids;
    }

    public void setCoupon_ids(List<String> coupon_ids) {
        this.coupon_ids = coupon_ids;
    }

    public String getDiscount_fee() {
        return discount_fee;
    }

    public void setDiscount_fee(String discount_fee) {
        this.discount_fee = discount_fee;
    }

    public String getPay_mode() {
        return pay_mode;
    }

    public void setPay_mode(String pay_mode) {
        this.pay_mode = pay_mode;
    }

    public String getGmt_pay_create() {
        return gmt_pay_create;
    }

    public void setGmt_pay_create(String gmt_pay_create) {
        this.gmt_pay_create = gmt_pay_create;
    }

    public String getGmt_pay_finish() {
        return gmt_pay_finish;
    }

    public void setGmt_pay_finish(String gmt_pay_finish) {
        this.gmt_pay_finish = gmt_pay_finish;
    }

    public String getFinal_fee() {
        return final_fee;
    }

    public void setFinal_fee(String final_fee) {
        this.final_fee = final_fee;
    }

    public PayFeeDetailDTO(){
        this.feeDetailList = new ArrayList<OrderFeeDetailDTO>();
    }
    public static PayFeeDetailDTO build(ServiceOrder order, Pay pay){
        PayFeeDetailDTO dto = new PayFeeDetailDTO();
        dto.setOrder_id(order.getId());
        dto.setPay_id(pay.getId());
        dto.setOrder_string_id(order.getOrder_string_id());
        dto.setDiscount_fee(pay.getDiscount_fee());
        dto.setBefore_discount_fee(pay.getBefore_discount_fee());
        dto.setFinal_fee(pay.getFinal_fee());
        List<String> coupon_ids = new ArrayList<String>();
        coupon_ids.add(pay.getCoupon_ids());
        dto.setCoupon_ids(coupon_ids);
        dto.setPay_mode(pay.getPay_mode());
        dto.setPay_status(pay.getPay_status());
        dto.setGmt_pay_create(DateUtil.parse(pay.getGmt_pay_create()));
        dto.setGmt_pay_finish(DateUtil.parse(pay.getGmt_pay_finish()));
        return dto;
    }
}
