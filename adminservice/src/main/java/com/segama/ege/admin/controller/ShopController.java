package com.segama.ege.admin.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.admin.utils.LongitudeLatitudeUtil;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.CapitalAccountMapper;
import com.segama.ege.repository.ProvCityAreaMapper;
import com.segama.ege.repository.ShopMapper;
import com.segama.ege.service.MessageDigestService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hxj
 * @version 1.0
 * @Description 门店相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/shop")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopController {
    @Resource
    private ShopMapper shopMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("enterprise_name") String enterprise_name
            ,@RequestParam(value = "person",required = false) String person
            ,@RequestParam(value = "phone",required = false) String phone
            , @RequestParam(value = "prov",required = false) String prov
            , @RequestParam(value = "city",required = false) String city
            , @RequestParam(value = "area",required = false) String area
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ShopExample shopExample = new ShopExample();
            ShopExample.Criteria shopExampleCriteria = shopExample.createCriteria();
            if(StringUtils.isNotEmpty(area)){

                shopExampleCriteria.andAddressLike("%"+area+"%");
            }else if(StringUtils.isNotEmpty(city)){
                shopExampleCriteria.andAddressLike("%"+city+"%");
            }else if(StringUtils.isNotEmpty(prov)){
                shopExampleCriteria.andAddressLike("%"+prov+"%");
            }

            if (StringUtils.isNotEmpty(enterprise_name)) {
                shopExampleCriteria.andEnterprise_nameLike("%" + enterprise_name + "%");
            }
            if (StringUtils.isNotEmpty(person)) {
                shopExampleCriteria.andPerson_liable_nameLike("%" + person + "%");
            }
            if (StringUtils.isNotEmpty(phone)) {
                shopExampleCriteria.andPhoneLike("%" + phone + "%");
            }
            int count = shopMapper.countByExample(shopExample);
            shopExample.setPageCount(pageSize);
            shopExample.setPageIndex(pageIndex);
            shopExample.setOrderByClause("gmt_create desc");
            List<Shop> shops = shopMapper.selectByExample(shopExample);
            baseVO.setData(shops);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("ShopController#list error", e);
        }
        return baseVO;
    }

    @Resource
    ProvCityAreaMapper provCityAreaMapper;

    @RequestMapping("/getProvCityAreaList")
    public BaseVO getProvCityAreaList(@RequestParam(value = "code",required = false) String code,
                                      @RequestParam(value = "type",required = false) String type) {
        BaseVO baseVO = new BaseVO();
        List<ProvCityArea> list = new ArrayList<>();
        ProvCityAreaExample example = new ProvCityAreaExample();
        ProvCityAreaExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(code)) {
            criteria.andParent_codeEqualTo(code);
        }
        if(!StringUtils.isEmpty(type)){
            criteria.andTypeEqualTo("0");
        }

        List<ProvCityArea> list1 = provCityAreaMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list1)){
            list.addAll(list1);
        }
        baseVO.setSuccess(true);
        baseVO.setData(list);
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id) {
        BaseVO baseVO = new BaseVO();
        if (id == null) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能删除！");
        } else {
            shopMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/disabled")
    public BaseVO disabled(@RequestParam("disableDay") Integer disableDay,
                           @RequestParam("disableText") String disableText,
                           @RequestParam("id") Long id,
                           @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        if (id == null) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能禁用！");
        } else {
            Shop shop = shopMapper.selectByPrimaryKey(id);
            shop.setIs_disable(true);
            shop.setDisable_reason(disableText);
            shop.setDisable_days(disableDay);
            shop.setModifier_account(account);
            shopMapper.updateByPrimaryKey(shop);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/getLongitudeLatitude")
    public BaseVO enable(@RequestParam("address") String address) {
        BaseVO baseVO = new BaseVO();
        baseVO.setData(LongitudeLatitudeUtil.getLongitudeLatitude(address));
            baseVO.setSuccess(true);
        return baseVO;
    }

    @RequestMapping("/enable")
    public BaseVO enable(@RequestParam("id") Long id,
                           @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        if (id == null) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能启用！");
        } else {
            Shop shop = shopMapper.selectByPrimaryKey(id);
            shop.setIs_disable(false);
            shop.setModifier_account(account);
            shopMapper.updateByPrimaryKey(shop);
            baseVO.setSuccess(true);
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
                       @RequestParam("is_disable") Boolean is_disable,
                       @RequestParam("is_recommend") Boolean is_recommend,
                       @RequestParam("business_license_img_url") String business_license_img_url,
                       @RequestParam("door_img_url") String door_img_url,
                       @RequestParam("logo_img_url") String logo_img_url,
                       @RequestParam("small_img_url") String small_img_url,
                       @RequestParam("introduce") String introduce,
                       @RequestParam("service") String service,
                      // @RequestParam("score") String score,
                       @RequestParam("workstation_num") Long workstation_num,
                       @RequestParam("business_hour") String business_hour,
                       @RequestParam("gmt_recommend") String gmt_recommend,
                       @RequestParam("account") String account
    ) {
        BaseVO baseVO = new BaseVO();
        try {

            if (id==null || StringUtils.isEmpty(account) || StringUtils.isEmpty(enterprise_name)) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            Shop shop = shopMapper.selectByPrimaryKey(id);
            shop.setEnterprise_name(enterprise_name);
            if(!StringUtils.isEmpty(person_liable_name)) {
                shop.setPerson_liable_name(person_liable_name);
            }
            if(is_recommend!=null) {
                shop.setIs_recommend(is_recommend);
            }
            if(!StringUtils.isEmpty(gmt_recommend)) {
                shop.setGmt_recommend(DateUtils.parseDate(gmt_recommend,DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(phone)) {
                shop.setPhone(phone);
            }
            if(!StringUtils.isEmpty(mobile)) {
                shop.setMobile(mobile);
            }
            if(!StringUtils.isEmpty(address)) {
                shop.setAddress(address);
            }
            if(longitude!=null) {
                shop.setLongitude(longitude);
            }
            if(latitude!=null) {
                shop.setLatitude(latitude);
            }
            if(is_disable!=null) {
                shop.setIs_disable(is_disable);
            }
            if(!StringUtils.isEmpty(business_license_img_url)) {
                shop.setBusiness_license_img_url(business_license_img_url);
            }
            if(!StringUtils.isEmpty(door_img_url)) {
                shop.setDoor_img_url(door_img_url);
            }
            if(!StringUtils.isEmpty(logo_img_url)) {
                shop.setLogo_img_url(logo_img_url);
            }
            if(!StringUtils.isEmpty(small_img_url)) {
                shop.setSmall_img_url(small_img_url);
            }
            if(!StringUtils.isEmpty(introduce)) {
                shop.setIntroduce(introduce);
            }
            if(!StringUtils.isEmpty(service)) {
                shop.setService(service);
            }
            /*if(!StringUtils.isEmpty(score)) {
                shop.setScore(score);
            }
*/
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
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopController#edit error", e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
            @RequestParam("enterprise_name") String enterprise_name,
            @RequestParam("person_liable_name") String person_liable_name,
            @RequestParam("phone") String phone,
            @RequestParam("mobile") String mobile,
            @RequestParam("address") String address,
            @RequestParam("business_license_img_url") String business_license_img_url,
            @RequestParam("door_img_url") String door_img_url,
            @RequestParam("logo_img_url") String logo_img_url,
            @RequestParam("small_img_url") String small_img_url,
            @RequestParam("introduce") String introduce,
            @RequestParam("service") String service,
            @RequestParam("score") String score,
            @RequestParam("longitude") BigDecimal longitude,
            @RequestParam("latitude") BigDecimal latitude,
            @RequestParam("is_disable") Boolean is_disable,
            @RequestParam("is_recommend") Boolean is_recommend,
            @RequestParam("workstation_num") Long workstation_num,
            @RequestParam("business_hour") String business_hour,
            @RequestParam("gmt_recommend") String gmt_recommend,
            @RequestParam("account") String account
            ) {

        BaseVO baseVO = new BaseVO();
        try {
            if (StringUtils.isEmpty(account) || StringUtils.isEmpty(enterprise_name)) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            Shop shop = new Shop();
            shop.setEnterprise_name(enterprise_name);
            if(!StringUtils.isEmpty(person_liable_name)) {
                shop.setPerson_liable_name(person_liable_name);
            }
            if(!StringUtils.isEmpty(phone)) {
                shop.setPhone(phone);
            }
            if(is_recommend!=null) {
                shop.setIs_recommend(is_recommend);
            }
            if(!StringUtils.isEmpty(mobile)) {
                shop.setMobile(mobile);
            }
            if(!StringUtils.isEmpty(address)) {
                shop.setAddress(address);
            }
            if(longitude!=null) {
                shop.setLongitude(longitude);
            }

            if(!StringUtils.isEmpty(gmt_recommend)) {
                shop.setGmt_recommend(DateUtils.parseDate(gmt_recommend,DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(business_hour)) {
                String[] hours = business_hour.split(" - ");
                String business_hour_start = hours[0];
                String business_hour_end = hours[1];
                shop.setBusiness_hour_start(business_hour_start);
                shop.setBusiness_hour_end(business_hour_end);
            }
            if(latitude!=null) {
                shop.setLatitude(latitude);
            }
            if(is_disable!=null) {
                shop.setIs_disable(is_disable);
            }
            if(!StringUtils.isEmpty(business_license_img_url)) {
                shop.setBusiness_license_img_url(business_license_img_url);
            }
            if(!StringUtils.isEmpty(door_img_url)) {
                shop.setDoor_img_url(door_img_url);
            }
            if(!StringUtils.isEmpty(small_img_url)) {
                shop.setSmall_img_url(small_img_url);
            }
            if(!StringUtils.isEmpty(logo_img_url)) {
                shop.setLogo_img_url(logo_img_url);
            }
            if(!StringUtils.isEmpty(introduce)) {
                shop.setIntroduce(introduce);
            }
            if(!StringUtils.isEmpty(service)) {
                shop.setService(service);
            }
            if(!StringUtils.isEmpty(score)) {
                shop.setScore(score);
            }
            if(workstation_num!=null) {
                shop.setWorkstation_num(workstation_num);
            }
            shop.setModifier_account(account);
            shop.setCreator_account(account);
            shop.setGmt_create(new Date());
            shop.setGmt_modify(new Date());
            shop.setVersion(0);
            shopMapper.insert(shop);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopController#add error", e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
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
            LOG.error("ShopController#get Exception input param is id:" + id, e);
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

    @Resource
    private CapitalAccountMapper capitalAccountMapper;

    @Resource
    private MessageDigestService messageDigestService;

    @RequestMapping("/editCapitalAccount")
    public BaseVO editCapitalAccount(@RequestParam("id") Long id,

                       @RequestParam("account") String account
    ) {
        BaseVO baseVO = new BaseVO();
        try {

            if (id==null || StringUtils.isEmpty(account)) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            Shop shop = shopMapper.selectByPrimaryKey(id);
            if(shop.getCapital_account_id() != null && StringUtils.isNotEmpty(shop.getCapital_account_str())){
                baseVO.setErrorMsg("资金账户已添加！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            CapitalAccount capitalAccount = new CapitalAccount();
            String account_no = UUIDUtils.UUID();
            capitalAccount.setAccount_no(account_no);
            //1门店 2车主
            capitalAccount.setAccount_type("1");
            capitalAccount.setGmt_create(new Date());
            capitalAccount.setGmt_modify(new Date());
            capitalAccount.setCreator_account(account);
            capitalAccount.setTotal_amount("0");
            capitalAccount.setBank_card_num(account_no);
            capitalAccount.setOpening_bank("0");
            capitalAccount.setFreezing_amount("0");
            capitalAccount.setAvailable_amount("0");
            capitalAccountMapper.insert(capitalAccount);
            //更新mac
            messageDigestService.updateCapitalAccountInfo(shop,"0");
            if(capitalAccount.getId()!=null && StringUtils.isNotEmpty(account_no)){
                shop.setCapital_account_id(capitalAccount.getId());
                shop.setCapital_account_str(account_no);
            }
            shopMapper.updateByPrimaryKey(shop);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加账户异常！");
            LOG.error("ShopController#editCapitalAccount error", e);
        }
        return baseVO;
    }
}
