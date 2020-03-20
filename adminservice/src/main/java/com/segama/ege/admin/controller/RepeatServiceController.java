package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.RepeatServiceVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.AdminSystemConfigMapper;
import com.segama.ege.repository.RepeatServiceWxUsersMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description 重复保养相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/repeat_service")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RepeatServiceController {
    @Resource
    private RepeatServiceWxUsersMapper repeatServiceWxUsersMapper;

    private static Logger LOG = LoggerFactory.getLogger(RepeatServiceController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "user_name",required = false) String user_name,
            @RequestParam(value = "car_plate",required = false) String car_plate
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            RepeatServiceWxUsersExample carExample = new RepeatServiceWxUsersExample();
            RepeatServiceWxUsersExample.Criteria criteria = carExample.createCriteria();
            if (StringUtils.isNotEmpty(user_name)) {
                criteria.andUser_nameLike("%"+user_name+"%");
            }
            if (StringUtils.isNotEmpty(car_plate)) {
                criteria.andCar_plateLike("%"+car_plate+"%");
            }
            int count = repeatServiceWxUsersMapper.countByExample(carExample);
            carExample.setPageCount(pageSize);
            carExample.setPageIndex(pageIndex);
            carExample.setOrderByClause("id desc");
            List<RepeatServiceWxUsers> repeatServiceWxUsers = repeatServiceWxUsersMapper.selectByExample(carExample);
            baseVO.setData(repeatServiceWxUsers);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("RepeatServiceController#list error", e);
        }
        return baseVO;
    }

    @Resource
    AdminSystemConfigMapper adminSystemConfigMapper;

    @RequestMapping("/get_config")
    public BaseVO delete() {
        BaseVO baseVO = new BaseVO();
        RepeatServiceVO vo = new RepeatServiceVO();
        vo.setRepeat_service_days(getConfigVal("repeat_service_days"));
        vo.setRepeat_service_counts(getConfigVal("repeat_service_counts"));
        baseVO.setSuccess(true);
        baseVO.setData(vo);

        return baseVO;
    }

    String getConfigVal(String key){
        try {
            AdminSystemConfigExample example = new AdminSystemConfigExample();
            AdminSystemConfigExample.Criteria criteria = example.createCriteria();

            criteria.andKeyEqualTo(key);
            List<AdminSystemConfig> adminSystemConfigs = adminSystemConfigMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(adminSystemConfigs)){
                 return adminSystemConfigs.get(0).getValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
