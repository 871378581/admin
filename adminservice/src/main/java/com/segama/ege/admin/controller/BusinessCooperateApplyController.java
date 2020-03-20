package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.BusinessCooperateApply;
import com.segama.ege.entity.BusinessCooperateApplyExample;
import com.segama.ege.repository.BusinessCooperateApplyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description businessCooperateApply相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/business_cooperate_apply")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BusinessCooperateApplyController {
    @Resource
    private BusinessCooperateApplyMapper businessCooperateApplyMapper;

    private static Logger LOG = LoggerFactory.getLogger(BusinessCooperateApplyController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            BusinessCooperateApplyExample businessCooperateApplyExample = new BusinessCooperateApplyExample();
            BusinessCooperateApplyExample.Criteria businessCooperateApplyExampleCriteria = businessCooperateApplyExample.createCriteria();
            int count = businessCooperateApplyMapper.countByExample(businessCooperateApplyExample);
            businessCooperateApplyExample.setPageCount(pageSize);
            businessCooperateApplyExample.setPageIndex(pageIndex);
            businessCooperateApplyExample.setOrderByClause("gmt_create desc");
            List<BusinessCooperateApply> businessCooperateApplys = businessCooperateApplyMapper.selectByExample(businessCooperateApplyExample);
            baseVO.setData(businessCooperateApplys);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("BusinessCooperateApplyController#list error",e);
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
            businessCooperateApplyMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("account") String account,
                    @RequestParam("contacter_status") String contacter_status,
                    @RequestParam("remark") String remark,
                    @RequestParam("shop_name") String shop_name, //门店名称,
                    @RequestParam("shop_area_size")String  shop_area_size,//门店面积,
                    @RequestParam("shop_address") String shop_address,//门店地址,
                    @RequestParam("merchant_type")String merchant_type//商务合作类型：1=门店，2=渠道,
                               ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            BusinessCooperateApply businessCooperateApply = businessCooperateApplyMapper.selectByPrimaryKey(id);
            if(contacter_status!=null){
                businessCooperateApply.setContacter_status(contacter_status);
            }
            if(!StringUtils.isEmpty(shop_name)){
                businessCooperateApply.setShop_name(shop_name);
            }
            if(!StringUtils.isEmpty(remark)){
                businessCooperateApply.setRemark(remark);
            }
            if(!StringUtils.isEmpty(shop_area_size)){
                businessCooperateApply.setShop_area_size(shop_area_size);
            }
            if(!StringUtils.isEmpty(shop_address)){
                businessCooperateApply.setShop_address(shop_address);
            }
            if(!StringUtils.isEmpty(merchant_type)){
                businessCooperateApply.setMerchant_type(merchant_type);
            }
            businessCooperateApply.setGmt_modify(new Date());
            businessCooperateApply.setModifier_account(account);
            businessCooperateApplyMapper.updateByPrimaryKey(businessCooperateApply);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("BusinessCooperateApplyController#edit error",e);
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
                BusinessCooperateApply businessCooperateApply = businessCooperateApplyMapper.selectByPrimaryKey(id);
                baseVO.setData(businessCooperateApply);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("BusinessCooperateApplyController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
