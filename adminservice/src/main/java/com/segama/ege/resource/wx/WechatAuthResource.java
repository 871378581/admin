package com.segama.ege.resource.wx;

import com.segama.ege.constant.Constants;
import com.segama.ege.dto.wx.WxUserInfo;
import com.segama.ege.service.CacheService;
import com.segama.ege.service.UserService;
import com.segama.ege.service.WeChatService;
import com.segama.ege.util.HttpHelper;
import com.segama.ege.util.CommonUtil;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static com.segama.ege.constant.Constants.LOGIN_AUTH_REDIRECT_PREFIX;
import static com.segama.ege.constant.Constants.SYSTEM_CURRENT_API_HOST;

@Controller
@RequestMapping("/ege/api/wechat/")
public class WechatAuthResource {

    @Autowired
    WeChatService weChatService;

    @Autowired
    CacheService cacheService;

    @Autowired
    UserService userService;

    @RequestMapping("/browser/auth")
    public String browserAuth(@RequestParam(name = "state") String state) throws MalformedURLException {
        URL redirectUrl = new URL(String.format("%s%s", cacheService.get(SYSTEM_CURRENT_API_HOST), "/ege/api/wechat/browser/user"));
        String toRedirect = weChatService.constructBrowserGrantedAccessUrl(redirectUrl, Constants.Scope.UserInfo, state).toString();
        CommonUtil.info("browserAuth", "result", new Object[]{toRedirect}, null);
        return "redirect:" + toRedirect;
    }

    @RequestMapping("/browser/user")
    public String userInfo(@RequestParam(name = "code") String code, @RequestParam(name = "state", required = false) String state) throws URISyntaxException {
        WxUserInfo wxUserInfo = weChatService.getWxUserInfo(code);

        String userLoginToken = userService.saveWxUser(wxUserInfo);

        String host = cacheService.get(SYSTEM_CURRENT_API_HOST);
        if (StringUtils.isEmpty(state)) {
            state = "default";
        }
        String redirectUrl = cacheService.get(LOGIN_AUTH_REDIRECT_PREFIX + state);
        URI uri = HttpHelper.appendUri(host + redirectUrl, "userToken=" + userLoginToken + "&state=" + state);
        String toRedirectUrl = uri.toASCIIString();
        CommonUtil.info("wxUserInfo", "result", new Object[]{code, state}, toRedirectUrl);
        return "redirect:" + toRedirectUrl;
    }
}
