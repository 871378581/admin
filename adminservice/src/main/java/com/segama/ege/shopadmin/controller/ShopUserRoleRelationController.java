package com.segama.ege.shopadmin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
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

/**
 * 门店用户角色关系管理
 *
 * @author hxj
 * @version 1.0
 * @since 2018/9/5
 */
@RestController
@RequestMapping("/ege/api/shop_admin/user_role_relation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopUserRoleRelationController {

    @Resource
    private ShopAdminUserRoleRelationMapper shopAdminUserRoleRelationMapper;

    @Resource
    private ShopAdminUserMapper shopAdminUserMapper;

    @Resource
    private ShopAdminRoleMapper shopAdminRoleMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopUserRoleRelationController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("roleName") String roleName,
            @RequestParam("account") String account,
            @RequestParam("shopId") Long shopId
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();


        try {
            ShopAdminUserRoleRelationExample adminUserRoleRelation = new ShopAdminUserRoleRelationExample();
            ShopAdminUserRoleRelationExample.Criteria criteria = adminUserRoleRelation.createCriteria();
            if(!StringUtils.isEmpty(roleName)){
                criteria.andRole_nameLike("%"+roleName+"%");
            }
            if(!StringUtils.isEmpty(account)){
                criteria.andAccountLike("%"+account+"%");
            }
            if(shopId==null){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("param can not be null");
                return baseVO;
            }
            adminUserRoleRelation.setOrderByClause("gmt_create desc");
            criteria.andShop_idEqualTo(shopId);
            int count = shopAdminUserRoleRelationMapper.countByExample(adminUserRoleRelation);
            if(count != 0){
                adminUserRoleRelation.setPageCount(pageSize);
                adminUserRoleRelation.setPageIndex(pageIndex);
                List<ShopAdminUserRoleRelation> adminUserRoleRelations = shopAdminUserRoleRelationMapper.selectByExample(adminUserRoleRelation);

                baseVO.setData(adminUserRoleRelations);
            }
            baseVO.setCode(0);
            baseVO.setCount(count);

        }catch (Exception e){
            baseVO.setErrorMsg("数据获取异常");
            baseVO.setSuccess(false);
            LOG.error("ShopUserRoleRelationController#list Exception",e);
        }
        return baseVO;
    }

    
    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id ) {
        BaseVO baseVO = BaseVO.createSuccess();
        if(id == null){
            return BaseVO.createFailure("id can not be null");
        }
        ShopAdminUserRoleRelation shopAdminUserRoleRelation = shopAdminUserRoleRelationMapper.selectByPrimaryKey(id);
        if(shopAdminUserRoleRelation!=null && "【超级管理员】".equals(shopAdminUserRoleRelation.getRole_name())){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("超级管理员不能删除！");
            return baseVO;
        }
        shopAdminUserRoleRelationMapper.deleteByPrimaryKey(id);
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
            ShopAdminUserRoleRelation roleMenuRelation = shopAdminUserRoleRelationMapper.selectByPrimaryKey(id);
            if(roleMenuRelation!=null && "【超级管理员】".equals(roleMenuRelation.getRole_name())){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("超级管理员不能编辑！");
                return baseVO;
            }
            if(roleId!=null){
                roleMenuRelation.setRole_id(roleId);
                ShopAdminRole adminRole = shopAdminRoleMapper.selectByPrimaryKey(roleId);
                if(adminRole!=null){
                    String role_name = adminRole.getRole_name();
                    roleMenuRelation.setRole_name(role_name);
                }
            }
            if(userId!=null){
                roleMenuRelation.setUser_id(userId);
                ShopAdminUser adminUser = shopAdminUserMapper.selectByPrimaryKey(userId);
                if(adminUser!=null){
                    String account = adminUser.getAccount();
                    roleMenuRelation.setAccount(account);
                }
            }
            roleMenuRelation.setModifier_account(editAccount);
            shopAdminUserRoleRelationMapper.updateByPrimaryKey(roleMenuRelation);
        } catch (Exception e) {
            LOG.error("ShopUserRoleRelationController#edit Exception",e);
            baseVO = BaseVO.createFailure("编辑异常");
        }
        return baseVO;
    }

    
    @RequestMapping("/add")
    public BaseVO add(@RequestParam("roleId") Long roleId,
                      @RequestParam("account") String editAccount,
                      @RequestParam("shopId") Long shopId,
                               @RequestParam("userId") Long userId) {

        BaseVO baseVO = BaseVO.createSuccess();
        try {
            ShopAdminUserRoleRelation adminUserRoleRelation = new ShopAdminUserRoleRelation();
            if( roleId == null || userId==null || shopId==null){
                return BaseVO.createFailure("param can not be null.");
            }
            if(roleId != null){
                adminUserRoleRelation.setRole_id(roleId);
            }
            adminUserRoleRelation.setShop_id(shopId);
            if(userId != null){
                adminUserRoleRelation.setUser_id(userId);
            }

            if(roleId!=null){
                adminUserRoleRelation.setRole_id(roleId);
                ShopAdminRole adminRole = shopAdminRoleMapper.selectByPrimaryKey(roleId);
                if(adminRole!=null){
                    String role_name = adminRole.getRole_name();
                    adminUserRoleRelation.setRole_name(role_name);
                }
            }
            if(userId!=null){
                adminUserRoleRelation.setUser_id(userId);
                ShopAdminUser adminUser = shopAdminUserMapper.selectByPrimaryKey(userId);
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
            shopAdminUserRoleRelationMapper.insert(adminUserRoleRelation);
        } catch (Exception e) {
            LOG.error("ShopUserRoleRelationController#add Exception",e);
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
            ShopAdminUserRoleRelation adminUserRoleRelation = shopAdminUserRoleRelationMapper.selectByPrimaryKey(id);
            baseVO.setData(adminUserRoleRelation);
        } catch (Exception e) {
            LOG.error("UserRoleRelationController#get Exception input param is id:"+id,e);
            baseVO = BaseVO.createFailure("查询信息异常！");
        }
        return baseVO;
    }

}
