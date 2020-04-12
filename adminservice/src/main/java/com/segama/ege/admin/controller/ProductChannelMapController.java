package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.LabelValueVO;
import com.segama.ege.entity.*;
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
import java.util.Set;

/**
 * @author hxj
 * @version 1.0
 * @Description 产品渠道映射关系相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/product_channel_map")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductChannelMapController extends BaseController{
    
    @Resource
    private ThProductChannelMapMapper thProductChannelMapMapper;

    @Resource
    private ThProductManageMapper thProductManageMapper;

    @Resource
    private ThBusinessMerchantManageMapper thBusinessMerchantManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(ProductChannelMapController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "product_code" ,required = false) String product_code
            ,@RequestParam(value = "product_onwer_account" ,required = false) String product_onwer_account
            ,@RequestParam(value = "limit",required = false) Integer pageSize,
            @RequestParam(value = "page",required = false) Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThProductChannelMapExample thProductChannelMapExample = new ThProductChannelMapExample();
            thProductChannelMapExample.setOrderByClause("gmt_create desc");
            ThProductChannelMapExample.Criteria thProductChannelMapExampleCriteria = thProductChannelMapExample.createCriteria();
            if(StringUtils.isNotEmpty(product_code)) {
                thProductChannelMapExampleCriteria.andProduct_codeEqualTo(product_code);
            }
            if(StringUtils.isNotEmpty(product_onwer_account)) {
                thProductChannelMapExampleCriteria.andProduct_onwer_accountEqualTo(product_onwer_account);
            }
            int count = thProductChannelMapMapper.countByExample(thProductChannelMapExample);
            List<ThProductChannelMap> thProductChannelMaps = Lists.newArrayList();
            if(count!=0) {
                thProductChannelMapExample.setPageCount(pageSize);
                thProductChannelMapExample.setPageIndex(pageIndex);
                thProductChannelMaps = thProductChannelMapMapper.selectByExample(thProductChannelMapExample);
                if(!CollectionUtils.isEmpty(thProductChannelMaps)){
                    for (ThProductChannelMap thProductChannelMap : thProductChannelMaps) {
                        ThProductManageExample example = new ThProductManageExample();
                        ThProductManageExample.Criteria criteria = example.createCriteria();
                        criteria.andProduct_codeEqualTo(thProductChannelMap.getProduct_code());
                        List<ThProductManage> thProductManages = thProductManageMapper.selectByExample(example);
                        if(!CollectionUtils.isEmpty(thProductManages)){
                            ThProductManage thProductManage = thProductManages.get(0);
                            thProductChannelMap.setProduct_name(thProductManage.getProduct_name());
                        }
                    }
                }
            }
            baseVO.setData(thProductChannelMaps);
            baseVO.setCount(count);
            baseVO.setSuccess(true);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ThProductChannelMapController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("biz_code") String biz_code) {
        BaseVO baseVO = new BaseVO();
        if(StringUtils.isEmpty(biz_code)){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("code为空不能删除！");
        }else {
            ThProductChannelMapExample thProductChannelMapExample = new ThProductChannelMapExample();
            ThProductChannelMapExample.Criteria criteria = thProductChannelMapExample.createCriteria();
            criteria.andBiz_codeEqualTo(biz_code);
            thProductChannelMapMapper.deleteByExample(thProductChannelMapExample);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit_user(ThProductChannelMap adminRoleNew,
                       @RequestParam("account") String editAccount) {
        BaseVO baseVO = new BaseVO();
        try {
            if(adminRoleNew.getId()==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThProductChannelMap adminRole = thProductChannelMapMapper.selectByPrimaryKey(adminRoleNew.getId());

            adminRole.setGmt_modify(new Date());
            adminRole.setModifier_account(editAccount);
            BeanUtils.copyProperties(adminRoleNew,adminRole);
            thProductChannelMapMapper.updateByPrimaryKey(adminRole);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("ThProductChannelMapController#edit error",e);

            String msg = "";
            if(StringUtils.isNotEmpty(e.getMessage())&&e.getMessage().contains("Duplicate")){
                msg="，请勿重复添加！";
            }
            baseVO.setErrorMsg("编辑异常"+msg);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(ThProductChannelMap thProductChannelMap,
            @RequestParam("account") String account) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(thProductChannelMap.getProduct_code())){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            thProductChannelMap.setCreator_account(account);
            thProductChannelMap.setModifier_account(account);
            thProductChannelMap.setGmt_create(new Date());
            thProductChannelMap.setGmt_modify(new Date());
            thProductChannelMap.setBiz_code(UUIDUtils.UUID());
            thProductChannelMapMapper.insert(thProductChannelMap);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThProductChannelMapController#add error",e);
            baseVO.setSuccess(false);
            String msg = "";
            if(StringUtils.isNotEmpty(e.getMessage())&&e.getMessage().contains("Duplicate")){
                msg="，请勿重复添加！";
            }
            baseVO.setErrorMsg("添加异常"+msg);
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id == null){
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            }else {
                ThProductChannelMap thProductChannelMap = thProductChannelMapMapper.selectByPrimaryKey(id);
                baseVO.setData(thProductChannelMap);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThProductChannelMapController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_product")
    public BaseVO getAllMenu(@RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            ThProductChannelMapExample example = new ThProductChannelMapExample();
            ThProductChannelMapExample.Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(account)){
                criteria.andProduct_onwer_accountEqualTo(account);
            }
            List<ThProductChannelMap> thProductChannelMaps = thProductChannelMapMapper.selectByExample(example);
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(thProductChannelMaps)){
                for (ThProductChannelMap thProductChannelMap : thProductChannelMaps) {
                    Map<String,Object> map = Maps.newHashMap();

                    //查询产品名称
                    ThProductManageExample thProductManageExample = new ThProductManageExample();
                    ThProductManageExample.Criteria criteria1 = thProductManageExample.createCriteria();
                    criteria1.andProduct_codeEqualTo(thProductChannelMap.getProduct_code());
                    List<ThProductManage> thProductManages = thProductManageMapper.selectByExample(thProductManageExample);
                    if(!CollectionUtils.isEmpty(thProductManages)){
                        ThProductManage thProductManage = thProductManages.get(0);
                        map.put("label",thProductManage.getProduct_name());
                    }
                    map.put("value",thProductChannelMap.getProduct_code());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThProductChannelMapController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询用户信息信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/getAllBusiness")
    public BaseVO getAllBusiness(@RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            ThProductChannelMapExample example = new ThProductChannelMapExample();
            ThProductChannelMapExample.Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(account) && !showAllUser(account)){
                criteria.andProduct_onwer_accountEqualTo(account);
            }
            List<ThProductChannelMap> thProductChannelMaps = thProductChannelMapMapper.selectByExample(example);
            Set<LabelValueVO> result = Sets.newHashSet();
            if(!CollectionUtils.isEmpty(thProductChannelMaps)){
                for (ThProductChannelMap thProductChannelMap : thProductChannelMaps) {
                    LabelValueVO labelValueVO = new LabelValueVO();

                    //查询商户名称
                    ThBusinessMerchantManageExample example1 = new ThBusinessMerchantManageExample();
                    ThBusinessMerchantManageExample.Criteria criteria1 = example1.createCriteria();
                    criteria1.andBusiness_codeEqualTo(thProductChannelMap.getBusiness_code());
                    List<ThBusinessMerchantManage> thBusinessMerchantManages = thBusinessMerchantManageMapper.selectByExample(example1);
                    if(!CollectionUtils.isEmpty(thBusinessMerchantManages)){
                        ThBusinessMerchantManage manage = thBusinessMerchantManages.get(0);
                        labelValueVO.setLabel(manage.getBusiness_name());
                        labelValueVO.setValue(manage.getBusiness_code());
                        result.add(labelValueVO);
                    }
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThProductChannelMapController#getAllBusiness error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }


}
