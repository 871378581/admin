package com.segama.ege.admin.vo;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2019-10-07 14:40
 */
public class LoginVO extends BaseVO {
    private String account;

    private String shopName;

    //运营user_id
    private Long id;

    //门店 user_id
    private Long shop_user_id;

    public Long getShop_user_id() {
        return shop_user_id;
    }

    public void setShop_user_id(Long shop_user_id) {
        this.shop_user_id = shop_user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
