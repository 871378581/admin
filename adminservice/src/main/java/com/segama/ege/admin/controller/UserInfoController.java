package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.AdminSystemConfig;
import com.segama.ege.entity.AdminSystemConfigExample;
import com.segama.ege.entity.AdminUser;
import com.segama.ege.entity.AdminUserExample;
import com.segama.ege.repository.AdminSystemConfigMapper;
import com.segama.ege.repository.AdminUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hxj
 * @version 1.0
 * @Description 登录相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserInfoController {
    
    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminSystemConfigMapper adminSystemConfigMapper;

    private static Logger LOG = LoggerFactory.getLogger(UserInfoController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "account" ,required = false) String account
            ,@RequestParam(value = "ownAccount" ,required = false) String ownAccount
            ,@RequestParam(value = "contacter_phone" ,required = false) String contacter_phone
            ,@RequestParam(value = "channel_type" ,required = false) Integer channel_type
            ,@RequestParam(value = "limit",required = false) Integer pageSize,
            @RequestParam(value = "page",required = false) Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            AdminUserExample adminRoleExample = new AdminUserExample();
            adminRoleExample.setOrderByClause("gmt_create desc");
            AdminUserExample.Criteria adminRoleExampleCriteria = adminRoleExample.createCriteria();
            if(StringUtils.isNotEmpty(account)) {
                adminRoleExampleCriteria.andAccountLike("%" + account + "%");
            }
            if(!showAllUser(ownAccount) && StringUtils.isNotEmpty(ownAccount)) {
                adminRoleExampleCriteria.andCreator_accountEqualTo(ownAccount);
            }
            if(StringUtils.isNotEmpty(contacter_phone)) {
                adminRoleExampleCriteria.andContacter_phoneLike("%" + contacter_phone + "%");
            }
            if(channel_type!=null) {
                adminRoleExampleCriteria.andChannel_typeEqualTo(channel_type);
            }
            int count = adminUserMapper.countByExample(adminRoleExample);
            List<AdminUser> collect = Lists.newArrayList();
            if(count!=0) {
                adminRoleExample.setPageCount(pageSize);
                adminRoleExample.setPageIndex(pageIndex);
                List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminRoleExample);
                collect = adminUsers.stream().filter(e -> !"admin".equals(e.getAccount())).collect(Collectors.toList());

            }
            baseVO.setData(collect);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("AdminUserController#list error",e);
        }
        return baseVO;
    }

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

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id ,@RequestParam("account") String account ) {
        BaseVO baseVO = new BaseVO();
        if(id == null || StringUtils.isEmpty(account)){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能删除！");
        }else {
            if("admin".equals(account)){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("该账号不允许删除");
            }
            adminUserMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("editAccount") String editAccount,
                    @RequestParam("password") String password) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null || StringUtils.isEmpty(password)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            AdminUser adminRole = adminUserMapper.selectByPrimaryKey(id);
            if(!StringUtils.isEmpty(password)){
                adminRole.setPassword(password);
            }
            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(editAccount);
            adminUserMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("AdminUserController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/edit_user")
    public BaseVO edit_user(AdminUser adminRoleNew,
                       @RequestParam("editAccount") String editAccount) {
        BaseVO baseVO = new BaseVO();
        try {
            if(adminRoleNew.getId()==null || StringUtils.isEmpty(adminRoleNew.getPassword())){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            if(adminRoleNew.getChannel_type()==1 && !showAllUser(editAccount)){
                baseVO.setErrorMsg("您暂时没有权限将渠道类型设置为A！");
                baseVO.setSuccess(false);
                return baseVO;
            }

            AdminUser adminRole = adminUserMapper.selectByPrimaryKey(adminRoleNew.getId());
            if(adminRoleNew.getChannel_type()==1){
                adminRole.setParent_account(null);
            }

            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(editAccount);
            if(adminRoleNew.getChannel_type()==1){
                adminRoleNew.setParent_account(null);
            }
            BeanUtils.copyProperties(adminRoleNew,adminRole);
            adminUserMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("AdminUserController#edit error",e);
            String msg = "";
            if(StringUtils.isNotEmpty(e.getMessage())&&e.getMessage().contains("Duplicate")){
                msg="请勿重复添加！";
            }
            baseVO.setErrorMsg("编辑异常，"+msg);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(AdminUser adminUser,
            @RequestParam("editAccount") String editAccount) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(adminUser.getAccount())|| StringUtils.isEmpty(adminUser.getPassword())){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            if(adminUser.getChannel_type()==1 && !showAllUser(editAccount)){
                baseVO.setErrorMsg("您暂时没有权限将渠道类型设置为A！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            adminUser.setCreator_account(editAccount);
            adminUser.setModifier_account(editAccount);
            adminUser.setVersion(0);
            adminUser.setChannel_code(UUIDUtils.UUID());
            adminUser.setGmt_create(new Date());
            adminUser.setGmt_modify(new Date());
            if(adminUser.getChannel_type()==1){
                adminUser.setParent_account(null);
            }
            adminUserMapper.insert(adminUser);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminUserController#add error",e);
            String msg = "";
            if(StringUtils.isNotEmpty(e.getMessage())&&e.getMessage().contains("Duplicate")){
                msg="请勿重复添加！";
            }
            baseVO.setErrorMsg("添加异常，"+msg);
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id == null){
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            }else {
                AdminUser adminUser = adminUserMapper.selectByPrimaryKey(id);
                baseVO.setData(adminUser);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminUserController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询用户信息信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_user")
    public BaseVO getAllMenu() {
        BaseVO baseVO = new BaseVO();
        try {
            List<AdminUser> adminUsers = adminUserMapper.selectByExample(new AdminUserExample());
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(adminUsers)){
                for (AdminUser adminUser : adminUsers) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",adminUser.getAccount());
                    map.put("value",adminUser.getId());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminUserController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询用户信息信息异常！");
        }
        return baseVO;
    }

    //查询所有A 如果是允许的账户可以展示所有的A 否则只展示自己
    @RequestMapping("/get_all_usersA")
    public BaseVO getAllUsers(@RequestParam(value = "account",required = false) String account ) {
        BaseVO baseVO = new BaseVO();
        try {
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!StringUtils.isEmpty(account) && !showAllUser(account)){

                AdminUserExample adminUserExample = new AdminUserExample();
                AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
                criteria.andAccountEqualTo(account);
                List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
                if(!CollectionUtils.isEmpty(adminUsers)){
                    AdminUser adminUser = adminUsers.get(0);
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",adminUser.getChannel_name());
                    map.put("value",account);
                    result.add(map);
                }

            }else {
                AdminUserExample adminUserExample = new AdminUserExample();
                AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
                criteria.andChannel_typeEqualTo(1);
                List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);

                if (!CollectionUtils.isEmpty(adminUsers)) {
                    for (AdminUser adminUser : adminUsers) {
                        Map<String, Object> map = Maps.newHashMap();
                        map.put("label", adminUser.getChannel_name());
                        map.put("value", adminUser.getAccount());
                        result.add(map);
                    }
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminUserController#getAllUsers error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询用户信息信息异常！");
        }
        return baseVO;
    }



    //查询所有A 如果是允许的账户可以展示所有的A 否则只展示自己
    @RequestMapping("/get_all_users_of_A")
    public BaseVO getAllUsersAA() {
        BaseVO baseVO = new BaseVO();
        try {
            List<Map<String,Object>> result = Lists.newArrayList();

            AdminUserExample adminUserExample = new AdminUserExample();
            AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
            criteria.andChannel_typeEqualTo(1);
            List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);

            if (!CollectionUtils.isEmpty(adminUsers)) {
                for (AdminUser adminUser : adminUsers) {
                    Map<String, Object> map = Maps.newHashMap();
                    map.put("label", adminUser.getChannel_name());
                    map.put("value", adminUser.getAccount());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminUserController#getAllUsers error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询用户信息信息异常！");
        }
        return baseVO;
    }

}
