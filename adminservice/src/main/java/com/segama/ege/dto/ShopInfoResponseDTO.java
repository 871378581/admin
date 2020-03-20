package com.segama.ege.dto;
import com.segama.ege.entity.Shop;
import com.segama.ege.admin.utils.DateUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ShopInfoResponseDTO extends BasePageDTO {
    private Long id;

    private String enterprise_name;

    private String person_liable_name;

    private String phone;

    private String mobile;

    private String address;

    private String business_license_img_url;

    private String door_img_url;

    private String logo_img_url;

    private String small_img_url;

    private String introduce;

    private String service;

    private String score;

    private Boolean is_disable;

    private Long workstation_num;

    private String business_hour_start;

    private String business_hour_end;

    private double longitude;

    private double latitude;

    private Boolean is_recommend;

    private String gmt_recommend;

    private boolean is_collected = false;

    private double distance = 0.0D;

    public List<OilInfoResponseDTO> getOils() {
        return oils;
    }

    private List<OilInfoResponseDTO> oils;

    public void addOil(OilInfoResponseDTO oil){
        this.oils.add(oil);
    }

    public List<ShopEvaluateTagInfo> getTagInfoList() {
        return tagInfoList;
    }

    public void addShopEvaluateTagInfo(ShopEvaluateTagInfo tagInfo){
        this.tagInfoList.add(tagInfo);
    }

    public void addShopEvaluateDetailInfo(ShopEvaluateDetailInfoDTO detailInfo){
        this.evaluateDetailInfos.add(detailInfo);
    }

    private List<ShopEvaluateTagInfo> tagInfoList;

    public List<ShopEvaluateDetailInfoDTO> getEvaluateDetailInfos() {
        return evaluateDetailInfos;
    }

    private List<ShopEvaluateDetailInfoDTO> evaluateDetailInfos;

    public int getEvaluate_count() {
        return evaluate_count;
    }

    public void setEvaluate_count(int evaluate_count) {
        this.evaluate_count = evaluate_count;
    }

    private int evaluate_count = 0 ;

    public ShopInfoResponseDTO(){
        if (CollectionUtils.isEmpty(oils)) {
            this.oils = new ArrayList<OilInfoResponseDTO>();
        }
        if (CollectionUtils.isEmpty(tagInfoList)) {
            tagInfoList = new ArrayList<ShopEvaluateTagInfo>();
        }

        if (CollectionUtils.isEmpty(evaluateDetailInfos)) {
            evaluateDetailInfos = new ArrayList<ShopEvaluateDetailInfoDTO>();
        }
    }

    public boolean isIs_collected() {
        return is_collected;
    }

    public void setIs_collected(boolean is_collected) {
        this.is_collected = is_collected;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public String getPerson_liable_name() {
        return person_liable_name;
    }

    public void setPerson_liable_name(String person_liable_name) {
        this.person_liable_name = person_liable_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusiness_license_img_url() {
        return business_license_img_url;
    }

    public void setBusiness_license_img_url(String business_license_img_url) {
        this.business_license_img_url = business_license_img_url;
    }

    public String getDoor_img_url() {
        return door_img_url;
    }

    public void setDoor_img_url(String door_img_url) {
        this.door_img_url = door_img_url;
    }

    public String getLogo_img_url() {
        return logo_img_url;
    }

    public void setLogo_img_url(String logo_img_url) {
        this.logo_img_url = logo_img_url;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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

    public Boolean getIs_disable() {
        return is_disable;
    }

    public void setIs_disable(Boolean is_disable) {
        this.is_disable = is_disable;
    }

    public Long getWorkstation_num() {
        return workstation_num;
    }

    public void setWorkstation_num(Long workstation_num) {
        this.workstation_num = workstation_num;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Boolean getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(Boolean is_recommend) {
        this.is_recommend = is_recommend;
    }

    public String getGmt_recommend() {
        return gmt_recommend;
    }

    public void setGmt_recommend(String gmt_recommend) {
        this.gmt_recommend = gmt_recommend;
    }

    public String getSmall_img_url() {
        return small_img_url;
    }

    public void setSmall_img_url(String small_img_url) {
        this.small_img_url = small_img_url;
    }

    public ShopInfoResponseDTO(Shop myShop){
        this.address = myShop.getAddress();
        this.business_license_img_url = myShop.getBusiness_license_img_url();
        this.door_img_url = myShop.getDoor_img_url();
        this.small_img_url = myShop.getSmall_img_url();
        this.enterprise_name = myShop.getEnterprise_name();
        this.id = myShop.getId();
        this.introduce = myShop.getIntroduce();
        this.is_disable = myShop.getIs_disable();
        this.latitude = myShop.getLatitude().doubleValue();
        this.longitude = myShop.getLongitude().doubleValue();
        this.is_recommend = myShop.getIs_recommend();
        this.mobile = myShop.getMobile();
        this.phone = myShop.getPhone();
        this.person_liable_name = myShop.getPerson_liable_name();
        this.gmt_recommend = DateUtil.parse(myShop.getGmt_recommend());
        this.business_hour_end = myShop.getBusiness_hour_end();
        this.business_hour_start = myShop.getBusiness_hour_start();
        this.workstation_num = myShop.getWorkstation_num();
        this.logo_img_url = myShop.getLogo_img_url();
        this.score = myShop.getScore();
        this.service = myShop.getService();

        if (CollectionUtils.isEmpty(oils)) {
            this.oils = new ArrayList<OilInfoResponseDTO>();
        }
        if (CollectionUtils.isEmpty(tagInfoList)) {
            tagInfoList = new ArrayList<ShopEvaluateTagInfo>();
        }

        if (CollectionUtils.isEmpty(evaluateDetailInfos)) {
            evaluateDetailInfos = new ArrayList<ShopEvaluateDetailInfoDTO>();
        }
    }
}
