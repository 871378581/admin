package com.segama.ege.shopadmin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.AdminUserMapper;
import com.segama.ege.repository.ShopAdminUserDetailInfoMapper;
import com.segama.ege.repository.ShopAdminUserMapper;
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
import java.util.stream.Collectors;

/**
 * @author hxj
 * @version 1.0
 * @Description 登录相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/shop_admin/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopUserInfoController {
    
    @Resource
    private ShopAdminUserMapper shopAdminUserMapper;

    @Resource
    private ShopAdminUserDetailInfoMapper shopAdminUserDetailInfoMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopUserInfoController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("account") String account,
            @RequestParam("shopId") Long shopId
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            if(shopId == null){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("id为空不能删除！");
            }
            ShopAdminUserExample adminRoleExample = new ShopAdminUserExample();
            adminRoleExample.setOrderByClause("gmt_create desc");
            ShopAdminUserExample.Criteria adminRoleExampleCriteria = adminRoleExample.createCriteria();
            if(StringUtils.isNotEmpty(account)) {
                adminRoleExampleCriteria.andAccountLike("%" + account + "%");
            }

            adminRoleExampleCriteria.andShop_idEqualTo(shopId);
            int count = shopAdminUserMapper.countByExample(adminRoleExample);
            if(count!=0) {
                adminRoleExample.setPageCount(pageSize);
                adminRoleExample.setPageIndex(pageIndex);
                List<ShopAdminUser> adminUsers = shopAdminUserMapper.selectByExample(adminRoleExample);
                List<ShopAdminUser> collect = adminUsers.stream().filter(e -> !"admin".equals(e.getAccount())).collect(Collectors.toList());
                baseVO.setData(collect);
                baseVO.setSuccess(true);
            }

            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ShopUserInfoController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id ,@RequestParam("account") String account ) {
        BaseVO baseVO = new BaseVO();
        if(id == null || StringUtils.isEmpty(account)){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能删除！");
            return baseVO;
        }else {
            ShopAdminUser shopAdminUser = shopAdminUserMapper.selectByPrimaryKey(id);
            if(shopAdminUser!=null && "0".equals(shopAdminUser.getRole_type())){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("该管理员账号不允许删除！");
                return baseVO;
            }

            shopAdminUserMapper.deleteByPrimaryKey(id);

            //删除用户之后删除用户详情
            ShopAdminUserDetailInfoExample example = new ShopAdminUserDetailInfoExample();
            ShopAdminUserDetailInfoExample.Criteria criteria = example.createCriteria();
            criteria.andAccountEqualTo(shopAdminUser.getAccount());
            criteria.andShop_idEqualTo(shopAdminUser.getShop_id());
            List<ShopAdminUserDetailInfo> shopAdminUserDetailInfos =
                    shopAdminUserDetailInfoMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(shopAdminUserDetailInfos)){
                ShopAdminUserDetailInfo detailInfo = shopAdminUserDetailInfos.get(0);
                shopAdminUserDetailInfoMapper.deleteByPrimaryKey(detailInfo.getId());
            }
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("editAccount") String editAccount,
                    @RequestParam("password") String password) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null || StringUtils.isEmpty(password)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopAdminUser adminRole = shopAdminUserMapper.selectByPrimaryKey(id);
            if(!StringUtils.isEmpty(password)){
                adminRole.setPassword(password);
            }
            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(editAccount);
            shopAdminUserMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("AdminUserController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
            @RequestParam("editAccount") String editAccount,
            @RequestParam("account") String account,
            @RequestParam("shopId") Long shopId,
            @RequestParam("password") String password) {

        BaseVO baseVO = new BaseVO();
        try {
            if (shopId == null || StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopAdminUser adminUser = new ShopAdminUser();
            adminUser.setShop_id(shopId);
            if (!StringUtils.isEmpty(account)) {
                adminUser.setAccount(account);
            }
            if (!StringUtils.isEmpty(password)) {
                adminUser.setPassword(password);
            }
            adminUser.setCreator_account(editAccount);
            adminUser.setModifier_account(editAccount);
            adminUser.setVersion(0);
            adminUser.setRole_type("-1");
            adminUser.setGmt_create(new Date());
            adminUser.setGmt_modify(new Date());
            shopAdminUserMapper.insert(adminUser);

            //在用户详情信息表插入一条记录
            ShopAdminUserDetailInfo detailInfo = new ShopAdminUserDetailInfo();
            detailInfo.setAccount(account);
            detailInfo.setShop_id(shopId);
            detailInfo.setModifier_account(account);
            detailInfo.setCreator_account(account);
            detailInfo.setGmt_create(new Date());
            detailInfo.setGmt_modify(new Date());
            shopAdminUserDetailInfoMapper.insert(detailInfo);

            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminUserController#add error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！账号或已被使用！请修改后再试！");
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
                ShopAdminUser adminUser = shopAdminUserMapper.selectByPrimaryKey(id);
                baseVO.setData(adminUser);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminUserController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询用户信息信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_user")
    public BaseVO getAllMenu(@RequestParam("shopId") Long shopId) {
        BaseVO baseVO = new BaseVO();
        try {
            ShopAdminUserExample adminUserExample = new ShopAdminUserExample();
            ShopAdminUserExample.Criteria criteria = adminUserExample.createCriteria();
            criteria.andShop_idEqualTo(shopId);
            List<ShopAdminUser> adminUsers = shopAdminUserMapper.selectByExample(adminUserExample);
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(adminUsers)){
                for (ShopAdminUser adminUser : adminUsers) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",adminUser.getAccount());
                    map.put("value",adminUser.getId());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminUserController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
