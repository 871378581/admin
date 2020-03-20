package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.AdminMenuMapper;
import com.segama.ege.repository.AdminRoleMapper;
import com.segama.ege.repository.AdminRoleMenuRelationMapper;
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
 * 用户信息管理
 *
 * @author hxj
 * @version 1.0
 * @since 2018/9/5
 */
@RestController
@RequestMapping("/ege/api/admin/role_menu_relation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RoleMenuRelationController{

    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Resource
    private AdminMenuMapper adminMenuMapper;

    @Resource
    private AdminRoleMenuRelationMapper adminRoleMenuRelationMapper;

    private static Logger LOG = LoggerFactory.getLogger(RoleMenuRelationController.class);


    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("roleName") String roleName,
            @RequestParam("menuName") String menuName
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex
            ) {
        BaseVO baseVO = new BaseVO();
        baseVO.setSuccess(true);
        try {

            AdminRoleMenuRelationExample adminRoleMenuRelationExample = new AdminRoleMenuRelationExample();
            AdminRoleMenuRelationExample.Criteria criteria = adminRoleMenuRelationExample.createCriteria();
            if(!StringUtils.isEmpty(roleName)){
                criteria.andRole_nameLike("%"+roleName+"%");
            }
            if(!StringUtils.isEmpty(menuName)){
                criteria.andMenu_nameLike("%"+menuName+"%");
            }
            int count = adminRoleMenuRelationMapper.countByExample(adminRoleMenuRelationExample);
            if(count != 0){
                adminRoleMenuRelationExample.setPageCount(pageSize);
                adminRoleMenuRelationExample.setPageIndex(pageIndex);
                adminRoleMenuRelationExample.setOrderByClause("gmt_create desc");
                List<AdminRoleMenuRelation> adminRoleMenuRelations = adminRoleMenuRelationMapper.selectByExample(adminRoleMenuRelationExample);
                if(!CollectionUtils.isEmpty(adminRoleMenuRelations)){
                    adminRoleMenuRelations.stream().map(e->{
                        AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(e.getRole_id());
                        AdminMenu adminMenu = adminMenuMapper.selectByPrimaryKey(e.getMenu_id());
                        e.setRole_name(adminRole.getRole_name());
                        e.setMenu_name(adminMenu.getMenu_name());
                        return e;
                    }).collect(Collectors.toList());
                }
                baseVO.setData(adminRoleMenuRelations);
            }
            baseVO.setCode(0);
            baseVO.setCount(count);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("RoleMenuRelationController#list error",e);
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
            adminRoleMenuRelationMapper.deleteByPrimaryKey(id);
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
            AdminRoleMenuRelation adminRoleMenuRelation = adminRoleMenuRelationMapper.selectByPrimaryKey(id);

            if(roleId!=null){
                adminRoleMenuRelation.setRole_id(roleId);
                AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(roleId);
                if(adminRole!=null) {
                    adminRoleMenuRelation.setRole_name(adminRole.getRole_name());
                }
            }
            if(menuId!=null){
                adminRoleMenuRelation.setMenu_id(menuId);
                AdminMenu adminMenu = adminMenuMapper.selectByPrimaryKey(menuId);
                if(adminMenu!=null){
                    adminRoleMenuRelation.setMenu_name(adminMenu.getMenu_name());
                }
            }
            adminRoleMenuRelation.setGmt_modify(new Date());
            adminRoleMenuRelation.setModifier_account(account);
            adminRoleMenuRelationMapper.updateByPrimaryKey(adminRoleMenuRelation);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("RoleMenuRelationController#edit Exception",e);
            baseVO.setErrorMsg("编辑异常");
            baseVO.setSuccess(false);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(@RequestParam("roleId") Long roleId,
                      @RequestParam("account") String account,
                               @RequestParam("menuId") Long menuId) {

        BaseVO baseVO = new BaseVO();
        try {
            AdminRoleMenuRelation roleMenuRelation = new AdminRoleMenuRelation();
            if( roleId == null || menuId==null){
                baseVO.setErrorMsg("add param can not be null");
                baseVO.setSuccess(false);
                return baseVO;
            }
            roleMenuRelation.setRole_id(roleId);
            AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(roleId);
            if(adminRole!=null) {
                roleMenuRelation.setRole_name(adminRole.getRole_name());
            }

            roleMenuRelation.setMenu_id(menuId);
            AdminMenu adminMenu = adminMenuMapper.selectByPrimaryKey(menuId);
            if(adminMenu!=null){
                roleMenuRelation.setMenu_name(adminMenu.getMenu_name());
            }

            roleMenuRelation.setCreator_account(account);
            roleMenuRelation.setModifier_account(account);
            roleMenuRelation.setVersion(0);
            roleMenuRelation.setGmt_create(new Date());
            roleMenuRelation.setGmt_modify(new Date());
            adminRoleMenuRelationMapper.insert(roleMenuRelation);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("RoleMenuRelationResource#add Exception",e);
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
            AdminRoleMenuRelation adminRoleMenuRelation = adminRoleMenuRelationMapper.selectByPrimaryKey(id);
            baseVO.setSuccess(true);
            baseVO.setData(adminRoleMenuRelation);
        } catch (Exception e) {
            LOG.error("RoleMenuRelationResource#get Exception input param is id:"+id,e);
            baseVO.setErrorMsg("查询信息异常");
            baseVO.setSuccess(false);
        }
        return baseVO;
    }

}
