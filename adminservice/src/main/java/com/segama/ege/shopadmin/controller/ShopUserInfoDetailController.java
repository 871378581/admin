package com.segama.ege.shopadmin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ShopAdminUserDetailInfo;
import com.segama.ege.entity.ShopAdminUserDetailInfoExample;
import com.segama.ege.repository.ShopAdminUserDetailInfoMapper;
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
 * @Description 用户信息相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/shop_admin/user_info_detail")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopUserInfoDetailController {
    @Resource
    private ShopAdminUserDetailInfoMapper shopAdminUserDetailInfoMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopUserInfoDetailController.class);

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                       @RequestParam("shopId") Long shopId,
                       @RequestParam("account") String account,
                       @RequestParam("age") Long age,
                       @RequestParam("phone") String phone,
                       @RequestParam("address") String address,
                       @RequestParam("gender") String gender,
                       @RequestParam("real_name") String real_name,
                       @RequestParam("birthday") String birthday,
                       @RequestParam("description") String description,
                       @RequestParam("job") String job
    ) {
        BaseVO baseVO = new BaseVO();
        try {
                if (StringUtils.isEmpty(account) || shopId == null) {
                    baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                    baseVO.setSuccess(false);
                    return baseVO;
                }
                ShopAdminUserDetailInfo detailInfo = new ShopAdminUserDetailInfo();


                if (id != null) {
                    detailInfo.setId(id);
                }

                if (StringUtils.isNotEmpty(phone)) {
                    detailInfo.setPhone(phone);
                }

                if (StringUtils.isNotEmpty(address)) {
                    detailInfo.setAddress(address);
                }

                if (StringUtils.isNotEmpty(gender)) {
                    detailInfo.setGender(gender);
                }

                if (StringUtils.isNotEmpty(real_name)) {
                    detailInfo.setReal_name(real_name);
                }

                if (StringUtils.isNotEmpty(birthday)) {
                    detailInfo.setBirthday(birthday);
                }

                if (StringUtils.isNotEmpty(description)) {
                    detailInfo.setDescription(description);
                }
                if (StringUtils.isNotEmpty(job)) {
                    detailInfo.setJob(job);
                }

                if (age != null) {
                    detailInfo.setAge(age);
                }

                detailInfo.setModifier_account(account);
                detailInfo.setAccount(account);
                detailInfo.setShop_id(shopId);

                if (id != null) {
                    //先根据账号和店铺id查询是否有信息,如果id 不同不允许操作
                    ShopAdminUserDetailInfoExample example = new ShopAdminUserDetailInfoExample();
                    ShopAdminUserDetailInfoExample.Criteria criteria = example.createCriteria();
                    criteria.andAccountEqualTo(account);
                    criteria.andShop_idEqualTo(shopId);
                    List<ShopAdminUserDetailInfo> shopAdminUserDetailInfos = shopAdminUserDetailInfoMapper.selectByExample(example);
                    if (!CollectionUtils.isEmpty(shopAdminUserDetailInfos)) {
                        ShopAdminUserDetailInfo detailInfo1 = shopAdminUserDetailInfos.get(0);
                        if (!id.equals(detailInfo1.getId())) {
                            baseVO.setErrorMsg("没有权限操作！");
                            baseVO.setSuccess(false);
                            return baseVO;
                        }
                    }
                    detailInfo.setGmt_modify(new Date());
                    shopAdminUserDetailInfoMapper.updateByPrimaryKeySelective(detailInfo);
                } else {
                    detailInfo.setModifier_account(account);
                    detailInfo.setCreator_account(account);
                    detailInfo.setGmt_create(new Date());
                    detailInfo.setGmt_modify(new Date());
                    shopAdminUserDetailInfoMapper.insert(detailInfo);

                    ShopAdminUserDetailInfoExample example = new ShopAdminUserDetailInfoExample();
                    ShopAdminUserDetailInfoExample.Criteria criteria = example.createCriteria();
                    criteria.andAccountEqualTo(account);
                    criteria.andShop_idEqualTo(shopId);
                    List<ShopAdminUserDetailInfo> shopAdminUserDetailInfos = shopAdminUserDetailInfoMapper.selectByExample(example);
                    if (!CollectionUtils.isEmpty(shopAdminUserDetailInfos)) {
                        baseVO.setData(shopAdminUserDetailInfos.get(0).getId());
                    }
                }
                baseVO.setSuccess(true);
            } catch(Exception e){
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("编辑异常！");
                LOG.error("ShopUserInfoDetailController#edit error", e);
            }

        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("account") String account,
                      @RequestParam("shopId") Long shopId) {
        BaseVO baseVO = new BaseVO();
        try {
            if (shopId == null || StringUtils.isEmpty(account)) {
                baseVO.setErrorMsg("必填项不能为空！");
                baseVO.setSuccess(false);
            } else {
                ShopAdminUserDetailInfoExample example = new ShopAdminUserDetailInfoExample();
                ShopAdminUserDetailInfoExample.Criteria criteria = example.createCriteria();
                criteria.andAccountEqualTo(account);
                criteria.andShop_idEqualTo(shopId);
                List<ShopAdminUserDetailInfo> shopAdminUserDetailInfos = shopAdminUserDetailInfoMapper.selectByExample(example);
                if(CollectionUtils.isEmpty(shopAdminUserDetailInfos)){
                    baseVO.setErrorMsg("个人信息还未编辑！");
                    baseVO.setSuccess(false);
                    return baseVO;
                }
                baseVO.setData(shopAdminUserDetailInfos.get(0));
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopUserInfoDetailController#get Exception input param is account="+account+"，shopId="+shopId, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
