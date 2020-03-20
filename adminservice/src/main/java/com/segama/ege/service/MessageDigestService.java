package com.segama.ege.service;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.entity.CapitalAccount;
import com.segama.ege.entity.Shop;
import com.segama.ege.repository.CapitalAccountMapper;
import com.segama.ege.util.MessageDigestUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class MessageDigestService {

    @Resource
    private CapitalAccountMapper capitalAccountMapper;

    public int updateCapitalAccountInfo(Shop shop, String new_fee){
        CapitalAccount capitalAccount = this.capitalAccountMapper.selectByPrimaryKey(shop.getCapital_account_id());
        if(capitalAccount == null){
            return -1;
        }
        String theory_mac = MessageDigestUtil.getSHA256Digest(
                capitalAccount.getAccount_no()
                        + capitalAccount.getAccount_type() + capitalAccount.getTotal_amount()
                        + capitalAccount.getFreezing_amount() + capitalAccount.getAvailable_amount()
                        + DateUtil.parse(capitalAccount.getGmt_modify()));
        //todo 增加校验值判断
        /*if(StringUtils.isEmpty(capitalAccount.getMac())
                || !theory_mac.equalsIgnoreCase(capitalAccount.getMac())){
            return -1;
        }*/
        Double new_total_amount = Double.parseDouble(capitalAccount.getTotal_amount()) + Double.parseDouble(new_fee);
        Double new_avail_amount = Double.parseDouble(capitalAccount.getAvailable_amount()) + Double.parseDouble(new_fee);
        Date now = new Date();

        String new_mac = MessageDigestUtil.getSHA256Digest(
                capitalAccount.getAccount_no()
                        + capitalAccount.getAccount_type() + new_total_amount
                        + capitalAccount.getFreezing_amount() + new_avail_amount
                        + DateUtil.parse(now));
        capitalAccount.setAvailable_amount(String.valueOf(new_avail_amount));
        capitalAccount.setTotal_amount(String.valueOf(new_total_amount));
        capitalAccount.setMac(new_mac);
        capitalAccount.setGmt_modify(now);
        int ret = this.capitalAccountMapper.updateByPrimaryKeySelective(capitalAccount);
        return ret;
    }
}
