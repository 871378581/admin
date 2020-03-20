package com.segama.ege.shopadmin.controller;

import com.alibaba.fastjson.JSON;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.Shop;
import com.segama.ege.entity.VerifyCommitRecord;
import com.segama.ege.entity.VerifyCommitRecordExample;
import com.segama.ege.repository.ShopMapper;
import com.segama.ege.repository.VerifyCommitRecordMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxj
 * @version 1.0
 * @Description 汽车管理相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/shop_admin/verify_commit")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VerifyCommitRecordShopAdminController {
    @Resource
    private VerifyCommitRecordMapper verifyCommitRecordMapper;

    @Resource
    private ShopMapper shopMapper;

    private static Logger LOG = LoggerFactory.getLogger(VerifyCommitRecordShopAdminController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("shop_id") Long shop_id
            ,@RequestParam("type") Integer type
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            VerifyCommitRecordExample example = new VerifyCommitRecordExample();
            VerifyCommitRecordExample.Criteria carExampleCriteria = example.createCriteria();

            if (shop_id!=null) {
                carExampleCriteria.andShop_idEqualTo(shop_id);
            }
            carExampleCriteria.andOperate_typeEqualTo(type);
            example.setOrderByClause("gmt_create desc");

            int count = verifyCommitRecordMapper.countByExample(example);
            example.setPageCount(pageSize);
            example.setPageIndex(pageIndex);
            List<VerifyCommitRecord> verifyCommitRecords = verifyCommitRecordMapper.selectByExample(example);
            baseVO.setData(verifyCommitRecords);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("VerifyCommitRecordShopAdminController#list error", e);
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
                Map<String,Object> map = new HashMap<>();
                VerifyCommitRecord verifyCommitRecord = verifyCommitRecordMapper.selectByPrimaryKey(id);
                if(verifyCommitRecord.getOperate_type()==0) {
                    Shop shop = shopMapper.selectByPrimaryKey(verifyCommitRecord.getShop_id());
                    map.put("newShopVerify", verifyCommitRecord);
                    map.put("oldShop", shop);
                    baseVO.setData(map);
                    //资金审核
                }else if(verifyCommitRecord.getOperate_type()==1){
                    baseVO.setData(verifyCommitRecord);
                }
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("VerifyCommitRecordShopAdminController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/withdraw")
    public BaseVO withdraw(@RequestParam("id") Long id,@RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null) {
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            } else {
                Map<String,Object> map = new HashMap<>();
                VerifyCommitRecord verifyCommitRecord = verifyCommitRecordMapper.selectByPrimaryKey(id);
                verifyCommitRecord.setRemark(account+"操作撤回");
                verifyCommitRecord.setModifier_account(account);
                verifyCommitRecord.setOperate_type(0);
                verifyCommitRecord.setStatus(3);
                verifyCommitRecord.setGmt_modify(new Date());
                verifyCommitRecordMapper.updateByPrimaryKey(verifyCommitRecord);
                baseVO.setData(map);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("VerifyCommitRecordShopAdminController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
