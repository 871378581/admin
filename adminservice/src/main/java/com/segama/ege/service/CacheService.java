package com.segama.ege.service;

import com.segama.ege.entity.AdminSystemConfig;
import com.segama.ege.entity.AdminSystemConfigExample;
import com.segama.ege.repository.AdminSystemConfigMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.segama.ege.constant.Constants.*;

@Component
public class CacheService {
    private static final Map<String, String> cacheMap = new HashMap<>();
    private static final Map<String, Object> objectCacheMap = new HashMap<>();
    private static final Map<String, Long> expiredCheckMap = new HashMap<>();


    @Autowired
    AdminSystemConfigMapper sysConfigMapper;

    static {
        cacheMap.put(SYSTEM_CURRENT_API_HOST, "http://www.jinlingongyi.cn");
        cacheMap.put(WX_TOKEN_KEY, "");
        cacheMap.put(SYSTEM_IMAGE_LOCATION, "/root/ege/adminservice/repo");
        cacheMap.put(SYSTEM_IMAGE_REPO_PREFIX, "/adminservice/repo/");
        cacheMap.put(WX_JS_TICKET_KEY, "");
        cacheMap.put(WX_APP_ID, "wx9c007035c17b2e42");
        cacheMap.put(WX_APP_SECRET, "8c2917321f52baf1f073efa164664208");
        cacheMap.put("login.auth.redirect.default", "/adminservice/h5/merchant/redirect.html");
        cacheMap.put("login.auth.redirect.abc", "/adminservice/h5/merchant/redirect.html");
    }


    /**
     * 从db配置表获取配置
     *
     * @param key
     * @return
     */
    public String getConfig(String key) {
        String enhancedKey = enhance(key);
        String value = get(enhancedKey);
        if (StringUtils.isNoneBlank(value)) {
            return value;
        } else {
            AdminSystemConfigExample sysConfigExample = new AdminSystemConfigExample();
            List<AdminSystemConfig> sysConfigs = sysConfigMapper.selectByExample(sysConfigExample);
            for (AdminSystemConfig sysConfig : sysConfigs) {
                put(enhance(sysConfig.getKey()), sysConfig.getValue(), 60 * 60); //缓存60分钟
            }
        }
        return get(enhancedKey);
    }

    private String enhance(String key) {
        return "db_key_" + key;
    }

    public void put(String key, String value) {
        put(key, value, -1);
    }

    public void put(String key, String value, int expiredInSeconds) {
        cacheMap.put(key, value);
        if (expiredInSeconds > 0) {
            expiredCheckMap.put(key, System.currentTimeMillis() + expiredInSeconds * 1000);
        }
    }

    public String get(String key) {
        if (cacheMap.containsKey(key)) {
            if (expiredCheckMap.containsKey(key)) {
                Long expiredTimeInMs = expiredCheckMap.get(key);
                //已过期
                if (expiredTimeInMs < System.currentTimeMillis()) {
                    cacheMap.remove(key);
                    return null;
                }
            }
        }
        return cacheMap.get(key);
    }

    public boolean containsCacheObjec(String key) {
        return objectCacheMap.containsKey(key);
    }

    public Object getCacheObject(String key) {
        return objectCacheMap.get(key);
    }

    public void putCacheObject(String key, Object cacheObj) {
        objectCacheMap.put(key, cacheObj);
    }
}
