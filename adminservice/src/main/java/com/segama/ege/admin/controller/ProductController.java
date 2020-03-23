package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ThProductManage;
import com.segama.ege.entity.ThProductManageExample;
import com.segama.ege.repository.ThProductManageMapper;
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
 * @Description 产品相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/product_manage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
    
    @Resource
    private ThProductManageMapper thProductManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "product_name" ,required = false) String product_name
            ,@RequestParam(value = "limit",required = false) Integer pageSize,
            @RequestParam(value = "page",required = false) Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThProductManageExample adminRoleExample = new ThProductManageExample();
            adminRoleExample.setOrderByClause("gmt_create desc");
            ThProductManageExample.Criteria adminRoleExampleCriteria = adminRoleExample.createCriteria();
            if(StringUtils.isNotEmpty(product_name)) {
                adminRoleExampleCriteria.andProduct_nameLike("%" + product_name + "%");
            }
            int count = thProductManageMapper.countByExample(adminRoleExample);
            if(count!=0) {
                adminRoleExample.setPageCount(pageSize);
                adminRoleExample.setPageIndex(pageIndex);
                List<ThProductManage> ThProductManages = thProductManageMapper.selectByExample(adminRoleExample);
                baseVO.setData(ThProductManages);
                baseVO.setSuccess(true);
            }

            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ThProductManageController#list error",e);
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
            ThProductManageExample thProductManageExample = new ThProductManageExample();
            ThProductManageExample.Criteria criteria = thProductManageExample.createCriteria();
            criteria.andProduct_codeEqualTo(product_code);
            thProductManageMapper.deleteByExample(thProductManageExample);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit_user(ThProductManage adminRoleNew,
                       @RequestParam("account") String editAccount) {
        BaseVO baseVO = new BaseVO();
        try {
            if(adminRoleNew.getId()==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThProductManage adminRole = thProductManageMapper.selectByPrimaryKey(adminRoleNew.getId());

            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(editAccount);
            BeanUtils.copyProperties(adminRoleNew,adminRole);
            thProductManageMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThProductManageController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(ThProductManage thProductManage,
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
            thProductManageMapper.insert(thProductManage);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThProductManageController#add error",e);
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
                ThProductManage ThProductManage = thProductManageMapper.selectByPrimaryKey(id);
                baseVO.setData(ThProductManage);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThProductManageController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_product")
    public BaseVO getAllMenu() {
        BaseVO baseVO = new BaseVO();
        try {
            List<ThProductManage> ThProductManages = thProductManageMapper.selectByExample(new ThProductManageExample());
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(ThProductManages)){
                for (ThProductManage ThProductManage : ThProductManages) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",ThProductManage.getProduct_name());
                    map.put("value",ThProductManage.getProduct_name());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThProductManageController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询用户信息信息异常！");
        }
        return baseVO;
    }


}