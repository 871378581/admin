package com.segama.ege.admin.controller;

import com.alibaba.fastjson.JSON;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.AdminSystemConfigMapper;
import com.segama.ege.repository.ThProductManageMapper;
import com.segama.ege.repository.ThSaleExtensionManageMapper;
import com.segama.ege.util.CommonUtil;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hxj 购买者信息填写
 * @version 1.0
 * @Description
 * @date 2020-03-28 02:05
 */
@RestController
@RequestMapping("/ege/api/other/customer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InfoAddController {

    @Resource
    private ThProductManageMapper thProductManageMapper;

    @Resource
    private ThSaleExtensionManageMapper thSaleExtensionManageMapper;

    @RequestMapping("/put_info")
    public BaseVO put_info(ThSaleExtensionManage thSaleExtensionManage) {
        BaseVO baseVO = new BaseVO();
        try {
            String share_url_code = thSaleExtensionManage.getShare_url_code();
            thSaleExtensionManage.setCode(UUIDUtils.UUID());
            if(!StringUtils.isEmpty(share_url_code)){
                String[] shareCodeArr = share_url_code.split("_");
                String createAcc = shareCodeArr[0];
                String codeprod = shareCodeArr[1];
                String ownerAcc = shareCodeArr[3];
                thSaleExtensionManage.setCreate_account(createAcc);
                thSaleExtensionManage.setProduct_code(codeprod);
                thSaleExtensionManage.setOwner_account(ownerAcc);
            }
            thSaleExtensionManage.setGmt_create(new Date());
            thSaleExtensionManageMapper.insert(thSaleExtensionManage);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            CommonUtil.info("InfoAddController#put_info", "exception", null, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("数据保存出错，请重试！");
        }
        return baseVO;
    }

    @RequestMapping("/get_real_url")
    public BaseVO url_code(@RequestParam("url_code") String url_code) {
        BaseVO baseVO = new BaseVO();
        try {
            ThProductManageExample example = new ThProductManageExample();
            String[] codeArr = url_code.split("_");
            String proCode = codeArr[1];
            example.createCriteria().andProduct_codeEqualTo(proCode);
            List<ThProductManage> thProductManages = thProductManageMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(thProductManages)){
                ThProductManage thProductManage = thProductManages.get(0);
                if(thProductManage.getProduct_status()==0){
                    baseVO.setSuccess(false);
                    baseVO.setErrorMsg("该产品已下线！");
                    return baseVO;
                }
                baseVO.setSuccess(true);
                baseVO.setData(thProductManage.getSource_url());
            }
        } catch (Exception e) {
            CommonUtil.info("InfoAddController#put_info", "exception", null, e);
            baseVO.setSuccess(false);
            baseVO.setError(JSON.toJSONString(e));
            baseVO.setErrorMsg(e.getMessage());
        }
        return baseVO;
    }
}
