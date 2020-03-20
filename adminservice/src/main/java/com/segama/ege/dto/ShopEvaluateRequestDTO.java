package com.segama.ege.dto;

public class ShopEvaluateRequestDTO {
    private String user_id;

    private long order_id;

    private String evaluate_content;

    private String evaluate_score;

    private String evaluate_tags;

    public String getEvaluate_tags() {
        return evaluate_tags;
    }

    public void setEvaluate_tags(String evaluate_tags) {
        this.evaluate_tags = evaluate_tags;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getEvaluate_content() {
        return evaluate_content;
    }

    public void setEvaluate_content(String evaluate_content) {
        this.evaluate_content = evaluate_content;
    }

    public String getEvaluate_score() {
        return evaluate_score;
    }

    public void setEvaluate_score(String evaluate_score) {
        this.evaluate_score = evaluate_score;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
