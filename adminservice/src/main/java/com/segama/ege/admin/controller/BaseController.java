package com.segama.ege.admin.controller;

import com.segama.ege.entity.AdminSystemConfig;
import com.segama.ege.entity.AdminSystemConfigExample;
import com.segama.ege.repository.AdminSystemConfigMapper;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2020-03-28 02:05
 */
public class BaseController {

    @Resource
    AdminSystemConfigMapper adminSystemConfigMapper;

    //展示所有用户
    private Boolean showAllUser(String ownAccount){
        AdminSystemConfigExample example = new AdminSystemConfigExample();
        AdminSystemConfigExample.Criteria criteria = example.createCriteria();
        // TODO 展示所有用户配置项
        criteria.andKeyEqualTo("showAllUserAccounts");
        List<AdminSystemConfig> adminSystemConfigs = adminSystemConfigMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(adminSystemConfigs)) {
            AdminSystemConfig adminSystemConfig = adminSystemConfigs.get(0);
            String value = adminSystemConfig.getValue();
            String[] split = value.split(",");
            for (String s : split) {
                if(ownAccount.equals(s)){
                    return true;
                }
            }
        }
        return false;
    }

    Set<Long> getMenuConfig(String key){
        Set<Long> menuId= new HashSet<>();
        try {
            AdminSystemConfigExample example = new AdminSystemConfigExample();
            AdminSystemConfigExample.Criteria criteria = example.createCriteria();
            criteria.andKeyEqualTo(key);
            List<AdminSystemConfig> adminSystemConfigs = adminSystemConfigMapper.selectByExample(example);
            AdminSystemConfig adminSystemConfig = adminSystemConfigs.get(0);
            String[] split = adminSystemConfig.getValue().split(",");
            for (String s : split) {
                menuId.add(Long.valueOf(s));
            }
        } catch (Exception e) {
            throw new RuntimeException("获取默认菜单配置异常！");
        }
        return menuId;
    }
}
