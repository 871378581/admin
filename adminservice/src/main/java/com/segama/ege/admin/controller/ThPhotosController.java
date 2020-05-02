package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ThPhotosManage;
import com.segama.ege.entity.ThPhotosManageExample;
import com.segama.ege.repository.ThPhotosManageMapper;
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

/**
 * @author hxj
 * @version 1.0
 * @Description 图片管理相关参数
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/photo_manage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ThPhotosController {

    @Resource
    private ThPhotosManageMapper thPhotosManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(ThPhotosController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "photo_name", required = false) String photo_name
            , @RequestParam(value = "limit", required = false) Integer pageSize,
            @RequestParam(value = "page", required = false) Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThPhotosManageExample adminRoleExample = new ThPhotosManageExample();
            adminRoleExample.setOrderByClause("gmt_create desc");
            ThPhotosManageExample.Criteria adminRoleExampleCriteria = adminRoleExample.createCriteria();
            if (StringUtils.isNotEmpty(photo_name)) {
                adminRoleExampleCriteria.andPhoto_nameLike("%" + photo_name + "%");
            }
            int count = thPhotosManageMapper.countByExample(adminRoleExample);
            List<ThPhotosManage> thTemplateManages = Lists.newArrayList();
            if (count != 0) {
                adminRoleExample.setPageCount(pageSize);
                adminRoleExample.setPageIndex(pageIndex);
                thTemplateManages = thPhotosManageMapper.selectByExample(adminRoleExample);
            }
            baseVO.setData(thTemplateManages);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("ThPhotosManageController#list error", e);
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
            ThPhotosManageExample thTemplateManageExample = new ThPhotosManageExample();
            ThPhotosManageExample.Criteria criteria = thTemplateManageExample.createCriteria();
            criteria.andPhoto_codeEqualTo(template_code);
            thPhotosManageMapper.deleteByExample(thTemplateManageExample);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }


    @RequestMapping("/add")
    public BaseVO add(ThPhotosManage thTemplateManage,
                      @RequestParam("account") String account) {

        BaseVO baseVO = new BaseVO();
        try {
            if (StringUtils.isEmpty(thTemplateManage.getUrl()) ) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            String[] split = thTemplateManage.getUrl().split("/");
            int length = split.length;
            String code = split[length - 1].split(".")[0];
            thTemplateManage.setPhoto_code(code);
            thTemplateManage.setCreator_account(account);
            thTemplateManage.setModifier_account(account);
            thTemplateManage.setGmt_create(new Date());
            thTemplateManage.setGmt_modify(new Date());
            thPhotosManageMapper.insert(thTemplateManage);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThPhotosManageController#add error", e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("code") String code) {

        BaseVO baseVO = new BaseVO();
        try {
            if (StringUtils.isEmpty(code) ) {
                baseVO.setErrorMsg("图片编码不能为空！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThPhotosManageExample example = new ThPhotosManageExample();
            example.createCriteria().andPhoto_codeEqualTo(code);
            List<ThPhotosManage> thPhotosManages = thPhotosManageMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(thPhotosManages)){
                ThPhotosManage thPhotosManage = thPhotosManages.get(0);
                String url = thPhotosManage.getUrl();
                baseVO.setData(url);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThPhotosManageController#add error", e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询异常！");
        }
        return baseVO;
    }

}
