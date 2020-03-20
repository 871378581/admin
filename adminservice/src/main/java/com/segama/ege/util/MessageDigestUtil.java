package com.segama.ege.util;
import java.io.UnsupportedEncodingException;
import java.security.*;

public class MessageDigestUtil {
    /**
     * 使用指定哈希算法SHA256计算摘要信息
     * @param content 内容
     * @return 内容摘要
     */
    public static String getSHA256Digest(String content){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha-256");
            messageDigest.update(content.getBytes("utf-8"));
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将字节数组转换成16进制字符串
     * @param bytes 即将转换的数据
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] bytes){
        StringBuffer sb = new StringBuffer(bytes.length);
        String temp = null;
        for (int i = 0;i< bytes.length;i++){
            temp = Integer.toHexString(0xFF & bytes[i]);
            if (temp.length() <2){
                sb.append(0);
            }
            sb.append(temp);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String ss = "e6364fc8-c044-4de6-87fc-1d005901235f" + "1" + "5000000" +
                "0" + "5000000" + "2019-12-08 13:25:24";
        String str = MessageDigestUtil.getSHA256Digest(ss);
        System.out.println(str);
        //String str2 = MessageDigestUtil.getSHA256Digest("test" + ss);
        //System.out.println(str2);
    }
}
