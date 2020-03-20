package com.segama.ege.admin.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.segama.ege.admin.response.LongitudeLatitudeVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2019-11-12 19:40
 * 天地图：http://lbs.tianditu.gov.cn/staticapi/static.html
 * 账号：1321823771@qq.com
 * pwd:Aa123456789
 * key=fa09038bbbb65076b627c75ccb230c0e
 * 用后面这个
 *
 */
public class LongitudeLatitudeUtil {

    private static Logger log = LoggerFactory.getLogger(LongitudeLatitudeUtil.class);

    /**
     * 获取经纬度用到的key 可以去天地图中添加
     */
    private static String LONGITUDE_LATITUDE_KEY = "266BZ-GPPRG-5NQQL-IXP7X-AVET2-4JBER";

    /**
     * 获取经纬度
     * @param address
     * @return
     */
    public static LongitudeLatitudeVO getLongitudeLatitude(String address) {
        LongitudeLatitudeVO longitudeLatitudeVO = new LongitudeLatitudeVO();
        StringBuffer errorMsg = new StringBuffer();
        HttpURLConnection conn=null;
        InputStream in = null;
        try { if(StringUtils.isNotEmpty(address)) {
                URL u = new URL("https://apis.map.qq.com/ws/geocoder/v1/?address="+address+"&key=" + LONGITUDE_LATITUDE_KEY);
                //获取连接对象
                conn = (HttpURLConnection) u.openConnection();
                //连接
                conn.connect();
                //获取输入流
                in = conn.getInputStream();
                //读取输入流
                int r;
                byte[] bs = new byte[1024];
                StringBuffer sb = new StringBuffer();
                while ((r = in.read(bs)) != -1) {
                    sb.append(new String(bs, 0, r));
                }
                in.close();


                /**
                 * status 0：正常返回，101：结果为空，404：出错。
                 * 返回结构{"msg":"ok","location":{"level":"购物服务","lon":"120.224528","lat":"29.27159"},"searchVersion":"4.8.0","status":"0"}
                 */
                errorMsg.append(sb);
                if (StringUtils.isNotEmpty(sb)) {
                    JSONObject jsonObject = JSON.parseObject(sb.toString());
                    Integer status = (Integer)jsonObject.get("status");
                    if (0==status) {
                        Map<String, Object> location = (Map<String, Object>) jsonObject.get("result");
                        Object location1 = location.get("location");
                        if(location1!=null) {
                            Map<String, Object> location1Map = (Map<String, Object>) location1;
                            longitudeLatitudeVO.setLongitude(location1Map.get("lng").toString());
                            longitudeLatitudeVO.setLatitude(location1Map.get("lat").toString());
                        }
                    }
                }
            }else{
                errorMsg.append("入参为空");
            }
        } catch (Exception e) {
            log.error("LongitudeLatitudeUtil#getLongitudeLatitude address={},e={}",
                    new Object[]{address, JSON.toJSONString(e)},e);
            errorMsg.append(JSON.toJSONString(e));
        }finally {
            try {
                if(in!=null){
                    in.close();
                }if(in!=null){
                    conn.disconnect();
                }
            } catch (Exception e) {
                log.error("LongitudeLatitudeUtil#getLongitudeLatitude finally address={},e={}",
                        new Object[]{address, JSON.toJSONString(e)},e);
                errorMsg.append("LongitudeLatitudeUtil#getLongitudeLatitude finally "+JSON.toJSONString(e));
            }
        }
        longitudeLatitudeVO.setErrorMsg(errorMsg.toString());
        return longitudeLatitudeVO;
    }

    public static void main(String[] args) {
        getLongitudeLatitude("中国重庆市重庆市");
    }
}
