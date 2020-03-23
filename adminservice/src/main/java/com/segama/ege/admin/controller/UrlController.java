package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ThUrlManage;
import com.segama.ege.entity.ThUrlManageExample;
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
public class UrlController {
    
    @Resource
    private ThUrlManageMapper thUrlManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(UrlController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "product_name" ,required = false) String product_name
            ,@RequestParam(value = "limit",required = false) Integer pageSize,
            @RequestParam(value = "page",required = false) Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThUrlManageExample adminRoleExample = new ThUrlManageExample();
            adminRoleExample.setOrderByClause("gmt_create desc");
            ThUrlManageExample.Criteria adminRoleExampleCriteria = adminRoleExample.createCriteria();
            if(StringUtils.isNotEmpty(product_name)) {
                adminRoleExampleCriteria.andProduct_nameLike("%" + product_name + "%");
            }
            int count = thUrlManageMapper.countByExample(adminRoleExample);
            if(count!=0) {
                adminRoleExample.setPageCount(pageSize);
                adminRoleExample.setPageIndex(pageIndex);
                List<ThUrlManage> ThUrlManages = thUrlManageMapper.selectByExample(adminRoleExample);
                baseVO.setData(ThUrlManages);
                baseVO.setSuccess(true);
            }

            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ThUrlManageController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("product_code") String product_code) {
        BaseVO baseVO = new BaseVO();
        if(StringUtils.isEmpty(product_code)){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("code为空不能删除！");
        }else {
            ThUrlManageExample thProductManageExample = new ThUrlManageExample();
            ThUrlManageExample.Criteria criteria = thProductManageExample.createCriteria();
            criteria.andProduct_codeEqualTo(product_code);
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
            if( StringUtils.isEmpty(thProductManage.getProduct_name())|| StringUtils.isEmpty(thProductManage.getProduct_type())){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            thProductManage.setCreator_account(account);
            thProductManage.setModifier_account(account);
            thProductManage.setGmt_create(new Date());
            thProductManage.setGmt_modify(new Date());
            thProductManage.setProduct_code(UUIDUtils.UUID());
            thUrlManageMapper.insert(thProductManage);
            baseVO.setSuccess(true);
        } catch (Exception e) {
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
            LOG.error("ThUrlManageController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_product")
    public BaseVO getAllMenu() {
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
            LOG.error("ThUrlManageController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询用户信息信息异常！");
        }
        return baseVO;
    }


}
