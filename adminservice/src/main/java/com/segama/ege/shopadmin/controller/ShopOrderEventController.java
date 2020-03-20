package com.segama.ege.shopadmin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ServiceOrderEvent;
import com.segama.ege.entity.ServiceOrderEventExample;
import com.segama.ege.repository.ServiceOrderEventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单事件
 *
 * @author hxj
 * @version 1.0
 * @since 2019/10/19
 */
@RestController
@RequestMapping("/ege/api/shop_admin/order_event")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopOrderEventController {

    @Resource
    private ServiceOrderEventMapper serviceOrderEventMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopOrderEventController.class);

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
