package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.AdminMenuGroup;
import com.segama.ege.entity.AdminMenuGroupExample;
import com.segama.ege.entity.AdminRoleMenuRelationExample;
import com.segama.ege.repository.AdminMenuGroupMapper;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hxj
 * @version 1.0
 * @Description 菜单组相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/menu_group")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MenuGroupController {
    @Resource
    private AdminMenuGroupMapper adminMenuGroupMapper;

    private static Logger LOG = LoggerFactory.getLogger(MenuGroupController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("group") String group
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            AdminMenuGroupExample adminMenuExample = new AdminMenuGroupExample();
            AdminMenuGroupExample.Criteria adminMenuGroupCriteria = adminMenuExample.createCriteria();
            if(StringUtils.isNotEmpty(group)) {
                adminMenuGroupCriteria.andGroupLike("%" + group + "%");
            }
            int count = adminMenuGroupMapper.countByExample(adminMenuExample);
            adminMenuExample.setPageCount(pageSize);
            adminMenuExample.setPageIndex(pageIndex);
            adminMenuExample.setOrderByClause("gmt_create desc");
            List<AdminMenuGroup> adminMenus = adminMenuGroupMapper.selectByExample(adminMenuExample);
            baseVO.setData(adminMenus);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("AdminMenuGroupController#list error",e);
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
            adminMenuGroupMapper.deleteByPrimaryKey(id);
            AdminRoleMenuRelationExample example = new AdminRoleMenuRelationExample();
            AdminRoleMenuRelationExample.Criteria criteria = example.createCriteria();
            criteria.andMenu_idEqualTo(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("group") String group,
                    @RequestParam("account") String account,
                    @RequestParam("sort") Long sort) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            AdminMenuGroup adminMenu = adminMenuGroupMapper.selectByPrimaryKey(id);

            if(sort!=null){
                adminMenu.setSort(sort);
            }
            if(!StringUtils.isEmpty(group)){
                adminMenu.setGroup(group);
            }
            adminMenu.setGmt_modify(new Date());
            adminMenu.setModifier_account(account);
            adminMenuGroupMapper.updateByPrimaryKey(adminMenu);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("AdminMenuGroupController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
                   @RequestParam("group") String group,
                   @RequestParam("sort") Long sort,
                   @RequestParam("account") String account) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(group) ||
                    sort==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            AdminMenuGroup adminMenu = new AdminMenuGroup();
            if(sort!=null){
                adminMenu.setSort(sort);
            }
            if(!StringUtils.isEmpty(group)){
                adminMenu.setGroup(group);
            }
            adminMenu.setCreator_account(account);
            adminMenu.setModifier_account(account);
            adminMenu.setGmt_create(new Date());
            adminMenu.setGmt_modify(new Date());
            adminMenuGroupMapper.insert(adminMenu);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminMenuGroupController#add error",e);
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
                AdminMenuGroup adminMenu = adminMenuGroupMapper.selectByPrimaryKey(id);
                baseVO.setData(adminMenu);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminMenuGroupController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_menu_group")
    public BaseVO getAllMenu() {
        BaseVO baseVO = new BaseVO();
        try {
            AdminMenuGroupExample adminMenuGroupExample = new AdminMenuGroupExample();
            adminMenuGroupExample.setPageIndex(1);
            adminMenuGroupExample.setPageCount(100);
            List<AdminMenuGroup> adminMenus = adminMenuGroupMapper.selectByExample(adminMenuGroupExample);
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(adminMenus)){
                for (AdminMenuGroup menuInfo : adminMenus) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",menuInfo.getGroup());
                    map.put("value",menuInfo.getGroup());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminMenuGroupController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
