package com.segama.ege.admin.controller;

import com.segama.ege.entity.AdminSystemConfig;
import com.segama.ege.entity.AdminSystemConfigExample;
import com.segama.ege.repository.AdminSystemConfigMapper;
import com.segama.ege.th.CommonService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2020-03-28 02:05
 */
@RestController
@RequestMapping("/ege/api/admin/test")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController {

    @Resource
    CommonService commonService;

    //展示所有用户
    @RequestMapping("/test")
    public Boolean showAllUser(){
        commonService.selectByCode(new Object[]{});
        return false;
    }
}
