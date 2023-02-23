package com.kled.dao;

import com.kled.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限（包括+-权限）
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
