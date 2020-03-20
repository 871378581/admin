package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.response.ShopOilSupplyVO;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 店铺机油管理
 *
 * @author hxj
 * @version 1.0
 * @since 2019/10/19
 */
@RestController
@RequestMapping("/ege/api/admin/shop_oil_supply")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopOilSupplyController {

    @Resource
    private ShopOilSupplyMapper shopOilSupplyMapper;

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private EngineOilMapper engineOilMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopOilSupplyController.class);

    @RequestMapping("/list")
    public BaseVO list(
            /*@RequestParam("oil_name") String oil_name,*/
            @RequestParam("shop_name") String shop_name,
            @RequestParam("shop_id") Long shop_id,
            @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        baseVO.setCode(0);
        ShopOilSupplyExample shopOilSupplyExample = new ShopOilSupplyExample();
        ShopOilSupplyExample.Criteria criteria = shopOilSupplyExample.createCriteria();

        List<Long> oils = Lists.newArrayList();
       /* if(!StringUtils.isEmpty(oil_name)) {
            EngineOilExample engineOilExample = new EngineOilExample();
            EngineOilExample.Criteria criteria1 = engineOilExample.createCriteria();
            criteria1.andBrand_nameLike("%" + oil_name + "%");
            List<EngineOil> engineOils = engineOilMapper.selectByExample(engineOilExample);
            if (!CollectionUtils.isEmpty(engineOils)) {
                oils.addAll(engineOils.stream().map(EngineOil::getId).collect(Collectors.toList()));
            }
        }*/

        List<Long> shops = Lists.newArrayList();
        if(shop_id!=null){
            criteria.andShop_idEqualTo(shop_id);
        }
        if(!StringUtils.isEmpty(shop_name)) {

            ShopExample shopExample = new ShopExample();
            ShopExample.Criteria shopExampleCriteria = shopExample.createCriteria();
            shopExampleCriteria.andEnterprise_nameLike("%" + shop_name + "%");
            List<Shop> shops1 = shopMapper.selectByExample(shopExample);
            if (!CollectionUtils.isEmpty(shops1)) {
                shops.addAll(shops1.stream().map(Shop::getId).collect(Collectors.toList()));
            }
        }

        if(!CollectionUtils.isEmpty(shops)){
            criteria.andShop_idIn(shops);
        }

        if(!CollectionUtils.isEmpty(oils)){
            criteria.andOil_idIn(oils);
        }

        try {
            int count = shopOilSupplyMapper.countByExample(shopOilSupplyExample);
            List<ShopOilSupplyVO> result = Lists.newArrayList();
            if(count != 0){
                shopOilSupplyExample.setPageCount(pageSize);
                shopOilSupplyExample.setPageIndex(pageIndex);
                List<ShopOilSupply> shopOilSupplyExamples = shopOilSupplyMapper.selectByExample(shopOilSupplyExample);
                if(!CollectionUtils.isEmpty(shopOilSupplyExamples)){
                    for (ShopOilSupply oilSupplyExample : shopOilSupplyExamples) {
                        ShopOilSupplyVO shopOilSupplyVO = new ShopOilSupplyVO();
                        BeanUtils.copyProperties(oilSupplyExample,shopOilSupplyVO);
                        Shop shop = shopMapper.selectByPrimaryKey(oilSupplyExample.getShop_id());
                        if(shop!=null){
                            shopOilSupplyVO.setShop_name(shop.getEnterprise_name());
                        }
                        EngineOil engineOil = engineOilMapper.selectByPrimaryKey(oilSupplyExample.getOil_id());
                        if(engineOil!=null) {
                            shopOilSupplyVO.setOil_name(engineOil.getBrand_name());
                            result.add(shopOilSupplyVO);
                        }
                    }
                }
            }
            baseVO.setData(result);
            baseVO.setCode(0);
            baseVO.setCount(count);

        }catch (Exception e){
            baseVO.setErrorMsg("数据获取异常");
            baseVO.setSuccess(false);
            LOG.error("ShopOilSupplyController#list Exception",e);
        }
        return baseVO;
    }

    
    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id ) {
        BaseVO baseVO = BaseVO.createSuccess();
        if(id == null){
            return BaseVO.createFailure("id can not be null");
        }
        shopOilSupplyMapper.deleteByPrimaryKey(id);
        return baseVO;
    }

    
    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                                @RequestParam("account") String editAccount,
                                @RequestParam("shop_id") Long shop_id,
                                @RequestParam("oil_id") Long oil_id) {
        BaseVO baseVO = BaseVO.createSuccess();
        try {
            if(id==null || shop_id==null || oil_id == null){
                return BaseVO.createFailure("edit param can not be null");
            }
            ShopOilSupply shopOilSupply = shopOilSupplyMapper.selectByPrimaryKey(id);
            shopOilSupply.setOil_id(oil_id);
            shopOilSupply.setModifier_account(editAccount);
            shopOilSupplyMapper.updateByPrimaryKey(shopOilSupply);
        } catch (Exception e) {
            String message = e.getMessage();
            if(!StringUtils.isEmpty(message) && message.indexOf("Duplicate")>0){
                message=",请不要添加相同的加油";
            }else{
                message="";
            }
            LOG.error("ShopOilSupplyController#edit Exception",e);
            baseVO = BaseVO.createFailure("编辑异常"+message);
        }
        return baseVO;
    }

    
    @RequestMapping("/add")
    public BaseVO add(@RequestParam("shop_id") Long shop_id,
                      @RequestParam("oil_id") Long oil_id,
                               @RequestParam("account") String account) {

        BaseVO baseVO = BaseVO.createSuccess();
        try {
            ShopOilSupply shopOilSupplyExample = new ShopOilSupply();
            if( shop_id == null || oil_id==null){
                return BaseVO.createFailure("param can not be null.");
            }
            shopOilSupplyExample.setShop_id(shop_id);
            shopOilSupplyExample.setOil_id(oil_id);

            shopOilSupplyExample.setModifier_account(account);
            shopOilSupplyExample.setCreator_account(account);
            shopOilSupplyExample.setVersion(0);
            shopOilSupplyExample.setGmt_create(new Date());
            shopOilSupplyExample.setGmt_modify(new Date());
            shopOilSupplyMapper.insert(shopOilSupplyExample);
        } catch (Exception e) {
            LOG.error("ShopOilSupplyController#add Exception",e);
            String message = e.getMessage();
            if(!StringUtils.isEmpty(message) && message.indexOf("Duplicate")>0){
                message=",请不要添加相同的加油";
            }else{
                message="";
            }
            baseVO  = BaseVO.createFailure("添加异常"+message);
        }
        return baseVO;
    }

    
    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id ) {
        BaseVO baseVO = BaseVO.createSuccess();
        try {
            if(id == null){
                return BaseVO.createFailure("id can not be null");
            }
            ShopOilSupply shopOilSupplyExample = shopOilSupplyMapper.selectByPrimaryKey(id);
            baseVO.setData(shopOilSupplyExample);
        } catch (Exception e) {
            LOG.error("ShopOilSupplyController#get Exception input param is id:"+id,e);
            baseVO = BaseVO.createFailure("查询信息异常！");
        }
        return baseVO;
    }

}
