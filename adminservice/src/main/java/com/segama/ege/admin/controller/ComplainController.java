package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ComplaintSuggest;
import com.segama.ege.entity.ComplaintSuggestExample;
import com.segama.ege.repository.ComplaintSuggestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
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
 * @Description businessCooperateApply相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/complaint_suggest")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ComplainController {
    @Resource
    private ComplaintSuggestMapper complaintSuggestMapper;

    private static Logger LOG = LoggerFactory.getLogger(ComplainController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("limit") Integer pageSize,
            @RequestParam("user_name") String user_name,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ComplaintSuggestExample complaintSuggestExample = new ComplaintSuggestExample();
            ComplaintSuggestExample.Criteria complaintSuggestExampleCriteria = complaintSuggestExample.createCriteria();
            if(!StringUtils.isEmpty(user_name)){
                complaintSuggestExampleCriteria.andUser_nameLike("%"+user_name+"%");
            }
            int count = complaintSuggestMapper.countByExample(complaintSuggestExample);
            complaintSuggestExample.setPageCount(pageSize);
            complaintSuggestExample.setPageIndex(pageIndex);
            complaintSuggestExample.setOrderByClause("gmt_create desc");
            List<ComplaintSuggest> businessCooperateApplys = complaintSuggestMapper.selectByExample(complaintSuggestExample);
            baseVO.setData(businessCooperateApplys);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ComplaintSuggestController#list error",e);
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
            complaintSuggestMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("account") String account,
                    @RequestParam("status") String status,
                    @RequestParam("respond_message") String respond_message
                               ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ComplaintSuggest businessCooperateApply = complaintSuggestMapper.selectByPrimaryKey(id);
            if(!StringUtils.isEmpty(respond_message)){
                businessCooperateApply.setRespond_message(respond_message);
            }
            if(!StringUtils.isEmpty(status)){
                businessCooperateApply.setStatus(status);
            }
            businessCooperateApply.setGmt_modify(new Date());
            businessCooperateApply.setModifier_account(account);
            complaintSuggestMapper.updateByPrimaryKey(businessCooperateApply);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ComplaintSuggestController#edit error",e);
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
                ComplaintSuggest businessCooperateApply = complaintSuggestMapper.selectByPrimaryKey(id);
                baseVO.setData(businessCooperateApply);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ComplaintSuggestController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
