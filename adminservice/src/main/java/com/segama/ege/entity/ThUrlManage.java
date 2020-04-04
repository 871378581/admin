package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ThUrlManage implements Serializable {
    private Long id;

    private String business_name;

    private String url_code;

    private String share_url_code;

    private String open_ticket_main_body;

    private String product_name;

    private String product_code;

    private String product_type;

    private String product_qudao_code;

    private String url;

    private Integer url_status;

    private String biz_line;

    private String channel_code;

    private String youxiao_time;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String owner_account;

    private String modifier_account;

    private String description;

    private String shifou_2_kaifa;

    private String owner_1_account;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name == null ? null : business_name.trim();
    }

    public String getUrl_code() {
        return url_code;
    }

    public void setUrl_code(String url_code) {
        this.url_code = url_code == null ? null : url_code.trim();
    }

    public String getShare_url_code() {
        return share_url_code;
    }

    public void setShare_url_code(String share_url_code) {
        this.share_url_code = share_url_code == null ? null : share_url_code.trim();
    }

    public String getOpen_ticket_main_body() {
        return open_ticket_main_body;
    }

    public void setOpen_ticket_main_body(String open_ticket_main_body) {
        this.open_ticket_main_body = open_ticket_main_body == null ? null : open_ticket_main_body.trim();
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name == null ? null : product_name.trim();
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code == null ? null : product_code.trim();
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type == null ? null : product_type.trim();
    }

    public String getProduct_qudao_code() {
        return product_qudao_code;
    }

    public void setProduct_qudao_code(String product_qudao_code) {
        this.product_qudao_code = product_qudao_code == null ? null : product_qudao_code.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getUrl_status() {
        return url_status;
    }

    public void setUrl_status(Integer url_status) {
        this.url_status = url_status;
    }

    public String getBiz_line() {
        return biz_line;
    }

    public void setBiz_line(String biz_line) {
        this.biz_line = biz_line == null ? null : biz_line.trim();
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code == null ? null : channel_code.trim();
    }

    public String getYouxiao_time() {
        return youxiao_time;
    }

    public void setYouxiao_time(String youxiao_time) {
        this.youxiao_time = youxiao_time == null ? null : youxiao_time.trim();
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

    public String getOwner_account() {
        return owner_account;
    }

    public void setOwner_account(String owner_account) {
        this.owner_account = owner_account == null ? null : owner_account.trim();
    }

    public String getModifier_account() {
        return modifier_account;
    }

    public void setModifier_account(String modifier_account) {
        this.modifier_account = modifier_account == null ? null : modifier_account.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getShifou_2_kaifa() {
        return shifou_2_kaifa;
    }

    public void setShifou_2_kaifa(String shifou_2_kaifa) {
        this.shifou_2_kaifa = shifou_2_kaifa == null ? null : shifou_2_kaifa.trim();
    }

    public String getOwner_1_account() {
        return owner_1_account;
    }

    public void setOwner_1_account(String owner_1_account) {
        this.owner_1_account = owner_1_account == null ? null : owner_1_account.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", business_name=").append(business_name);
        sb.append(", url_code=").append(url_code);
        sb.append(", share_url_code=").append(share_url_code);
        sb.append(", open_ticket_main_body=").append(open_ticket_main_body);
        sb.append(", product_name=").append(product_name);
        sb.append(", product_code=").append(product_code);
        sb.append(", product_type=").append(product_type);
        sb.append(", product_qudao_code=").append(product_qudao_code);
        sb.append(", url=").append(url);
        sb.append(", url_status=").append(url_status);
        sb.append(", biz_line=").append(biz_line);
        sb.append(", channel_code=").append(channel_code);
        sb.append(", youxiao_time=").append(youxiao_time);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", owner_account=").append(owner_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", description=").append(description);
        sb.append(", shifou_2_kaifa=").append(shifou_2_kaifa);
        sb.append(", owner_1_account=").append(owner_1_account);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}