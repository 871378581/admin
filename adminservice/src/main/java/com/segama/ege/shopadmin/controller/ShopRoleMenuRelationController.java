package com.segama.ege.shopadmin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色菜单关系信息管理
 *
 * @author hxj
 * @version 1.0
 * @since 2018/9/5
 */
@RestController
@RequestMapping("/ege/api/shop_admin/role_menu_relation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopRoleMenuRelationController {

    @Resource
    private ShopAdminRoleMapper shopAdminRoleMapper;

    @Resource
    private ShopAdminMenuMapper shopAdminMenuMapper;

    @Resource
    private ShopAdminRoleMenuRelationMapper shopAdminRoleMenuRelationMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopRoleMenuRelationController.class);


    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("roleName") String roleName,
            @RequestParam("menuName") String menuName,
            @RequestParam("shopId") Long shopId
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex
            ) {
        BaseVO baseVO = new BaseVO();
        baseVO.setSuccess(true);
        try {

            ShopAdminRoleMenuRelationExample adminRoleMenuRelationExample = new ShopAdminRoleMenuRelationExample();
            ShopAdminRoleMenuRelationExample.Criteria criteria = adminRoleMenuRelationExample.createCriteria();
            if(shopId==null){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("param can not be null");
                return baseVO;
            }
            if(!StringUtils.isEmpty(roleName)){
                criteria.andRole_nameLike("%"+roleName+"%");
            }
            if(!StringUtils.isEmpty(menuName)){
                criteria.andMenu_nameLike("%"+menuName+"%");
            }
            criteria.andShop_idEqualTo(shopId);
            adminRoleMenuRelationExample.setOrderByClause("gmt_create desc");
            int count = shopAdminRoleMenuRelationMapper.countByExample(adminRoleMenuRelationExample);
            if(count != 0){
                adminRoleMenuRelationExample.setPageCount(pageSize);
                adminRoleMenuRelationExample.setPageIndex(pageIndex);
                List<ShopAdminRoleMenuRelation> shopAdminRoleMenuRelations = shopAdminRoleMenuRelationMapper.selectByExample(adminRoleMenuRelationExample);
                if(!CollectionUtils.isEmpty(shopAdminRoleMenuRelations)){
                    shopAdminRoleMenuRelations.stream().map(e->{
                        ShopAdminRole adminRole = shopAdminRoleMapper.selectByPrimaryKey(e.getRole_id());
                        ShopAdminMenu adminMenu = shopAdminMenuMapper.selectByPrimaryKey(e.getMenu_id());
                        if(adminRole!=null &&adminMenu!=null) {
                            e.setRole_name(adminRole.getRole_name());
                            e.setMenu_name(adminMenu.getMenu_name());
                        }
                        return e;
                    }).collect(Collectors.toList());
                }
                baseVO.setData(shopAdminRoleMenuRelations);
            }
            baseVO.setCode(0);
            baseVO.setCount(count);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ShopRoleMenuRelationController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id ) {
        BaseVO baseVO = new BaseVO();
        if(id == null){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能删除！");
        }else {
            ShopAdminRoleMenuRelation shopAdminRoleMenuRelation = shopAdminRoleMenuRelationMapper.selectByPrimaryKey(id);
            if(shopAdminRoleMenuRelation!=null && "【超级管理员】".equals(shopAdminRoleMenuRelation.getRole_name())){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("超级管理员相关菜单不能删除！");
                return baseVO;
            }
            shopAdminRoleMenuRelationMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                       @RequestParam("roleId") Long roleId,
                       @RequestParam("account") String account,
                       @RequestParam("menuId") Long menuId) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(account) || id==null || roleId==null || menuId == null){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("edit param can not be null");
                return baseVO;
            }
            ShopAdminRoleMenuRelation adminRoleMenuRelation = shopAdminRoleMenuRelationMapper.selectByPrimaryKey(id);
            if(adminRoleMenuRelation!=null && "【超级管理员】".equals(adminRoleMenuRelation.getRole_name())){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("超级管理员相关菜单不能删除！");
                return baseVO;
            }
            if(roleId!=null){
                adminRoleMenuRelation.setRole_id(roleId);
                ShopAdminRole adminRole = shopAdminRoleMapper.selectByPrimaryKey(roleId);
                if(adminRole!=null) {
                    adminRoleMenuRelation.setRole_name(adminRole.getRole_name());
                }
            }
            if(menuId!=null){
                adminRoleMenuRelation.setMenu_id(menuId);
                ShopAdminMenu adminMenu = shopAdminMenuMapper.selectByPrimaryKey(menuId);
                if(adminMenu!=null){
                    adminRoleMenuRelation.setMenu_name(adminMenu.getMenu_name());
                }
            }
            adminRoleMenuRelation.setGmt_modify(new Date());
            adminRoleMenuRelation.setModifier_account(account);
            shopAdminRoleMenuRelationMapper.updateByPrimaryKey(adminRoleMenuRelation);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopRoleMenuRelationController#edit Exception",e);
            baseVO.setErrorMsg("编辑异常");
            baseVO.setSuccess(false);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(@RequestParam("roleId") Long roleId,
                      @RequestParam("account") String account,
                      @RequestParam("shopId") Long shopId,
                               @RequestParam("menuId") Long menuId) {

        BaseVO baseVO = new BaseVO();
        try {
            ShopAdminRoleMenuRelation roleMenuRelation = new ShopAdminRoleMenuRelation();
            if( roleId == null || menuId==null || shopId==null){
                baseVO.setErrorMsg("add param can not be null");
                baseVO.setSuccess(false);
                return baseVO;
            }
            roleMenuRelation.setRole_id(roleId);
            roleMenuRelation.setShop_id(shopId);
            ShopAdminRole adminRole = shopAdminRoleMapper.selectByPrimaryKey(roleId);
            if(adminRole!=null) {
                roleMenuRelation.setRole_name(adminRole.getRole_name());
            }

            roleMenuRelation.setMenu_id(menuId);
            ShopAdminMenu adminMenu = shopAdminMenuMapper.selectByPrimaryKey(menuId);
            if(adminMenu!=null){
                roleMenuRelation.setMenu_name(adminMenu.getMenu_name());
            }

            roleMenuRelation.setCreator_account(account);
            roleMenuRelation.setModifier_account(account);
            roleMenuRelation.setVersion(0);
            roleMenuRelation.setGmt_create(new Date());
            roleMenuRelation.setGmt_modify(new Date());
            shopAdminRoleMenuRelationMapper.insert(roleMenuRelation);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopRoleMenuRelationController#add Exception",e);
            baseVO.setErrorMsg("添加异常");
            baseVO.setSuccess(false);
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id == null){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("id can not be null");
                return baseVO;
            }
            ShopAdminRoleMenuRelation adminRoleMenuRelation = shopAdminRoleMenuRelationMapper.selectByPrimaryKey(id);
            baseVO.setSuccess(true);
            baseVO.setData(adminRoleMenuRelation);
        } catch (Exception e) {
            LOG.error("ShopRoleMenuRelationController#get Exception input param is id:"+id,e);
            baseVO.setErrorMsg("查询信息异常");
            baseVO.setSuccess(false);
        }
        return baseVO;
    }

}
