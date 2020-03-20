package com.segama.ege.service;

import com.segama.ege.dto.wx.WxUserInfo;
import com.segama.ege.entity.WxUser;
import com.segama.ege.entity.WxUserExample;
import com.segama.ege.repository.WxUserMapper;
import com.segama.ege.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;


@Component
public class UserService {
    @Resource
    private WxUserMapper wxUserMapper;

    public String saveWxUser(WxUserInfo wxUserInfo) {
        WxUserExample wxUserExample = new WxUserExample();
        wxUserExample.createCriteria().andToken_idEqualTo(wxUserInfo.getOpenid());
        List<WxUser> wxUsers = wxUserMapper.selectByExample(wxUserExample);
        if (CollectionUtils.isEmpty(wxUsers)) {

            WxUser wxUser = new WxUser();
            wxUser.setToken_id(wxUserInfo.getOpenid());
            wxUser.setUser_id(wxUserInfo.getOpenid());
            wxUser.setUser_head(wxUserInfo.getHeadimgurl());
            wxUser.setNick_name(wxUserInfo.getNickname());
            wxUser.setGmt_create(new Date());
            wxUser.setGmt_modify(new Date());
            wxUser.setGmt_register(new Date());
            int userId = wxUserMapper.insertSelective(wxUser);
            if (userId <= 0) {
                CommonUtil.info("saveWxUser", "failed", new Object[]{wxUserInfo}, userId);
                throw new RuntimeException("Failed in create wx user:" + wxUserInfo.getOpenid());
            }
            DecimalFormat df = new DecimalFormat("8000000000");
            wxUser.setAccount(df.format(wxUser.getId()));
            wxUserMapper.updateByPrimaryKeySelective(wxUser);
        } else {
            WxUser wxUser = wxUsers.get(0);
            wxUser.setUser_head(wxUserInfo.getHeadimgurl());
            wxUser.setNick_name(wxUserInfo.getNickname());
            wxUser.setGmt_modify(new Date());
            wxUserMapper.updateByPrimaryKeySelective(wxUser);
        }
        return wxUserInfo.getOpenid();
    }

    public WxUser getUserInfoByToken(String userToken) {
        if (StringUtils.isBlank(userToken)) {
            return null;
        }
        WxUserExample wxUserExample = new WxUserExample();
        wxUserExample.createCriteria().andToken_idEqualTo(userToken);
        List<WxUser> wxUsers = wxUserMapper.selectByExample(wxUserExample);
        if (!CollectionUtils.isEmpty(wxUsers)) {
            return wxUsers.get(0);
        }
        return null;
    }

    public void test() {
        WxUserExample example = new WxUserExample();
        List<WxUser> wxUsers = wxUserMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(wxUsers)){
            for (int i=0; i < wxUsers.size(); ++i ){
                WxUser eachUser = wxUsers.get(i);
                DecimalFormat df = new DecimalFormat("8000000000");
                String dd = df.format(eachUser.getId());
                eachUser.setAccount(dd);
                wxUserMapper.updateByPrimaryKeySelective(eachUser);
            }
        }
    }
}
