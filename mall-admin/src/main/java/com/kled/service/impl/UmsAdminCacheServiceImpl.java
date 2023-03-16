package com.kled.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.kled.mbg.mapper.UmsAdminRoleRelationMapper;
import com.kled.mbg.model.UmsAdmin;
import com.kled.mbg.model.UmsAdminRoleRelation;
import com.kled.mbg.model.UmsAdminRoleRelationExample;
import com.kled.service.RedisService;
import com.kled.service.UmsAdminCacheService;
import com.kled.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
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

    @Override
    public void delResourceListByRole(Long roleId) {
        UmsAdminRoleRelationExample example = new UmsAdminRoleRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<UmsAdminRoleRelation> relationList = adminRoleRelationMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(relationList)){
            String keyPrefix = REDIS_DATABASE+":"+REDIS_KEY_RESOURCE_LIST+":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {
        UmsAdminRoleRelationExample example = new UmsAdminRoleRelationExample();
        example.createCriteria().andRoleIdIn(roleIds);
        List<UmsAdminRoleRelation> relationList = adminRoleRelationMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(relationList)){
            String keyPrefix=REDIS_DATABASE+":"+REDIS_KEY_RESOURCE_LIST+":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }
}
