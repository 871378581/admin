package com.segama.ege.util;

import com.alibaba.fastjson.JSON;
import com.segama.ege.entity.WxUser;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class CommonUtil {
    private static final Logger log = getLogger(CommonUtil.class);

    public static void info(String entry, String result, Object[] objects, Object responseObj) {
        if (responseObj != null) {
            if (responseObj instanceof Throwable) {
                log.error(String.format("%s|%s|%s|%s", getTraceId(), entry, result, JSON.toJSONString(objects)), (Throwable) responseObj);
            }
        }
        log.info(String.format("%s|%s|%s|%s|%s", getTraceId(), entry, result, JSON.toJSONString(objects), JSON.toJSONString(responseObj)));
    }

    private static ThreadLocal<Session> session = new ThreadLocal<>();

    public static String getTraceId() {
        if (session.get() == null) {
            session.set(new Session());
        }
        return session.get().getTraceId();
    }

    public static WxUser getCurrentLoginUser() {
        if (session.get() == null) {
            session.set(new Session());
        }
        return session.get().getCurrentWxUser();
    }

    public static void setCurrentLoginUser(WxUser wxUser) {
        if (session.get() == null) {
            session.set(new Session());
        }
        session.get().setCurrentWxUser(wxUser);
    }

    public static void addContextParam(String key, String value) {
        if (session.get() == null) {
            session.set(new Session());
        }
        session.get().getContext().put(key, value);
    }

    public static void getContextParam(String key) {
        if (session.get() == null) {
            session.set(new Session());
        }
        session.get().getContext().get(key);
    }

    public static void logout() {
        session.set(null);
    }
}
