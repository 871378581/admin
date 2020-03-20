package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.SettleConfig;
import com.segama.ege.entity.SettleConfigExample;
import com.segama.ege.repository.SettleConfigMapper;
import org.apache.commons.lang3.StringUtils;
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
 * @Description 结算配置
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/settle_config")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SettleConfigController {

    @Resource
    private SettleConfigMapper settleConfigMapper;

    private static Logger LOG = LoggerFactory.getLogger(SettleConfigController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            SettleConfigExample settleConfigExample = new SettleConfigExample();
            SettleConfigExample.Criteria settleConfigExampleCriteria = settleConfigExample.createCriteria();
            
            int count = settleConfigMapper.countByExample(settleConfigExample);
            settleConfigExample.setPageCount(pageSize);
            settleConfigExample.setPageIndex(pageIndex);
            settleConfigExample.setOrderByClause("gmt_create desc");
            List<SettleConfig> adminMenus = settleConfigMapper.selectByExample(settleConfigExample);
            baseVO.setData(adminMenus);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("SettleConfigController#list error",e);
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
            settleConfigMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("fee") String fee,
                    @RequestParam("account") String account,
                    @RequestParam("card_level") Integer card_level) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null || StringUtils.isEmpty(fee) || card_level == null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            SettleConfig adminMenu = settleConfigMapper.selectByPrimaryKey(id);
            adminMenu.setCard_level(card_level);
            adminMenu.setFee(fee);
            adminMenu.setGmt_modify(new Date());
            adminMenu.setModifier_account(account);
            settleConfigMapper.updateByPrimaryKey(adminMenu);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            String message = e.getMessage();
            if(!StringUtils.isEmpty(message) && message.indexOf("Duplicate")>0){
                message=",数据重复！";
            }else{
                message="";
            }
            baseVO.setErrorMsg("编辑异常！"+message);
            LOG.error("SettleConfigController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(@RequestParam("card_level") Integer card_level,
                      @RequestParam("fee") String fee,
                      @RequestParam("account") String account) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(fee) || card_level ==null || StringUtils.isEmpty(account)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            SettleConfig adminMenu = new SettleConfig();
            adminMenu.setFee(fee);
            adminMenu.setCard_level(card_level);
            adminMenu.setCreator_account(account);
            adminMenu.setModifier_account(account);
            adminMenu.setGmt_create(new Date());
            adminMenu.setGmt_modify(new Date());
            settleConfigMapper.insert(adminMenu);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("SettleConfigController#add error",e);
            baseVO.setSuccess(false);
            String message = e.getMessage();
            if(!StringUtils.isEmpty(message) && message.indexOf("Duplicate")>0){
                message=",数据重复！";
            }else{
                message="";
            }
            baseVO.setErrorMsg("添加异常！"+message);
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
                SettleConfig adminMenu = settleConfigMapper.selectByPrimaryKey(id);
                baseVO.setData(adminMenu);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("SettleConfigController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
