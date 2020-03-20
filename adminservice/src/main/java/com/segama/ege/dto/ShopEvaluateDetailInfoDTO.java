package com.segama.ege.dto;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.entity.ShopEvaluateDetail;

public class ShopEvaluateDetailInfoDTO {
    private Long id;

    private String user_id;

    private String nick_name;

    private String user_head;

    private String car_type;

    private String gmt_repair;

    private String evaluate_score;

    private String evaluate_content;

    private String gmt_evaluate_commit;

    private Boolean is_invalid;

    private Long shop_id;

    public String getUser_head() {
        return user_head;
    }

    public void setUser_head(String user_head) {
        this.user_head = user_head;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getGmt_repair() {
        return gmt_repair;
    }

    public void setGmt_repair(String gmt_repair) {
        this.gmt_repair = gmt_repair;
    }

    public String getEvaluate_score() {
        return evaluate_score;
    }

    public void setEvaluate_score(String evaluate_score) {
        this.evaluate_score = evaluate_score;
    }

    public String getEvaluate_content() {
        return evaluate_content;
    }

    public void setEvaluate_content(String evaluate_content) {
        this.evaluate_content = evaluate_content;
    }

    public String getGmt_evaluate_commit() {
        return gmt_evaluate_commit;
    }

    public void setGmt_evaluate_commit(String gmt_evaluate_commit) {
        this.gmt_evaluate_commit = gmt_evaluate_commit;
    }

    public Boolean getIs_invalid() {
        return is_invalid;
    }

    public void setIs_invalid(Boolean is_invalid) {
        this.is_invalid = is_invalid;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public static ShopEvaluateDetailInfoDTO build(ShopEvaluateDetail detail){
        ShopEvaluateDetailInfoDTO dto = new ShopEvaluateDetailInfoDTO();
        dto.setCar_type(detail.getCar_type());
        dto.setEvaluate_content(detail.getEvaluate_content());
        dto.setEvaluate_score(detail.getEvaluate_score());
        dto.setGmt_evaluate_commit(DateUtil.parse(detail.getGmt_evaluate_commit()));
        dto.setGmt_repair(DateUtil.parse(detail.getGmt_repair()));
        dto.setId(detail.getId());
        dto.setShop_id(detail.getShop_id());
        dto.setUser_id(detail.getUser_id());
        dto.setNick_name(detail.getNick_name());
        dto.setIs_invalid(detail.getIs_invalid());
        dto.setUser_head(detail.getUser_head());
        return dto;
    }
}
