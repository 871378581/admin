package com.segama.ege.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.segama.ege.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 短信发送服务
 */
@Component
public class SmsService {

    //初始化ascClient需要的几个参数
    final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
    final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
    final String accessKeyId = "LTAI4FdF8XqaTS4godSAvkzf";
    final String accessKeySecret = "Y57BK07D6MTjvQBVGQ5RijT9w4rSVc";//你的accessKeySecret，参考本文档步骤2
    //初始化ascClient,暂时不支持多region（请勿修改）
    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
            accessKeySecret);

    static {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
    }

    /**
     * 发送验证短信
     *
     * @param verifyCode      验证码
     * @param receiverPhoneNo 接受手机
     * @return
     */
    public boolean verify(String verifyCode, String receiverPhoneNo) {
        return sendVerifyMsg(verifyCode, receiverPhoneNo);
    }


    public boolean sendVerifyMsg(String code, String phoneNo) {
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //使用post提交
            request.setMethod(MethodType.POST);
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
            request.setPhoneNumbers(phoneNo);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName("EGE数联生态");
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode("SMS_176030192");
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            request.setTemplateParam("{\"code\":\"" + code + "\"}");
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            CommonUtil.info("sendVerifyMsg", "result", new Object[]{"code=" + code, "phone=" + phoneNo}, sendSmsResponse);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                //请求成功
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            CommonUtil.info("sendVerifyMsg", "exception", new Object[]{"code=" + code, "phone=" + phoneNo}, e);
            return false;
        }
    }

    public boolean sendSMSNotifyRetry(String templateNo, String phone, String param) {
        for (int i = 0; i < 3; i++) {
            if(sendSMSNotify(templateNo, phone, param)){
                return true;
            }
        }
        return false;
    }
    public boolean sendSMSNotify(String templateNo, String phone, String param) {
        if(StringUtils.isBlank(templateNo) || StringUtils.isBlank(phone) || StringUtils.isBlank(param)){
            CommonUtil.info("sendSMSNotify", "param invalid", new Object[]{"templateNo=" + templateNo, "phone=" + phone, "param="+param}, "");
            return false;
        }
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //使用post提交
            request.setMethod(MethodType.POST);
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
            request.setPhoneNumbers(phone);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName("EGE数联生态");
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(templateNo);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            request.setTemplateParam("{\"car_plate\":\"" + param + "\"}");
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            CommonUtil.info("sendSMSNotify", "entry", new Object[]{"templateNo=" + templateNo, "phone=" + phone, "param="+param}, sendSmsResponse);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                //请求成功
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            CommonUtil.info("sendSMSNotify", "entry", new Object[]{"templateNo=" + templateNo, "phone=" + phone, "param="+param}, e);
            return false;
        }
    }

    public static void main(String[] args) {
        SmsService smsService = new SmsService();
//        smsService.sendSMSNotify("SMS_181210003","13472867511","浙B11007");
//        smsService.sendSMSNotify("SMS_181200005","13472867511","浙B11007");
//        smsService.sendSMSNotify("SMS_181195017","13472867511","浙B11007");
        smsService.sendSMSNotifyRetry("SMS_181195016","13472867511","浙B11007");
        smsService.sendVerifyMsg("SMS_181195016","13472867511");
    }
}
