package com.segama.ege.shopadmin.intercepter;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ShopAdminUser;
import com.segama.ege.entity.ShopAdminUserExample;
import com.segama.ege.repository.ShopAdminUserMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import static com.segama.ege.admin.constants.AdminConstants.TOKEN;

public class ShopAdminInterceptor extends HandlerInterceptorAdapter {
    /**
     * 用户服务
     */
    @Resource
    private ShopAdminUserMapper shopAdminUserMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        response.setHeader("Content-type", "text/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setCharacterEncoding("utf8");
        String token = request.getParameter(TOKEN);
        if(!path.startsWith("/ege/api/shop_admin")){
            //只拦截运营端接口
            return true;
        }

        if (StringUtils.isEmpty(token)) {
            //不需要的拦截直接过
            return true;
        } else {
            ShopAdminUserExample adminUserExample = new ShopAdminUserExample();
            ShopAdminUserExample.Criteria criteria = adminUserExample.createCriteria();
            criteria.andTokenEqualTo(token);
            criteria.andExpire_timeGreaterThan(new Date());
            List<ShopAdminUser> adminUsers = shopAdminUserMapper.selectByExample(adminUserExample);
            if(!CollectionUtils.isEmpty(adminUsers)  && adminUsers.size() > 0){
                return true;
            }else{
                PrintWriter writer = response.getWriter();
                BaseVO baseVO = new BaseVO();
                baseVO.setSuccess(false);
                baseVO.setData(Lists.newArrayList());
                baseVO.setStatus(401);
                baseVO.setCount(0);
                baseVO.setCode(0);
                baseVO.setErrorMsg("登录超时");
                writer.print(JSON.toJSONString(baseVO));
                writer.flush();
                return false;
            }
        }
    }
}
