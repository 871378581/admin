package com.segama.ege.dto;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.domain.MembershipLevel;
import com.segama.ege.entity.Car;
import com.segama.ege.entity.WxUser;
import com.segama.ege.util.PlateConvertUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class WxUserInfoDTO {

    private String user_id;

    private String sex;

    private String account;

    private String nick_name;

    private String user_head;

    private String user_name;

    private String birth;

    private String place_city;

    private String level;

    private String phone;

    private String job;

    private boolean has_activated_car = false;

    private String default_plate;

    private String default_car_tye;

    private boolean has_default_car;

    private String card_level;

    private CarInfoResponseListDTO carListDTO;

    public CarInfoResponseListDTO getCarListDTO() {
        return carListDTO;
    }

    public void setCarListDTO(CarInfoResponseListDTO carListDTO) {
        this.carListDTO = carListDTO;
    }

    public String getDefault_plate() {
        return default_plate;
    }

    public void setDefault_plate(String default_plate) {
        this.default_plate = default_plate;
    }

    public String getDefault_car_tye() {
        return default_car_tye;
    }

    public void setDefault_car_tye(String default_car_tye) {
        this.default_car_tye = default_car_tye;
    }

    public boolean isHas_default_car() {
        return has_default_car;
    }

    public void setHas_default_car(boolean has_default_car) {
        this.has_default_car = has_default_car;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getUser_head() {
        return user_head;
    }

    public void setUser_head(String user_head) {
        this.user_head = user_head;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPlace_city() {
        return place_city;
    }

    public void setPlace_city(String place_city) {
        this.place_city = place_city;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCard_level() {
        return card_level;
    }

    public void setCard_level(String card_level) {
        this.card_level = card_level;
    }

    public boolean isHas_activated_car() {
        return has_activated_car;
    }

    public void setHas_activated_car(boolean has_activated_car) {
        this.has_activated_car = has_activated_car;
    }

    public static WxUserInfoDTO buildOrigin(WxUser wxUser, CarInfoResponseListDTO carListDTO) {
        WxUserInfoDTO dto = new WxUserInfoDTO();
        dto.setAccount(wxUser.getAccount());
        dto.setBirth(wxUser.getBirth());
        dto.setUser_head(wxUser.getUser_head());
        dto.setJob(wxUser.getJob());
        dto.setLevel(wxUser.getMembership_level());
        dto.setNick_name(wxUser.getNick_name());
        dto.setPhone(wxUser.getPhone());
        dto.setPlace_city(wxUser.getPlace_city());
        dto.setUser_id(wxUser.getUser_id());
        dto.setUser_name(wxUser.getUser_name());
        dto.setSex(wxUser.getSex());
        dto.setHas_default_car(wxUser.getHas_default_car());
        dto.setDefault_car_tye(wxUser.getDefault_car_tye());
        dto.setDefault_plate(PlateConvertUtil.convertToCapital(wxUser.getDefault_plate()));
        dto.setCard_level(wxUser.getCard_level());
        dto.setCarListDTO(carListDTO);
        if(carListDTO != null){
            List<CarInfoResponseDTO> cars = carListDTO.getCars();
            if(cars != null && cars.size() > 0){
                for (CarInfoResponseDTO eachDTO: cars) {
                    boolean f1 = StringUtils.isNotEmpty(eachDTO.getCard_level())
                            && (!eachDTO.getCard_level().equals(MembershipLevel.common_card.getCode()));
                    boolean f2 = StringUtils.isNotEmpty(eachDTO.getGmt_lose_effect())
                            && DateUtil.getDateByStr(eachDTO.getGmt_lose_effect() + DateUtil.ZERO_TIME_STR).after(new Date());
                    if(f1 && f2){
                        dto.setHas_activated_car(true);
                        break;
                    }
                }
            }
        }
        return dto;
    }

    public WxUser build() {
        WxUser dto = new WxUser();
        dto.setAccount(getAccount());
        dto.setBirth(getBirth());
        dto.setUser_head(getUser_head());
        dto.setJob(getJob());
        dto.setMembership_level(getLevel());
        dto.setNick_name(getNick_name());
        dto.setPhone(getPhone());
        dto.setPlace_city(getPlace_city());
        dto.setUser_id(getUser_id());
        dto.setUser_name(getUser_name());
        dto.setSex(getSex());
        dto.setHas_default_car(isHas_default_car());
        dto.setDefault_car_tye(getDefault_car_tye());
        dto.setDefault_plate(getDefault_plate());
        dto.setCard_level(getCard_level());
        return dto;
    }
}
