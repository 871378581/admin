package com.segama.ege.service;

import com.alibaba.fastjson.JSON;
import com.segama.ege.dto.wx.GrantBrowserAccessToken;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class WeChatServiceTest {

    @Test
    public void getToken() {
        WeChatService weChatService = new WeChatService();

        weChatService.setCacheService(new CacheService());

//        System.out.println(weChatService.getToken());
//
//        System.out.println(weChatService.getJSTicket());
//
//        System.out.println(JSON.toJSONString(weChatService.getShareJsConfig("http://www.baidu.com")));

//        System.out.println(weChatService.getBrowserGrantedAccessToken("071EXS7w0D4EPc1bgX4w05dK7w0EXS7T"));

//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx9c007035c17b2e42&secret=8c2917321f52baf1f073efa164664208&code=071loZYR0FXeC52FoqWR0R6VYR0loZYp&grant_type=authorization_code";
//        String forObject = restTemplate.getForObject(url, String.class);
//        System.out.println(forObject);

        String request = "{\"access_token\":\"26_zrl9DRBSXu_gYpJ5f-OtOd0B4AiPCe2pM6tQSz565so3GdM0oLirQCjSZQCX3bo4cn66HyatqaZP5OqY91i8Pg\",\"expires_in\":7200,\"refresh_token\":\"26_cGIZrZOIgRQTphwoTinYoeMJXxWDZqIDblZNk6R5WzsUaRzwQwQThXg0eySfA7fTBfAliVFV_FoVHnUBnOh6Lg\",\"openid\":\"o4TdCt1EbR0eYB5n0Zyjq-JMx7g8\",\"scope\":\"snsapi_userinfo\"}";
        GrantBrowserAccessToken grantBrowserAccessToken = JSON.parseObject(request, GrantBrowserAccessToken.class);
        System.out.println(JSON.toJSONString(grantBrowserAccessToken));
    }
}