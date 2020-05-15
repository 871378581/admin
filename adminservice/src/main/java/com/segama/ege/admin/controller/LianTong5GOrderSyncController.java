package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.admin.utils.ExcelUtil;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
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

    @RequestMapping("/export")
    public void export(
            ThLtOrderSyncData thLtOrderSyncData) {
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

            ex.setOrderByClause("gmt_create desc");
            List<ThLtOrderSyncData> thOrderManages = Lists.newArrayList();
            if(count>0) {
                int pageSize=20;
                int page = (count + pageSize - 1) / pageSize;
                for(int i=1;i<=page;i++){
                    ex.setPageIndex(i);
                    ex.setPageCount(20);
                    thOrderManages.addAll(thLtOrderSyncDataMapper.selectByExample(ex));
                }
                String[] rowName=null;
                List<Object[]> dataList = Lists.newArrayList();
                if(!CollectionUtils.isEmpty(thOrderManages)) {
                    rowName = new String[]{
                            "ID",
                            "订单号",
                            "所属渠道",
                            "城市",
                            "套餐名称",
                            "套餐编码",
                            "合约期",
                            "优惠金额",
                            "姓名",
                            "证件号码",
                            "联系人",
                            "联系人电话",
                            "区",
                            "地址",
                            "选号",
                            "是否冻结",
                            "冻结金额",
                            "订单创建时间"
                    };

                    for (ThLtOrderSyncData syncData : thOrderManages) {
                        dataList.add(new Object[]{
                                syncData.getId(),
                                syncData.getCode(),
                                syncData.getChannel_code(),
                                syncData.getCity_name(),
                                syncData.getPacakge_name(),
                                syncData.getPacakge_code(),
                                syncData.getContract_period(),
                                syncData.getDiscount_amount(),
                                syncData.getAccess_name(),
                                syncData.getId_number(),
                                syncData.getAddressee(),
                                syncData.getAddressee_phone(),
                                syncData.getDistrict_name(),
                                syncData.getAddress(),
                                syncData.getSelected_phone_num(),
                                syncData.getFreeze(),
                                syncData.getFreeze_amount(),
                                syncData.getOrder_create_time()
                        });
                    }
                }else{
                    rowName = new String[]{"结果"};
                    dataList.add(new Object[]{"没有数据"});
                }
                ExcelUtil.exportExcel("5G订单同步数据", rowName, dataList, new String("5G订单同步数据.xls".getBytes("UTF-8"), "iso-8859-1"), response);
            }
            baseVO.setSuccess(true);
        }catch (Exception e){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("系统异常");
            LOG.error("LianTong5GOrderSyncController#list error",e);
        }
    }

}
