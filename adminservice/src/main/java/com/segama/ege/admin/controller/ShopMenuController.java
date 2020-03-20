package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ShopAdminMenu;
import com.segama.ege.entity.ShopAdminMenuExample;
import com.segama.ege.entity.AdminRoleMenuRelationExample;
import com.segama.ege.entity.ShopAdminRoleMenuRelationExample;
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
 * @Description 登录相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/shop_menu")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopMenuController {
    @Resource
    private ShopAdminMenuMapper shopAdminMenuMapper;

    @Resource
    private ShopAdminRoleMenuRelationMapper shopAdminRoleMenuRelationMapper;


    private static Logger LOG = LoggerFactory.getLogger(ShopMenuController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("menuName") String menuName
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ShopAdminMenuExample adminMenuExample = new ShopAdminMenuExample();
            ShopAdminMenuExample.Criteria adminMenuExampleCriteria = adminMenuExample.createCriteria();
            if(StringUtils.isNotEmpty(menuName)) {
                adminMenuExampleCriteria.andMenu_nameLike("%" + menuName + "%");
            }
            int count = shopAdminMenuMapper.countByExample(adminMenuExample);
            adminMenuExample.setPageCount(pageSize);
            adminMenuExample.setPageIndex(pageIndex);
            adminMenuExample.setOrderByClause("gmt_create desc");
            List<ShopAdminMenu> adminMenus = shopAdminMenuMapper.selectByExample(adminMenuExample);
            baseVO.setData(adminMenus);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ShopMenuController#list error",e);
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
            shopAdminMenuMapper.deleteByPrimaryKey(id);
            ShopAdminRoleMenuRelationExample example = new ShopAdminRoleMenuRelationExample();
            ShopAdminRoleMenuRelationExample.Criteria criteria = example.createCriteria();
            criteria.andMenu_idEqualTo(id);
            shopAdminRoleMenuRelationMapper.deleteByExample(example);
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
            ShopAdminMenu adminMenu = shopAdminMenuMapper.selectByPrimaryKey(id);
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
            shopAdminMenuMapper.updateByPrimaryKey(adminMenu);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopMenuController#edit error",e);
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
            ShopAdminMenu adminMenu = new ShopAdminMenu();
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
            shopAdminMenuMapper.insert(adminMenu);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopMenuController#add error",e);
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
                ShopAdminMenu adminMenu = shopAdminMenuMapper.selectByPrimaryKey(id);
                baseVO.setData(adminMenu);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopMenuController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_menu")
    public BaseVO getAllMenu() {
        BaseVO baseVO = new BaseVO();
        try {
            List<ShopAdminMenu> adminMenus = shopAdminMenuMapper.selectByExample(new ShopAdminMenuExample());
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(adminMenus)){
                for (ShopAdminMenu menuInfo : adminMenus) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",menuInfo.getMenu_name());
                    map.put("value",menuInfo.getId());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopMenuController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
