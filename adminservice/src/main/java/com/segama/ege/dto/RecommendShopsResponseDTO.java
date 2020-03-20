package com.segama.ege.dto;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class RecommendShopsResponseDTO {

    private long id;//shop_id

    private String enterprise_name;

    private long distance;

    private String service;

    private String score;

    private String address;

    private String door_img_url;

    private String logo_img_url;

    private String small_img_url;

    private String business_hour_start;

    private String business_hour_end;

    private String gmt_recommend;

    public String getLogo_img_url() {
        return logo_img_url;
    }

    public String getSmall_img_url() {
        return small_img_url;
    }

    public void setSmall_img_url(String small_img_url) {
        this.small_img_url = small_img_url;
    }

    public void setLogo_img_url(String logo_img_url) {
        this.logo_img_url = logo_img_url;
    }

    public String getBusiness_hour_start() {
        return business_hour_start;
    }

    public void setBusiness_hour_start(String business_hour_start) {
        this.business_hour_start = business_hour_start;
    }

    public String getBusiness_hour_end() {
        return business_hour_end;
    }

    public void setBusiness_hour_end(String business_hour_end) {
        this.business_hour_end = business_hour_end;
    }

    public String getDoor_img_url() {
        return door_img_url;
    }

    public void setDoor_img_url(String door_img_url) {
        this.door_img_url = door_img_url;
    }

    private List<ShopEvaluateTagInfo> tagInfoList;

    private boolean is_order;//是否可以预约

    public RecommendShopsResponseDTO(){
        if (CollectionUtils.isEmpty(tagInfoList)) {
            tagInfoList = new ArrayList<ShopEvaluateTagInfo>();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ShopEvaluateTagInfo> getTagInfoList() {
        return tagInfoList;
    }

    public void addShopEvaluateTagInfo(ShopEvaluateTagInfo info){
        this.tagInfoList.add(info);
    }

    public boolean isIs_order() {
        return is_order;
    }

    public void setIs_order(boolean is_order) {
        this.is_order = is_order;
    }

    public String getGmt_recommend() {
        return gmt_recommend;
    }

    public void setGmt_recommend(String gmt_recommend) {
        this.gmt_recommend = gmt_recommend;
    }
}
