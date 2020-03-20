package com.segama.ege.service;

import com.alibaba.fastjson.JSON;
import com.segama.ege.domain.CapitalFlowTypeEnum;
import com.segama.ege.dto.CapitalFlowDTO;
import com.segama.ege.entity.CapitalAccount;
import com.segama.ege.entity.CapitalFlow;
import com.segama.ege.entity.Shop;
import com.segama.ege.repository.CapitalAccountMapper;
import com.segama.ege.repository.CapitalFlowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author hxj 订单流水服务
 * @version 1.0
 * @Description
 * @date 2019-12-17 23:55
 */
@Component
public class CapitalFlowService {
    @Resource
    private CapitalFlowMapper capitalFlowMapper;

    @Resource
    CapitalAccountMapper capitalAccountMapper;

    private static Logger logger = LoggerFactory.getLogger(CapitalFlowService.class);

    /**
     * @param capitalFlowDTO 必填 operate_type 字段必填
     * @param shop           必填
     * @return
     * @see CapitalFlowTypeEnum
     */
    public int insertFlow(CapitalFlowDTO capitalFlowDTO, Shop shop) {
        try {

            if (capitalFlowDTO == null || shop == null) {
                logger.error("CapitalFlowService#insertFlow capitalFlowDTO={},shop={}"
                        , new Object[]{JSON.toJSONString(capitalFlowDTO)
                                , JSON.toJSONString(shop)});
                return -1;
            }

            Long capital_account_id = shop.getCapital_account_id();
            CapitalAccount capitalAccount = null;
            if (capital_account_id != null) {
                capitalAccount = capitalAccountMapper.selectByPrimaryKey(capital_account_id);
            }

            CapitalFlow capitalFlow = new CapitalFlow();
            capitalFlow.setShop_id(shop.getId());
            BeanUtils.copyProperties(capitalFlowDTO, capitalFlow);
            capitalFlow.setGmt_create(new Date());
            if (capitalAccount != null) {
                capitalFlow.setTotal_amount(capitalAccount.getTotal_amount());
                capitalFlow.setFreezing_amount(capitalAccount.getFreezing_amount());
                capitalFlow.setAvailable_amount(capitalAccount.getAvailable_amount());
                capitalFlow.setOpening_bank(capitalAccount.getOpening_bank());
                capitalFlow.setBank_card_num(capitalAccount.getBank_card_num());
            }
            capitalFlow.setPayee(capitalFlowDTO.getAmount());
            capitalFlow.setShop_id(shop.getId());
            capitalFlow.setShop_name(shop.getEnterprise_name());
            return capitalFlowMapper.insert(capitalFlow);

        } catch (Exception e) {
            logger.error("CapitalFlowService#insertFlow Exception capitalFlowDTO={}"
                    , new Object[]{e,
                            JSON.toJSONString(capitalFlowDTO)
                            , JSON.toJSONString(shop)});
            return -1;
        }
    }
}
