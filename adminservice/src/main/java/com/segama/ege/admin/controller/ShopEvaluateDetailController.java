package com.segama.ege.admin.controller;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ShopEvaluateDetail;
import com.segama.ege.entity.ShopEvaluateDetailExample;
import com.segama.ege.entity.AdminRoleMenuRelationExample;
import com.segama.ege.repository.ShopEvaluateDetailMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @Description 相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/shop_evaluate_detail")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopEvaluateDetailController {
    @Resource
    private ShopEvaluateDetailMapper shopEvaluateDetailMapper;

    private static Logger LOG = LoggerFactory.getLogger(ShopEvaluateDetailController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("time") String time
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ShopEvaluateDetailExample shopEvaluateDetailExample = new ShopEvaluateDetailExample();
            ShopEvaluateDetailExample.Criteria shopEvaluateDetailExampleCriteria = shopEvaluateDetailExample.createCriteria();

            if(!StringUtils.isEmpty(time)) {
                String[] hours = time.split(" - ");
                String time_start_str = hours[0];
                String time_end_str = hours[1];
                Date time_start = DateUtils.parseDate(time_start_str, DateUtil.YYYY_MM_DD_HH_MM_SS);
                Date time_end = DateUtils.parseDate(time_end_str, DateUtil.YYYY_MM_DD_HH_MM_SS);
                shopEvaluateDetailExampleCriteria.andGmt_repairBetween(time_start,time_end);
            }
            int count = shopEvaluateDetailMapper.countByExample(shopEvaluateDetailExample);
            shopEvaluateDetailExample.setPageCount(pageSize);
            shopEvaluateDetailExample.setPageIndex(pageIndex);
            shopEvaluateDetailExample.setOrderByClause("gmt_create desc");
            List<ShopEvaluateDetail> shopEvaluateDetails = shopEvaluateDetailMapper.selectByExample(shopEvaluateDetailExample);
            baseVO.setData(shopEvaluateDetails);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ShopEvaluateDetailController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id ) {
        BaseVO baseVO = new BaseVO();
        if(id == null){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能删除！");
        }else {
            shopEvaluateDetailMapper.deleteByPrimaryKey(id);
            AdminRoleMenuRelationExample example = new AdminRoleMenuRelationExample();
            AdminRoleMenuRelationExample.Criteria criteria = example.createCriteria();
            criteria.andMenu_idEqualTo(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
                        @RequestParam("user_id") String user_id,
                        @RequestParam("nick_name") String nick_name,
                        @RequestParam("car_type") String car_type,
                        @RequestParam("gmt_repair") String gmt_repair,
                        @RequestParam("evaluate_score") String evaluate_score,
                        @RequestParam("evaluate_content") String evaluate_content,
                        @RequestParam("is_invalid") Boolean is_invalid,
                        @RequestParam("shop_id") Long shop_id,
                       @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(user_id==null || account == null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopEvaluateDetail shopEvaluateDetail = new ShopEvaluateDetail();
            shopEvaluateDetail.setUser_id(user_id);
            shopEvaluateDetail.setNick_name(nick_name);
            shopEvaluateDetail.setCar_type(car_type);
            shopEvaluateDetail.setGmt_repair(DateUtils.parseDate(gmt_repair,DateUtil.YYYY_MM_DD_HH_MM_SS));
            shopEvaluateDetail.setEvaluate_score(evaluate_score);
            shopEvaluateDetail.setEvaluate_content(evaluate_content);
            shopEvaluateDetail.setIs_invalid(is_invalid);
            shopEvaluateDetail.setShop_id(shop_id);
            shopEvaluateDetail.setGmt_modify(new Date());
            shopEvaluateDetail.setGmt_evaluate_commit(new Date());
            shopEvaluateDetail.setGmt_create(new Date());
            shopEvaluateDetail.setModifier_account(account);
            shopEvaluateDetail.setCreator_account(account);
            shopEvaluateDetail.setVersion(0);
            shopEvaluateDetailMapper.insert(shopEvaluateDetail);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopEvaluateDetailController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ShopEvaluateDetail shopEvaluateDetail = shopEvaluateDetailMapper.selectByPrimaryKey(id);

            shopEvaluateDetail.setGmt_modify(new Date());
            shopEvaluateDetail.setModifier_account(account);
            shopEvaluateDetailMapper.updateByPrimaryKey(shopEvaluateDetail);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ShopEvaluateDetailController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id == null){
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            }else {
                ShopEvaluateDetail shopEvaluateDetail = shopEvaluateDetailMapper.selectByPrimaryKey(id);
                baseVO.setData(shopEvaluateDetail);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ShopEvaluateDetailController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
