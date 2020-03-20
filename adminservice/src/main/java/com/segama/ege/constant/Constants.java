package com.segama.ege.constant;

import java.nio.charset.Charset;

public class Constants {
    public static final String SYSTEM_CURRENT_API_HOST = "current_api_host";
    public static final String SYSTEM_IMAGE_LOCATION = "system_image_location";
    public static final String SYSTEM_IMAGE_REPO_PREFIX = "system_image_repo_prefix";
    public static final String WX_TOKEN_KEY = "WX_TOKEN_KEY";
    public static final String WX_JS_TICKET_KEY = "WX_JS_TICKET_KEY";
    public static final String WX_APP_ID = "WX_APP_ID";
    public static final String WX_APP_SECRET = "WX_APP_SECRET";

    public static final String USER_TOKEN_COOKIE = "_999_user_token";
    public static final String ADMIN_USER_TOKEN_COOKIE = "_admin_999_user_token";
    public static final Charset UTF8 = Charset.forName("UTF8");

    public static final String customer_service_wechat_qr_code = "customer_service_wechat_qr_code";
    public static final String customer_service_phone = "customer_service_phone";
    public static final String customer_service_email = "customer_service_email";
    public static final String description_words = "description_words";
    public static final String effect_after_x_days = "effect_after_x_days";
    public static final String period_of_validity = "period_of_validity";
    public static final String repeat_service_days = "repeat_service_days";
    public static final String repeat_service_counts = "repeat_service_counts";

    public static final String LOGIN_AUTH_REDIRECT_PREFIX = "login.auth.redirect.";
    public static final String CACHE_OBJECT_KEY_CAR_TYPE = "cache.object.car.type";

    public static final class Scope {
        public static final String Base = "snsapi_base";
        public static final String UserInfo = "snsapi_userinfo";
    }
}
