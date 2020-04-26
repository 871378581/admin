package com.segama.ege.admin.controller;

import com.segama.ege.entity.AdminSystemConfig;
import com.segama.ege.entity.AdminSystemConfigExample;
import com.segama.ege.entity.AdminUserRoleRelation;
import com.segama.ege.entity.AdminUserRoleRelationExample;
import com.segama.ege.repository.AdminRoleMapper;
import com.segama.ege.repository.AdminSystemConfigMapper;
import com.segama.ege.repository.AdminUserRoleRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2020-03-28 02:05
 */
public class BaseController {

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpServletRequest request;

    /**
     * 模版链接key
     */
    public static String TEMPALTE_URL_KEY="tempalte_url_key";

    //展示所有用户信息，用于后台管理员获取所有数据 配置的是一个后台超级管理员id
    public static String SHOW_ALL_USER_ROLE_ID_KEY="show_all_user_role_id_key";

    @Resource
    AdminSystemConfigMapper adminSystemConfigMapper;

    @Resource
    AdminUserRoleRelationMapper adminUserRoleRelationMapper;

    //展示所有用户
    public Boolean showAllUser(String ownAccount){
        if("admin".equals(ownAccount)){
            return true;
        }
        AdminSystemConfigExample example = new AdminSystemConfigExample();
        AdminSystemConfigExample.Criteria criteria = example.createCriteria();
        // TODO 展示所有用户配置项
        criteria.andKeyEqualTo(SHOW_ALL_USER_ROLE_ID_KEY);

        //根据账号查询该账号有哪些权限
        AdminUserRoleRelationExample example1 = new AdminUserRoleRelationExample();
        example1.createCriteria().andAccountEqualTo(ownAccount);
        List<AdminUserRoleRelation> adminUserRoleRelations = adminUserRoleRelationMapper.selectByExample(example1);

        List<AdminSystemConfig> adminSystemConfigs = adminSystemConfigMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(adminSystemConfigs)) {
            AdminSystemConfig adminSystemConfig = adminSystemConfigs.get(0);
            String value = adminSystemConfig.getValue();
            if(StringUtils.isEmpty(value)){
                throw new RuntimeException("SHOW_ALL_USER_ROLE_ID_KEY 未配置");
            }
            for (AdminUserRoleRelation roleRelation : adminUserRoleRelations) {
                if(roleRelation.getRole_id().equals(Long.valueOf(value))){
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

    /**
     * 获取配置
     * @param key
     * @return
     */
    public String getConfig(String key){
        AdminSystemConfigExample example = new AdminSystemConfigExample();
        AdminSystemConfigExample.Criteria criteria = example.createCriteria();
        criteria.andKeyEqualTo(key);
        List<AdminSystemConfig> adminSystemConfigs = adminSystemConfigMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(adminSystemConfigs)) {
            AdminSystemConfig adminSystemConfig = adminSystemConfigs.get(0);
            return adminSystemConfig.getValue();
        }
        return "";
    }

    public Map<String, List<AdminSystemConfig>> getConfig(List<String> keys){
        AdminSystemConfigExample example = new AdminSystemConfigExample();
        AdminSystemConfigExample.Criteria criteria = example.createCriteria();
        criteria.andKeyIn(keys);
        List<AdminSystemConfig> adminSystemConfigs = adminSystemConfigMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(adminSystemConfigs)) {
            return adminSystemConfigs.stream().collect(Collectors.groupingBy(AdminSystemConfig::getKey));
        }
        return null;
    }
}
