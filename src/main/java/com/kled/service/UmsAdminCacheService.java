package com.kled.service;

import java.util.List;

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

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRole(Long roleId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRoleIds(List<Long> roleIds);
}
