package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ShopEvaluateDetail implements Serializable {
    private Long id;

    private String user_id;

    private String nick_name;

    private String car_type;

    private Date gmt_repair;

    private String evaluate_score;

    private String evaluate_content;

    private Date gmt_evaluate_commit;

    private Boolean is_invalid;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private Long shop_id;

    private Integer version;

    private Long order_id;

    private String user_head;

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

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type == null ? null : car_type.trim();
    }

    public Date getGmt_repair() {
        return gmt_repair;
    }

    public void setGmt_repair(Date gmt_repair) {
        this.gmt_repair = gmt_repair;
    }

    public String getEvaluate_score() {
        return evaluate_score;
    }

    public void setEvaluate_score(String evaluate_score) {
        this.evaluate_score = evaluate_score == null ? null : evaluate_score.trim();
    }

    public String getEvaluate_content() {
        return evaluate_content;
    }

    public void setEvaluate_content(String evaluate_content) {
        this.evaluate_content = evaluate_content == null ? null : evaluate_content.trim();
    }

    public Date getGmt_evaluate_commit() {
        return gmt_evaluate_commit;
    }

    public void setGmt_evaluate_commit(Date gmt_evaluate_commit) {
        this.gmt_evaluate_commit = gmt_evaluate_commit;
    }

    public Boolean getIs_invalid() {
        return is_invalid;
    }

    public void setIs_invalid(Boolean is_invalid) {
        this.is_invalid = is_invalid;
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

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getUser_head() {
        return user_head;
    }

    public void setUser_head(String user_head) {
        this.user_head = user_head == null ? null : user_head.trim();
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
        sb.append(", car_type=").append(car_type);
        sb.append(", gmt_repair=").append(gmt_repair);
        sb.append(", evaluate_score=").append(evaluate_score);
        sb.append(", evaluate_content=").append(evaluate_content);
        sb.append(", gmt_evaluate_commit=").append(gmt_evaluate_commit);
        sb.append(", is_invalid=").append(is_invalid);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", shop_id=").append(shop_id);
        sb.append(", version=").append(version);
        sb.append(", order_id=").append(order_id);
        sb.append(", user_head=").append(user_head);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}