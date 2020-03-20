package com.segama.ege.dto.wx;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 2/5/15
 * Time         : 7:42 PM
 * Description  : share js ticket
 */
public class ShareConfiguration {
    @JsonProperty("jsapi_ticket")
    private final String ticket;
    @JsonProperty("nonceStr")
    private final String nonce;
    @JsonProperty("timestamp")
    private final String timestamp;
    @JsonProperty("signature")
    private final String signature;

    @JsonProperty("appId")
    private String appId;


    public ShareConfiguration(String ticket, String nonce, String timestamp, String signature) {
        this.ticket = ticket;
        this.nonce = nonce;
        this.timestamp = timestamp;
        this.signature = signature;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTicket() {
        return ticket;
    }

    public String getNonce() {
        return nonce;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSignature() {
        return signature;
    }
}
