package com.segama.ege.shopadmin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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
@RequestMapping("/ege/api/shop_admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopUserLoginController {
    @Resource
    private ShopAdminUserMapper shopAdminUserMapper;

    @Resource
    private ShopAdminUserRoleRelationMapper shopAdminUserRoleRelationMapper;

    @Resource
    private ShopAdminRoleMenuRelationMapper shopAdminRoleMenuRelationMapper;

    @Resource
    private ShopAdminMenuMapper shopAdminMenuMapper;

    @Resource
    private ShopAdminRoleMapper shopAdminRoleMapper;

    @Resource
    private ShopMapper shopMapper;


    private static Logger LOG = LoggerFactory.getLogger(ShopUserLoginController.class);

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
                ShopAdminUserExample adminUserExample = new ShopAdminUserExample();
                ShopAdminUserExample.Criteria criteria = adminUserExample.createCriteria();
                criteria.andPasswordEqualTo(password);
                criteria.andAccountEqualTo(account);
                List<ShopAdminUser> adminUsers = shopAdminUserMapper.selectByExample(adminUserExample);
                if(!CollectionUtils.isEmpty(adminUsers)){
                    ShopAdminUser adminUser = adminUsers.get(0);
                    loginVO.setStatus(200);
                    String uuid = UUID();
                    loginVO.setToken(uuid);
                    loginVO.setData(adminUser.getShop_id());
                    loginVO.setShop_user_id(adminUser.getId());
                    loginVO.setAccount(adminUser.getAccount());
                    Shop shop = shopMapper.selectByPrimaryKey(adminUser.getShop_id());
                    loginVO.setShopName(shop.getEnterprise_name());
                    adminUser.setToken(uuid);
                    Date now = new Date();
                    Date expireTime = DateUtils.addHours(now, 168);
                    adminUser.setExpire_time(expireTime);
                    shopAdminUserMapper.updateByPrimaryKey(adminUser);
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
        LinkedList<MainMenuVO> mainMenus = Lists.newLinkedList();
        baseVO.setData(menuMap);
        try {
            ShopAdminUserExample adminUserExample = new ShopAdminUserExample();
            ShopAdminUserExample.Criteria criteria = adminUserExample.createCriteria();
            if(StringUtils.isEmpty(token)){
                baseVO.setSuccess(false);
                return baseVO;
            }
            criteria.andTokenEqualTo(token);
            //查询失效时间大于当前时间的数据
            criteria.andExpire_timeGreaterThan(new Date());
            List<ShopAdminUser> adminUsers = shopAdminUserMapper.selectByExample(adminUserExample);
            if(CollectionUtils.isEmpty(adminUsers)) {
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("数据为空！");
                return baseVO;
            }
            ShopAdminUser adminUser = adminUsers.get(0);

            List<Long> roleIds = Lists.newArrayList();
            /*查询用户角色关系表*/
            ShopAdminUserRoleRelationExample adminUserRoleRelationExample = new ShopAdminUserRoleRelationExample();
            ShopAdminUserRoleRelationExample.Criteria criteria2 = adminUserRoleRelationExample.createCriteria();
            criteria2.andUser_idEqualTo(adminUser.getId());
            criteria2.andShop_idEqualTo(adminUser.getShop_id());
            List<ShopAdminUserRoleRelation> adminUserRoleRelations = shopAdminUserRoleRelationMapper.selectByExample(adminUserRoleRelationExample);
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
                ShopAdminRoleMenuRelationExample adminRoleMenuRelationE = new ShopAdminRoleMenuRelationExample();
                ShopAdminRoleMenuRelationExample.Criteria criteria1 = adminRoleMenuRelationE.createCriteria();
                criteria1.andRole_idIn(roleIds);

                //查询角色表，如果当前登录人包含管理员角色, 如果有新增的菜单菜单，都添加一下
                ShopAdminRoleExample adminRoleExample = new ShopAdminRoleExample();
                ShopAdminRoleExample.Criteria criteria3 = adminRoleExample.createCriteria();
                criteria3.andIdIn(roleIds);
                List<ShopAdminRole> shopAdminRoles = shopAdminRoleMapper.selectByExample(adminRoleExample);
                if(!CollectionUtils.isEmpty(shopAdminRoles)) {
                    List<ShopAdminRole> collect1 = shopAdminRoles
                            .stream()
                            .filter(e -> {
                                return "【超级管理员】".equals(e.getRole_name());
                            }).collect(Collectors.toList());

                    if (!CollectionUtils.isEmpty(collect1)) {
                        //查询所有菜单信息
                        List<ShopAdminMenu> shopAdminMenus = shopAdminMenuMapper.selectByExample(new ShopAdminMenuExample());
                        ShopAdminRoleMenuRelationExample exampleRoleMenu = new ShopAdminRoleMenuRelationExample();
                        ShopAdminRoleMenuRelationExample.Criteria criteria4 = exampleRoleMenu.createCriteria();
                        criteria4.andShop_idEqualTo(adminUser.getShop_id());
                        criteria4.andRole_idEqualTo(collect1.get(0).getId());

                        List<ShopAdminRoleMenuRelation> shopAdminRoleMenuRelations = shopAdminRoleMenuRelationMapper.selectByExample(exampleRoleMenu);
                        Map<String, List<ShopAdminRoleMenuRelation>> collect =
                                shopAdminRoleMenuRelations.stream()
                                        .collect((Collectors.groupingBy(ShopAdminRoleMenuRelation::getMenu_name)));
                        //增量新增菜单
                        for (ShopAdminMenu shopAdminMenu : shopAdminMenus) {
                            List<ShopAdminRoleMenuRelation> shopAdminRoleMenuRelations1 = collect.get(shopAdminMenu.getMenu_name());
                            if (CollectionUtils.isEmpty(shopAdminRoleMenuRelations1)) {
                                ShopAdminRoleMenuRelationExample example =new ShopAdminRoleMenuRelationExample();
                                ShopAdminRoleMenuRelationExample.Criteria criteria5 = example.createCriteria();
                                criteria5.andShop_idEqualTo(adminUser.getShop_id());
                                criteria5.andMenu_idEqualTo(shopAdminMenu.getId());
                                List<ShopAdminRoleMenuRelation> relations =
                                        shopAdminRoleMenuRelationMapper.selectByExample(example);
                                if(!CollectionUtils.isEmpty(relations)){
                                    ShopAdminRoleMenuRelation rela = relations.get(0);
                                    rela.setMenu_name(shopAdminMenu.getMenu_name());
                                    shopAdminRoleMenuRelationMapper.updateByPrimaryKey(rela);
                                }else {

                                    ShopAdminRoleMenuRelation record = new ShopAdminRoleMenuRelation();
                                    record.setShop_id(adminUser.getShop_id());
                                    record.setMenu_name(shopAdminMenu.getMenu_name());
                                    record.setMenu_id(shopAdminMenu.getId());
                                    record.setRole_name(collect1.get(0).getRole_name());
                                    record.setRole_id(collect1.get(0).getId());
                                    record.setGmt_modify(new Date());
                                    record.setGmt_create(new Date());
                                    record.setModifier_account("sys");
                                    record.setCreator_account("sys");
                                    record.setVersion(0);
                                    record.setDescription("平台管理员创建");
                                    shopAdminRoleMenuRelationMapper.insert(record);
                                }
                            }
                        }
                    }
                }

                List<ShopAdminRoleMenuRelation> adminRoleMenuRelations = shopAdminRoleMenuRelationMapper.selectByExample(adminRoleMenuRelationE);
                if(!CollectionUtils.isEmpty(adminRoleMenuRelations)){
                    menuIds.addAll(adminRoleMenuRelations.stream().map(e -> e.getMenu_id()).collect(Collectors.toSet()));
                }
            }

            if(!CollectionUtils.isEmpty(menuIds)){
                ShopAdminMenuExample adminMenuExample = new ShopAdminMenuExample();
                ShopAdminMenuExample.Criteria adminMenuExampleCriteria = adminMenuExample.createCriteria();
                adminMenuExampleCriteria.andIdIn(menuIds.stream().collect(Collectors.toList()));
                List<ShopAdminMenu> adminMenus = shopAdminMenuMapper.selectByExample(adminMenuExample);
                //按照主菜单分组之后的子菜单
                Map<String,List<ShopAdminMenu>> menuMapGroup = adminMenus.stream().collect(Collectors.groupingBy(ShopAdminMenu::getGroup));
                for (Map.Entry<String, List<ShopAdminMenu>> stringListEntry : menuMapGroup.entrySet()) {
                    MainMenuVO mainMenuVO  = new MainMenuVO();
                    mainMenuVO.setText(stringListEntry.getKey());
                    List<SubMenuVO> subMenus = Lists.newArrayList();
                    for (ShopAdminMenu adminMenu : stringListEntry.getValue()) {
                        SubMenuVO subMenu = new SubMenuVO();
                        subMenu.setHref(adminMenu.getUrl());
                        subMenu.setText(adminMenu.getMenu_name());
                        subMenus.add(subMenu);
                    }
                    mainMenuVO.setSubset(subMenus);
                    mainMenus.add(mainMenuVO);
                }
            }
            //将基本信息添加到第一个
            MainMenuVO mainMenuVO = new MainMenuVO();
            mainMenuVO.setText("基本信息管理");
            List<SubMenuVO> subset = Lists.newArrayList();
            SubMenuVO subMenuVO = new SubMenuVO();
            subMenuVO.setHref("app/user_info_detail/manage.html");
            subMenuVO.setText("基本信息");
            subset.add(subMenuVO);
            mainMenuVO.setSubset(subset);

            mainMenus.addFirst(mainMenuVO);
            baseVO.setData(mainMenus);
            baseVO.setSuccess(true);

        } catch (Exception e) {
            LOG.error("ShopUserLoginController error",e);
            baseVO.setErrorMsg("system error!");
        }
        return baseVO;
    }

    @RequestMapping("/login/loginCheck")
    public Object loginCheck(){
        BaseVO baseVO = new BaseVO();
        baseVO.setSuccess(true);
        return baseVO;
    }

}
