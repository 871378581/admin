package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.AdminSystemConfigMapper;
import com.segama.ege.repository.ThBusinessMerchantManageMapper;
import com.segama.ege.repository.ThProductChannelMapMapper;
import com.segama.ege.repository.ThTemplateManageMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hxj
 * @version 1.0
 * @Description 模版相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/template_manage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TemplateController {

    @Resource
    private ThTemplateManageMapper thTemplateManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(TemplateController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "template_name", required = false) String template_name
            ,@RequestParam(value = "type", required = false) String type
            , @RequestParam(value = "limit", required = false) Integer pageSize,
            @RequestParam(value = "page", required = false) Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThTemplateManageExample adminRoleExample = new ThTemplateManageExample();
            adminRoleExample.setOrderByClause("gmt_create desc");
            ThTemplateManageExample.Criteria adminRoleExampleCriteria = adminRoleExample.createCriteria();
            if (StringUtils.isNotEmpty(template_name)) {
                adminRoleExampleCriteria.andTemplate_nameLike("%" + template_name + "%");
            }
            int count = thTemplateManageMapper.countByExample(adminRoleExample);
            List<ThTemplateManage> thTemplateManages = Lists.newArrayList();
            if (count != 0) {
                adminRoleExample.setPageCount(pageSize);
                adminRoleExample.setPageIndex(pageIndex);
                thTemplateManages = thTemplateManageMapper.selectByExample(adminRoleExample);
            }
            baseVO.setData(thTemplateManages);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("ThTemplateManageController#list error", e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("template_code") String template_code) {
        BaseVO baseVO = new BaseVO();
        if (StringUtils.isEmpty(template_code)) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("code为空不能删除！");
        } else {
            ThTemplateManageExample thTemplateManageExample = new ThTemplateManageExample();
            ThTemplateManageExample.Criteria criteria = thTemplateManageExample.createCriteria();
            criteria.andTemplate_codeEqualTo(template_code);
            thTemplateManageMapper.deleteByExample(thTemplateManageExample);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit_user(ThTemplateManage adminRoleNew,
                            @RequestParam("account") String editAccount) {
        BaseVO baseVO = new BaseVO();
        try {
            if (adminRoleNew.getId() == null) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThTemplateManage temp = thTemplateManageMapper.selectByPrimaryKey(adminRoleNew.getId());

            temp.setGmt_modify(new Date());
            temp.setModifier_account(editAccount);
            BeanUtils.copyProperties(adminRoleNew, temp);
            thTemplateManageMapper.updateByPrimaryKey(temp);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThTemplateManageController#edit error", e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(ThTemplateManage thTemplateManage,
                      @RequestParam("account") String account) {

        BaseVO baseVO = new BaseVO();
        try {
            if (StringUtils.isEmpty(thTemplateManage.getTemplate_name()) ) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            thTemplateManage.setCreator_account(account);
            thTemplateManage.setModifier_account(account);
            thTemplateManage.setGmt_create(new Date());
            thTemplateManage.setGmt_modify(new Date());
            thTemplateManage.setTemplate_code(UUIDUtils.UUID());
            thTemplateManageMapper.insert(thTemplateManage);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThTemplateManageController#add error", e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null) {
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            } else {
                ThTemplateManage ThTemplateManage = thTemplateManageMapper.selectByPrimaryKey(id);
                baseVO.setData(ThTemplateManage);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThTemplateManageController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_templates")
    public BaseVO get_all_templates() {
        BaseVO baseVO = new BaseVO();
        try {
            ThTemplateManageExample example = new ThTemplateManageExample();
            ThTemplateManageExample.Criteria criteria = example.createCriteria();
            List<ThTemplateManage> thTemplateManages = thTemplateManageMapper.selectByExample(example);
            List<Map<String, Object>> result = Lists.newArrayList();
            if (!CollectionUtils.isEmpty(thTemplateManages)) {
                for (ThTemplateManage thTemplateManage : thTemplateManages) {
                    Map<String, Object> map = Maps.newHashMap();
                    map.put("label", thTemplateManage.getTemplate_name());
                    map.put("value", thTemplateManage.getTemplate_code());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThTemplateManageController#get_all_templates error", e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
