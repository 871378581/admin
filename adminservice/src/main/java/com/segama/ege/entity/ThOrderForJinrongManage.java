package com.segama.ege.entity;

import java.io.Serializable;
import java.util.Date;

public class ThOrderForJinrongManage implements Serializable {
    private Long id;

    private String operate_type;

    private String order_code;

    private String order_time;

    private String product_name;

    private String channel_account;

    private String channel_code;

    private String zhuce;

    private String xinhu;

    private String jinjian;

    private String jihuo;

    private String shouxin;

    private String heka;

    private String xiakuan;

    private String xiakuan_amt;

    private Date gmt_create;

    private Date gmt_modify;

    private String creator_account;

    private String modifier_account;

    private String description;

    private String picihao;

    private String zhuce_bak;

    private String xinhu_bak;

    private String jinjian_bak;

    private String jihuo_bak;

    private String shouxin_bak;

    private String heka_bak;

    private String xiakuan_bak;

    private String xiakuan_amt_bak;

    private Integer show_btn;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(String operate_type) {
        this.operate_type = operate_type == null ? null : operate_type.trim();
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code == null ? null : order_code.trim();
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time == null ? null : order_time.trim();
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name == null ? null : product_name.trim();
    }

    public String getChannel_account() {
        return channel_account;
    }

    public void setChannel_account(String channel_account) {
        this.channel_account = channel_account == null ? null : channel_account.trim();
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code == null ? null : channel_code.trim();
    }

    public String getZhuce() {
        return zhuce;
    }

    public void setZhuce(String zhuce) {
        this.zhuce = zhuce == null ? null : zhuce.trim();
    }

    public String getXinhu() {
        return xinhu;
    }

    public void setXinhu(String xinhu) {
        this.xinhu = xinhu == null ? null : xinhu.trim();
    }

    public String getJinjian() {
        return jinjian;
    }

    public void setJinjian(String jinjian) {
        this.jinjian = jinjian == null ? null : jinjian.trim();
    }

    public String getJihuo() {
        return jihuo;
    }

    public void setJihuo(String jihuo) {
        this.jihuo = jihuo == null ? null : jihuo.trim();
    }

    public String getShouxin() {
        return shouxin;
    }

    public void setShouxin(String shouxin) {
        this.shouxin = shouxin == null ? null : shouxin.trim();
    }

    public String getHeka() {
        return heka;
    }

    public void setHeka(String heka) {
        this.heka = heka == null ? null : heka.trim();
    }

    public String getXiakuan() {
        return xiakuan;
    }

    public void setXiakuan(String xiakuan) {
        this.xiakuan = xiakuan == null ? null : xiakuan.trim();
    }

    public String getXiakuan_amt() {
        return xiakuan_amt;
    }

    public void setXiakuan_amt(String xiakuan_amt) {
        this.xiakuan_amt = xiakuan_amt == null ? null : xiakuan_amt.trim();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPicihao() {
        return picihao;
    }

    public void setPicihao(String picihao) {
        this.picihao = picihao == null ? null : picihao.trim();
    }

    public String getZhuce_bak() {
        return zhuce_bak;
    }

    public void setZhuce_bak(String zhuce_bak) {
        this.zhuce_bak = zhuce_bak == null ? null : zhuce_bak.trim();
    }

    public String getXinhu_bak() {
        return xinhu_bak;
    }

    public void setXinhu_bak(String xinhu_bak) {
        this.xinhu_bak = xinhu_bak == null ? null : xinhu_bak.trim();
    }

    public String getJinjian_bak() {
        return jinjian_bak;
    }

    public void setJinjian_bak(String jinjian_bak) {
        this.jinjian_bak = jinjian_bak == null ? null : jinjian_bak.trim();
    }

    public String getJihuo_bak() {
        return jihuo_bak;
    }

    public void setJihuo_bak(String jihuo_bak) {
        this.jihuo_bak = jihuo_bak == null ? null : jihuo_bak.trim();
    }

    public String getShouxin_bak() {
        return shouxin_bak;
    }

    public void setShouxin_bak(String shouxin_bak) {
        this.shouxin_bak = shouxin_bak == null ? null : shouxin_bak.trim();
    }

    public String getHeka_bak() {
        return heka_bak;
    }

    public void setHeka_bak(String heka_bak) {
        this.heka_bak = heka_bak == null ? null : heka_bak.trim();
    }

    public String getXiakuan_bak() {
        return xiakuan_bak;
    }

    public void setXiakuan_bak(String xiakuan_bak) {
        this.xiakuan_bak = xiakuan_bak == null ? null : xiakuan_bak.trim();
    }

    public String getXiakuan_amt_bak() {
        return xiakuan_amt_bak;
    }

    public void setXiakuan_amt_bak(String xiakuan_amt_bak) {
        this.xiakuan_amt_bak = xiakuan_amt_bak == null ? null : xiakuan_amt_bak.trim();
    }

    public Integer getShow_btn() {
        return show_btn;
    }

    public void setShow_btn(Integer show_btn) {
        this.show_btn = show_btn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", operate_type=").append(operate_type);
        sb.append(", order_code=").append(order_code);
        sb.append(", order_time=").append(order_time);
        sb.append(", product_name=").append(product_name);
        sb.append(", channel_account=").append(channel_account);
        sb.append(", channel_code=").append(channel_code);
        sb.append(", zhuce=").append(zhuce);
        sb.append(", xinhu=").append(xinhu);
        sb.append(", jinjian=").append(jinjian);
        sb.append(", jihuo=").append(jihuo);
        sb.append(", shouxin=").append(shouxin);
        sb.append(", heka=").append(heka);
        sb.append(", xiakuan=").append(xiakuan);
        sb.append(", xiakuan_amt=").append(xiakuan_amt);
        sb.append(", gmt_create=").append(gmt_create);
        sb.append(", gmt_modify=").append(gmt_modify);
        sb.append(", creator_account=").append(creator_account);
        sb.append(", modifier_account=").append(modifier_account);
        sb.append(", description=").append(description);
        sb.append(", picihao=").append(picihao);
        sb.append(", zhuce_bak=").append(zhuce_bak);
        sb.append(", xinhu_bak=").append(xinhu_bak);
        sb.append(", jinjian_bak=").append(jinjian_bak);
        sb.append(", jihuo_bak=").append(jihuo_bak);
        sb.append(", shouxin_bak=").append(shouxin_bak);
        sb.append(", heka_bak=").append(heka_bak);
        sb.append(", xiakuan_bak=").append(xiakuan_bak);
        sb.append(", xiakuan_amt_bak=").append(xiakuan_amt_bak);
        sb.append(", show_btn=").append(show_btn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}