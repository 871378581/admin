package com.segama.ege.admin.response;

import java.math.BigDecimal;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2019-11-12 19:52
 */
public class LongitudeLatitudeVO{

    private String longitude="0";

    private String latitude="0";

    private String errorMsg;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
