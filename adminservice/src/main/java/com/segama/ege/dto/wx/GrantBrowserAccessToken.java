package com.segama.ege.dto.wx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: ethan.wang
 * Date: 3/5/14
 * Time: 3:17 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GrantBrowserAccessToken {
    @JsonProperty("access_token")
    private String access_token;
    @JsonProperty("expires_in")
    private String expires_in;
    @JsonProperty("refresh_token")
    private String refresh_token;
    @JsonProperty("openid")
    private String openid;
    @JsonProperty("scope")
    private String scope;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
