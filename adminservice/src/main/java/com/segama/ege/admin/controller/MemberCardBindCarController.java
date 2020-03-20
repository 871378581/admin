package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.MembershipCard;
import com.segama.ege.entity.MembershipCardExample;
import com.segama.ege.entity.MembershipcardBindCarLog;
import com.segama.ege.entity.MembershipcardBindCarLogExample;
import com.segama.ege.repository.MembershipCardMapper;
import com.segama.ege.repository.MembershipcardBindCarLogMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description 会员卡绑定汽车日志
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/member_card_bid_car_manage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MemberCardBindCarController{
    @Resource
    private MembershipcardBindCarLogMapper membershipcardBindCarLogMapper;

    private static Logger LOG = LoggerFactory.getLogger(MemberCardBindCarController.class);

    @Resource
    MembershipCardMapper membershipCardMapper;

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("plate") String plate
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            MembershipcardBindCarLogExample example = new MembershipcardBindCarLogExample();
            MembershipcardBindCarLogExample.Criteria criteria = example.createCriteria();

            if (StringUtils.isNotEmpty(plate)) {
                criteria.andPlateLike("%" + plate + "%");
            }
            int count = membershipcardBindCarLogMapper.countByExample(example);
            example.setPageCount(pageSize);
            example.setPageIndex(pageIndex);
            example.setOrderByClause("gmt_create desc");
            List<MembershipcardBindCarLog> cars = membershipcardBindCarLogMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(cars)){
                cars.stream().forEach(card->{
                    MembershipCard membershipCard = queryCard(card.getMembership_card_id());
                    card.setGmt_lose_effect(membershipCard.getExpire_date());
                    card.setGmt_take_effect(membershipCard.getEffective_date());
                });
            }
            baseVO.setData(cars);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("MembershipCardBindCarLogController#list error", e);
        }
        return baseVO;
    }

    private MembershipCard queryCard(String cardNo){
        MembershipCardExample example = new MembershipCardExample();
        MembershipCardExample.Criteria criteria = example.createCriteria();
        criteria.andCard_idEqualTo(cardNo);
        List<MembershipCard> membershipCards = membershipCardMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(membershipCards)){
            return membershipCards.get(0);
        }
        return null;
    }

}
