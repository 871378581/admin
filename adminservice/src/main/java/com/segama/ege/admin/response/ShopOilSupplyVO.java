package com.segama.ege.admin.response;

import com.segama.ege.entity.ShopOilSupply;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2019-10-20 01:06
 */
public class ShopOilSupplyVO extends ShopOilSupply {
    private String oil_name;
    private String shop_name;

    public String getOil_name() {
        return oil_name;
    }

    public void setOil_name(String oil_name) {
        this.oil_name = oil_name;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }
}
