package com.segama.ege.admin.controller;

import com.alibaba.fastjson.JSON;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import com.segama.ege.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private ThUrlManageMapper thUrlManageMapper;

    @Resource
    private ThSaleExtensionManageMapper thSaleExtensionManageMapper;

    @RequestMapping("/put_info")
    public BaseVO put_info(ThSaleExtensionManage thSaleExtensionManage,
                           @RequestParam(value = "channel",required = false) String channel,
                           @RequestParam(value = "prod",required = false) String prod) {
        BaseVO baseVO = new BaseVO();
        try {
            if(!StringUtils.isEmpty(channel) && !StringUtils.isEmpty(prod) ){
                thSaleExtensionManage.setGmt_create(new Date());
                thSaleExtensionManage.setQq(channel+"@l@"+prod);
                thSaleExtensionManageMapper.insert(thSaleExtensionManage);
                baseVO.setSuccess(true);
                return baseVO;
            }

            String share_url_code = thSaleExtensionManage.getShare_url_code();
            thSaleExtensionManage.setCode(UUIDUtils.UUID());
            if(!StringUtils.isEmpty(share_url_code)){
                ThUrlManageExample example = new ThUrlManageExample();
                example.createCriteria().andShare_url_codeLike(share_url_code+"%");
                List<ThUrlManage> thUrlManages = thUrlManageMapper.selectByExample(example);
                if(!CollectionUtils.isEmpty(thUrlManages)){
                    ThUrlManage thUrlManage = thUrlManages.get(0);
                    String url = thUrlManage.getUrl();
                    String share_url_code1 = thUrlManage.getShare_url_code();
                    if(share_url_code.split("_").length==3
                            && share_url_code1.length()!=share_url_code.length()){

                        url=url.split("&")[0]+"&code="+share_url_code;
                    }
                    thSaleExtensionManage.setRequest_url(url);
                }
                String[] shareCodeArr = share_url_code.split("_");
                String createAcc = shareCodeArr[0];//创建人
                String codeprod = shareCodeArr[1];//产品编码
                thSaleExtensionManage.setCreate_account(createAcc);
                thSaleExtensionManage.setProduct_code(codeprod);

                //A 还未分配给b 编码长度等于拆分后3
                if(shareCodeArr.length==3){
                    thSaleExtensionManage.setOwner_account(createAcc);
                }else {
                    String ownerAcc = shareCodeArr[3];//小b
                    thSaleExtensionManage.setOwner_account(ownerAcc);
                }
            }else{
                throw new RuntimeException("share_url_code is null");
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

    @Resource
    ThTemplateManageMapper thTemplateManageMapper;
    private static Logger LOG = LoggerFactory.getLogger(InfoAddController.class);

    @RequestMapping("/query")
    public BaseVO query(@RequestParam("t_code") String t_code) {
        BaseVO baseVO = new BaseVO();
        try {
            if (org.apache.commons.lang3.StringUtils.isEmpty(t_code)) {
                baseVO.setErrorMsg("参数错误！");
                baseVO.setSuccess(false);
            } else {

                ThTemplateManageExample example = new ThTemplateManageExample();
                example.createCriteria().andTemplate_codeEqualTo(t_code);
                List<ThTemplateManage> thTemplateManages = thTemplateManageMapper.selectByExample(example);
                if(!CollectionUtils.isEmpty(thTemplateManages)){
                    baseVO.setData(thTemplateManages.get(0));
                }else{
                    baseVO.setData(new ThTemplateManage());
                }
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThTemplateManageController#get Exception input param is t_code:" + t_code, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
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
