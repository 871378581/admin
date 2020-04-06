package com.segama.ege.admin.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.BuildUrlVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.AdminUserMapper;
import com.segama.ege.repository.ThProductManageMapper;
import com.segama.ege.repository.ThUrlManageMapper;
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
 * @Description 链接相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/url_manage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UrlController extends BaseController{
    
    @Resource
    private ThUrlManageMapper thUrlManageMapper;

    @Resource
    private ThProductManageMapper thProductManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(UrlController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "owner_1_account" ,required = false) String owner_1_account
            ,@RequestParam(value = "product_code" ,required = false) String product_code
            ,@RequestParam(value = "account") String account
            ,@RequestParam(value = "channel_type") String channel_type
            ,@RequestParam(value = "limit",required = false) Integer pageSize,
            @RequestParam(value = "page",required = false) Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThUrlManageExample adminRoleExample = new ThUrlManageExample();
            adminRoleExample.setOrderByClause("gmt_create desc");
            ThUrlManageExample.Criteria adminRoleExampleCriteria = adminRoleExample.createCriteria();
            if(StringUtils.isNotEmpty(product_code)) {
                adminRoleExampleCriteria.andProduct_codeEqualTo(product_code);
            }
            if(StringUtils.isNotEmpty(owner_1_account)) {
                adminRoleExampleCriteria.andOwner_1_accountEqualTo(owner_1_account);
            }

            //不是管理员只能查看自己创建的链接
            Boolean aBoolean = showAllUser(account);
            if(!aBoolean){
                //A登录看数据用这个过滤
                if("1".equals(channel_type)){
                    adminRoleExampleCriteria.andOwner_1_accountEqualTo(account);

                    //b用这个字段过滤数据
                }else if("2".equals(channel_type)){
                    adminRoleExampleCriteria.andOwner_accountEqualTo(account);
                }
            }

            int count = thUrlManageMapper.countByExample(adminRoleExample);
            List<ThUrlManage> thUrlManages = Lists.newArrayList();
            if(count!=0) {
                adminRoleExample.setPageCount(pageSize);
                adminRoleExample.setPageIndex(pageIndex);
                thUrlManages = thUrlManageMapper.selectByExample(adminRoleExample);
                if(!CollectionUtils.isEmpty(thUrlManages)){
                    for (ThUrlManage thUrlManage : thUrlManages) {
                        ThProductManageExample example = new ThProductManageExample();
                        example.createCriteria().andProduct_codeEqualTo(thUrlManage.getProduct_code());
                        List<ThProductManage> thProductManages = thProductManageMapper.selectByExample(example);
                        if(!CollectionUtils.isEmpty(thProductManages)){
                            ThProductManage thProductManage = thProductManages.get(0);
                            String product_name1 = thProductManage.getProduct_name();
                            thUrlManage.setProduct_name(product_name1);
                            thUrlManage.setShifou_2_kaifa(thProductManage.getShifou_2_kaifa());
                        }
                        if(aBoolean){
                            thUrlManage.setShow_a_fenpei("0");
                        }else{
                            thUrlManage.setShow_a_fenpei("1");
                        }
                    }
                }

            }
            baseVO.setData(thUrlManages);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setError(JSON.toJSONString(e));
            baseVO.setSuccess(false);
            LOG.error("ThUrlManageController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("url_code") String url_code) {
        BaseVO baseVO = new BaseVO();
        if(StringUtils.isEmpty(url_code)){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("code为空不能删除！");
        }else {
            ThUrlManageExample thProductManageExample = new ThUrlManageExample();
            ThUrlManageExample.Criteria criteria = thProductManageExample.createCriteria();
            criteria.andUrl_codeEqualTo(url_code);
            thUrlManageMapper.deleteByExample(thProductManageExample);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit_user(ThUrlManage adminRoleNew,
                       @RequestParam("account") String editAccount) {
        BaseVO baseVO = new BaseVO();
        try {
            if(adminRoleNew.getId()==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThUrlManage adminRole = thUrlManageMapper.selectByPrimaryKey(adminRoleNew.getId());
            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(editAccount);
            BeanUtils.copyProperties(adminRoleNew,adminRole);
            thUrlManageMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setError(JSON.toJSONString(e));
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThUrlManageController#edit error",e);
        }
        return baseVO;
    }

    /**
     * 分配链接
     * @param adminRoleNew
     * @param editAccount
     * @return
     */
    @RequestMapping("/fenpei")
    public BaseVO fenpei(ThUrlManage adminRoleNew,
                            @RequestParam("account") String editAccount) {
        BaseVO baseVO = new BaseVO();
        try {
            if(adminRoleNew.getId()==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }

            ThUrlManage adminRole = thUrlManageMapper.selectByPrimaryKey(adminRoleNew.getId());
            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(editAccount);
            String shifou_2_kaifa="";
            if(adminRole!=null){
                String product_code = adminRole.getProduct_code();
                ThProductManageExample example = new ThProductManageExample();
                example.createCriteria().andProduct_codeEqualTo(product_code);
                List<ThProductManage> thProductManages = thProductManageMapper.selectByExample(example);
                if(!CollectionUtils.isEmpty(thProductManages)) {
                    ThProductManage thProductManage = thProductManages.get(0);
                    shifou_2_kaifa = thProductManage.getShifou_2_kaifa();
                }

            }
            //是二次开发
            if("是".equals(shifou_2_kaifa)){
                adminRole.setOwner_account(adminRoleNew.getOwner_account());
                String share_url_code = adminRole.getShare_url_code();
                String[] s = share_url_code.split("_");
                String code = s[0]+"_"+s[1]+"_"+s[2]+"_"+adminRoleNew.getOwner_account();
                adminRole.setShare_url_code(code);

                ThProductManageExample example = new ThProductManageExample();
                example.createCriteria()
                        .andProduct_codeEqualTo(s[1])
                        .andProduct_statusEqualTo(1);

                List<ThProductManage> thProductManages = thProductManageMapper.selectByExample(example);
                String url = "";
                if(!CollectionUtils.isEmpty(thProductManages)){
                    ThProductManage thProductManage = thProductManages.get(0);
                    url = thProductManage.getUrl();
                }else{
                    throw new RuntimeException("未查询到相关产品或产品已下线！");
                }
                String url2 = url + "?code=" + code;
                adminRole.setUrl(url2);
            }else{
                adminRole.setOwner_1_account(adminRoleNew.getOwner_1_account());
            }
            thUrlManageMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setError(JSON.toJSONString(e));
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThUrlManageController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(ThUrlManage thProductManage,
            @RequestParam("account") String account) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(thProductManage.getUrl())){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            //分享的唯一编码
            thProductManage.setUrl_code(UUIDUtils.UUID());
            thProductManage.setCreator_account(account);
            thProductManage.setOwner_1_account(account);
            thProductManage.setModifier_account(account);
            thProductManage.setGmt_create(new Date());
            thProductManage.setGmt_modify(new Date());
            thUrlManageMapper.insert(thProductManage);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setError(JSON.toJSONString(e));
            LOG.error("ThUrlManageController#add error",e);
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
                ThUrlManage ThUrlManage = thUrlManageMapper.selectByPrimaryKey(id);
                baseVO.setData(ThUrlManage);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setError(JSON.toJSONString(e));
            LOG.error("ThUrlManageController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_product")
    public BaseVO get_all_product() {
        BaseVO baseVO = new BaseVO();
        try {
            List<ThUrlManage> ThUrlManages = thUrlManageMapper.selectByExample(new ThUrlManageExample());
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(ThUrlManages)){
                for (ThUrlManage ThUrlManage : ThUrlManages) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",ThUrlManage.getProduct_name());
                    map.put("value",ThUrlManage.getId());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setError(JSON.toJSONString(e));
            LOG.error("ThUrlManageController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询用户信息信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/buildUrl")
    public BaseVO buildUrl(@RequestParam("account") String account,@RequestParam("product_code") String product_code) {
        BaseVO baseVO = new BaseVO();
        BuildUrlVO buildUrlVO = new BuildUrlVO();
        baseVO.setData(buildUrlVO);
        try {
            //查询产品链接
            ThProductManageExample example = new ThProductManageExample();
            example.createCriteria()
                    .andProduct_codeEqualTo(product_code)
                    .andProduct_statusEqualTo(1);

            List<ThProductManage> thProductManages = thProductManageMapper.selectByExample(example);
            String sourceUrl = "";
            if(!CollectionUtils.isEmpty(thProductManages)){
                ThProductManage thProductManage = thProductManages.get(0);
                sourceUrl = thProductManage.getUrl();
            }else{
                throw new RuntimeException("未查询到相关产品或产品已下线！");
            }
            ThUrlManageExample thUrlManageExample = new ThUrlManageExample();
            ThUrlManageExample.Criteria criteria = thUrlManageExample.createCriteria();
            criteria.andCreator_accountEqualTo(account);
            criteria.andProduct_codeEqualTo(product_code);
            thUrlManageExample.setOrderByClause("share_url_code desc");
            List<ThUrlManage> thUrlManages = thUrlManageMapper.selectByExample(thUrlManageExample);
            if(!CollectionUtils.isEmpty(thUrlManages)){
                ThUrlManage thUrlManage = thUrlManages.get(0);
                //code逻辑 创建人账号_产品code_版本_归属人账号
                String share_url_code = thUrlManage.getShare_url_code();
                String[] split = share_url_code.split("_");
                Long newVersion = Long.valueOf(split[2])+1L;
                String newShareCode = account+"_"+product_code+"_"+newVersion;
                buildUrlVO.setBuildUrl(sourceUrl+"?code="+newShareCode);
                buildUrlVO.setShareCode(newShareCode);
            }else{
                //code逻辑 创建人账号_产品code_版本_归属人账号
                String newShareCode = account+"_"+product_code+"_"+1;
                buildUrlVO.setBuildUrl(sourceUrl+"?code="+newShareCode);
                buildUrlVO.setShareCode(newShareCode);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setError(JSON.toJSONString(e));
            LOG.error("ThUrlManageController#getAllMenu error",e);
            baseVO.setSuccess(false);
            String msg=e.getMessage();
            baseVO.setErrorMsg("链接自动创建异常！"+msg);
        }
        return baseVO;
    }


    @Resource
    private AdminUserMapper adminUserMapper;

    //查询所有b 如果是允许的账户可以展示所有的A 否则只展示自己
    @RequestMapping("/get_channel_b_and_own")
    public BaseVO getAllUsersB(@RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            List<Map<String,Object>> result = Lists.newArrayList();
            //查询自己
            AdminUserExample adminUserExample1 = new AdminUserExample();
            AdminUserExample.Criteria criteria1 = adminUserExample1.createCriteria();
            criteria1.andAccountEqualTo(account);
            List<AdminUser> adminUsers1 = adminUserMapper.selectByExample(adminUserExample1);
            if(!CollectionUtils.isEmpty(adminUsers1)){
                AdminUser adminUser = adminUsers1.get(0);
                Map<String, Object> map = Maps.newHashMap();
                map.put("label", StringUtils.isEmpty(adminUser.getChannel_name())?adminUser.getAccount():adminUser.getChannel_name());
                map.put("value", adminUser.getAccount());
                result.add(map);
            }

            AdminUserExample adminUserExample = new AdminUserExample();
            AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
            criteria.andChannel_typeEqualTo(2);
            criteria.andCreator_accountEqualTo(account);
            List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);

            if (!CollectionUtils.isEmpty(adminUsers)) {
                for (AdminUser adminUser : adminUsers) {
                    Map<String, Object> map = Maps.newHashMap();
                    map.put("label", StringUtils.isEmpty(adminUser.getChannel_name())?adminUser.getAccount():adminUser.getChannel_name());
                    map.put("value", adminUser.getAccount());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setError(JSON.toJSONString(e));
            LOG.error("AdminUserController#getAllUsers error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询渠道信息异常！");
        }
        return baseVO;
    }


    //根据权限控制显示什么添加按钮
    @RequestMapping("/showAddUrl")
    public BaseVO showAddUrl(@RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            baseVO.setData(showAllUser(account));
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setError(JSON.toJSONString(e));
            LOG.error("AdminUserController#showAddUrl error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询渠道信息异常！");
        }
        return baseVO;
    }


}
