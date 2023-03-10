package com.kled.dao;

import com.kled.mbg.model.UmsMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色管理自定义DAO
 */
public interface UmsRoleDao {
    /**
     * 根据后台用户ID获取菜单
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
}
