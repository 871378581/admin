package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.AdminSystemConfigMapper;
import com.segama.ege.repository.ThBusinessMerchantManageMapper;
import com.segama.ege.repository.ThProductChannelMapMapper;
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
public class ProductController extends BaseController {

    @Resource
    private ThProductManageMapper thProductManageMapper;

    @Resource
    private ThProductChannelMapMapper thProductChannelMapMapper;

    @Resource
    private ThBusinessMerchantManageMapper thBusinessMerchantManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "product_name", required = false) String product_name
            ,@RequestParam(value = "type", required = false) String type
            , @RequestParam(value = "limit", required = false) Integer pageSize,
            @RequestParam(value = "page", required = false) Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThProductManageExample adminRoleExample = new ThProductManageExample();
            adminRoleExample.setOrderByClause("gmt_create desc");
            ThProductManageExample.Criteria adminRoleExampleCriteria = adminRoleExample.createCriteria();
            if (StringUtils.isNotEmpty(product_name)) {
                adminRoleExampleCriteria.andProduct_nameLike("%" + product_name + "%");
            }
            if (StringUtils.isNotEmpty(type)) {
                adminRoleExampleCriteria.andTypeEqualTo(type);
            }
            int count = thProductManageMapper.countByExample(adminRoleExample);
            List<ThProductManage> thProductManages = Lists.newArrayList();
            if (count != 0) {
                adminRoleExample.setPageCount(pageSize);
                adminRoleExample.setPageIndex(pageIndex);
                thProductManages = thProductManageMapper.selectByExample(adminRoleExample);
                if (!CollectionUtils.isEmpty(thProductManages)) {
                    for (ThProductManage thProductManage : thProductManages) {
                        ThBusinessMerchantManageExample example = new ThBusinessMerchantManageExample();
                        if (!StringUtils.isEmpty(thProductManage.getBusiness_code())) {
                            example.createCriteria().andBusiness_codeEqualTo(thProductManage.getBusiness_code());
                            List<ThBusinessMerchantManage> thBusinessMerchantManages = thBusinessMerchantManageMapper.selectByExample(example);
                            if (!CollectionUtils.isEmpty(thBusinessMerchantManages)) {
                                ThBusinessMerchantManage manage = thBusinessMerchantManages.get(0);
                                thProductManage.setBusiness_name(manage.getBusiness_name());
                            }
                        }
                    }
                }
            }
            baseVO.setData(thProductManages);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("ThProductManageController#list error", e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("product_code") String product_code) {
        BaseVO baseVO = new BaseVO();
        if (StringUtils.isEmpty(product_code)) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("code为空不能删除！");
        } else {
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
            if (adminRoleNew.getId() == null) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThProductManage adminRole = thProductManageMapper.selectByPrimaryKey(adminRoleNew.getId());

            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(editAccount);
            BeanUtils.copyProperties(adminRoleNew, adminRole);
            thProductManageMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThProductManageController#edit error", e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(ThProductManage thProductManage,
                      @RequestParam("account") String account) {

        BaseVO baseVO = new BaseVO();
        try {
            if (StringUtils.isEmpty(thProductManage.getProduct_name()) || StringUtils.isEmpty(thProductManage.getProduct_type())) {
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
            LOG.error("ThProductManageController#add error", e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null) {
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            } else {
                ThProductManage ThProductManage = thProductManageMapper.selectByPrimaryKey(id);
                baseVO.setData(ThProductManage);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThProductManageController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_product")
    public BaseVO get_all_product(
            @RequestParam(value = "shifou_2_kaifa", required = false) String shifou_2_kaifa
            ,@RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "account", required = false) String account) {
        BaseVO baseVO = new BaseVO();
        try {
            ThProductManageExample example = new ThProductManageExample();
            ThProductManageExample.Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(code)){
                criteria.andBusiness_codeEqualTo(code);
            }
            if(!StringUtils.isEmpty(shifou_2_kaifa)){
                criteria.andShifou_2_kaifaEqualTo(shifou_2_kaifa);
            }
            List<Map<String, Object>> result = Lists.newArrayList();
            if (showAllUser(account)) {
                //只查上线的产品
                criteria.andProduct_statusEqualTo(1);
                List<ThProductManage> ThProductManages = thProductManageMapper.selectByExample(example);
                if (!CollectionUtils.isEmpty(ThProductManages)) {
                    for (ThProductManage ThProductManage : ThProductManages) {
                        Map<String, Object> map = Maps.newHashMap();
                        map.put("label", ThProductManage.getProduct_name());
                        map.put("value", ThProductManage.getProduct_code());
                        result.add(map);
                    }
                }
            } else {
                //查询A下面的所有产品
                ThProductChannelMapExample example1 = new ThProductChannelMapExample();
                ThProductChannelMapExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andProduct_onwer_accountEqualTo(account);
                if(!StringUtils.isEmpty(code)){
                    criteria1.andBusiness_codeEqualTo(code);
                }

                List<ThProductChannelMap> thProductChannelMaps = thProductChannelMapMapper.selectByExample(example1);
                if (!CollectionUtils.isEmpty(thProductChannelMaps)) {
                    for (ThProductChannelMap thProductChannelMap : thProductChannelMaps) {
                        ThProductManageExample example2 = new ThProductManageExample();
                        ThProductManageExample.Criteria criteria2 = example2.createCriteria();
                        criteria2.andProduct_codeEqualTo(thProductChannelMap.getProduct_code());

                        List<ThProductManage> thProductManages = thProductManageMapper.selectByExample(example2);
                        if (!CollectionUtils.isEmpty(thProductManages)) {
                            ThProductManage thProductManage = thProductManages.get(0);
                            if(!StringUtils.isEmpty(shifou_2_kaifa)){
                                if (thProductManage.getShifou_2_kaifa().equals(shifou_2_kaifa)
                                        && thProductManage.getProduct_status().equals(1)) {
                                    Map<String, Object> map = Maps.newHashMap();
                                    map.put("label", thProductManage.getProduct_name());
                                    map.put("value", thProductManage.getProduct_code());
                                    result.add(map);
                                }
                            }else {
                                if (thProductManage.getProduct_status().equals(1)) {
                                    Map<String, Object> map = Maps.newHashMap();
                                    map.put("label", thProductManage.getProduct_name());
                                    map.put("value", thProductManage.getProduct_code());
                                    result.add(map);
                                }
                            }
                        }
                    }
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThProductManageController#getAllMenu error", e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
