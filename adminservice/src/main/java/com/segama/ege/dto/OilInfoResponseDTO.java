package com.segama.ege.dto;

import com.segama.ege.entity.EngineOil;

public class OilInfoResponseDTO {
    private String photo_url;

    private long oil_id;

    private String oil_type;

    private String market_price_min;

    private String market_price_max;

    private String brand_name;

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public long getOil_id() {
        return oil_id;
    }

    public void setOil_id(long oil_id) {
        this.oil_id = oil_id;
    }

    public String getMarket_price_min() {
        return market_price_min;
    }

    public void setMarket_price_min(String market_price_min) {
        this.market_price_min = market_price_min;
    }

    public String getMarket_price_max() {
        return market_price_max;
    }

    public void setMarket_price_max(String market_price_max) {
        this.market_price_max = market_price_max;
    }

    private String member_price;

    public String getMember_price() {
        return member_price;
    }

    public void setMember_price(String member_price) {
        this.member_price = member_price;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getOil_type() {
        return oil_type;
    }

    public void setOil_type(String oil_type) {
        this.oil_type = oil_type;
    }

    public OilInfoResponseDTO(EngineOil oil){
        this.brand_name = oil.getBrand_name();
        this.oil_id = oil.getId();
        this.photo_url = oil.getPhoto_url();
        this.market_price_min = String.valueOf(oil.getMarket_price().doubleValue());
        this.market_price_max = String.valueOf(oil.getMarket_price_max().doubleValue());
        this.member_price = String.valueOf(oil.getMember_price().doubleValue());
        this.oil_type = oil.getOil_type();
    }
}
