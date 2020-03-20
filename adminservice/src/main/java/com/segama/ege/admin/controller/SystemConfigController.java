package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.AdminSystemConfig;
import com.segama.ege.entity.AdminSystemConfigExample;
import com.segama.ege.repository.AdminSystemConfigMapper;
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
 * @Description 系统配置相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/admin_system_config")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SystemConfigController {
    @Resource
    private AdminSystemConfigMapper adminSystemConfigMapper;

    private static Logger LOG = LoggerFactory.getLogger(SystemConfigController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("key") String key
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            AdminSystemConfigExample adminSystemConfigExample = new AdminSystemConfigExample();
            adminSystemConfigExample.setOrderByClause("gmt_create desc");
            AdminSystemConfigExample.Criteria adminSystemConfigExampleCriteria = adminSystemConfigExample.createCriteria();
            if(StringUtils.isNotEmpty(key)) {
                adminSystemConfigExampleCriteria.andKeyLike("%" + key + "%");
            }
            int count = adminSystemConfigMapper.countByExample(adminSystemConfigExample);
            adminSystemConfigExample.setPageCount(pageSize);
            adminSystemConfigExample.setPageIndex(pageIndex);
            List<AdminSystemConfig> adminSystemConfigs = adminSystemConfigMapper.selectByExample(adminSystemConfigExample);
            baseVO.setData(adminSystemConfigs);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("SystemConfigController#list error",e);
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
            adminSystemConfigMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO add(
            @RequestParam("id") Long id,
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("account") String account,
            @RequestParam("description") String description) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(key) ||
                    StringUtils.isEmpty(value) ||
                    StringUtils.isEmpty(description)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            AdminSystemConfig adminSystemConfig = adminSystemConfigMapper.selectByPrimaryKey(id);
            if(adminSystemConfig!=null) {
                if (!StringUtils.isEmpty(key)) {
                    adminSystemConfig.setKey(key);
                }
                if (!StringUtils.isEmpty(value)) {
                    adminSystemConfig.setValue(value);
                }
                if (!StringUtils.isEmpty(description)) {
                    adminSystemConfig.setDescription(description);
                }
                adminSystemConfig.setModifier_account(account);
                adminSystemConfig.setVersion(0);
                adminSystemConfig.setGmt_create(new Date());
                adminSystemConfig.setGmt_modify(new Date());
                adminSystemConfigMapper.updateByPrimaryKey(adminSystemConfig);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("SystemConfigController#add error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("account") String account,
            @RequestParam("description") String description) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(key) ||
                    StringUtils.isEmpty(value) ||
                    StringUtils.isEmpty(description)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            AdminSystemConfig adminSystemConfig = new AdminSystemConfig();
            if(!StringUtils.isEmpty(key)){
                adminSystemConfig.setKey(key);
            }
            if(!StringUtils.isEmpty(value)){
                adminSystemConfig.setValue(value);
            }
            if(!StringUtils.isEmpty(description)){
                adminSystemConfig.setDescription(description);
            }
            adminSystemConfig.setCreator_account(account);
            adminSystemConfig.setModifier_account(account);
            adminSystemConfig.setVersion(0);
            adminSystemConfig.setGmt_create(new Date());
            adminSystemConfig.setGmt_modify(new Date());
            adminSystemConfigMapper.insert(adminSystemConfig);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("SystemConfigController#add error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
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
                AdminSystemConfig adminSystemConfig = adminSystemConfigMapper.selectByPrimaryKey(id);
                baseVO.setData(adminSystemConfig);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("SystemConfigController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询系统配置信息信息异常！");
        }
        return baseVO;
    }
}
