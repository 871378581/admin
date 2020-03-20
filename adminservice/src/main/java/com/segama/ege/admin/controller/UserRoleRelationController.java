package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.AdminRoleMapper;
import com.segama.ege.repository.AdminUserMapper;
import com.segama.ege.repository.AdminUserRoleRelationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * 用户角色关系管理
 *
 * @author hxj
 * @version 1.0
 * @since 2018/9/5
 */
@RestController
@RequestMapping("/ege/api/admin/user_role_relation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserRoleRelationController{

    @Resource
    private AdminUserRoleRelationMapper adminUserRoleRelationMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminRoleMapper adminRoleMapper;

    private static Logger LOG = LoggerFactory.getLogger(UserRoleRelationController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("roleName") String roleName,
            @RequestParam("account") String account
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        AdminUserRoleRelationExample adminUserRoleRelation = new AdminUserRoleRelationExample();
        AdminUserRoleRelationExample.Criteria criteria = adminUserRoleRelation.createCriteria();
        adminUserRoleRelation.setOrderByClause("gmt_create desc");
        if(!StringUtils.isEmpty(roleName)){
            criteria.andRole_nameLike("%"+roleName+"%");
        }
        if(!StringUtils.isEmpty(account)){
            criteria.andAccountLike("%"+account+"%");
        }

        try {
            int count = adminUserRoleRelationMapper.countByExample(adminUserRoleRelation);
            if(count != 0){
                adminUserRoleRelation.setPageCount(pageSize);
                adminUserRoleRelation.setPageIndex(pageIndex);
                List<AdminUserRoleRelation> adminUserRoleRelations = adminUserRoleRelationMapper.selectByExample(adminUserRoleRelation);

                baseVO.setData(adminUserRoleRelations);
            }
            baseVO.setCode(0);
            baseVO.setCount(count);

        }catch (Exception e){
            baseVO.setErrorMsg("数据获取异常");
            baseVO.setSuccess(false);
            LOG.error("UserRoleRelationController#list Exception",e);
        }
        return baseVO;
    }

    
    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id ) {
        BaseVO baseVO = BaseVO.createSuccess();
        if(id == null){
            return BaseVO.createFailure("id can not be null");
        }
        adminUserRoleRelationMapper.deleteByPrimaryKey(id);
        return baseVO;
    }

    
    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                                @RequestParam("account") String editAccount,
                                @RequestParam("roleId") Long roleId,
                                @RequestParam("userId") Long userId) {
        BaseVO baseVO = BaseVO.createSuccess();
        try {
            if(id==null || roleId==null || userId == null){
                return BaseVO.createFailure("edit param can not be null");
            }
            AdminUserRoleRelation roleMenuRelation = adminUserRoleRelationMapper.selectByPrimaryKey(id);

            if(roleId!=null){
                roleMenuRelation.setRole_id(roleId);
                AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(roleId);
                if(adminRole!=null){
                    String role_name = adminRole.getRole_name();
                    roleMenuRelation.setRole_name(role_name);
                }
            }
            if(userId!=null){
                roleMenuRelation.setUser_id(userId);
                AdminUser adminUser = adminUserMapper.selectByPrimaryKey(userId);
                if(adminUser!=null){
                    String account = adminUser.getAccount();
                    roleMenuRelation.setAccount(account);
                }
            }
            roleMenuRelation.setModifier_account(editAccount);
            adminUserRoleRelationMapper.updateByPrimaryKey(roleMenuRelation);
        } catch (Exception e) {
            LOG.error("UserRoleRelationController#edit Exception",e);
            baseVO = BaseVO.createFailure("编辑异常");
        }
        return baseVO;
    }

    
    @RequestMapping("/add")
    public BaseVO add(@RequestParam("roleId") Long roleId,
                      @RequestParam("account") String editAccount,
                               @RequestParam("userId") Long userId) {

        BaseVO baseVO = BaseVO.createSuccess();
        try {
            AdminUserRoleRelation adminUserRoleRelation = new AdminUserRoleRelation();
            if( roleId == null || userId==null){
                return BaseVO.createFailure("param can not be null.");
            }
            if(roleId != null){
                adminUserRoleRelation.setRole_id(roleId);
            }
            if(userId != null){
                adminUserRoleRelation.setUser_id(userId);
            }

            if(roleId!=null){
                adminUserRoleRelation.setRole_id(roleId);
                AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(roleId);
                if(adminRole!=null){
                    String role_name = adminRole.getRole_name();
                    adminUserRoleRelation.setRole_name(role_name);
                }
            }
            if(userId!=null){
                adminUserRoleRelation.setUser_id(userId);
                AdminUser adminUser = adminUserMapper.selectByPrimaryKey(userId);
                if(adminUser!=null){
                    String account = adminUser.getAccount();
                    adminUserRoleRelation.setAccount(account);
                }
            }
            adminUserRoleRelation.setModifier_account(editAccount);
            adminUserRoleRelation.setCreator_account(editAccount);
            adminUserRoleRelation.setVersion(0);
            adminUserRoleRelation.setGmt_create(new Date());
            adminUserRoleRelation.setGmt_modify(new Date());
            adminUserRoleRelationMapper.insert(adminUserRoleRelation);
        } catch (Exception e) {
            LOG.error("UserRoleRelationController#add Exception",e);
            baseVO  = BaseVO.createFailure("添加异常");
        }
        return baseVO;
    }

    
    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id ) {
        BaseVO baseVO = BaseVO.createSuccess();
        try {
            if(id == null){
                return BaseVO.createFailure("id can not be null");
            }
            AdminUserRoleRelation adminUserRoleRelation = adminUserRoleRelationMapper.selectByPrimaryKey(id);
            baseVO.setData(adminUserRoleRelation);
        } catch (Exception e) {
            LOG.error("UserRoleRelationController#get Exception input param is id:"+id,e);
            baseVO = BaseVO.createFailure("查询用户角色关系信息异常！");
        }
        return baseVO;
    }

}
