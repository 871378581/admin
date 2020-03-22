package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.AdminRole;
import com.segama.ege.entity.AdminRoleExample;
import com.segama.ege.entity.AdminRoleMenuRelationExample;
import com.segama.ege.entity.AdminUserRoleRelationExample;
import com.segama.ege.repository.AdminRoleMapper;
import com.segama.ege.repository.AdminUserMapper;
import com.segama.ege.repository.AdminUserRoleRelationMapper;
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

/**
 * @author hxj
 * @version 1.0
 * @Description 角色相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/role")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RoleController {
    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminUserRoleRelationMapper adminUserRoleRelationMapper;

    private static Logger LOG = LoggerFactory.getLogger(RoleController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("roleName") String roleName
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            AdminRoleExample adminRoleExample = new AdminRoleExample();
            AdminRoleExample.Criteria AdminRoleExampleCriteria = adminRoleExample.createCriteria();
            if(StringUtils.isNotEmpty(roleName)) {
                AdminRoleExampleCriteria.andRole_nameLike("%" + roleName + "%");
            }
            int count = adminRoleMapper.countByExample(adminRoleExample);
            adminRoleExample.setPageCount(pageSize);
            adminRoleExample.setPageIndex(pageIndex);
            adminRoleExample.setOrderByClause("gmt_create desc");
            List<AdminRole> AdminRoles = adminRoleMapper.selectByExample(adminRoleExample);
            baseVO.setData(AdminRoles);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("AdminRoleController#list error",e);
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
            adminRoleMapper.deleteByPrimaryKey(id);
            AdminUserRoleRelationExample example = new AdminUserRoleRelationExample();
            AdminUserRoleRelationExample.Criteria criteria = example.createCriteria();
            criteria.andRole_idEqualTo(id);
            adminUserRoleRelationMapper.deleteByExample(example);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("account") String account,
                    @RequestParam("roleName") String roleName,
                    @RequestParam("description") String description) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null || StringUtils.isEmpty(roleName) || StringUtils.isEmpty(description)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(id);
            if(!StringUtils.isEmpty(roleName)){
                adminRole.setRole_name(roleName);
            }
            if(!StringUtils.isEmpty(description)){
                adminRole.setDescription(description);
            }
            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(account);
            adminRoleMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("AdminRoleController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
            @RequestParam("account") String account,
            @RequestParam("roleName") String roleName,
                      @RequestParam("description") String description) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(account) ||
                    StringUtils.isEmpty(roleName) ||
                    StringUtils.isEmpty(description)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            AdminRole adminRole = new AdminRole();
            if(!StringUtils.isEmpty(roleName)){
                adminRole.setRole_name(roleName);
            }
            if(!StringUtils.isEmpty(description)){
                adminRole.setDescription(description);
            }
            adminRole.setCreator_account(account);
            adminRole.setModifier_account(account);
            adminRole.setVersion(0);
            adminRole.setGmt_create(new Date());
            adminRole.setGmt_modify(new Date());
            adminRoleMapper.insert(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminRoleController#add error",e);
            baseVO.setSuccess(false);
            String msg = "";
            if(StringUtils.isNotEmpty(e.getMessage())&&e.getMessage().contains("Duplicate")){
                msg="请勿重复添加！";
            }
            baseVO.setErrorMsg("添加异常"+msg);
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
                AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(id);
                baseVO.setData(adminRole);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminRoleController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_role")
    public BaseVO getAllMenu() {
        BaseVO baseVO = new BaseVO();
        try {
            List<AdminRole> adminRoles = adminRoleMapper.selectByExample(new AdminRoleExample());
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(adminRoles)){
                for (AdminRole adminRole : adminRoles) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",adminRole.getRole_name());
                    map.put("value",adminRole.getId());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminRoleController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
