package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.AdminUser;
import com.segama.ege.entity.AdminUserExample;
import com.segama.ege.entity.ThSaleExtensionManage;
import com.segama.ege.entity.ThSaleExtensionManageExample;
import com.segama.ege.repository.AdminUserMapper;
import com.segama.ege.repository.ThSaleExtensionManageMapper;
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
 * @Description 销售数据管理
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/sale_extension")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SaleExtensionManageController extends BaseController {
    @Resource
    private ThSaleExtensionManageMapper thSaleExtensionManageMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

    private static Logger LOG = LoggerFactory.getLogger(SaleExtensionManageController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "menuName",required = false) String menuName
            ,@RequestParam(value = "account") String account
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThSaleExtensionManageExample example = new ThSaleExtensionManageExample();
            ThSaleExtensionManageExample.Criteria criteria = example.createCriteria();
            if(StringUtils.isNotEmpty(menuName)) {
                //ThSaleExtensionManageExampleCriteria.andMenu_nameLike("%" + menuName + "%");
            }
            if(!showAllUser(account)){
                AdminUserExample example1 = new AdminUserExample();
                example1.createCriteria().andAccountEqualTo(account);
                List<AdminUser> adminUsers = adminUserMapper.selectByExample(example1);
                if(!CollectionUtils.isEmpty(adminUsers)){
                    AdminUser adminUser = adminUsers.get(0);
                    if(adminUser.getChannel_type().equals(1)){
                        criteria.andCreate_accountEqualTo(account);
                    }else if(adminUser.getChannel_type().equals(2)){
                        criteria.andOwner_accountEqualTo(account);
                    }
                }

            }
            int count = thSaleExtensionManageMapper.countByExample(example);
            example.setPageCount(pageSize);
            example.setPageIndex(pageIndex);
            example.setOrderByClause("gmt_create desc");
            List<ThSaleExtensionManage> adminMenus = thSaleExtensionManageMapper.selectByExample(example);
            baseVO.setData(adminMenus);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ThSaleExtensionManageController#list error",e);
        }
        return baseVO;
    }


}
