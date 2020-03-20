package com.segama.ege.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.entity.Shop;
import com.segama.ege.entity.ShopCollection;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopCollectionResponseDTO {
    private Long id;

    private String user_id;

    private Long shop_id;

    private String gmt_collect;

    private String enterprise_name;

    private String door_img_url;

    private String small_img_url;

    private String service;

    private Boolean status;

    private String address;

    private String score;

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

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public String getDoor_img_url() {
        return door_img_url;
    }

    public void setDoor_img_url(String door_img_url) {
        this.door_img_url = door_img_url;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmt_collect() {
        return gmt_collect;
    }

    public void setGmt_collect(String gmt_collect) {
        this.gmt_collect = gmt_collect;
    }

    public String getScore() {
        return score;
    }

    public String getSmall_img_url() {
        return small_img_url;
    }

    public void setSmall_img_url(String small_img_url) {
        this.small_img_url = small_img_url;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public static ShopCollectionResponseDTO buildOrigin(ShopCollection shopCollection,
                                                        Shop shop) {
        ShopCollectionResponseDTO dto = new ShopCollectionResponseDTO();
        dto.setAddress(shop.getAddress());
        dto.setDoor_img_url(shop.getDoor_img_url());
        dto.setEnterprise_name(shop.getEnterprise_name());
        dto.setId(shopCollection.getId());
        dto.setScore(shop.getScore());
        dto.setService(shop.getService());
        dto.setStatus(shopCollection.getStatus());
        dto.setUser_id(shopCollection.getUser_id());
        dto.setShop_id(shopCollection.getShop_id());
        dto.setGmt_collect(DateUtil.parse(shopCollection.getGmt_collect()));
        dto.setSmall_img_url(shop.getSmall_img_url());
        return dto;
    }

}
