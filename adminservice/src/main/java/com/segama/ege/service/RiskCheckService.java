package com.segama.ege.service;

import com.segama.ege.domain.WxUserTypeEnum;
import com.segama.ege.entity.WxUser;
import com.segama.ege.repository.WxUserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RiskCheckService {

    @Resource
    private WxUserMapper userMapper;

    public boolean checkCarUserHaveRisk(WxUser wxUser){
        if(wxUser.getUser_type().equals(WxUserTypeEnum.black_list.getCode())){
            return true;
        }

        return false;
    }
}
