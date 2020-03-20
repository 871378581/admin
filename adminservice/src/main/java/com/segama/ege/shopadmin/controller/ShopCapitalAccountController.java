package com.segama.ege.shopadmin.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.domain.CapitalFlowTypeEnum;
import com.segama.ege.dto.CapitalFlowDTO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.CapitalAccountMapper;
import com.segama.ege.repository.ShopAdminUserDetailInfoMapper;
import com.segama.ege.repository.ShopMapper;
import com.segama.ege.repository.VerifyCommitRecordMapper;
import com.segama.ege.service.CapitalFlowService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hxj
 * @version 1.0
 * @Description 用户信息相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/shop_admin/capital_account")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopCapitalAccountController {
    @Resource
    private CapitalAccountMapper capitalAccountMapper;

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private ShopAdminUserDetailInfoMapper shopAdminUserDetailInfoMapper;

    @Resource
    private VerifyCommitRecordMapper verifyCommitRecordMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopCapitalAccountController.class);


    @RequestMapping("/get")
    public BaseVO get(@RequestParam("account") String account,
                      @RequestParam("shopId") Long shopId) {
        BaseVO baseVO = new BaseVO();
        try {
            if (shopId == null || StringUtils.isEmpty(account)) {
                baseVO.setErrorMsg("必填项不能为空！");
                baseVO.setSuccess(false);
            } else {
                Shop shop = shopMapper.selectByPrimaryKey(shopId);
                if(shop!=null){
                    Long capital_account_id = shop.getCapital_account_id();
                    if(capital_account_id != null){
                        CapitalAccount capitalAccount = capitalAccountMapper.selectByPrimaryKey(capital_account_id);
                        baseVO.setData(capitalAccount);
                    }else{
                        baseVO.setErrorMsg("未添加门店账户！");
                        baseVO.setSuccess(false);
                        return baseVO;
                    }
                }


            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopCapitalAccountController#get Exception input param is account="+account+"，shopId="+shopId, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                       @RequestParam("bankAddr") String bankAddr,
                       @RequestParam("bankNum") String bankNum,
                       @RequestParam("shopId") Long shopId,
                       @RequestParam("account") String account,
                      @RequestParam("payee") String payee) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null || shopId==null || StringUtils.isEmpty(account) ) {
                baseVO.setErrorMsg("必填项不能为空！");
                baseVO.setSuccess(false);
            } else {
                Shop shop = shopMapper.selectByPrimaryKey(shopId);
                if(shop!=null){
                    Long capital_account_id = shop.getCapital_account_id();
                    if(capital_account_id !=id){
                        baseVO.setErrorMsg("没权限操作！");
                        baseVO.setSuccess(false);
                        return baseVO;
                    }
                    if(capital_account_id != null){
                        CapitalAccount capitalAccount = capitalAccountMapper.selectByPrimaryKey(capital_account_id);
                        if(StringUtils.isNotEmpty(bankAddr)) {
                            capitalAccount.setOpening_bank(bankAddr);
                        }
                        if(StringUtils.isNotEmpty(bankNum)) {
                            capitalAccount.setBank_card_num(bankNum);
                        }
                        if(StringUtils.isNotEmpty(payee)) {
                            capitalAccount.setPayee(payee);
                        }
                        capitalAccountMapper.updateByPrimaryKey(capitalAccount);
                    }else{
                        baseVO.setErrorMsg("未添加门店账户！");
                        baseVO.setSuccess(false);
                        return baseVO;
                    }
                }


            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopCapitalAccountController#get Exception input param is account="+account+"，shopId="+shopId, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/doSuply")
    public BaseVO doSuply(
            @RequestParam("id") Long id,//资金账户id
            @RequestParam("amount") BigDecimal amount,//提现金额
                @RequestParam("account") String account,
                      @RequestParam("shopId") Long shopId) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id==null || shopId == null || StringUtils.isEmpty(account) || amount==null) {
                baseVO.setErrorMsg("必填项不能为空！");
                baseVO.setSuccess(false);
            } else {
                Shop shop = shopMapper.selectByPrimaryKey(shopId);
                if(shop!=null){
                    Long capital_account_id = shop.getCapital_account_id();
                    if(capital_account_id != null){
                        CapitalAccount capitalAccount = capitalAccountMapper.selectByPrimaryKey(capital_account_id);
                        if(capitalAccount!=null) {
                            if (capitalAccount.getId() != id ||
                                    StringUtils.isEmpty(capitalAccount.getAvailable_amount())
                                        || 1==amount.compareTo(new BigDecimal(capitalAccount.getAvailable_amount()))
                                        ) {
                                baseVO.setErrorMsg("金额不足，不允许提现！");
                                baseVO.setSuccess(false);
                                return baseVO;
                            }
                            //创建申请
                            //判断是否已经存在申请记录
                           /* VerifyCommitRecordExample example = new VerifyCommitRecordExample();
                            VerifyCommitRecordExample.Criteria criteria = example.createCriteria();
                            criteria.andShop_idEqualTo(shopId);
                            criteria.andOperate_typeEqualTo(1);//0表示店铺信息修改 1门店提现
                            List<VerifyCommitRecord> verifyCommitRecords = verifyCommitRecordMapper.selectByExample(example);
                            if(!CollectionUtils.isEmpty(verifyCommitRecords)){
                                List<VerifyCommitRecord> collect = verifyCommitRecords.stream().filter(e -> {
                                    return e.getStatus() == 2;
                                }).collect(Collectors.toList());
                                if(!CollectionUtils.isEmpty(collect)){
                                    baseVO.setErrorMsg("已经存在未审核的提现申请，请等待审核之后再试！");
                                    baseVO.setSuccess(false);
                                    return baseVO;
                                }
                            }*/

                            //将申请提现的金额冻结 并扣减可用余额
                            BigDecimal subtract = new BigDecimal(capitalAccount.getAvailable_amount()).subtract(amount);
                            BigDecimal freez=BigDecimal.ZERO;
                            if(StringUtils.isNotEmpty(capitalAccount.getFreezing_amount())){
                                freez = new BigDecimal(capitalAccount.getFreezing_amount()).add(amount);
                            }else{
                                freez=amount;
                            }
                            capitalAccount.setFreezing_amount(freez.toString());
                            capitalAccount.setAvailable_amount(subtract.toString());
                            capitalAccount.setGmt_modify(new Date());
                            int i = capitalAccountMapper.updateByPrimaryKey(capitalAccount);
                            if(i>0) {

                                VerifyCommitRecord verifyCommitRecord = new VerifyCommitRecord();
                                verifyCommitRecord.setCreator_account(account);
                                verifyCommitRecord.setGmt_create(new Date());
                                verifyCommitRecord.setGmt_modify(new Date());
                                //0表示店铺申请 1表示资金提现申请
                                verifyCommitRecord.setOperate_type(1);
                                //0表示表示拒绝，1通过通过，2审核中 3 撤回
                                verifyCommitRecord.setStatus(2);
                                verifyCommitRecord.setShop_id(shopId);
                                verifyCommitRecord.setShop_name(shop.getEnterprise_name());
                                Map<String, String> map = Maps.newHashMap();
                                map.put("amount", String.valueOf(amount));
                                map.put("shopId", String.valueOf(shopId));
                                map.put("account", account);
                                map.put("capitalId", id.toString());
                                verifyCommitRecord.setAmount(String.valueOf(amount));
                                ShopAdminUserDetailInfoExample infoExample = new ShopAdminUserDetailInfoExample();
                                ShopAdminUserDetailInfoExample.Criteria criteria1 = infoExample.createCriteria();
                                criteria1.andShop_idEqualTo(shopId);
                                criteria1.andAccountEqualTo(account);
                                List<ShopAdminUserDetailInfo> detailInfos = shopAdminUserDetailInfoMapper.selectByExample(infoExample);
                                if (!CollectionUtils.isEmpty(detailInfos)) {
                                    ShopAdminUserDetailInfo detailInfo = detailInfos.get(0);
                                    map.put("realName", detailInfo.getReal_name());
                                }

                                verifyCommitRecord.setTarget_json(JSON.toJSONString(map));
                                verifyCommitRecord.setChange_json(JSON.toJSONString(map));
                                int insert = verifyCommitRecordMapper.insert(verifyCommitRecord);
                                if(insert>0) {
                                    map.put("verify_id",verifyCommitRecord.getId().toString());
                                    financialFlow(map, "发起提现申请");
                                }
                            }
                        }
                    }else{
                        baseVO.setErrorMsg("未添加门店账户！不允许提现！");
                        baseVO.setSuccess(false);
                        return baseVO;
                    }
                }


            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopCapitalAccountController#doSuply Exception input param is account="+account+"，shopId="+shopId, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("操作异常！");
        }
        return baseVO;
    }

    @Resource
    private CapitalFlowService capitalFlowService;

    private void financialFlow(Map<String,String> map,String desc){
        try {
            Shop shop = shopMapper.selectByPrimaryKey(Long.valueOf(map.get("shopId")));
            if(shop!=null){
                CapitalFlowDTO capitalFlowDTO = new CapitalFlowDTO();
                capitalFlowDTO.setOperate_type(CapitalFlowTypeEnum.cashout.getCode());
                capitalFlowDTO.setAccount(map.get("account"));
                capitalFlowDTO.setAmount(map.get("amount"));
                capitalFlowDTO.setReal_name(map.get("realName"));
                String verify_id = map.get("verify_id");
                if(StringUtils.isNotEmpty(verify_id)) {
                    capitalFlowDTO.setVerify_id(Long.valueOf(verify_id));
                }
                capitalFlowDTO.setDescription(desc);
                capitalFlowService.insertFlow(capitalFlowDTO,shop);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
