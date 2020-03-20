package com.segama.ege.shopadmin.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.Shop;
import com.segama.ege.entity.ShopExample;
import com.segama.ege.entity.VerifyCommitRecord;
import com.segama.ege.entity.VerifyCommitRecordExample;
import com.segama.ege.repository.ShopMapper;
import com.segama.ege.repository.VerifyCommitRecordMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
 * @Description 门店相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/shop_admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopAdminShopController {
    @Resource
    private ShopMapper shopMapper;

    @Resource
    private VerifyCommitRecordMapper verifyCommitRecordMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopAdminShopController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("shop_id") Long shop_id
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ShopExample shopExample = new ShopExample();
            ShopExample.Criteria shopExampleCriteria = shopExample.createCriteria();
            if (shop_id == null) {
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("参数为空！");
            } else{
                shopExampleCriteria.andIdEqualTo(shop_id);
                int count = shopMapper.countByExample(shopExample);
                shopExample.setPageCount(pageSize);
                shopExample.setPageIndex(pageIndex);
                List<Shop> shops = shopMapper.selectByExample(shopExample);
                baseVO.setData(shops);
                baseVO.setSuccess(true);
                baseVO.setCount(count);
            }
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("ShopAdminShopController#list error", e);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                       @RequestParam("enterprise_name") String enterprise_name,
                       @RequestParam("person_liable_name") String person_liable_name,
                       @RequestParam("phone") String phone,
                       @RequestParam("mobile") String mobile,
                       @RequestParam("address") String address,
                       @RequestParam("longitude") BigDecimal longitude,
                       @RequestParam("latitude") BigDecimal latitude,
                      // @RequestParam("is_disable") Boolean is_disable,
                      // @RequestParam("is_recommend") Boolean is_recommend,
                       @RequestParam("business_license_img_url") String business_license_img_url,
                       @RequestParam("door_img_url") String door_img_url,
                       @RequestParam("logo_img_url") String logo_img_url,
                       @RequestParam("small_img_url") String small_img_url,
                       @RequestParam("introduce") String introduce,
                       @RequestParam("service") String service,
                      // @RequestParam("score") String score,
                       @RequestParam("workstation_num") Long workstation_num,
                       @RequestParam("business_hour") String business_hour,
                    //   @RequestParam("gmt_recommend") String gmt_recommend,
                       @RequestParam("account") String account
    ) {
        BaseVO baseVO = new BaseVO();
        try {

            if (id==null || StringUtils.isEmpty(account) ) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            VerifyCommitRecordExample example = new VerifyCommitRecordExample();
            VerifyCommitRecordExample.Criteria criteria = example.createCriteria();
            criteria.andShop_idEqualTo(id);
            criteria.andOperate_typeEqualTo(0);//0表示店铺信息修改
            List<VerifyCommitRecord> verifyCommitRecords = verifyCommitRecordMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(verifyCommitRecords)){
                List<VerifyCommitRecord> collect = verifyCommitRecords.stream().filter(e -> {
                    return e.getStatus() == 2;
                }).collect(Collectors.toList());
                if(!CollectionUtils.isEmpty(collect)){
                    baseVO.setErrorMsg("已经存在未审核的变更，请等待审核之后再试！");
                    baseVO.setSuccess(false);
                    return baseVO;
                }
            }
            Shop shop = shopMapper.selectByPrimaryKey(id);

            if(!StringUtils.isEmpty(phone)) {
                shop.setPhone(phone);
            }
            if(!StringUtils.isEmpty(mobile)) {
                shop.setMobile(mobile);
            }

            if(longitude!=null) {
                shop.setLongitude(longitude);
            }
            if(latitude!=null) {
                shop.setLatitude(latitude);
            }

            if(workstation_num!=null) {
                shop.setWorkstation_num(workstation_num);
            }
            if(!StringUtils.isEmpty(business_hour)) {
                String[] hours = business_hour.split(" - ");
                String business_hour_start = hours[0];
                String business_hour_end = hours[1];
                shop.setBusiness_hour_start(business_hour_start);
                shop.setBusiness_hour_end(business_hour_end);
            }
            shop.setModifier_account(account);
            shop.setGmt_modify(new Date());
            shopMapper.updateByPrimaryKey(shop);

            int flag=0;
            Shop changeSHop = new Shop();
            if(StringUtils.isNotEmpty(enterprise_name)
                    &&!shop.getEnterprise_name().equals(enterprise_name)){
                flag++;
                shop.setEnterprise_name(enterprise_name);
                changeSHop.setEnterprise_name(enterprise_name);
            }

            if(!StringUtils.isEmpty(person_liable_name)
                && !shop.getPerson_liable_name().equals(person_liable_name)) {
                flag++;
                shop.setPerson_liable_name(person_liable_name);
                changeSHop.setPerson_liable_name(person_liable_name);
            }
            if(!StringUtils.isEmpty(address)
                && !shop.getAddress().equals(address)) {
                flag++;
                shop.setAddress(address);
                changeSHop.setAddress(address);
                changeSHop.setLongitude(longitude);
                changeSHop.setLatitude(latitude);
            }
            if(!StringUtils.isEmpty(business_license_img_url)
                && !shop.getBusiness_license_img_url().equals(business_license_img_url)) {
                flag++;
                shop.setBusiness_license_img_url(business_license_img_url);
                changeSHop.setBusiness_license_img_url(business_license_img_url);
            }
            if(!StringUtils.isEmpty(door_img_url)
                && !shop.getDoor_img_url().equals(door_img_url)) {
                flag++;
                shop.setDoor_img_url(door_img_url);
                changeSHop.setDoor_img_url(door_img_url);
            }
            if(!StringUtils.isEmpty(logo_img_url)
                && !shop.getLogo_img_url().equals(logo_img_url)) {
                flag++;
                shop.setLogo_img_url(logo_img_url);
                changeSHop.setLogo_img_url(logo_img_url);
            }
            if(!StringUtils.isEmpty(small_img_url)
                    && !shop.getSmall_img_url().equals(small_img_url)) {
                flag++;
                shop.setSmall_img_url(small_img_url);
                changeSHop.setSmall_img_url(small_img_url);
            }
            if(!StringUtils.isEmpty(introduce)
                && !shop.getIntroduce().equals(introduce)) {
                flag++;
                shop.setIntroduce(introduce);
                changeSHop.setSmall_img_url(introduce);
            }
            if(!StringUtils.isEmpty(service)
                && !shop.getService().equals(service)) {
                flag++;
                shop.setService(service);
                changeSHop.setService(service);
            }
            if(flag>0){
                VerifyCommitRecord verifyCommitRecord = new VerifyCommitRecord();
                verifyCommitRecord.setCreator_account(account);
                verifyCommitRecord.setGmt_create(new Date());
                verifyCommitRecord.setGmt_modify(new Date());
                //0表示店铺
                verifyCommitRecord.setOperate_type(0);
                //0表示表示拒绝，1通过通过，2审核中 3 撤回
                verifyCommitRecord.setStatus(2);
                verifyCommitRecord.setShop_id(id);
                verifyCommitRecord.setShop_name(shop.getEnterprise_name());
                verifyCommitRecord.setTarget_json(JSON.toJSONString(shop));
                verifyCommitRecord.setChange_json(JSON.toJSONString(changeSHop));
                verifyCommitRecordMapper.insert(verifyCommitRecord);
                baseVO.setErrorMsg("部分数据需要审核通过之后才能更新～");
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopController#edit error", e);
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
                Shop shop = shopMapper.selectByPrimaryKey(id);
                baseVO.setData(shop);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopAdminShopController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_shop")
    public BaseVO getAllOil() {
        BaseVO baseVO = new BaseVO();
        try {
            List<Shop> shops = shopMapper.selectByExample(new ShopExample());
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(shops)){
                for (Shop shop : shops) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",shop.getEnterprise_name());
                    map.put("value",shop.getId());
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
