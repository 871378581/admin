package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.ShopPhotoResourceVO;
import com.segama.ege.entity.Shop;
import com.segama.ege.entity.ShopPhotoResource;
import com.segama.ege.entity.ShopPhotoResourceExample;
import com.segama.ege.repository.ShopMapper;
import com.segama.ege.repository.ShopPhotoResourceMapper;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hxj
 * @version 1.0
 * @Description 店铺图片资源相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/shop_photo_manage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopPhotoResourceController {
    @Resource
    private ShopPhotoResourceMapper shopPhotoResourceMapper;

    @Resource
    private ShopMapper shopMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopPhotoResourceController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("shop_id") Long shopId,
            @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ShopPhotoResourceExample shopPhotoResourceExample = new ShopPhotoResourceExample();
            ShopPhotoResourceExample.Criteria shopPhotoResourceExampleCriteria = shopPhotoResourceExample.createCriteria();
            if(shopId!=null){shopPhotoResourceExampleCriteria.andShop_idEqualTo(shopId);}
            int count = shopPhotoResourceMapper.countByExample(shopPhotoResourceExample);
            shopPhotoResourceExample.setPageCount(pageSize);
            shopPhotoResourceExample.setPageIndex(pageIndex);
            shopPhotoResourceExample.setOrderByClause("gmt_create desc");
            List<ShopPhotoResource> shopPhotoResources = shopPhotoResourceMapper.selectByExample(shopPhotoResourceExample);
            List<ShopPhotoResourceVO> vos = new ArrayList<>();
            if(!CollectionUtils.isEmpty(shopPhotoResources)){
                List<ShopPhotoResourceVO> collect = shopPhotoResources.stream().map((sp) -> {
                    ShopPhotoResourceVO resourceVO = new ShopPhotoResourceVO();
                    BeanUtils.copyProperties(sp, resourceVO);
                    Shop shop = shopMapper.selectByPrimaryKey(sp.getShop_id());
                    if (shop != null) {
                        resourceVO.setShop_name(shop.getEnterprise_name());
                    }
                    return resourceVO;
                }).collect(Collectors.toList());
                if(!CollectionUtils.isEmpty(collect)){
                    vos.addAll(collect);
                }
            }
            baseVO.setData(vos);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ShopPhotoResourceController#list error",e);
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
            shopPhotoResourceMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("account") String account,
                    @RequestParam("photo_url") String photo_url,
                    @RequestParam("verify_status") Boolean verify_status,
                    @RequestParam("shop_id") Long shop_id,
                    @RequestParam("order_id") Integer order_id
                               ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null || StringUtils.isEmpty(photo_url)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopPhotoResource shopPhotoResource = shopPhotoResourceMapper.selectByPrimaryKey(id);
            if(order_id!=null){
                shopPhotoResource.setOrder_id(order_id);
            }
            if(shop_id!=null){
                shopPhotoResource.setShop_id(shop_id);
            }
            if(!StringUtils.isEmpty(photo_url)){
                shopPhotoResource.setPhoto_url(photo_url);
            }
            if(!StringUtils.isEmpty(verify_status)){
                shopPhotoResource.setVerify_status(verify_status);
            }

            shopPhotoResource.setGmt_modify(new Date());
            shopPhotoResource.setModifier_account(account);
            shopPhotoResource.setVersion(0);
            shopPhotoResourceMapper.updateByPrimaryKey(shopPhotoResource);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopPhotoResourceController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
                      @RequestParam("account") String account,
                      @RequestParam("photo_url") String photo_url,
                      @RequestParam("verify_status") Boolean verify_status,
                      @RequestParam("shop_id") Long shop_id,
                      @RequestParam("order_id") Integer order_id
    ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(photo_url)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopPhotoResource shopPhotoResource = new ShopPhotoResource();
            if(order_id!=null){
                shopPhotoResource.setOrder_id(order_id);
            }
            if(shop_id!=null){
                shopPhotoResource.setShop_id(shop_id);
            }
            if(!StringUtils.isEmpty(photo_url)){
                shopPhotoResource.setPhoto_url(photo_url);
            }
            if(!StringUtils.isEmpty(verify_status)){
                shopPhotoResource.setVerify_status(verify_status);
            }

            shopPhotoResource.setCreator_account(account);
            shopPhotoResource.setModifier_account(account);
            shopPhotoResource.setGmt_create(new Date());
            shopPhotoResource.setGmt_modify(new Date());
            shopPhotoResource.setVersion(0);
            shopPhotoResourceMapper.insert(shopPhotoResource);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopPhotoResourceController#add error",e);
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
                ShopPhotoResource shopPhotoResource = shopPhotoResourceMapper.selectByPrimaryKey(id);
                baseVO.setData(shopPhotoResource);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopPhotoResourceController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
