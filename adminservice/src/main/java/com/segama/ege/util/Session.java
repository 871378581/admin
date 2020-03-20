package com.segama.ege.util;

import com.segama.ege.entity.WxUser;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Session {
    private String traceId;
    private Map<String, String> context;
    private WxUser currentWxUser;

    public Session(){
        this.traceId = UUID.randomUUID().toString();
        this.context = new HashMap<String, String>();
    }

    public WxUser getCurrentWxUser() {
        return currentWxUser;
    }

    public void setCurrentWxUser(WxUser currentWxUser) {
        this.currentWxUser = currentWxUser;
    }

    public Map<String, String> getContext() {
        return context;
    }

    public void setContext(Map<String, String> context) {
        this.context = context;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
