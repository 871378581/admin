package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.ShopAdminUserVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hxj
 * @version 1.0
 * @Description 门店管理员管理的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/shop_user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopAdminUserController {
    
    @Resource
    private ShopAdminUserMapper shopAdminUserMapper;

    @Resource
    private ShopAdminRoleMapper shopAdminRoleMapper;

    @Resource
    private ShopAdminUserRoleRelationMapper shopAdminUserRoleRelationMapper;

    @Resource
    private ShopAdminRoleMenuRelationMapper shopAdminRoleMenuRelationMapper;

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private ShopAdminMenuMapper shopAdminMenuMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopAdminUserController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("account") String account
            ,@RequestParam(value = "shopId" ,required = false) Long shopId
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ShopAdminUserExample adminRoleExample = new ShopAdminUserExample();
            ShopAdminUserExample.Criteria criteria = adminRoleExample.createCriteria();
            if(StringUtils.isNotEmpty(account)) {
                criteria.andAccountLike("%" + account + "%");
            }
            if(shopId !=null){
                criteria.andShop_idEqualTo(shopId);
            }

            //0表示管理员 -1表示其他
            criteria.andRole_typeEqualTo("0");
            int count = shopAdminUserMapper.countByExample(adminRoleExample);
            List<ShopAdminUserVO> shopAdminUserVOS = new ArrayList<>();
            if(count!=0) {
                adminRoleExample.setPageCount(pageSize);
                adminRoleExample.setPageIndex(pageIndex);
                adminRoleExample.setOrderByClause("gmt_create desc");

                List<ShopAdminUser> shopAdminUsers = shopAdminUserMapper.selectByExample(adminRoleExample);

                if(!CollectionUtils.isEmpty(shopAdminUsers)){
                    List<ShopAdminUserVO> collect = shopAdminUsers.stream().map(user -> {
                        Shop shop = shopMapper.selectByPrimaryKey(user.getShop_id());
                        ShopAdminUserVO shopAdminUserVO = new ShopAdminUserVO();
                        BeanUtils.copyProperties(user, shopAdminUserVO);
                        if (shop != null) {
                            shopAdminUserVO.setShopName(shop.getEnterprise_name());
                        }
                        return shopAdminUserVO;
                    }).collect(Collectors.toList());
                    if(!CollectionUtils.isEmpty(collect)){
                        shopAdminUserVOS.addAll(collect);
                    }
                }
                baseVO.setData(shopAdminUserVOS);
                baseVO.setSuccess(true);
            }
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ShopAdminUserController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/shopList")
    public BaseVO getShopList(
            @RequestParam("shopName") String shopName) {
        BaseVO baseVO = new BaseVO();
        try {
            ShopExample example = new ShopExample();
            ShopExample.Criteria criteria = example.createCriteria();
            criteria.andEnterprise_nameLike("%"+shopName+"%");
            example.setPageIndex(1);
            example.setPageCount(50);
            List<Shop> shops = shopMapper.selectByExample(example);
            if(CollectionUtils.isEmpty(shops)){
                baseVO.setData(Lists.newArrayList());
            }else{
                baseVO.setData(shops);
            }
            baseVO.setSuccess(true);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ShopAdminUserController#getShopList error",e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id ,@RequestParam("account") String account ) {
        BaseVO baseVO = new BaseVO();
        if(id == null || StringUtils.isEmpty(account)){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能删除！");
        }else {
            shopAdminUserMapper.deleteByPrimaryKey(id);
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
            ShopAdminUser adminRole = shopAdminUserMapper.selectByPrimaryKey(id);
            if(!StringUtils.isEmpty(password)){
                adminRole.setPassword(password);
            }
            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(editAccount);
            shopAdminUserMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopAdminUserController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
            @RequestParam("editAccount") String editAccount,
            @RequestParam("role_type") String role_type,
            @RequestParam("shop_id") Long shop_id,
            @RequestParam("account") String account,
            @RequestParam("password") String password) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(account)|| StringUtils.isEmpty(password)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopAdminRoleExample example = new ShopAdminRoleExample();
            ShopAdminRoleExample.Criteria criteria = example.createCriteria();
            criteria.andShop_idEqualTo(shop_id);
            criteria.andRole_nameEqualTo("【超级管理员】");
            List<ShopAdminRole> shopAdminRoles = shopAdminRoleMapper.selectByExample(example);
            if(CollectionUtils.isEmpty(shopAdminRoles)){
                ShopAdminRole shopAdminRole = new ShopAdminRole();
                shopAdminRole.setShop_id(shop_id);
                shopAdminRole.setDescription("平台管理员创建");
                shopAdminRole.setGmt_modify(new Date());
                shopAdminRole.setCreator_account(editAccount);
                shopAdminRole.setVersion(0);
                shopAdminRole.setGmt_create(new Date());
                shopAdminRole.setRole_name("【超级管理员】");
                shopAdminRole.setModifier_account(editAccount);
                shopAdminRoleMapper.insert(shopAdminRole);
            }
            ShopAdminUser shopAdminUser = new ShopAdminUser();
            if(!StringUtils.isEmpty(account)){
                shopAdminUser.setAccount(account);
            }
            if(!StringUtils.isEmpty(password)){
                shopAdminUser.setPassword(password);
            }
            if(!StringUtils.isEmpty(role_type)){
                shopAdminUser.setRole_type(role_type);
            }
            if(shop_id!=null){
                shopAdminUser.setShop_id(shop_id);
            }
            shopAdminUser.setCreator_account(editAccount);
            shopAdminUser.setModifier_account(editAccount);
            shopAdminUser.setVersion(0);
            shopAdminUser.setGmt_create(new Date());
            shopAdminUser.setGmt_modify(new Date());
            shopAdminUserMapper.insert(shopAdminUser);

            //查询刚才创建的用户id
            ShopAdminUserExample userExample = new ShopAdminUserExample();
            ShopAdminUserExample.Criteria criteria1 = userExample.createCriteria();
            criteria1.andShop_idEqualTo(shop_id);
            criteria1.andAccountEqualTo(account);
            List<ShopAdminUser> shopAdminUsers = shopAdminUserMapper.selectByExample(userExample);
            if(!CollectionUtils.isEmpty(shopAdminUsers)){
                ShopAdminUser shopAdminUser1 = shopAdminUsers.get(0);
                Long userId = shopAdminUser1.getId();
                String acc = shopAdminUser1.getAccount();
                //查询角色id
                ShopAdminRoleExample roleExample = new ShopAdminRoleExample();
                ShopAdminRoleExample.Criteria criteria2 = roleExample.createCriteria();
                criteria2.andRole_nameEqualTo("【超级管理员】");
                criteria2.andShop_idEqualTo(shop_id);
                List<ShopAdminRole> shopAdminRoles1 = shopAdminRoleMapper.selectByExample(roleExample);

                if(!CollectionUtils.isEmpty(shopAdminRoles1)){
                    ShopAdminRole shopAdminRole = shopAdminRoles1.get(0);
                    Long roleId = shopAdminRole.getId();
                    String role_name = shopAdminRole.getRole_name();

                    //将所有菜单添加到该角色
                    List<ShopAdminMenu> shopAdminMenus = shopAdminMenuMapper.selectByExample(new ShopAdminMenuExample());
                    ShopAdminRoleMenuRelationExample exampleRoleMenu = new ShopAdminRoleMenuRelationExample();
                    ShopAdminRoleMenuRelationExample.Criteria criteria3 = exampleRoleMenu.createCriteria();
                    criteria3.andShop_idEqualTo(shop_id);
                    criteria3.andRole_idEqualTo(roleId);

                    List<ShopAdminRoleMenuRelation> shopAdminRoleMenuRelations = shopAdminRoleMenuRelationMapper.selectByExample(exampleRoleMenu);

                    if(!CollectionUtils.isEmpty(shopAdminMenus) && CollectionUtils.isEmpty(shopAdminRoleMenuRelations)){
                        for (ShopAdminMenu shopAdminMenu : shopAdminMenus) {
                            ShopAdminRoleMenuRelation record = new ShopAdminRoleMenuRelation();
                            record.setShop_id(shop_id);
                            record.setMenu_name(shopAdminMenu.getMenu_name());
                            record.setMenu_id(shopAdminMenu.getId());
                            record.setRole_name(role_name);
                            record.setRole_id(roleId);
                            record.setGmt_modify(new Date());
                            record.setGmt_create(new Date());
                            record.setModifier_account(editAccount);
                            record.setCreator_account(editAccount);
                            record.setVersion(0);
                            record.setDescription("平台管理员创建");
                            shopAdminRoleMenuRelationMapper.insert(record);
                        }
                    }else{
                        Map<String, List<ShopAdminRoleMenuRelation>> collect =
                                shopAdminRoleMenuRelations.stream()
                                        .collect((Collectors.groupingBy(ShopAdminRoleMenuRelation::getMenu_name)));
                        //增量新增菜单
                        for (ShopAdminMenu shopAdminMenu : shopAdminMenus) {
                            List<ShopAdminRoleMenuRelation> shopAdminRoleMenuRelations1 = collect.get(shopAdminMenu.getMenu_name());
                            if(CollectionUtils.isEmpty(shopAdminRoleMenuRelations1)){
                                ShopAdminRoleMenuRelation record = new ShopAdminRoleMenuRelation();
                                record.setShop_id(shop_id);
                                record.setMenu_name(shopAdminMenu.getMenu_name());
                                record.setMenu_id(shopAdminMenu.getId());
                                record.setRole_name(role_name);
                                record.setRole_id(roleId);
                                record.setGmt_modify(new Date());
                                record.setGmt_create(new Date());
                                record.setModifier_account(editAccount);
                                record.setCreator_account(editAccount);
                                record.setVersion(0);
                                record.setDescription("平台管理员创建");
                                shopAdminRoleMenuRelationMapper.insert(record);
                            }
                        }
                    }

                    //插入用户角色关系表
                    ShopAdminUserRoleRelation shopAdminUserRoleRelation = new ShopAdminUserRoleRelation();
                    shopAdminUserRoleRelation.setShop_id(shop_id);
                    shopAdminUserRoleRelation.setRole_id(roleId);
                    shopAdminUserRoleRelation.setUser_id(userId);
                    shopAdminUserRoleRelation.setRole_name(role_name);
                    shopAdminUserRoleRelation.setVersion(0);
                    shopAdminUserRoleRelation.setDescription("平台管理员创建");
                    shopAdminUserRoleRelation.setAccount(acc);
                    shopAdminUserRoleRelation.setCreator_account(editAccount);
                    shopAdminUserRoleRelation.setGmt_create(new Date());
                    shopAdminUserRoleRelation.setGmt_modify(new Date());
                    shopAdminUserRoleRelation.setModifier_account(editAccount);

                    shopAdminUserRoleRelationMapper.insert(shopAdminUserRoleRelation);
                }

            }

            baseVO.setSuccess(true);
        } catch (Exception e) {
            String message = e.getMessage();
            if(StringUtils.isNotEmpty(message) && message.indexOf("Duplicate")>0){
                message="账号已经被注册，请重新注册";
            }else{
                message="";
            }
            LOG.error("ShopAdminUserController#add error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！"+message);
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
                ShopAdminUser shopAdminUser = shopAdminUserMapper.selectByPrimaryKey(id);
                baseVO.setData(shopAdminUser);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopAdminUserController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询用户信息信息异常！");
        }
        return baseVO;
    }



}
