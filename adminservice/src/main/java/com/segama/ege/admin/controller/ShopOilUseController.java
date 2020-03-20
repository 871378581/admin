package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.ShopOilUseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.BannerMapper;
import com.segama.ege.repository.ReportMapper;
import com.segama.ege.repository.ServiceOrderMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author hxj
 * @version 1.0
 * @Description 门店机油使用情况
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/shop_oil_use")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopOilUseController {
    @Resource
    private ServiceOrderMapper serviceOrderMapper;

    @Resource
    private ReportMapper reportMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopOilUseController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("gmt_create") String gmt_create,
            @RequestParam("shop_id") String shop_ids,
            @RequestParam("oil_id") String oil_ids
            ) {
        BaseVO baseVO = new BaseVO();
        try {

            ServiceOrderExample example = new ServiceOrderExample();
            ServiceOrderExample.Criteria criteria = example.createCriteria();
            //店铺
            if(!StringUtils.isEmpty(shop_ids)){
                List<Long> collect =
                        Lists.newArrayList(
                                shop_ids.split(","))
                                .stream()
                                .map(Long::valueOf)
                                .collect(Collectors.toList());
                criteria.andShop_idIn(collect);
            }
            //机油
            if(!StringUtils.isEmpty(oil_ids)){
                List<Long> collect =
                        Lists.newArrayList(
                                oil_ids.split(","))
                                .stream()
                                .map(Long::valueOf)
                                .collect(Collectors.toList());
                criteria.andOil_idIn(collect);
            }
            if (!StringUtils.isEmpty(gmt_create)) {
                String[] hours = gmt_create.split(" - ");
                String time_start_str = hours[0];
                String time_end_str = hours[1];
                Date time_start = DateUtils.parseDate(time_start_str, DateUtil.YYYY_MM_DD_HH_MM_SS);
                Date time_end = DateUtils.parseDate(time_end_str, DateUtil.YYYY_MM_DD_HH_MM_SS);
                criteria.andGmt_createBetween(time_start, time_end);
            }
            int count = serviceOrderMapper.countByExample(example);
            List<ShopOilUseVO> shopOilUseVOS = Lists.newArrayList();
            if(count>0){
                int page =  (count-1)/10+1;
                for(int i=1;i<=page;i++){
                    example.setPageIndex(i);
                    example.setPageCount(10);
                    List<ServiceOrder> serviceOrders = serviceOrderMapper.selectByExample(example);
                    Optional.ofNullable(serviceOrders).ifPresent(
                            a->shopOilUseVOS.addAll(
                                    a.stream()
                                            .map(b->{
                                                Report report = reportMapper.selectByPrimaryKey(b.getReport_id());
                                                return new ShopOilUseVO(
                                                        report.getReport_items(),
                                                        b.getOil_id(),
                                                        b.getOil_brand(),
                                                        b.getShop_id(),
                                                        b.getShop_name()
                                                        );
                                            }
                                    ).collect(Collectors.toList())
                            )
                    );
                }
            }

            baseVO.setData(null);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ShopOilUseController#list error",e);
        }
        return baseVO;
    }

}
