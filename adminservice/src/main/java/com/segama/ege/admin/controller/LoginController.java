package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.segama.ege.admin.constants.IconEnum;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.LoginVO;
import com.segama.ege.admin.vo.MainMenuVO;
import com.segama.ege.admin.vo.SubMenuVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.*;
import java.util.stream.Collectors;

import static com.segama.ege.admin.constants.AdminConstants.SYS_ERR;
import static com.segama.ege.admin.utils.UUIDUtils.UUID;

/**
 * @author hxj
 * @version 1.0
 * @Description 登录相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {
    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Resource
    private AdminMenuMapper adminMenuMapper;

    @Resource
    private AdminMenuGroupMapper adminMenuGroupMapper;

    @Resource
    private AdminUserRoleRelationMapper adminUserRoleRelationMapper;

    @Resource
    private AdminRoleMenuRelationMapper adminRoleMenuRelationMapper;

    private static Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login/signIn")
    public Object signIn(@RequestParam("account") String account,
                         @RequestParam("password") String password){
        LoginVO loginVO= new LoginVO();
        try {
            loginVO.setSuccess(Boolean.TRUE);
            if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
                loginVO.setErrorMsg("用户名和密码不能为空！");
                loginVO.setStatus(401);
            }else {
                AdminUserExample adminUserExample = new AdminUserExample();
                AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
                criteria.andPasswordEqualTo(password);
                criteria.andAccountEqualTo(account);
                List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
                if(!CollectionUtils.isEmpty(adminUsers)){
                    AdminUser adminUser = adminUsers.get(0);
                    if(adminUser.getStatus()==0){
                        loginVO.setErrorMsg("账户状态无效！");
                        loginVO.setStatus(401);
                    }else {
                        loginVO.setStatus(200);
                        String uuid = UUID();
                        loginVO.setToken(uuid);
                        loginVO.setData(adminUser.getChannel_type());
                        loginVO.setAccount(adminUser.getAccount());
                        adminUser.setToken(uuid);
                        Date now = new Date();
                        Date expireTime = DateUtils.addHours(now, 168);
                        adminUser.setExpire_time(expireTime);
                        loginVO.setId(adminUser.getId());
                        adminUserMapper.updateByPrimaryKey(adminUser);
                    }
                }else{
                    loginVO.setErrorMsg("用户名或密码错误！");
                    loginVO.setStatus(401);
                }
            }
        } catch (Exception e) {
            loginVO.setStatus(500);
            loginVO.setErrorMsg(SYS_ERR);
            loginVO.setSuccess(Boolean.FALSE);
        }
        return loginVO;
    }

    @RequestMapping("/login/menu")
    public BaseVO menu(@RequestParam("token") String token) {
        BaseVO baseVO = new BaseVO();
        Map<String,List<MainMenuVO>> menuMap = Maps.newHashMap();
        List<MainMenuVO> mainMenus = Lists.newArrayList();
        baseVO.setData(menuMap);
        try {
            AdminUserExample adminUserExample = new AdminUserExample();
            AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
            if(StringUtils.isEmpty(token)){
                baseVO.setSuccess(false);
                return baseVO;
            }
            criteria.andTokenEqualTo(token);
            //查询失效时间大于当前时间的数据
            criteria.andExpire_timeGreaterThan(new Date());
            List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
            if(CollectionUtils.isEmpty(adminUsers)) {
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("数据为空！");
                return baseVO;
            }
            AdminUser adminUser = adminUsers.get(0);

            List<Long> roleIds = Lists.newArrayList();
            /*查询用户角色关系表*/
            AdminUserRoleRelationExample adminUserRoleRelationExample = new AdminUserRoleRelationExample();
            AdminUserRoleRelationExample.Criteria criteria2 = adminUserRoleRelationExample.createCriteria();
            criteria2.andUser_idEqualTo(adminUser.getId());
            List<AdminUserRoleRelation> adminUserRoleRelations = adminUserRoleRelationMapper.selectByExample(adminUserRoleRelationExample);
            if(!CollectionUtils.isEmpty(adminUserRoleRelations)){
                roleIds.addAll(
                        adminUserRoleRelations
                                .stream()
                                .map(e -> e.getRole_id())
                                .collect(Collectors.toList())
                        );
            }

            //获取去重后的菜单id
            Set<Long> menuIds = Sets.newHashSet();
            if(!CollectionUtils.isEmpty(roleIds)){
                AdminRoleMenuRelationExample adminRoleMenuRelationE = new AdminRoleMenuRelationExample();
                AdminRoleMenuRelationExample.Criteria criteria1 = adminRoleMenuRelationE.createCriteria();
                criteria1.andRole_idIn(roleIds);
                List<AdminRoleMenuRelation> adminRoleMenuRelations = adminRoleMenuRelationMapper.selectByExample(adminRoleMenuRelationE);
                if(!CollectionUtils.isEmpty(adminRoleMenuRelations)){
                    menuIds.addAll(adminRoleMenuRelations.stream().map(e -> e.getMenu_id()).collect(Collectors.toSet()));
                }
            }

            if(!CollectionUtils.isEmpty(menuIds)){
                AdminMenuExample adminMenuExample = new AdminMenuExample();
                AdminMenuExample.Criteria adminMenuExampleCriteria = adminMenuExample.createCriteria();
                adminMenuExampleCriteria.andIdIn(menuIds.stream().collect(Collectors.toList()));
                List<AdminMenu> adminMenus = adminMenuMapper.selectByExample(adminMenuExample);
                //按照主菜单分组之后的子菜单
                Map<String,List<AdminMenu>> menuMapGroup = adminMenus.stream().collect(Collectors.groupingBy(AdminMenu::getGroup));
                for (Map.Entry<String, List<AdminMenu>> stringListEntry : menuMapGroup.entrySet()) {
                    MainMenuVO mainMenuVO  = new MainMenuVO();
                    mainMenuVO.setText(stringListEntry.getKey());

                    AdminMenuGroupExample example = new AdminMenuGroupExample();
                    AdminMenuGroupExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andGroupEqualTo(stringListEntry.getKey());
                    List<AdminMenuGroup> adminMenuGroups = adminMenuGroupMapper.selectByExample(example);

                    if(!CollectionUtils.isEmpty(adminMenuGroups)&&!StringUtils.isEmpty(adminMenuGroups.get(0).getIcon())){
                        mainMenuVO.setIcon(IconEnum.getCode(Integer.valueOf(adminMenuGroups.get(0).getIcon())));
                    }
                    List<SubMenuVO> subMenus = Lists.newArrayList();
                    for (AdminMenu adminMenu : stringListEntry.getValue()) {
                        SubMenuVO subMenu = new SubMenuVO();
                        subMenu.setHref(adminMenu.getUrl());
                        subMenu.setText(adminMenu.getMenu_name());
                        if(!StringUtils.isEmpty(adminMenu.getIcon())){
                            subMenu.setIcon(IconEnum.getCode(Integer.valueOf(adminMenu.getIcon())));
                        }
                        subMenus.add(subMenu);
                    }
                    mainMenuVO.setSubset(subMenus);
                    mainMenus.add(mainMenuVO);
                }
            }
            if(!CollectionUtils.isEmpty(mainMenus)){
                Collections.sort(mainMenus, new Comparator<MainMenuVO>() {
                    @Override
                    public int compare(MainMenuVO vo1, MainMenuVO vo2) {
                        try {
                            AdminMenuGroupExample example = new AdminMenuGroupExample();
                            AdminMenuGroupExample.Criteria criteria1 = example.createCriteria();
                            criteria1.andGroupEqualTo(vo1.getText());
                            List<AdminMenuGroup> adminMenuGroups = adminMenuGroupMapper.selectByExample(example);

                            AdminMenuGroupExample example2 = new AdminMenuGroupExample();
                            AdminMenuGroupExample.Criteria criteria2 = example2.createCriteria();
                            criteria2.andGroupEqualTo(vo2.getText());
                            List<AdminMenuGroup> adminMenuGroups2 = adminMenuGroupMapper.selectByExample(example2);
                            if(!CollectionUtils.isEmpty(adminMenuGroups) && !CollectionUtils.isEmpty(adminMenuGroups2)){
                               return adminMenuGroups.get(0).getSort().intValue() - adminMenuGroups2.get(0).getSort().intValue();
                            }

                        } catch (Exception e) {
                            LOG.error("loginController error",e);
                        }
                        return 0;
                    }
                });
            }
            baseVO.setData(mainMenus);
            baseVO.setSuccess(true);

        } catch (Exception e) {
            LOG.error("LoginController error",e);
            baseVO.setErrorMsg("system error!");
        }
        return baseVO;
    }

    @RequestMapping("/login/show")
    public Object select(){
        AdminUserExample adminUserExample = new AdminUserExample();
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
        return adminUsers;
    }

    @RequestMapping("/login/loginCheck")
    public Object loginCheck(){
        BaseVO baseVO = new BaseVO();
        baseVO.setSuccess(true);
        return baseVO;
    }
}
