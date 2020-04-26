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
import com.segama.ege.util.DESUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/lt/prod")
    public void getPageUrl(){
        try {
            Map<String, List<AdminSystemConfig>> config = this.getConfig(
                    Lists.newArrayList(
                            Constants.LIAN_TONG_ACTIVE_URL_KEY,
                            Constants.LIAN_TONG_PASSWORD_KEY
                    ));

            if(config != null){
                List<AdminSystemConfig> urlConf = config.get(Constants.LIAN_TONG_ACTIVE_URL_KEY);
                List<AdminSystemConfig> passConf = config.get(Constants.LIAN_TONG_PASSWORD_KEY);
                String url = urlConf.get(0).getValue() + buildParam(passConf.get(0).getValue());
                response.sendRedirect(url);
            }
        } catch (Exception e) {
            log.error("getPageUrl error",e);
        }
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
    /**
     * 同步数据
     */
    @RequestMapping(value = "/lt/sync",method = RequestMethod.POST)
    public SyncVO sync() throws Exception{
        String reqBbody = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);

        SyncVO baseVO = new SyncVO();
        baseVO.setSuccess(false);
        try {
            SysncDataVO vo = JSON.parseObject(reqBbody, SysncDataVO.class);
            if(StringUtils.isEmpty(reqBbody) || StringUtils.isEmpty(vo.getParam())){
                baseVO.setMsg("param error");
                return baseVO;
            }
            String decrypt = DESUtils.decrypt(vo.getParam(), password);
            SysncDataVO sysncDataVO1 = JSON.parseObject(decrypt, SysncDataVO.class);
            if(dataList.size()==10000){
                baseVO.setMsg("测试数据存储已满！");
                return baseVO;
            }
            dataList.add(sysncDataVO1);
            baseVO.setSuccess(true);
            baseVO.setMsg("success");
        } catch (Exception e) {
            log.error("sync error",e);
            baseVO.setSuccess(false);
            baseVO.setMsg("sys err");
        }
        return baseVO;
    }

    /**
     * 获取参数
     * @param password
     * @return
     */
    String buildParam(String password){
        JSONObject data_json = new JSONObject();
        JSONArray exts = new JSONArray();

        //活动编码
        JSONObject obj3 = new JSONObject();
        obj3.put("ext_key", "prod_code");
        obj3.put("ext_value", "20787878787");
        exts.add(obj3);

        //号码
        JSONObject obj5 = new JSONObject();
        obj5.put("ext_key", "prod_name");
        obj5.put("ext_value", "花呗");
        exts.add(obj5);

        //用户id
        JSONObject obj2 = new JSONObject();
        obj2.put("ext_key", "prod_price");
        obj2.put("ext_value", "45");
        exts.add(obj2);
        data_json.put("src", 1020);
        data_json.put("ext", exts);
        String formData = DESUtils.encrypt(data_json.toString(), password);
        return formData;
    }


}
