package com.kled.service;

/**
 * 后台用户缓存操作
 */
public interface UmsAdminCacheService {
    /**
     * 删除后台用户资源列表缓存
     */
    void delResourceList(Long adminId);

    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);
}
