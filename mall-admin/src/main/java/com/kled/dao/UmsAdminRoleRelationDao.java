package com.kled.dao;

import com.kled.mbg.model.UmsAdminRoleRelation;
import com.kled.mbg.model.UmsPermission;
import com.kled.mbg.model.UmsRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限（包括+-权限）
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
    /**
     * 获取用户所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list")List<UmsAdminRoleRelation> adminRoleRelationList);

}
