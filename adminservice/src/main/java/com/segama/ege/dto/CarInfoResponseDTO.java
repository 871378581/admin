package com.segama.ege.dto;
import com.segama.ege.entity.Car;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.entity.WxUser;
import com.segama.ege.util.PlateConvertUtil;

public class CarInfoResponseDTO {
    private Long id;

    private String user_id;

    private String plate;

    private Long car_type_id;

    private String car_type_name;

    private String car_type_color;

    private String car_logo_url;

    private String gmt_last_maintenance;

    private String last_maintenance_miles;

    private String next_maintenance_miles;

    private String membership_card_id;

    private String car_status;

    private String user_name;

    private String gmt_activate;

    private String gmt_take_effect;

    private String gmt_lose_effect;

    private Boolean is_default;

    private String color;

    private String vin;

    private String card_level;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLast_maintenance_miles() {
        return last_maintenance_miles;
    }

    public void setLast_maintenance_miles(String last_maintenance_miles) {
        this.last_maintenance_miles = last_maintenance_miles;
    }

    public String getNext_maintenance_miles() {
        return next_maintenance_miles;
    }

    public void setNext_maintenance_miles(String next_maintenance_miles) {
        this.next_maintenance_miles = next_maintenance_miles;
    }

    public String getCard_level() {
        return card_level;
    }

    public void setCard_level(String card_level) {
        this.card_level = card_level;
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

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Long getCar_type_id() {
        return car_type_id;
    }

    public void setCar_type_id(Long car_type_id) {
        this.car_type_id = car_type_id;
    }

    public String getCar_type_name() {
        return car_type_name;
    }

    public void setCar_type_name(String car_type_name) {
        this.car_type_name = car_type_name;
    }

    public String getCar_type_color() {
        return car_type_color;
    }

    public void setCar_type_color(String car_type_color) {
        this.car_type_color = car_type_color;
    }

    public String getCar_logo_url() {
        return car_logo_url;
    }

    public void setCar_logo_url(String car_logo_url) {
        this.car_logo_url = car_logo_url;
    }

    public String getGmt_last_maintenance() {
        return gmt_last_maintenance;
    }

    public void setGmt_last_maintenance(String gmt_last_maintenance) {
        this.gmt_last_maintenance = gmt_last_maintenance;
    }

    public String getMembership_card_id() {
        return membership_card_id;
    }

    public void setMembership_card_id(String membership_card_id) {
        this.membership_card_id = membership_card_id;
    }

    public String getCar_status() {
        return car_status;
    }

    public void setCar_status(String car_status) {
        this.car_status = car_status;
    }

    public String getGmt_activate() {
        return gmt_activate;
    }

    public void setGmt_activate(String gmt_activate) {
        this.gmt_activate = gmt_activate;
    }

    public String getGmt_take_effect() {
        return gmt_take_effect;
    }

    public void setGmt_take_effect(String gmt_take_effect) {
        this.gmt_take_effect = gmt_take_effect;
    }

    public String getGmt_lose_effect() {
        return gmt_lose_effect;
    }

    public void setGmt_lose_effect(String gmt_lose_effect) {
        this.gmt_lose_effect = gmt_lose_effect;
    }

    public Boolean getIs_default() {
        return is_default;
    }

    public void setIs_default(Boolean is_default) {
        this.is_default = is_default;
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

    public CarInfoResponseDTO(Car car, WxUser currentLoginUser){
        this.car_logo_url = car.getCar_logo_url();
        this.last_maintenance_miles = car.getLast_maintenance_miles();
        this.next_maintenance_miles = car.getNext_maintenance_miles();
        this.car_status = car.getCar_status();
        this.car_type_color = car.getCar_type_color();
        this.car_type_id = car.getCar_type_id();
        this.color = car.getColor();
        this.gmt_activate = DateUtil.parseToYYYYMMDD(car.getGmt_activate());
        this.gmt_last_maintenance = DateUtil.parseToYYYYMMDD(car.getGmt_last_maintenance());
        this.gmt_lose_effect = DateUtil.parseToYYYYMMDD(car.getGmt_lose_effect());
        this.gmt_take_effect = DateUtil.parseToYYYYMMDD(car.getGmt_take_effect());
        this.car_type_name = car.getCar_type_name();
        this.is_default = car.getIs_default();
        this.membership_card_id = car.getMembership_card_id();
        this.plate = PlateConvertUtil.convertToCapital(car.getPlate());
        this.vin = car.getVin();
        this.user_id = car.getUser_id();
        this.user_name = currentLoginUser.getUser_name();
        this.id = car.getId();
        this.card_level = car.getCard_level();
    }
}
