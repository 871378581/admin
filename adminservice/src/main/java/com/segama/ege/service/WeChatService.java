package com.segama.ege.service;

import com.alibaba.fastjson.JSON;
import com.segama.ege.dto.wx.*;
import com.segama.ege.util.CommonUtil;
import com.segama.ege.util.JSShareHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.segama.ege.constant.Constants.*;


@Component
public class WeChatService {
    private static String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    private static String WX_JS_TICKET_URL = "http://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=%s";
    private static String grantToUserInfoInWeChatBrowserGetCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";
    private static String grantToUserInfoInWeChatBrowserGetAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    private static final int WX_TOKEN_EXPIRE_SECOND = 3600;


    @Autowired
    CacheService cacheService;


    /**
     * 获取微信token
     * 支持缓存获取，如果没有则通过直接查询微信接口获取
     *
     * @return
     */
    public String getToken() {
        String tokenVal = cacheService.get(WX_TOKEN_KEY);
        if (StringUtils.isEmpty(tokenVal)) {
            String token = loadNewToken();
            if (!StringUtils.isEmpty(token)) {
                cacheService.put(WX_TOKEN_KEY, token, WX_TOKEN_EXPIRE_SECOND);
            }
            return token;
        } else {
            return (String) tokenVal;
        }
    }

    /**
     * js分享需要的ticket
     *
     * @return
     */
    public String getJSTicket() {
        String tokenVal = cacheService.get(WX_JS_TICKET_KEY);
        if (StringUtils.isEmpty(tokenVal)) {
            String token = loadJSTicket();
            if (!StringUtils.isEmpty(token)) {
                cacheService.put(WX_JS_TICKET_KEY, token, WX_TOKEN_EXPIRE_SECOND);
            }
            return token;
        } else {
            return tokenVal;
        }
    }

    private String loadJSTicket() {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(WX_JS_TICKET_URL, getToken());
        JSShareTicket accessToken = restTemplate.getForObject(url, JSShareTicket.class);
        CommonUtil.info("loadJSTicket", "result", new Object[]{url}, accessToken);
        if (accessToken == null) {
            return null;
        }
        return accessToken.getTicket();
    }

    private String loadNewToken() {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(WX_ACCESS_TOKEN_URL, cacheService.getConfig(WX_APP_ID), cacheService.getConfig(WX_APP_SECRET));
        AccessToken accessToken = restTemplate.getForObject(url, AccessToken.class);
        CommonUtil.info("loadNewToken", "result", new Object[]{url}, accessToken);
        if (accessToken == null) {
            return null;
        }
        return accessToken.getAccessToken();
    }

    public ShareConfiguration getShareJsConfig(String currentUri) {
        ShareConfiguration shareConfiguration = JSShareHelper.getWeChatShareConfiguration(getJSTicket(), currentUri);
        if (shareConfiguration != null) {
            shareConfiguration.setAppId(cacheService.getConfig(WX_APP_ID));
        }
        return shareConfiguration;
    }

    public GrantBrowserAccessToken getBrowserGrantedAccessToken(final String code) {
        try {
            String url = String.format(grantToUserInfoInWeChatBrowserGetAccessTokenUrl, cacheService.getConfig(WX_APP_ID), cacheService.getConfig(WX_APP_SECRET), code);
            CommonUtil.info("getBrowserGrantedAccessToken", "start", new Object[]{url}, null);
            RestTemplate restTemplate = new RestTemplate();
            String grantBrowserAccessToken = restTemplate.getForObject(url, String.class);
            CommonUtil.info("getBrowserGrantedAccessToken", "success", new Object[]{url}, grantBrowserAccessToken);
            return JSON.parseObject(grantBrowserAccessToken, GrantBrowserAccessToken.class);
        } catch (Exception ex) {
            CommonUtil.info("getBrowserGrantedAccessToken", "exception", new Object[]{code}, ex);
            throw ex;
        }
    }

    public WxUserInfo getWxUserInfo(final String code) {
        try {
            GrantBrowserAccessToken browserGrantedAccessToken = getBrowserGrantedAccessToken(code);
            String url = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", browserGrantedAccessToken.getAccess_token(), browserGrantedAccessToken.getOpenid());
            String wxUserInfo = restTemplate().getForObject(url, String.class);
            CommonUtil.info("getWxUserInfo", "success", new Object[]{url}, wxUserInfo);
            return JSON.parseObject(wxUserInfo, WxUserInfo.class);
        } catch (Exception ex) {
            CommonUtil.info("getWxUserInfo", "exception", new Object[]{code}, ex);
            throw ex;
        }
    }

    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
//        RestTemplate restTemplate = new RestTemplate(
//                new HttpComponentsClientHttpRequestFactory()); // 使用HttpClient，支持GZIP
        restTemplate.getMessageConverters().set(1,
                new StringHttpMessageConverter(StandardCharsets.UTF_8)); // 支持中文编码
        return restTemplate;
    }

    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public URL constructBrowserGrantedAccessUrl(final URL redirectUrl, final String scope, String state) throws MalformedURLException {
        String url = String.format(grantToUserInfoInWeChatBrowserGetCodeUrl, cacheService.getConfig(WX_APP_ID), redirectUrl, scope, state);
        return new URL(url);
    }
}
