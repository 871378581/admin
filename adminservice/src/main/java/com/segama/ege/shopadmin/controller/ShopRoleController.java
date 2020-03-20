package com.segama.ege.shopadmin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
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
 * @Description 门店角色相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/shop_admin/role")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopRoleController {
    @Resource
    private ShopAdminRoleMapper shopAdminRoleMapper;

    @Resource
    private ShopAdminUserRoleRelationMapper shopAdminUserRoleRelationMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopRoleController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("roleName") String roleName,
            @RequestParam("shopId") Long shopId
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            if(shopId==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopAdminRoleExample adminRoleExample = new ShopAdminRoleExample();
            adminRoleExample.setOrderByClause("gmt_create desc");
            ShopAdminRoleExample.Criteria adminRoleExampleCriteria = adminRoleExample.createCriteria();
            if(StringUtils.isNotEmpty(roleName)) {
                adminRoleExampleCriteria.andRole_nameLike("%" + roleName + "%");
            }
            adminRoleExampleCriteria.andShop_idEqualTo(shopId);
            int count = shopAdminRoleMapper.countByExample(adminRoleExample);
            adminRoleExample.setPageCount(pageSize);
            adminRoleExample.setPageIndex(pageIndex);
            List<ShopAdminRole> adminRoles = shopAdminRoleMapper.selectByExample(adminRoleExample);
            baseVO.setData(adminRoles);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ShopRoleController#list error",e);
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
            ShopAdminRole adminRole = shopAdminRoleMapper.selectByPrimaryKey(id);
            if("【超级管理员】".equals(adminRole.getRole_name())){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("超级管理员不能删除！");
                return baseVO;
            }
            shopAdminRoleMapper.deleteByPrimaryKey(id);
            ShopAdminUserRoleRelationExample example = new ShopAdminUserRoleRelationExample();
            ShopAdminUserRoleRelationExample.Criteria criteria = example.createCriteria();
            criteria.andRole_idEqualTo(id);
            shopAdminUserRoleRelationMapper.deleteByExample(example);
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
            ShopAdminRole adminRole = shopAdminRoleMapper.selectByPrimaryKey(id);
            if("【超级管理员】".equals(adminRole.getRole_name())){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("超级管理员不能编辑！");
                return baseVO;
            }
            if(!StringUtils.isEmpty(roleName)){
                adminRole.setRole_name(roleName);
            }
            if(!StringUtils.isEmpty(description)){
                adminRole.setDescription(description);
            }
            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(account);
            shopAdminRoleMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopRoleController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
            @RequestParam("account") String account,
            @RequestParam("roleName") String roleName,
            @RequestParam("shopId") Long shopId,
                      @RequestParam("description") String description) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(account) ||
                    shopId==null ||
                    StringUtils.isEmpty(roleName) ||
                    StringUtils.isEmpty(description)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopAdminRole adminRole = new ShopAdminRole();
            if(!StringUtils.isEmpty(roleName)){
                adminRole.setRole_name(roleName);
            }
            adminRole.setShop_id(shopId);
            if(!StringUtils.isEmpty(description)){
                adminRole.setDescription(description);
            }
            adminRole.setCreator_account(account);
            adminRole.setModifier_account(account);
            adminRole.setVersion(0);
            adminRole.setGmt_create(new Date());
            adminRole.setGmt_modify(new Date());
            shopAdminRoleMapper.insert(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopRoleController#add error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
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
                ShopAdminRole adminRole = shopAdminRoleMapper.selectByPrimaryKey(id);
                baseVO.setData(adminRole);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopRoleController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_role")
    public BaseVO getAllMenu(@RequestParam("shopId") Long shopId) {
        BaseVO baseVO = new BaseVO();
        try {
            ShopAdminRoleExample shopAdminRoleExample = new ShopAdminRoleExample();
            ShopAdminRoleExample.Criteria criteria = shopAdminRoleExample.createCriteria();
            criteria.andShop_idEqualTo(shopId);
            shopAdminRoleExample.setOrderByClause("gmt_create desc");
            List<ShopAdminRole> adminRoles = shopAdminRoleMapper.selectByExample(shopAdminRoleExample);
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(adminRoles)){
                for (ShopAdminRole adminRole : adminRoles) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",adminRole.getRole_name());
                    map.put("value",adminRole.getId());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopRoleController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
