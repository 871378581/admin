package com.segama.ege.admin.vo;

import com.segama.ege.entity.ShopAdminUser;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2019-10-23 01:44
 */
public class ShopAdminUserVO extends ShopAdminUser {
    /*店铺名*/
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
