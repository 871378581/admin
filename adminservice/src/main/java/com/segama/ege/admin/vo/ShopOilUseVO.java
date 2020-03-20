package com.segama.ege.admin.vo;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2020-01-14 23:55
 */
public class ShopOilUseVO {

    public ShopOilUseVO(String test_report, Long oil_id, String oil_name, Long shop_id, String shop_name) {
        this.test_report = test_report;
        this.oil_id = oil_id;
        this.oil_name = oil_name;
        this.shop_id = shop_id;
        this.shop_name = shop_name;
    }

    private String test_report;
    private Long oil_id;
    private String oil_name;
    private Long shop_id;
    private String shop_name;
    private Long oil_num;

    public String getTest_report() {
        return test_report;
    }

    public void setTest_report(String test_report) {
        this.test_report = test_report;
    }

    public Long getOil_id() {
        return oil_id;
    }

    public void setOil_id(Long oil_id) {
        this.oil_id = oil_id;
    }

    public String getOil_name() {
        return oil_name;
    }

    public void setOil_name(String oil_name) {
        this.oil_name = oil_name;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public Long getOil_num() {
        return oil_num;
    }

    public void setOil_num(Long oil_num) {
        this.oil_num = oil_num;
    }
}
