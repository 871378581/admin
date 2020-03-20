package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.AdminMenuMapper;
import com.segama.ege.repository.AdminRoleMenuRelationMapper;
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
import java.util.*;

/**
 * @author hxj
 * @version 1.0
 * @Description 登录相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/menu")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MenuController {
    @Resource
    private AdminMenuMapper adminMenuMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminRoleMenuRelationMapper adminRoleMenuRelationMapper;


    private static Logger LOG = LoggerFactory.getLogger(MenuController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("menuName") String menuName
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            AdminMenuExample adminMenuExample = new AdminMenuExample();
            AdminMenuExample.Criteria adminMenuExampleCriteria = adminMenuExample.createCriteria();
            if(StringUtils.isNotEmpty(menuName)) {
                adminMenuExampleCriteria.andMenu_nameLike("%" + menuName + "%");
            }
            int count = adminMenuMapper.countByExample(adminMenuExample);
            adminMenuExample.setPageCount(pageSize);
            adminMenuExample.setPageIndex(pageIndex);
            adminMenuExample.setOrderByClause("gmt_create desc");
            List<AdminMenu> adminMenus = adminMenuMapper.selectByExample(adminMenuExample);
            baseVO.setData(adminMenus);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("AdminMenuController#list error",e);
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
            adminMenuMapper.deleteByPrimaryKey(id);
            AdminRoleMenuRelationExample example = new AdminRoleMenuRelationExample();
            AdminRoleMenuRelationExample.Criteria criteria = example.createCriteria();
            criteria.andMenu_idEqualTo(id);
            adminRoleMenuRelationMapper.deleteByExample(example);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("group") String group,
                    @RequestParam("menuName") String menuName,
                    @RequestParam("account") String account,
                    @RequestParam("url") String url) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null || StringUtils.isEmpty(menuName) || StringUtils.isEmpty(url)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            AdminMenu adminMenu = adminMenuMapper.selectByPrimaryKey(id);
            if(!StringUtils.isEmpty(menuName)){
                adminMenu.setMenu_name(menuName);
            }
            if(!StringUtils.isEmpty(url)){
                adminMenu.setUrl(url);
            }
            if(!StringUtils.isEmpty(group)){
                adminMenu.setGroup(group);
            }
            adminMenu.setGmt_modify(new Date());
            adminMenu.setModifier_account(account);
            adminMenuMapper.updateByPrimaryKey(adminMenu);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("AdminMenuController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(@RequestParam("menuName") String menuName,
                               @RequestParam("group") String group,
                               @RequestParam("url") String url,
                               @RequestParam("account") String account) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(menuName) ||
                    StringUtils.isEmpty(url)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            AdminMenu adminMenu = new AdminMenu();
            if(!StringUtils.isEmpty(menuName)){
                adminMenu.setMenu_name(menuName);
            }

            if(!StringUtils.isEmpty(url)){
                adminMenu.setUrl(url);
            }
            if(!StringUtils.isEmpty(group)){
                adminMenu.setGroup(group);
            }
            adminMenu.setCreator_account(account);
            adminMenu.setModifier_account(account);
            adminMenu.setVersion(0);
            adminMenu.setGmt_create(new Date());
            adminMenu.setGmt_modify(new Date());
            adminMenuMapper.insert(adminMenu);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminMenuController#add error",e);
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
                AdminMenu adminMenu = adminMenuMapper.selectByPrimaryKey(id);
                baseVO.setData(adminMenu);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminMenuController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_menu")
    public BaseVO getAllMenu() {
        BaseVO baseVO = new BaseVO();
        try {
            List<AdminMenu> adminMenus = adminMenuMapper.selectByExample(new AdminMenuExample());
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(adminMenus)){
                for (AdminMenu menuInfo : adminMenus) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",menuInfo.getMenu_name());
                    map.put("value",menuInfo.getId());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminMenuController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
