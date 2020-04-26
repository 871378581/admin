package com.segama.ege.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.security.Security;

public class DESUtils {

    public static final Log log = LogFactory.getLog(DESUtils.class);

    /**
     * 报表json密钥
     */
    private final static String DES = "DES";

    /**
     * 加密
     * @param src 数据源
     * @param key 密钥，长度必须是8的倍数
     * @return 返回加密后的数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        System.out.println("数据长度："+(src.length%8)+",密钥长度："+key.length);
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        /**加密方式/模式/填充方式，PKCS7Padding填充方式 jdk不支持 , BC 是 provider **/
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS7Padding","BC");
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(src);
    }
    /**
     * 解密
     *
     * @param src 数据源
     * @param key 密钥，长度必须是8的倍数
     * @return 返回解密后的原始数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        System.out.println("解密数据长度："+(src.length%8)+",密钥长度："+key.length);
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS7Padding","BC");
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(src);
    }

    /**
     * 密码解密
     *
     * @param hex
     * @param pwd
     * @return
     * @throws Exception
     */
    public final static String decrypt(String hex,String pwd) {
        try {
            System.out.println("解密前："+hex);
            String data = new String(decrypt(hex2byte(hex.getBytes("UTF-8")), pwd.getBytes()), "UTF-8");
            System.out.println("解密后："+data);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 密码加密
     * @param pwd
     * @return
     * @throws Exception
     */
    public final static String encrypt(String data,String pwd) {
        try {
            String hex =  byte2hex(encrypt(data.getBytes("UTF-8"), pwd.getBytes()));
            return hex;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 二行制转字符串
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;

        }
        return hs.toUpperCase();
    }

    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0) throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }
}
