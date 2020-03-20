package com.segama.ege.shopadmin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.CapitalFlowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description 资金流水
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/shop_admin/capital_flow")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopCapitalFlowController {
    @Resource
    private CapitalFlowMapper capitalFlowMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopCapitalFlowController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("type") Long type,
            @RequestParam("shopId") Long shopId
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            if(shopId==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            CapitalFlowExample example = new CapitalFlowExample();
            CapitalFlowExample.Criteria criteria = example.createCriteria();
            if(type!=null) {
                criteria.andOperate_typeEqualTo(type);
            }
            criteria.andShop_idEqualTo(shopId);
            int count = capitalFlowMapper.countByExample(example);
            example.setPageCount(pageSize);
            example.setPageIndex(pageIndex);
            example.setOrderByClause("gmt_create desc");
            List<CapitalFlow> capitalFlows = capitalFlowMapper.selectByExample(example);
            baseVO.setData(capitalFlows);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ShopCapitalFlowController#list error",e);
        }
        return baseVO;
    }

}
