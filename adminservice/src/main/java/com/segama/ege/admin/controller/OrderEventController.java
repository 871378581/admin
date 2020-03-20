package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.response.ShopOilSupplyVO;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.EngineOilMapper;
import com.segama.ege.repository.ServiceOrderEventMapper;
import com.segama.ege.repository.ShopMapper;
import com.segama.ege.repository.ShopOilSupplyMapper;
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
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单事件
 *
 * @author hxj
 * @version 1.0
 * @since 2019/10/19
 */
@RestController
@RequestMapping("/ege/api/admin/order_event")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderEventController {

    @Resource
    private ServiceOrderEventMapper serviceOrderEventMapper;

    private static Logger LOG = LoggerFactory.getLogger(OrderEventController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("order_id") Long order_id,
            @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();

        try {
            if(order_id==null){
                baseVO.setData(Lists.newArrayList());
                baseVO.setSuccess(true);
                return baseVO;
            }
            ServiceOrderEventExample example = new ServiceOrderEventExample();
            ServiceOrderEventExample.Criteria criteria = example.createCriteria();
            criteria.andOrder_idEqualTo(order_id);
            int count = serviceOrderEventMapper.countByExample(example);
            if(count != 0){
                example.setPageCount(pageSize);
                example.setPageIndex(pageIndex);
                example.setOrderByClause("gmt_create desc");
                List<ServiceOrderEvent> serviceOrderEvents = serviceOrderEventMapper.selectByExample(example);
                baseVO.setData(serviceOrderEvents);
            }
            baseVO.setCode(0);
            baseVO.setCount(count);

        }catch (Exception e){
            baseVO.setErrorMsg("数据获取异常");
            baseVO.setSuccess(false);
            LOG.error("OrderEventController#list Exception",e);
        }
        return baseVO;
    }

}
