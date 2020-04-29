package com.segama.ege.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.segama.ege.admin.config.Constants;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.SyncVO;
import com.segama.ege.admin.vo.SysncDataVO;
import com.segama.ege.entity.AdminSystemConfig;
import com.segama.ege.entity.ThLtOrderSyncData;
import com.segama.ege.entity.ThUrlManage;
import com.segama.ege.entity.ThUrlManageExample;
import com.segama.ege.repository.ThLtOrderSyncDataMapper;
import com.segama.ege.repository.ThUrlManageMapper;
import com.segama.ege.util.DESUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2020-03-28 02:05
 */
@RestController
@RequestMapping("/ege/api/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LianTongController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(LianTongController.class);

    /**
     * 重定向到联通链接
     */
    @RequestMapping({"/lt/prod/{channelCode}/{productName}/{productCode}","/lt/prod","/lt/prod/{channelCode}"})
    public void getPageUrl(
            @PathVariable(value = "channelCode",required = false) String channelCode,
            @PathVariable(value = "productName",required = false) String productName,
                           @PathVariable(value = "productCode",required = false) String productCode){
        try {
            Map<String, List<AdminSystemConfig>> config = this.getConfig(
                    Lists.newArrayList(
                            Constants.LIAN_TONG_ACTIVE_URL_KEY,
                            Constants.LIAN_TONG_PASSWORD_KEY,
                            Constants.DEFAULT_GIFT_CODE,
                            Constants.DEFAULT_GIFT_NAME
                    ));

            if(config != null){
                List<AdminSystemConfig> urlConf = config.get(Constants.LIAN_TONG_ACTIVE_URL_KEY);
                List<AdminSystemConfig> passConf = config.get(Constants.LIAN_TONG_PASSWORD_KEY);
                List<AdminSystemConfig> productCodeConf = config.get(Constants.DEFAULT_GIFT_CODE);
                List<AdminSystemConfig> productNameConf = config.get(Constants.DEFAULT_GIFT_NAME);
                if(StringUtils.isEmpty(productCode)){
                    productCode = productCodeConf.get(0).getValue();
                }
                if(StringUtils.isEmpty(productName)){
                    productName = productNameConf.get(0).getValue();
                }
                String url = urlConf.get(0).getValue() +
                        buildParam(passConf.get(0).getValue(),channelCode,productCode,productName);
                response.sendRedirect(url);
            }
        } catch (Exception e) {
            log.error("getPageUrl error",e);
        }
    }

    @Autowired
    private ThUrlManageMapper thUrlManageMapper;
    /**
     * 重定向到联通链接
     */
    @RequestMapping("/lt/{urlCode}")
    public String shortUrl(
            @PathVariable(value = "urlCode",required = false) String urlCode){
        try {
            if(!StringUtils.isEmpty(urlCode)){
                //查询生效的链接
                ThUrlManageExample example = new ThUrlManageExample();
                example.createCriteria().andUrl_codeEqualTo(urlCode).andUrl_statusEqualTo(1);
                List<ThUrlManage> thUrlManages = thUrlManageMapper.selectByExample(example);
                if(!CollectionUtils.isEmpty(thUrlManages)){
                    ThUrlManage thUrlManage = thUrlManages.get(0);
                    String url = thUrlManage.getUrl();
                    response.sendRedirect(url);
                }
            }

        } catch (Exception e) {
            log.error("shortUrl error urlCode={}",new Object[]{urlCode},e);
        }
        return "链接失效";
    }


    /**
     * 联通数据mock
     */
    private static List<SysncDataVO> dataList = new ArrayList();

    /**
     * 测试数据保存
     */
    @RequestMapping("/lt/page")
    public BaseVO page(){
        BaseVO baseVO = new BaseVO();
        try {
            baseVO.setSuccess(true);
            baseVO.setData(dataList);
        } catch (Exception e) {
            log.error("page error",e);
            baseVO.setSuccess(false);
            baseVO.setError(e.getMessage());
        }
       return baseVO;
    }
    /**
     * 测试数据保存
     */
    @RequestMapping("/lt/clear")
    public SyncVO clear(){
        SyncVO baseVO = new SyncVO();
        try {
            baseVO.setSuccess(true);
            baseVO.setMsg("success");
            dataList.clear();
        } catch (Exception e) {
            log.error("clear error",e);
            baseVO.setSuccess(false);
            baseVO.setMsg(e.getMessage());
        }
        return baseVO;
    }

    private static final String password = "th@123456.";

    @Resource
    private ThLtOrderSyncDataMapper thLtOrderSyncDataMapper;

    /**
     * 同步数据
     */
    @RequestMapping(value = "/lt/sync",method = RequestMethod.POST)
    public SyncVO sync() throws Exception{
        String reqBbody = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);

        SyncVO baseVO = new SyncVO();
        baseVO.setSuccess(false);
        try {
            SysncDataVO sysncDataVO = JSON.parseObject(reqBbody, SysncDataVO.class);
            if(StringUtils.isEmpty(reqBbody) || StringUtils.isEmpty(sysncDataVO.getParam())){
                baseVO.setMsg("param error");
                return baseVO;
            }
            String decrypt = DESUtils.decrypt(sysncDataVO.getParam(), password);
            SysncDataVO sysncDataVO1 = JSON.parseObject(decrypt, SysncDataVO.class);
            /*if(dataList.size()==10000){
                baseVO.setMsg("测试数据存储已满！");
                return baseVO;
            }*/
            //dataList.add(sysncDataVO1);
            ThLtOrderSyncData data = new ThLtOrderSyncData();
            data.setCode(sysncDataVO1.getOrderId());
            data.setExtend(sysncDataVO1.getExtend());
            data.setAccess_name(sysncDataVO1.getAccessName());
            data.setAddress(sysncDataVO1.getAddress());
            data.setAddressee(sysncDataVO1.getAddressee());
            data.setAddressee_phone(sysncDataVO1.getAddresseePhone());
            data.setChannel_code(sysncDataVO1.getChannelCode());
            data.setCity_name(sysncDataVO1.getCityName());
            data.setPacakge_code(sysncDataVO1.getPacakgeCode());
            data.setPacakge_name(sysncDataVO1.getPacakgeName());
            data.setFreeze(String.valueOf(sysncDataVO1.getFreeze()));
            data.setFreeze_amount(sysncDataVO1.getFreezeAmount());
            data.setOrder_create_time(sysncDataVO1.getOrderCreateTime());
            data.setId_number(sysncDataVO1.getIdNumber());
            data.setSelected_phone_num(sysncDataVO1.getSelectedPhoneNum());
            data.setDistrict_name(sysncDataVO1.getDistrictName());
            data.setContract_period(sysncDataVO1.getContractPeriod());
            data.setDiscount_amount(sysncDataVO1.getDiscountAmount());

            data.setGmt_modify(new Date());
            data.setGmt_create(new Date());
            data.setModifier_account("system");
            data.setCreator_account("system");
            data.setGmt_create(new Date());
            int insert = thLtOrderSyncDataMapper.insert(data);
            baseVO.setSuccess(true);
            baseVO.setMsg("success");
        } catch (Exception e) {
            log.error("sync error",e);
            baseVO.setSuccess(false);
            baseVO.setMsg("sys err"+e.getMessage());
        }
        return baseVO;
    }

    /**
     * 获取参数
     * @param password
     * @return
     */
    static String  buildParam(String password,String channelCode,String productName,String productCode){
        JSONObject data_json = new JSONObject();
        JSONArray exts = new JSONArray();

        //活动编码
        JSONObject obj3 = new JSONObject();
        obj3.put("ext_key", "channelCode");
        obj3.put("ext_value", channelCode);
        exts.add(obj3);

        //号码
        JSONObject obj5 = new JSONObject();
        obj5.put("ext_key", "extend");
        StringBuffer sb = new StringBuffer();
        sb.append("init=true;");
        if(!StringUtils.isEmpty(productCode)){
            sb.append("productCode="+productCode+";");
        }
        if(!StringUtils.isEmpty(productName)){
            sb.append("productName="+productName+";");
        }
        obj5.put("ext_value", sb.toString());
        exts.add(obj5);

        data_json.put("src", 1020);
        data_json.put("ext", exts);
        String formData = DESUtils.encrypt(data_json.toString(), password);
        return formData;
    }

    private static String url="http://124.160.11.209:8025/preferenPurchase/gotoIndex.do?formData=";
    public static void main(String[] args) {
        String s = url + buildParam("prefPur@zj186","23132","12312","2312");
        System.out.println(s);
    }



}
