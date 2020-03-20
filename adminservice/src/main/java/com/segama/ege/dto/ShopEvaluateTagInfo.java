package com.segama.ege.dto;

public class ShopEvaluateTagInfo {
    private String tag;//评价标签
    private double score;//评价得分
    private int count;//评价此标签的总人次

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
