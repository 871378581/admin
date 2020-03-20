package com.segama.ege.service;

import com.segama.ege.entity.AdminSystemConfig;
import com.segama.ege.entity.AdminSystemConfigExample;
import com.segama.ege.repository.AdminSystemConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigService {

    @Autowired
    AdminSystemConfigMapper sysConfigMapper;

    Map<String, String> cacheInMem = new HashMap<>();

    public String get(String key) {
        if (cacheInMem.containsKey(key)) return cacheInMem.get(key);
        AdminSystemConfigExample sysConfigExample = new AdminSystemConfigExample();
        List<AdminSystemConfig> sysConfigs = sysConfigMapper.selectByExample(sysConfigExample);
        for (AdminSystemConfig sysConfig : sysConfigs) {
            cacheInMem.put(sysConfig.getKey(), sysConfig.getValue());
        }

        return cacheInMem.get(key);
    }

    public int updateSysConfig(String key, String value) {
        AdminSystemConfigExample sysConfigExample = new AdminSystemConfigExample();
        sysConfigExample.createCriteria().andKeyEqualTo(key);
        List<AdminSystemConfig> sysConfigs = sysConfigMapper.selectByExample(sysConfigExample);
        if(!CollectionUtils.isEmpty(sysConfigs)){
            AdminSystemConfig config = sysConfigs.get(0);
            config.setValue(value);
            config.setGmt_create(new Date());
            int ret = sysConfigMapper.updateByPrimaryKey(config);
            if(ret > 0){
                cacheInMem.remove(key);
                cacheInMem.put(key, value);
            }
            return ret;
        }
        return 0;
    }
}
