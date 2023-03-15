package com.kled.service;

import com.kled.mbg.model.UmsMenu;
import com.kled.mbg.model.UmsRole;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * 用户角色表service
 */
public interface UmsRoleService {
    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * 获取所有角色列表
     */
    List<UmsRole> list();

    /**
     * 分页获取角色列表
     */
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);
}
