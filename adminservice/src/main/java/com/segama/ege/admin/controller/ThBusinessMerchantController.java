package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ThBusinessMerchantManage;
import com.segama.ege.entity.ThBusinessMerchantManageExample;
import com.segama.ege.entity.AdminRoleMenuRelationExample;
import com.segama.ege.entity.ThProductChannelMap;
import com.segama.ege.repository.ThBusinessMerchantManageMapper;
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
 * @Description 商户管理相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/business_merchant")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ThBusinessMerchantController {
    @Resource
    private ThBusinessMerchantManageMapper thBusinessMerchantManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(ThBusinessMerchantController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("business_name") String business_name
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThBusinessMerchantManageExample example = new ThBusinessMerchantManageExample();
            ThBusinessMerchantManageExample.Criteria critier = example.createCriteria();
            if(StringUtils.isNotEmpty(business_name)) {
                critier.andBusiness_nameLike("%" + business_name + "%");
            }
            int count = thBusinessMerchantManageMapper.countByExample(example);
            example.setPageCount(pageSize);
            example.setPageIndex(pageIndex);
            example.setOrderByClause("gmt_create desc");
            List<ThBusinessMerchantManage> thBusinessMerchantManages = thBusinessMerchantManageMapper.selectByExample(example);
            baseVO.setData(thBusinessMerchantManages);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ThBusinessMerchantManageController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("business_code") String business_code) {
        BaseVO baseVO = new BaseVO();
        if(StringUtils.isEmpty(business_code)){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("code为空不能删除！");
        }else {
            ThBusinessMerchantManageExample example = new ThBusinessMerchantManageExample();
            ThBusinessMerchantManageExample.Criteria criteria = example.createCriteria();
            criteria.andBusiness_codeEqualTo(business_code);
            thBusinessMerchantManageMapper.deleteByExample(example);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(ThBusinessMerchantManage manage,
                    @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(manage.getId()==null || StringUtils.isEmpty(account)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThBusinessMerchantManage thBusinessMerchantManage = thBusinessMerchantManageMapper.selectByPrimaryKey(manage.getId());
            thBusinessMerchantManage.setGmt_modify(new Date());
            thBusinessMerchantManage.setModifier_account(account);
            BeanUtils.copyProperties(manage,thBusinessMerchantManage);
            baseVO.setSuccess(true);
            thBusinessMerchantManageMapper.updateByPrimaryKey(thBusinessMerchantManage);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThBusinessMerchantManageController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(ThBusinessMerchantManage manage,
                      @RequestParam("account") String account) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(account) ||
                    StringUtils.isEmpty(manage.getBusiness_name())){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            manage.setId(null);
            manage.setCreator_account(account);
            manage.setModifier_account(account);
            manage.setBusiness_code(UUIDUtils.UUID());
            manage.setGmt_create(new Date());
            manage.setGmt_modify(new Date());
            thBusinessMerchantManageMapper.insert(manage);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThBusinessMerchantManageController#add error",e);
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
                ThBusinessMerchantManage thBusinessMerchantManage = thBusinessMerchantManageMapper.selectByPrimaryKey(id);
                baseVO.setData(thBusinessMerchantManage);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThBusinessMerchantManageController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_merchants")
    public BaseVO getAllMenu() {
        BaseVO baseVO = new BaseVO();
        try {
            List<ThBusinessMerchantManage> thBusinessMerchantManages = thBusinessMerchantManageMapper.selectByExample(new ThBusinessMerchantManageExample());
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(thBusinessMerchantManages)){
                for (ThBusinessMerchantManage menuInfo : thBusinessMerchantManages) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",menuInfo.getBusiness_name());
                    map.put("value",menuInfo.getBusiness_code());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThBusinessMerchantManageController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
