package com.segama.ege.shopadmin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ShopAdminMenu;
import com.segama.ege.entity.ShopAdminMenuExample;
import com.segama.ege.repository.ShopAdminMenuMapper;
import com.segama.ege.repository.ShopAdminRoleMenuRelationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author hxj
 * @version 1.0
 * @Description 登录相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/shop_admin/shop_menu")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopAdminMenuController {
    @Resource
    private ShopAdminMenuMapper shopAdminMenuMapper;

    @Resource
    private ShopAdminRoleMenuRelationMapper shopAdminRoleMenuRelationMapper;


    private static Logger LOG = LoggerFactory.getLogger(ShopAdminMenuController.class);

    @RequestMapping("/get_all_menu")
    public BaseVO getAllMenu() {
        BaseVO baseVO = new BaseVO();
        try {
            ShopAdminMenuExample shopAdminMenuExample = new ShopAdminMenuExample();
            shopAdminMenuExample.setOrderByClause("gmt_create desc");
            List<ShopAdminMenu> adminMenus = shopAdminMenuMapper.selectByExample(shopAdminMenuExample);
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
            LOG.error("ShopAdminMenuController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
