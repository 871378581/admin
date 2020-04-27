package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ThLtOrderSyncData;
import com.segama.ege.entity.ThLtOrderSyncDataExample;
import com.segama.ege.entity.ThOrderManage;
import com.segama.ege.repository.ThLtOrderSyncDataMapper;
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

/**
 * @author hxj
 * @version 1.0
 * @Description 订单相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/sync_order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LianTong5GOrderSyncController extends BaseController {
    @Resource
    private ThLtOrderSyncDataMapper thLtOrderSyncDataMapper;

    private static Logger LOG = LoggerFactory.getLogger(LianTong5GOrderSyncController.class);

    @RequestMapping("/list")
    public BaseVO list(
            ThLtOrderSyncData thLtOrderSyncData
            ,@RequestParam("account") String account
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThLtOrderSyncDataExample ex = new ThLtOrderSyncDataExample();
            ThLtOrderSyncDataExample.Criteria thOrderManageExampleCriteria = ex.createCriteria();
            if(StringUtils.isNotEmpty(thLtOrderSyncData.getChannel_code())) {
                thOrderManageExampleCriteria.andChannel_codeEqualTo( thLtOrderSyncData.getChannel_code() );
            }
            if(StringUtils.isNotEmpty(thLtOrderSyncData.getFreeze())) {
                thOrderManageExampleCriteria.andFreezeEqualTo(thLtOrderSyncData.getFreeze());
            }
            int count = thLtOrderSyncDataMapper.countByExample(ex);
            ex.setPageCount(pageSize);
            ex.setPageIndex(pageIndex);
            ex.setOrderByClause("gmt_create desc");
            List<ThLtOrderSyncData> thOrderManages = Lists.newArrayList();
            if(count>0) {
                thOrderManages = thLtOrderSyncDataMapper.selectByExample(ex);
            }
            baseVO.setData(thOrderManages);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("LianTong5GOrderSyncController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(ThLtOrderSyncData thLtOrderSyncData,
                    @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(thLtOrderSyncData.getCode())){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThLtOrderSyncDataExample example = new ThLtOrderSyncDataExample();
            example.createCriteria().andCodeEqualTo(thLtOrderSyncData.getCode());
            List<ThLtOrderSyncData> thLtOrderSyncData1 = thLtOrderSyncDataMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(thLtOrderSyncData1)) {
                ThLtOrderSyncData thLtOrderSyncData2 = thLtOrderSyncData1.get(0);
                thLtOrderSyncData2.setGmt_modify(new Date());
                thLtOrderSyncData2.setModifier_account(account);
                BeanUtils.copyProperties(thLtOrderSyncData, thLtOrderSyncData2);
                thLtOrderSyncDataMapper.updateByPrimaryKey(thLtOrderSyncData2);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("LianTong5GOrderSyncController#edit error",e);
        }
        return baseVO;
    }



    @RequestMapping("/get")
    public BaseVO get(@RequestParam("code") String order_code ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(order_code)){
                baseVO.setErrorMsg("code为不能为空！");
                baseVO.setSuccess(false);
            }else {
                ThLtOrderSyncDataExample thOrderManageExample = new ThLtOrderSyncDataExample();
                thOrderManageExample.createCriteria().andCodeEqualTo(order_code);
                List<ThLtOrderSyncData> thLtOrderSyncData = thLtOrderSyncDataMapper.selectByExample(thOrderManageExample);
                if(!CollectionUtils.isEmpty(thLtOrderSyncData)){
                    baseVO.setData(thLtOrderSyncData.get(0));
                }
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("LianTong5GOrderSyncController#get Exception input param is order_code="+order_code,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }
    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("code") String code ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(code)){
                baseVO.setErrorMsg("code为不能为空！");
                baseVO.setSuccess(false);
            }else {
                ThLtOrderSyncDataExample example = new ThLtOrderSyncDataExample();
                example.createCriteria().andCodeEqualTo(code);
                thLtOrderSyncDataMapper.deleteByExample(example);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("LianTong5GOrderSyncController#get Exception input param is code:"+code,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("操作异常！");
        }
        return baseVO;
    }

}
