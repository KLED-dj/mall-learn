package com.kled.service.impl;

import com.kled.mbg.model.UmsAdmin;
import com.kled.service.RedisService;
import com.kled.service.UmsAdminCacheService;
import com.kled.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsAdminService adminService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Override
    public void delResourceList(Long adminId) {
        String key = REDIS_DATABASE+":"+REDIS_KEY_RESOURCE_LIST+":"+adminId;
        redisService.del(key);
    }

    @Override
    public void delAdmin(Long adminId) {
        UmsAdmin admin = adminService.getItem(adminId);
        if (admin!=null){
            String key = REDIS_DATABASE+":"+REDIS_KEY_ADMIN+":"+admin.getUsername();
        }
    }
}
