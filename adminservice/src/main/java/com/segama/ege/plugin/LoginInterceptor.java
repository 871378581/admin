package com.segama.ege.plugin;

import com.segama.ege.entity.WxUser;
import com.segama.ege.service.UserService;
import com.segama.ege.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.segama.ege.constant.Constants.USER_TOKEN_COOKIE;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
//        CommonUtil.info("LoginInterceptor", "preHandle", new Object[]{cookies}, null);
        if (cookies != null) {
            if (cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(USER_TOKEN_COOKIE)) {
                        String userToken = cookie.getValue();
                        if (!StringUtils.isEmpty(userToken)) {
                            WxUser currentWxUser = userService.getUserInfoByToken(userToken);
                            if (currentWxUser != null) {
                                CommonUtil.setCurrentLoginUser(currentWxUser);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        String token = request.getParameter(USER_TOKEN_COOKIE);
//        CommonUtil.info("LoginInterceptor", "preHandle#fallback", new Object[]{token}, null);
        if (!StringUtils.isEmpty(token)) {
            if (!StringUtils.isEmpty(token)) {
                WxUser currentWxUser = userService.getUserInfoByToken(token);
                if (currentWxUser != null) {
                    CommonUtil.setCurrentLoginUser(currentWxUser);
                    return true;
                }
            }
        }


        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        CommonUtil.logout();
    }
}
