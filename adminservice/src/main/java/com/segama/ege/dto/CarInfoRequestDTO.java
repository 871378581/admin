package com.segama.ege.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarInfoRequestDTO {

    private long id = 0;

    private String user_id;//open_id

    private String plate;//车牌

    private String color;//颜色

    private String vin;//车架号

    private String type;//型号

    private String brand_code;//品牌编码

    private String type_code;//型号编码

    private String car_logo_url;//车图标图片链接

    private Boolean is_default;//是否默认车辆

    public String getCar_logo_url() {
        return car_logo_url;
    }

    public void setCar_logo_url(String car_logo_url) {
        this.car_logo_url = car_logo_url;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getIs_default() {
        return is_default;
    }

    public void setIs_default(Boolean is_default) {
        this.is_default = is_default;
    }

    public String getBrand_code() {
        return brand_code;
    }

    public void setBrand_code(String brand_code) {
        this.brand_code = brand_code;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }
}
