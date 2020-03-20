package com.segama.ege.admin.controller;

import com.alibaba.fastjson.JSON;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.admin.utils.ExcelUtil;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.domain.CapitalFlowTypeEnum;
import com.segama.ege.dto.CapitalFlowDTO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.CapitalAccountMapper;
import com.segama.ege.repository.CarMapper;
import com.segama.ege.repository.ShopMapper;
import com.segama.ege.repository.VerifyCommitRecordMapper;
import com.segama.ege.service.CapitalFlowService;
import com.segama.ege.util.PlateConvertUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author hxj
 * @version 1.0
 * @Description 汽车管理相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/verify_commit")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VerifyCommitRecordAdminController {
    @Resource
    private VerifyCommitRecordMapper verifyCommitRecordMapper;

    @Resource
    private HttpServletResponse httpServletResponse;

    @Resource
    private ShopMapper shopMapper;

    private static Logger LOG = LoggerFactory.getLogger(VerifyCommitRecordAdminController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("shop_name") String shop_name
            ,@RequestParam("type") Integer type
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            VerifyCommitRecordExample example = new VerifyCommitRecordExample();
            VerifyCommitRecordExample.Criteria carExampleCriteria = example.createCriteria();

            if (StringUtils.isNotEmpty(shop_name)) {
                carExampleCriteria.andShop_nameLike("%" + shop_name + "%");
            }
            carExampleCriteria.andOperate_typeEqualTo(type);
            //将撤回de申请剔除
            carExampleCriteria.andStatusNotEqualTo(3);
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
            LOG.error("VerifyCommitRecordAdminController#list error", e);
        }
        return baseVO;
    }

    @RequestMapping("/export")
    public void export() {
        try {
            VerifyCommitRecordExample example = new VerifyCommitRecordExample();
            VerifyCommitRecordExample.Criteria criteria = example.createCriteria();
            criteria.andOperate_typeEqualTo(1);
            criteria.andStatusEqualTo(2);
            List<VerifyCommitRecord> verifyCommitRecords = verifyCommitRecordMapper.selectByExampleWithBLOBs(example);
            ExcelUtil.exportExcel(
                    "门店资金提现数据表格",
                    new String[]{"门店","开户行","银行卡号","收款人","提现金额","创建人账号","提现发起人"},
                    new ArrayList<Object[]>() {{
                        for (VerifyCommitRecord record : verifyCommitRecords) {
                            Map<String,String> map = JSON.parseObject(record.getTarget_json(),Map.class);
                            String capitalId = map.get("capitalId");
                            String amount = map.get("amount");
                            String realName = map.get("realName");
                            Long capitalIdL = Long.valueOf(capitalId);
                            CapitalAccount capitalAccount = capitalAccountMapper.selectByPrimaryKey(capitalIdL);
                            add(new Object[]{
                                    record.getShop_name(),
                                    capitalAccount.getOpening_bank(),
                                    capitalAccount.getBank_card_num(),
                                    capitalAccount.getPayee(),
                                    amount,
                                    record.getCreator_account(),
                                    realName
                            });
                        }
                    }},
                    new String("门店资金提现数据表格.xls".getBytes("UTF-8"),"iso-8859-1"),
                    httpServletResponse);
        }catch (Exception e){
            LOG.error("VerifyCommitRecordAdminController#export error",e);
        }
    }

    @RequestMapping("/verify")
    public BaseVO verify(@RequestParam("id") Long id,
                       @RequestParam("status") Integer status,
                       @RequestParam("remark") String remark,
                       @RequestParam("payment_voucher_img_url") String payment_voucher_img_url,
                       @RequestParam("account") String account
    ) {
        BaseVO baseVO = new BaseVO();
        try {

            if (id==null || status == null) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            VerifyCommitRecord verifyCommitRecord = verifyCommitRecordMapper.selectByPrimaryKey(id);
            if(verifyCommitRecord.getStatus() == 3){
                baseVO.setErrorMsg("该申请已撤销！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            if(verifyCommitRecord.getStatus() == 0 || verifyCommitRecord.getStatus() == 1 ){
                baseVO.setErrorMsg("该状态不允许操作！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            verifyCommitRecord.setStatus(status);

            verifyCommitRecord.setModifier_account(account);
            verifyCommitRecord.setVerify_account(account);
            if(StringUtils.isNotEmpty(remark)){
                verifyCommitRecord.setRemark(remark);
            }
            if(StringUtils.isNotEmpty(payment_voucher_img_url)){
                verifyCommitRecord.setPayment_voucher(payment_voucher_img_url);
            }
            int i = verifyCommitRecordMapper.updateByPrimaryKey(verifyCommitRecord);
            if(i>0){
                //0拒绝 1通过 资金申请拒绝 将冻结资金退回可用资金
                if(status==0 && verifyCommitRecord.getOperate_type()==1){
                    String target_json = verifyCommitRecord.getTarget_json();
                    if(StringUtils.isNotEmpty(target_json)){
                        Map<String,String> map = JSON.parseObject(target_json,Map.class);
                        String capitalId = map.get("capitalId");
                        String amount = map.get("amount");
                        Long capitalIdL = Long.valueOf(capitalId);
                        CapitalAccount capitalAccount = capitalAccountMapper.selectByPrimaryKey(capitalIdL);
                        //将冻结金额还原
                        String freezing_amount = capitalAccount.getFreezing_amount();
                        BigDecimal freez=BigDecimal.ZERO;
                        if(StringUtils.isNotEmpty(freezing_amount)){
                            freez = new BigDecimal(freezing_amount).subtract(new BigDecimal(amount));
                            capitalAccount.setFreezing_amount(freez.toString());
                            //总额扣除冻结金额
                            BigDecimal subtract = new BigDecimal(capitalAccount.getAvailable_amount()).add(new BigDecimal(amount));
                            capitalAccount.setAvailable_amount(subtract.toString());
                            capitalAccount.setGmt_modify(new Date());
                            int i1 = capitalAccountMapper.updateByPrimaryKey(capitalAccount);
                            if(i1>0){
                                financialFlow( map,"门店拒绝提现");
                            }
                        }else{
                            baseVO.setErrorMsg("冻结金额为0不允许操作！");
                            baseVO.setSuccess(false);
                            return baseVO;
                        }
                    }
                }
                Integer operate_type = verifyCommitRecord.getOperate_type();
                String target_json = verifyCommitRecord.getTarget_json();
                //更新数据
                doUpdateByType(status,operate_type, target_json, verifyCommitRecord);
                baseVO.setSuccess(true);
            }
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("审核异常！");
            LOG.error("VerifyCommitRecordAdminController#verify error", e);
        }
        return baseVO;
    }

    @Resource
    private CapitalAccountMapper capitalAccountMapper;

    @Resource
    private CapitalFlowService capitalFlowService;
    /**
     * 更新数据
     */
    private void doUpdateByType(Integer status,Integer type,String targetJson,VerifyCommitRecord verifyCommitRecord){
        if(status == 1) {
            //更新店铺数据
            if (type == 0) {
                Shop shop = JSON.parseObject(targetJson, Shop.class);
                Shop shopOld = shopMapper.selectByPrimaryKey(shop.getId());
                shopOld.setEnterprise_name(shop.getEnterprise_name());
                shopOld.setPerson_liable_name(shop.getPerson_liable_name());
                shopOld.setAddress(shop.getAddress());
                shopOld.setIntroduce(shop.getIntroduce());
                shopOld.setService(shop.getService());
                shopOld.setBusiness_license_img_url(shop.getBusiness_license_img_url());
                shopOld.setLogo_img_url(shop.getLogo_img_url());
                shopOld.setSmall_img_url(shop.getSmall_img_url());
                shopOld.setDoor_img_url(shop.getDoor_img_url());
                shopMapper.updateByPrimaryKey(shopOld);
                //todo 门店资金提现
            } else if (type == 1) {
                String target_json = verifyCommitRecord.getTarget_json();
                if(StringUtils.isNotEmpty(target_json)){
                    Map<String,String> map = JSON.parseObject(target_json,Map.class);
                    String capitalId = map.get("capitalId");
                    String amount = map.get("amount");
                    Long capitalIdL = Long.valueOf(capitalId);
                    CapitalAccount capitalAccount = capitalAccountMapper.selectByPrimaryKey(capitalIdL);
                    //将冻结金额减去
                    String freezing_amount = capitalAccount.getFreezing_amount();
                    if(StringUtils.isNotEmpty(freezing_amount)){
                        BigDecimal freez = new BigDecimal(freezing_amount).subtract(new BigDecimal(amount));
                        capitalAccount.setFreezing_amount(freez.toString());
                        //总额扣除冻结金额
                        BigDecimal subtract = new BigDecimal(capitalAccount.getTotal_amount()).subtract(new BigDecimal(amount));
                        capitalAccount.setTotal_amount(subtract.toString());
                        capitalAccount.setGmt_modify(new Date());
                        int i = capitalAccountMapper.updateByPrimaryKey(capitalAccount);
                        if(i>0){
                            //流水
                            financialFlow(map,"门店审核通过，提现成功");
                        }
                    }

                }
            }
        }
    }

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
            LOG.error("VerifyCommitRecordAdminController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
