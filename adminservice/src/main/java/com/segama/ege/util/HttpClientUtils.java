package com.segama.ege.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2020-04-27 00:54
 */
public class HttpClientUtils {

    // 发送POST请求（JSON形式）
    public static String postJSON(String path, String json) throws Exception {
        StringEntity entity = new StringEntity(json, Charset.forName("UTF-8"));
        return postRequest(path, "application/json", entity);
    }

    // 发送POST请求
    public static String postRequest(String path, String mediaType, HttpEntity entity) throws Exception {
        HttpPost post = new HttpPost(path);
        post.addHeader("Content-Type", mediaType);
        post.addHeader("Accept", "application/json");
        post.setEntity(entity);
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = client.execute(post);
            int code = response.getStatusLine().getStatusCode();
            if (code == 200)
                return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            post.releaseConnection();
        }
        return "";
    }

    private static final String requestUrl = "http://localhost/ege/api/lt/sync";
    public static void main(String[] args) throws Exception {
        String jsonParam="{\n" +
                "\t\"extend\": \"prod_name:张三;prod_code=12312;\",\n" +
                "\t\"channelCode\": \"123213123\",\n" +
                "\t\"accessName\": \"张三\",\n" +
                "\t\"address\": \"下城区****\",\n" +
                "\t\"addressee\": \"马六\",\n" +
                "\t\"addresseePhone\": \"13888888888\",\n" +
                "\t\"cityName\": \"杭州\",\n" +
                "\t\"contractPeriod\": \"12\",\n" +
                "\t\"discountAmount\": \"500\",\n" +
                "\t\"districtName\": \"下城区\",\n" +
                "\t\"freeze\": true,\n" +
                "\t\"freezeAmount\": \"1000\",\n" +
                "\t\"idNumber\": \"342455197910101111\",\n" +
                "\t\"orderCreateTime\": \"2020-04-27 00:00:00\",\n" +
                "\t\"pacakgeCode\": \"99\",\n" +
                "\t\"pacakgeName\": \"99元冰激凌套餐\",\n" +
                "\t\"selectedPhoneNum\": \"13899234234\"\n" +
                "}";
        String code = DESUtils.encrypt(jsonParam, "th@123456.");
        String s = HttpClientUtils.postJSON(requestUrl, "{\"param\":\""+code+"\"}");
        System.out.println(s);
    }
}
