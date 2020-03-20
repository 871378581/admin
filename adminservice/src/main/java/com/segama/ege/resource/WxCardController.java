package com.segama.ege.resource;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.constant.Constants;
import com.segama.ege.domain.CarStatus;
import com.segama.ege.domain.MemberCardTakeEffectEnum;
import com.segama.ege.domain.MembershipCardStatus;
import com.segama.ege.dto.*;
import com.segama.ege.entity.*;
import com.segama.ege.repository.MembershipCardMapper;
import com.segama.ege.repository.MembershipcardBindCarLogMapper;
import com.segama.ege.repository.WxUserMapper;
import com.segama.ege.service.CacheService;
import com.segama.ege.util.CommonUtil;
import com.segama.ege.util.PlateConvertUtil;
import org.apache.commons.lang3.StringUtils;
import com.segama.ege.repository.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/ege/api/card")
public class WxCardController
{
    @Resource
    private MembershipCardMapper cardMapper;

    @Resource
    private CarMapper carMapper;

    @Autowired
    CacheService cacheService;

    @Resource
    private WxUserMapper userMapper;

    @Resource
    private MembershipcardBindCarLogMapper logMapper;

    @PostMapping("/activateCard")
    public BaseResult activateCard(@RequestBody CardActivateRequestDTO dto) {
        BaseResult result = null;
        WxUser wxUser = CommonUtil.getCurrentLoginUser();
        if (wxUser == null) {
            WxUserExample userExample = new WxUserExample();
            userExample.createCriteria().andUser_idEqualTo(dto.getUser_id());
            List<WxUser> wxUsers  = this.userMapper.selectByExample(userExample);
            if(CollectionUtils.isEmpty(wxUsers)){
                return BaseResult.buildLoginRequiredResponse();
            }
            wxUser = wxUsers.get(0);
        }

        if(StringUtils.isNotEmpty(dto.getCard_id())
                && StringUtils.isNotEmpty(dto.getUser_id())
                && StringUtils.isNotEmpty(dto.getPassword())
                && StringUtils.isNotEmpty(dto.getPlate())
                && StringUtils.isNotEmpty(dto.getPhone())
                && StringUtils.isNotEmpty(dto.getUser_name())){

            MembershipCardExample example = new MembershipCardExample();
            example.createCriteria().andPasswordEqualTo(dto.getPassword()).andCard_idEqualTo(dto.getCard_id());
            List<MembershipCard> cards = this.cardMapper.selectByExample(example);
            if(CollectionUtils.isEmpty(cards)){
                result = BaseResult.error("504", "会员卡号和密码不匹配，无法激活！");
                return result;
            }

            MembershipCard myCard = cards.get(0);
            Date now = new Date();
            if(myCard.getStatus().equals(MembershipCardStatus.expired.getCode())
                    || (myCard.getExpire_date()!= null && myCard.getExpire_date().before(now))){
                result = BaseResult.error("504", "该卡片已经过期，无法激活！");
                return result;
            }

            if(!myCard.getStatus().equals(MembershipCardStatus.have_maked.getCode())){
                result = BaseResult.error("504", "当前卡片状态异常(未制作)，无法激活");
                return result;
            }

            CarExample carExample = new CarExample();
            carExample.createCriteria().andPlateEqualTo(dto.getPlate()).andUser_idEqualTo(dto.getUser_id());
            List<Car> cars = this.carMapper.selectByExample(carExample);
            if(CollectionUtils.isEmpty(cars)){
                result = BaseResult.error("504", "微信用户和所属的车牌号码不匹配！");
                return result;
            }

            Car myCar = cars.get(0);
            if(myCar.getCar_status() != null && myCar.getCar_status().equals(CarStatus.using.getCode())
                    && myCar.getMembership_card_id() != null
                    && myCar.getMembership_card_id().equals(myCard.getCard_id())) {
                result = BaseResult.error("504", "该车和会员卡已经绑定，无需重复绑定！");
                return result;
            }

            myCard.setGmt_modify(now);
            myCard.setStatus(MembershipCardStatus.activated.getCode());
            String effectiveDateStr ="";
            String expireDateStr = "";
            if(myCard.getTake_effect_type().equals(MemberCardTakeEffectEnum.effect_after_x_days.getCode())){
                String currDateStr = DateUtil.getNowDateStr();
                int days = Integer.parseInt(cacheService.getConfig(Constants.effect_after_x_days));
                effectiveDateStr = DateUtil.plusDay(days, currDateStr);
                myCard.setEffective_date(DateUtil.getDateByStr(effectiveDateStr));

                int effective_days = myCard.getEffective_days();
                if( effective_days <= 0){
                    effective_days = Integer.parseInt(cacheService.getConfig(Constants.period_of_validity));
                }
                expireDateStr = DateUtil.plusDay(effective_days, effectiveDateStr);
                myCard.setExpire_date(DateUtil.getDateByStr(expireDateStr));
            }
            cardMapper.updateByPrimaryKeySelective(myCard);


            myCar.setMembership_card_id(dto.getCard_id());
            myCar.setCar_status(CarStatus.using.getCode());
            myCar.setGmt_activate(now);
            myCar.setGmt_modify(now);
            if(myCard.getTake_effect_type().equals(MemberCardTakeEffectEnum.effect_after_x_days.getCode())){
                myCar.setGmt_take_effect(DateUtil.getDateByStr(effectiveDateStr));
                myCar.setGmt_lose_effect(DateUtil.getDateByStr(expireDateStr));
            }
            myCar.setCard_level(myCard.getCard_level());
            int ret = carMapper.updateByPrimaryKeySelective(myCar);
            if(ret <= 0){
                result = BaseResult.error("503", "车绑定会员卡失败");
                return result;
            }

            //同步更新微信用户信息表的默认车辆的card_level字段
            if(wxUser.getHas_default_car() && wxUser.getDefault_plate().equalsIgnoreCase(myCar.getPlate())){
                wxUser.setCard_level(myCard.getCard_level());
                wxUser.setGmt_modify(now);
                wxUser.setDefault_plate(PlateConvertUtil.convertToCapital(myCar.getPlate()));
            }
            if(!dto.getUser_name().equals(wxUser.getUser_name())){
                wxUser.setUser_name(dto.getUser_name());
            }
            if(!dto.getPhone().equals(wxUser.getPhone())){
                wxUser.setPhone(dto.getPhone());
            }
            this.userMapper.updateByPrimaryKeySelective(wxUser);

            MembershipcardBindCarLog log = new MembershipcardBindCarLog();
            log.setGmt_create(now);
            log.setGmt_bind(now);
            log.setGmt_activate(now);
            log.setGmt_take_effect(myCar.getGmt_take_effect());
            log.setGmt_lose_effect(myCar.getGmt_lose_effect());
            log.setMembership_card_id(dto.getCard_id());
            log.setPlate(dto.getPlate());
            log.setStatus(MembershipCardStatus.activated.getCode());
            log.setUser_id(dto.getUser_id());
            log.setVersion(0);
            this.logMapper.insert(log);

            result =  BaseResult.success(true);
        }else{
            result = BaseResult.error("503", "请求参数不能为空");
        }
        return result;
    }
}
