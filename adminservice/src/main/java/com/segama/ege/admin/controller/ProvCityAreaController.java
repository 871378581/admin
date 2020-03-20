package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.AdminRole;
import com.segama.ege.entity.ProvCityArea;
import com.segama.ege.entity.ProvCityAreaExample;
import com.segama.ege.repository.ProvCityAreaMapper;
import com.segama.ege.repository.AdminUserMapper;
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
import java.util.stream.Collectors;

/**
 * @author hxj
 * @version 1.0
 * @Description 省市区配置相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/prov_city_area")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProvCityAreaController {
    @Resource
    private ProvCityAreaMapper provCityAreaMapper;

    private static Logger LOG = LoggerFactory.getLogger(ProvCityAreaController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("codeName") String codeName,
            @RequestParam("code") String code
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ProvCityAreaExample provCityAreaExample = new ProvCityAreaExample();
            ProvCityAreaExample.Criteria provCityAreaExampleCriteria = provCityAreaExample.createCriteria();
            if(StringUtils.isNotEmpty(codeName)) {
                provCityAreaExampleCriteria.andCode_nameLike("%" + codeName + "%");
            }
            if(StringUtils.isNotEmpty(code)) {
                provCityAreaExampleCriteria.andCodeLike("%" + code + "%");
            }
            int count = provCityAreaMapper.countByExample(provCityAreaExample);
            provCityAreaExample.setPageIndex(pageIndex);
            provCityAreaExample.setPageCount(pageSize);
            provCityAreaExample.setOrderByClause("gmt_create desc");
            List<ProvCityArea> provCityAreas = provCityAreaMapper.selectByExample(provCityAreaExample);
            List<ProvCityArea> collect = provCityAreas.stream().map((e) -> {
                if(e.getParent_code()!=null) {
                    ProvCityAreaExample example = new ProvCityAreaExample();
                    ProvCityAreaExample.Criteria criteria = example.createCriteria();
                    criteria.andCodeEqualTo(e.getParent_code());
                    List<ProvCityArea> provCityAreas1 = provCityAreaMapper.selectByExample(example);
                    if (!CollectionUtils.isEmpty(provCityAreas1)) {
                        ProvCityArea provCityArea = provCityAreas1.get(0);
                        e.setParent_code(provCityArea.getCode_name());
                    }
                }
                return e;
            }).collect(Collectors.toList());
            baseVO.setData(collect);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("AdminRoleController#list error",e);
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
            provCityAreaMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("account") String account,
                    @RequestParam("codeName") String codeName,
                    @RequestParam("code") String code,
                    @RequestParam("parentCode") String parentCode,
                    @RequestParam("type") String type,
                    @RequestParam("is_disable") boolean is_disable) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null || StringUtils.isEmpty(codeName) || StringUtils.isEmpty(code)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ProvCityArea provCityArea = provCityAreaMapper.selectByPrimaryKey(id);
            if(!StringUtils.isEmpty(codeName)){
                provCityArea.setCode_name(codeName);
            }
            if(type !=null){
                provCityArea.setType(type);
            }
            if(!StringUtils.isEmpty(code)){
                provCityArea.setCode(code);
            }
            if(!StringUtils.isEmpty(parentCode)){
                provCityArea.setParent_code(parentCode);
            }

            provCityArea.setIs_disable(is_disable);

            provCityArea.setGmt_modify(new Date());
            provCityArea.setModifier_account(account);
            provCityAreaMapper.updateByPrimaryKey(provCityArea);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ProvCityAreaController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
            @RequestParam("account") String account,
            @RequestParam("codeName") String codeName,
            @RequestParam("code") String code,
            @RequestParam("parentCode") String parentCode,
            @RequestParam("is_disable") boolean is_disable,
            @RequestParam("type") String type) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(account) ||
                    StringUtils.isEmpty(code) ||
                    StringUtils.isEmpty(codeName)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ProvCityArea provCityArea = new ProvCityArea();
            if(!StringUtils.isEmpty(codeName)){
                provCityArea.setCode_name(codeName);
            }
            if(type !=null){
                provCityArea.setType(type);
            }
            if(!StringUtils.isEmpty(code)){
                provCityArea.setCode(code);
            }
            if(!StringUtils.isEmpty(parentCode)){
                provCityArea.setParent_code(parentCode);
            }
            provCityArea.setIs_disable(is_disable);

            provCityArea.setGmt_modify(new Date());
            provCityArea.setModifier_account(account);
            provCityArea.setCreator_account(account);
            provCityArea.setModifier_account(account);
            provCityArea.setGmt_create(new Date());
            provCityArea.setGmt_modify(new Date());
            provCityAreaMapper.insert(provCityArea);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ProvCityAreaController#add error",e);
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
                ProvCityArea provCityArea = provCityAreaMapper.selectByPrimaryKey(id);
                baseVO.setData(provCityArea);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ProvCityAreaController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    /**
     * 查询所有省
     * @return
     */
    @RequestMapping("/get_all_area")
    public BaseVO getAllMenu(@RequestParam("type") String type) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(type)) {
                baseVO.setErrorMsg("type为不能为空！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ProvCityAreaExample example = new ProvCityAreaExample();
            ProvCityAreaExample.Criteria criteria = example.createCriteria();
            criteria.andTypeEqualTo(type);
            List<ProvCityArea> provCityAreas = provCityAreaMapper.selectByExample(example);
            List<Map<String,Object>> result = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(provCityAreas)){
                for (ProvCityArea provCityArea : provCityAreas) {
                    Map<String,Object> map = Maps.newHashMap();
                    map.put("label",provCityArea.getCode_name());
                    map.put("value",provCityArea.getCode());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ProvCityAreaController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
