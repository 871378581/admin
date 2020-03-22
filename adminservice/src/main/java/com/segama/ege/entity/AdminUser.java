package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class AdminUser implements Serializable {
    private Long id;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String account;

    private String password;

    private Integer version;

    private String token;

    private Date expire_time;

    private String channel_code;

    private String channel_name;

    private String main_body;

    private String contacter;

    private String contacter_phone;

    private Integer status;

    private Integer channel_type;

    private String jieru_way;

    private String meiti_type;

    private String meiti_pwd;

    private String meiti_account;

    private String account_id;

    private String bank_card;

    private String open_bank_area;

    private String real_name;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code == null ? null : channel_code.trim();
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name == null ? null : channel_name.trim();
    }

    public String getMain_body() {
        return main_body;
    }

    public void setMain_body(String main_body) {
        this.main_body = main_body == null ? null : main_body.trim();
    }

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter == null ? null : contacter.trim();
    }

    public String getContacter_phone() {
        return contacter_phone;
    }

    public void setContacter_phone(String contacter_phone) {
        this.contacter_phone = contacter_phone == null ? null : contacter_phone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(Integer channel_type) {
        this.channel_type = channel_type;
    }

    public String getJieru_way() {
        return jieru_way;
    }

    public void setJieru_way(String jieru_way) {
        this.jieru_way = jieru_way == null ? null : jieru_way.trim();
    }

    public String getMeiti_type() {
        return meiti_type;
    }

    public void setMeiti_type(String meiti_type) {
        this.meiti_type = meiti_type == null ? null : meiti_type.trim();
    }

    public String getMeiti_pwd() {
        return meiti_pwd;
    }

    public void setMeiti_pwd(String meiti_pwd) {
        this.meiti_pwd = meiti_pwd == null ? null : meiti_pwd.trim();
    }

    public String getMeiti_account() {
        return meiti_account;
    }

    public void setMeiti_account(String meiti_account) {
        this.meiti_account = meiti_account == null ? null : meiti_account.trim();
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id == null ? null : account_id.trim();
    }

    public String getBank_card() {
        return bank_card;
    }

    public void setBank_card(String bank_card) {
        this.bank_card = bank_card == null ? null : bank_card.trim();
    }

    public String getOpen_bank_area() {
        return open_bank_area;
    }

    public void setOpen_bank_area(String open_bank_area) {
        this.open_bank_area = open_bank_area == null ? null : open_bank_area.trim();
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name == null ? null : real_name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", version=").append(version);
        sb.append(", token=").append(token);
        sb.append(", expire_time=").append(expire_time);
        sb.append(", channel_code=").append(channel_code);
        sb.append(", channel_name=").append(channel_name);
        sb.append(", main_body=").append(main_body);
        sb.append(", contacter=").append(contacter);
        sb.append(", contacter_phone=").append(contacter_phone);
        sb.append(", status=").append(status);
        sb.append(", channel_type=").append(channel_type);
        sb.append(", jieru_way=").append(jieru_way);
        sb.append(", meiti_type=").append(meiti_type);
        sb.append(", meiti_pwd=").append(meiti_pwd);
        sb.append(", meiti_account=").append(meiti_account);
        sb.append(", account_id=").append(account_id);
        sb.append(", bank_card=").append(bank_card);
        sb.append(", open_bank_area=").append(open_bank_area);
        sb.append(", real_name=").append(real_name);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}