package com.segama.ege.util;

import com.segama.ege.dto.wx.ShareConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 2/5/15
 * Time         : 8:04 PM
 * Description  : js ticket encode
 */
public class JSShareHelper {
    private static final Logger log = LoggerFactory.getLogger(JSShareHelper.class);

    public static ShareConfiguration getWeChatShareConfiguration(String ticket, String url) {
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature;

        string1 = "jsapi_ticket=" + ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (Exception e) {
            log.error("Error in generate share configuration.", e);
            return null;
        }

        return new ShareConfiguration(ticket, nonce_str, timestamp, signature);

    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
