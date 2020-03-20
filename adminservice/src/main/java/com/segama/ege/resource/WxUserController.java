package com.segama.ege.resource;

import com.segama.ege.dto.*;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import com.segama.ege.service.UserService;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.segama.ege.service.SmsService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/ege/api/user")
public class WxUserController extends BaseController {
    @Autowired
    UserService userService;

    @Autowired
    SmsService smsService;

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private WxUserMapper wxUserMapper;

    @Resource
    private ShopAdminUserMapper shopAdminUserMapper;

    @Resource
    private ShopAdminUserDetailInfoMapper shopAdminUserDetailInfoMapper;

    @Resource
    private CarMapper carMapper;

    @Resource
    private SmsSentRecordMapper smsSentRecordMapper;

    private static final Logger log = getLogger(WxUserController.class);

    @RequestMapping("/getUserInfo")
    public BaseResult getUserInfo(@RequestParam(value = "user_id", defaultValue = "") String user_id) {
        BaseResult result;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            WxUserExample example = new WxUserExample();
            example.createCriteria().andUser_idEqualTo(user_id);
            List<WxUser> wxUsers = wxUserMapper.selectByExample(example);
            if(wxUsers.size()>0) {
                currentLoginUser = wxUsers.get(0);
            }
            if (currentLoginUser == null) {
                return BaseResult.buildLoginRequiredResponse();
            }
        }
        CarExample carExample = new CarExample();
        carExample.createCriteria().andUser_idEqualTo(currentLoginUser.getUser_id());
        carExample.setOrderByClause("is_default desc, gmt_create asc");
        List<Car> cars = this.carMapper.selectByExample(carExample);
        CarInfoResponseListDTO carListDTO = new CarInfoResponseListDTO();
        carListDTO.addCars(cars, currentLoginUser);
        WxUserInfoDTO dto = WxUserInfoDTO.buildOrigin(currentLoginUser, carListDTO);
        result = BaseResult.success(dto);
        return result;
    }

    @PostMapping("/saveUserInfo")
    public BaseResult saveUserInfo(@RequestBody WxUserInfoRequestDTO dto) {
        BaseResult result = new BaseResult();
        if(StringUtils.isNotEmpty(dto.getUser_id())) {
            WxUserExample example = new WxUserExample();
            example.createCriteria().andUser_idEqualTo(dto.getUser_id());
            List<WxUser> wxUsers = wxUserMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(wxUsers)){
                WxUser wxUser = wxUsers.get(0);

                if(StringUtils.isNotEmpty(dto.getLevel())){
                    wxUser.setMembership_level(dto.getLevel());
                }

                if(StringUtils.isNotEmpty(dto.getSex())){
                    wxUser.setSex(dto.getSex());
                }

                if(StringUtils.isNotEmpty(dto.getLevel())){
                    wxUser.setMembership_level(dto.getLevel());
                }
                if(StringUtils.isNotEmpty(dto.getAccount())){
                    wxUser.setAccount(dto.getAccount());
                }
                if(StringUtils.isNotEmpty(dto.getBirth())){
                    wxUser.setBirth(dto.getBirth());
                }
                if(StringUtils.isNotEmpty(dto.getJob())){
                    wxUser.setJob(dto.getJob());
                }

                if(StringUtils.isNotEmpty(dto.getPlace_city())){
                    wxUser.setPlace_city(dto.getPlace_city());
                }

                if(StringUtils.isNotEmpty(dto.getUser_head())){
                    wxUser.setUser_head(dto.getUser_head());
                }

                if(StringUtils.isNotEmpty(dto.getUser_name())){
                    wxUser.setUser_name(dto.getUser_name());
                }

                if (StringUtils.isNotEmpty(dto.getPhone())){
                    wxUser.setPhone(dto.getPhone());
                    wxUser.setHas_bind_phone(true);
                }
                wxUser.setGmt_modify(new Date());
                wxUserMapper.updateByPrimaryKey(wxUser);
                result.setSuccess(true);
            }else{
                result.setSuccess(false);
                result.setErrorMessage("未找到该会员，无法更新。");
            }
        }else{
            result.setSuccess(false);
            result.setErrorMessage("会员号为空，无法更新。");
        }
        return result;
    }

    @RequestMapping("/auth/getVerifyCode")
    public BaseResult getVerifyCode(@RequestParam(value = "user_id", defaultValue = "") String user_id,
                                    @RequestParam("phone") String phone) {
        BaseResult toReturn;
        try {
            WxUser currentUser = CommonUtil.getCurrentLoginUser();
            if (currentUser == null) {
                return BaseResult.buildLoginRequiredResponse();
            }
            if (currentUser.getHas_bind_phone() != null && currentUser.getHas_bind_phone()) {
                return BaseResult.error("441", "已经通过验证，无需重复提交");
            }
            //判断是否超过限制次数
            Date currentTime = new Date();
            String todayDate = DateUtil.getYYYYMMDDStrOfToday();
            SmsSentRecordExample example = new SmsSentRecordExample();
            example.createCriteria().andUser_idEqualTo(currentUser.getUser_id())
                    .andTime_in_minLike(todayDate + "%");
            int cnt = smsSentRecordMapper.countByExample(example);
            if (cnt > 5) {
                return BaseResult.error("442", "超过今日短信发送上限");
            }
            //先调用短信api发送短信，如果短信发送成功，则插入消息发送记录
            Random random = new Random();
            String code = String.format("%04d", random.nextInt(9999));
            boolean isSendSuccess = smsService.sendVerifyMsg(code, phone);
            if(!isSendSuccess){
                return BaseResult.error("500", "获取验证码失败，请一分钟后重试");
            }

            SmsSentRecord smsSentRecord = new SmsSentRecord();
            smsSentRecord.setUser_id(currentUser.getUser_id());
            smsSentRecord.setMobile_phone(currentUser.getPhone());
            smsSentRecord.setTime_in_min(DateUtil.parse(currentTime));
            smsSentRecord.setGmt_create(currentTime);
            smsSentRecord.setContent(code);
            smsSentRecordMapper.insertSelective(smsSentRecord);

            //更新db
            currentUser.setPhone(phone);
            currentUser.setCode(code);
            currentUser.setCode_expired_at(DateUtil.plusMinutes(currentTime, 5));//5分钟有效期
            wxUserMapper.updateByPrimaryKeySelective(currentUser);
            toReturn = BaseResult.success("sent");
        } catch (Exception e) {
            toReturn = BaseResult.error("500", "获取验证码失败，请一分钟后重试");
            log.error("error in getVerifyCode", e);
        }
        return toReturn;
    }

    @RequestMapping("/auth/verify")
    public BaseResult bind(@RequestParam(value = "user_id", defaultValue = "") String user_id,
                           @RequestParam(value = "code") String code) {
        BaseResult toReturn;
        try {
            if (StringUtils.isBlank(code)) {
                return BaseResult.error("410", "无效验证码");
            }

            WxUser currentUser = CommonUtil.getCurrentLoginUser();
            if (currentUser == null) {
                return BaseResult.buildLoginRequiredResponse();
            }

            if (currentUser.getCode_expired_at().after(new Date())
                    && code.equals(currentUser.getCode())) {
                currentUser.setHas_bind_phone(true);
                wxUserMapper.updateByPrimaryKeySelective(currentUser);
                toReturn = BaseResult.success("success");
            } else {
                return BaseResult.error("411", "无效验证码");
            }
        } catch (Exception e) {
            toReturn = BaseResult.error("500", "验证失败");
            log.error("error in bind phone", e);
        }
        return toReturn;
    }

    @RequestMapping("/shopUserLogin")
    public BaseResult shopUserLogin(@RequestParam(value = "account") String account,
                                    @RequestParam("password") String password) {
        BaseResult toReturn;
        if(StringUtils.isNotEmpty(account) && StringUtils.isNotEmpty(password)){
            ShopAdminUserExample example = new ShopAdminUserExample();
            example.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
            List<ShopAdminUser> adminUsers = this.shopAdminUserMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(adminUsers)){
                ShopAdminUser adminUser = adminUsers.get(0);
                Shop shop = this.shopMapper.selectByPrimaryKey(adminUser.getShop_id());
                if(shop == null||shop.getIs_disable()){
                    toReturn = BaseResult.error("500", "用户名所属门店不存在");
                }
                ShopUserLoginResponseDTO dto = new ShopUserLoginResponseDTO();
                dto.setShop_id(adminUser.getShop_id());
                dto.setShop_user_id(adminUser.getId());
                ShopAdminUserDetailInfoExample detailInfoExample = new ShopAdminUserDetailInfoExample();
                detailInfoExample.createCriteria().andShop_idEqualTo(adminUser.getShop_id()).andAccountEqualTo(adminUser.getAccount());
                List<ShopAdminUserDetailInfo> infos = this.shopAdminUserDetailInfoMapper.selectByExample(detailInfoExample);
                if(!CollectionUtils.isEmpty(infos)){
                    ShopAdminUserDetailInfo detailInfo = infos.get(0);
                    dto.setBirth(detailInfo.getBirth());
                    dto.setJob(detailInfo.getJob());
                    dto.setPhone(detailInfo.getPhone());
                    dto.setPlace_city(detailInfo.getCity());
                    dto.setSex(detailInfo.getGender());
                    dto.setShop_user_account(detailInfo.getAccount());
                    dto.setShop_user_name(detailInfo.getReal_name());
                    dto.setUser_head(detailInfo.getUser_head());
                }
                toReturn = BaseResult.success(dto);
            }else{
                toReturn = BaseResult.error("500", "用户名和密码不匹配");
            }
        }else{
            toReturn = BaseResult.error("500", "用户名或密码不能为空");
        }
        return toReturn;
    }

    @PostMapping("/saveShopUserInfo")
    public BaseResult saveShopUserInfo(@RequestBody ShopAdminUserInfoRequestDTO dto) {
        BaseResult result = new BaseResult();
        ShopAdminUserExample example = new ShopAdminUserExample();
        example.createCriteria().andShop_idEqualTo(dto.getShop_id()).andAccountEqualTo(dto.getShop_user_account());
        List<ShopAdminUser> shopAdminUsers = this.shopAdminUserMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(shopAdminUsers)){
            ShopAdminUser adminUser = shopAdminUsers.get(0);
            ShopAdminUserDetailInfoExample detailInfoExample = new ShopAdminUserDetailInfoExample();
            detailInfoExample.createCriteria().andShop_idEqualTo(adminUser.getShop_id()).andAccountEqualTo(adminUser.getAccount());
            List<ShopAdminUserDetailInfo> infos = this.shopAdminUserDetailInfoMapper.selectByExample(detailInfoExample);
            int ret = 0;
            if(!CollectionUtils.isEmpty(infos)){
                ShopAdminUserDetailInfo eachInfo = infos.get(0);
                if(StringUtils.isNotEmpty(dto.getSex())){
                    eachInfo.setGender(dto.getSex());
                }
                if(StringUtils.isNotEmpty(dto.getBirth())){
                    eachInfo.setBirth(dto.getBirth());
                }
                if(StringUtils.isNotEmpty(dto.getJob())){
                    eachInfo.setJob(dto.getJob());
                }

                if(StringUtils.isNotEmpty(dto.getPlace_city())){
                    eachInfo.setCity(dto.getPlace_city());
                }

                if(StringUtils.isNotEmpty(dto.getShop_user_name())){
                    eachInfo.setReal_name(dto.getShop_user_name());
                }

                if (StringUtils.isNotEmpty(dto.getPhone())){
                    eachInfo.setPhone(dto.getPhone());
                }

                eachInfo.setGmt_modify(new Date());
                ret = this.shopAdminUserDetailInfoMapper.updateByPrimaryKeySelective(eachInfo);
            }

            if(ret > 0){
                result.setSuccess(true);
            }else{
                result.setSuccess(false);
            }

        }else{
            result.setSuccess(false);
            result.setErrorMessage("未找到该员工，无法更新。");
        }
        return result;
    }

    @PostMapping("/updateShopUserPassword")
    public BaseResult updateShopUserPassword(@RequestBody UpdateShopUserPasswordRequestDTO dto) {
        BaseResult result = new BaseResult();
        ShopAdminUser adminUser = this.shopAdminUserMapper.selectByPrimaryKey(dto.getShop_user_id());
        if(adminUser == null){
            result.setSuccess(false);
            result.setErrorMessage("未找到该员工，无法修改密码。");
            return result;
        }
        if(StringUtils.isEmpty(dto.getOld_password())|| !adminUser.getPassword().equals(dto.getOld_password())){
            result.setSuccess(false);
            result.setErrorMessage("该员工原密码输入错误，无法修改密码。");
            return result;
        }
        if(StringUtils.isEmpty(dto.getNew_password())){
            result.setSuccess(false);
            result.setErrorMessage("该员工原密码输入错误，无法修改密码。");
            return result;
        }

        if(dto.getOld_password().equals(dto.getNew_password())){
            result.setSuccess(false);
            result.setErrorMessage("该员工原密码与新密码一致，无需修改密码。");
            return result;
        }

        adminUser.setPassword(dto.getNew_password());
        adminUser.setGmt_modify(new Date());
        int ret = this.shopAdminUserMapper.updateByPrimaryKeySelective(adminUser);
        if(ret > 0){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
            result.setErrorMessage("该员工密码更新异常!");
        }
        return result;
    }
}
