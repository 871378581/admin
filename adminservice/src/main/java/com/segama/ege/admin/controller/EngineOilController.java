package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.AdminMenu;
import com.segama.ege.entity.AdminMenuExample;
import com.segama.ege.entity.EngineOil;
import com.segama.ege.entity.EngineOilExample;
import com.segama.ege.repository.EngineOilMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hxj
 * @version 1.0
 * @Description 机油相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/engine_oil")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EngineOilController {
    @Resource
    private EngineOilMapper engineOilMapper;

    private static Logger LOG = LoggerFactory.getLogger(EngineOilController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            EngineOilExample engineOilExample = new EngineOilExample();
            EngineOilExample.Criteria engineOilExampleCriteria = engineOilExample.createCriteria();
            int count = engineOilMapper.countByExample(engineOilExample);
            engineOilExample.setPageCount(pageSize);
            engineOilExample.setPageIndex(pageIndex);
            engineOilExample.setOrderByClause("gmt_create desc");
            List<EngineOil> engineOils = engineOilMapper.selectByExample(engineOilExample);
            baseVO.setData(engineOils);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("HotRecommendController#list error",e);
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
            engineOilMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("account") String account,
                    @RequestParam("photo_url") String photo_url,
                    @RequestParam("brand") String brand,
                    @RequestParam("brand_name") String brand_name,
                    @RequestParam("market_price") BigDecimal market_price,
                       @RequestParam("market_price_max") BigDecimal market_price_max,
                    @RequestParam("member_price") BigDecimal member_price,
                    @RequestParam("code") String code
                               ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null || StringUtils.isEmpty(brand)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            EngineOil engineOil = engineOilMapper.selectByPrimaryKey(id);
            if(market_price!=null){
                engineOil.setMarket_price(market_price);
            }
            if(market_price_max!=null){
                engineOil.setMarket_price_max(market_price_max);
            }
            if(member_price!=null){
                engineOil.setMember_price(member_price);
            }
            if(!StringUtils.isEmpty(brand_name)){
                engineOil.setBrand_name(brand_name);
            }
            if(!StringUtils.isEmpty(brand)){
                engineOil.setBrand(brand);
            }
            if(!StringUtils.isEmpty(photo_url)){
                engineOil.setPhoto_url(photo_url);
            }
            if(!StringUtils.isEmpty(code)){
                engineOil.setCode(code);
            }
            engineOil.setGmt_modify(new Date());
            engineOil.setModifier_account(account);
            engineOilMapper.updateByPrimaryKey(engineOil);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("EngineOilController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
                      @RequestParam("account") String account,
                      @RequestParam("photo_url") String photo_url,
                      @RequestParam("brand") String brand,
                      @RequestParam("brand_name") String brand_name,
                      @RequestParam("market_price") BigDecimal market_price,
                      @RequestParam("market_price_max") BigDecimal market_price_max,
                      @RequestParam("member_price") BigDecimal member_price,
                      @RequestParam("code") String code
    ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(photo_url)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            EngineOil engineOil = new EngineOil();
            if(market_price_max!=null){
                engineOil.setMarket_price_max(market_price_max);
            }
            if(market_price!=null){
                engineOil.setMarket_price(market_price);
            }
            //门店机油
            engineOil.setOil_type("1");
            if(member_price!=null){
                engineOil.setMember_price(member_price);
            }
            if(!StringUtils.isEmpty(brand_name)){
                engineOil.setBrand_name(brand_name);
            }
            if(!StringUtils.isEmpty(brand)){
                engineOil.setBrand(brand);
            }
            if(!StringUtils.isEmpty(photo_url)){
                engineOil.setPhoto_url(photo_url);
            }
            if(!StringUtils.isEmpty(code)){
                engineOil.setCode(code);
            }

            engineOil.setCreator_account(account);
            engineOil.setModifier_account(account);
            engineOil.setGmt_create(new Date());
            engineOil.setGmt_modify(new Date());
            engineOilMapper.insert(engineOil);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("EngineOilController#add error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
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
                EngineOil engineOil = engineOilMapper.selectByPrimaryKey(id);
                baseVO.setData(engineOil);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("EngineOilController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_oil")
    public BaseVO getAllOil() {
        BaseVO baseVO = new BaseVO();
        try {
            List<EngineOil> engineOils = engineOilMapper.selectByExample(new EngineOilExample());
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(engineOils)){
                for (EngineOil engineOil : engineOils) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",engineOil.getBrand_name());
                    map.put("value",engineOil.getId());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("EngineOilController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
