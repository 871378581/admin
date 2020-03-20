package com.segama.ege.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WxUser implements Serializable {
    private Long id;

    private String user_id;

    private String nick_name;

    private String user_head;

    private String token_id;

    private String user_name;

    private String birth;

    private String sex;

    private String id_card;

    private Boolean has_bind_phone;

    private String phone;

    private Date gmt_register;

    private String place_city;

    private BigDecimal last_longitude;

    private BigDecimal last_latitude;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private Integer version;

    private String membership_level;

    private String job;

    private Date code_expired_at;

    private String code;

    private String default_plate;

    private String default_car_tye;

    private Boolean has_default_car;

    private String card_level;

    private Long capital_account_id;

    private String account;

    private String capital_account_str;

    private Integer user_type;

    private static final long serialVersionUID = 1L;

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
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? null : nick_name.trim();
    }

    public String getUser_head() {
        return user_head;
    }

    public void setUser_head(String user_head) {
        this.user_head = user_head == null ? null : user_head.trim();
    }

    public String getToken_id() {
        return token_id;
    }

    public void setToken_id(String token_id) {
        this.token_id = token_id == null ? null : token_id.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card == null ? null : id_card.trim();
    }

    public Boolean getHas_bind_phone() {
        return has_bind_phone;
    }

    public void setHas_bind_phone(Boolean has_bind_phone) {
        this.has_bind_phone = has_bind_phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getGmt_register() {
        return gmt_register;
    }

    public void setGmt_register(Date gmt_register) {
        this.gmt_register = gmt_register;
    }

    public String getPlace_city() {
        return place_city;
    }

    public void setPlace_city(String place_city) {
        this.place_city = place_city == null ? null : place_city.trim();
    }

    public BigDecimal getLast_longitude() {
        return last_longitude;
    }

    public void setLast_longitude(BigDecimal last_longitude) {
        this.last_longitude = last_longitude;
    }

    public BigDecimal getLast_latitude() {
        return last_latitude;
    }

    public void setLast_latitude(BigDecimal last_latitude) {
        this.last_latitude = last_latitude;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modify() {
        return gmt_modify;
    }

    public void setGmt_modify(Date gmt_modify) {
        this.gmt_modify = gmt_modify;
    }

    public String getCreator_account() {
        return creator_account;
    }

    public void setCreator_account(String creator_account) {
        this.creator_account = creator_account == null ? null : creator_account.trim();
    }

    public String getModifier_account() {
        return modifier_account;
    }

    public void setModifier_account(String modifier_account) {
        this.modifier_account = modifier_account == null ? null : modifier_account.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getMembership_level() {
        return membership_level;
    }

    public void setMembership_level(String membership_level) {
        this.membership_level = membership_level == null ? null : membership_level.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Date getCode_expired_at() {
        return code_expired_at;
    }

    public void setCode_expired_at(Date code_expired_at) {
        this.code_expired_at = code_expired_at;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDefault_plate() {
        return default_plate;
    }

    public void setDefault_plate(String default_plate) {
        this.default_plate = default_plate == null ? null : default_plate.trim();
    }

    public String getDefault_car_tye() {
        return default_car_tye;
    }

    public void setDefault_car_tye(String default_car_tye) {
        this.default_car_tye = default_car_tye == null ? null : default_car_tye.trim();
    }

    public Boolean getHas_default_car() {
        return has_default_car;
    }

    public void setHas_default_car(Boolean has_default_car) {
        this.has_default_car = has_default_car;
    }

    public String getCard_level() {
        return card_level;
    }

    public void setCard_level(String card_level) {
        this.card_level = card_level == null ? null : card_level.trim();
    }

    public Long getCapital_account_id() {
        return capital_account_id;
    }

    public void setCapital_account_id(Long capital_account_id) {
        this.capital_account_id = capital_account_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getCapital_account_str() {
        return capital_account_str;
    }

    public void setCapital_account_str(String capital_account_str) {
        this.capital_account_str = capital_account_str == null ? null : capital_account_str.trim();
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user_id=").append(user_id);
        sb.append(", nick_name=").append(nick_name);
        sb.append(", user_head=").append(user_head);
        sb.append(", token_id=").append(token_id);
        sb.append(", user_name=").append(user_name);
        sb.append(", birth=").append(birth);
        sb.append(", sex=").append(sex);
        sb.append(", id_card=").append(id_card);
        sb.append(", has_bind_phone=").append(has_bind_phone);
        sb.append(", phone=").append(phone);
        sb.append(", gmt_register=").append(gmt_register);
        sb.append(", place_city=").append(place_city);
        sb.append(", last_longitude=").append(last_longitude);
        sb.append(", last_latitude=").append(last_latitude);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", version=").append(version);
        sb.append(", membership_level=").append(membership_level);
        sb.append(", job=").append(job);
        sb.append(", code_expired_at=").append(code_expired_at);
        sb.append(", code=").append(code);
        sb.append(", default_plate=").append(default_plate);
        sb.append(", default_car_tye=").append(default_car_tye);
        sb.append(", has_default_car=").append(has_default_car);
        sb.append(", card_level=").append(card_level);
        sb.append(", capital_account_id=").append(capital_account_id);
        sb.append(", account=").append(account);
        sb.append(", capital_account_str=").append(capital_account_str);
        sb.append(", user_type=").append(user_type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}