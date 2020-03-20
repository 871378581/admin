package com.segama.ege.resource;

import com.segama.ege.entity.WxUser;
import com.segama.ege.entity.WxUserExample;
import com.segama.ege.exception.NotLoginException;
import com.segama.ege.repository.WxUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

public class BaseController {
    @Resource
    private WxUserMapper wxUserMapper;

    protected WxUser resolveCurrentLoginUser(String user_id) throws NotLoginException {
        if (StringUtils.isNotEmpty(user_id) && !user_id.equals("none")){
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andToken_idEqualTo(user_id);
            List<WxUser> wxUsers = wxUserMapper.selectByExample(wxUserExample);
            if (!CollectionUtils.isEmpty(wxUsers)) {
                return wxUsers.get(0);
            }else{
                wxUserExample = new WxUserExample();
                wxUserExample.createCriteria().andUser_idEqualTo(user_id);
                wxUsers = wxUserMapper.selectByExample(wxUserExample);
                if (!CollectionUtils.isEmpty(wxUsers)) {
                    return wxUsers.get(0);
                }
            }
        }
        throw new NotLoginException();
    }
}
