package com.kled.service;

import com.kled.mbg.model.UmsMenu;
import com.kled.mbg.model.UmsRole;

import java.util.List;

/**
 * 用户角色表service
 */
public interface UmsRoleService {
    //@TODO 未完整

    List<UmsMenu> getMenuList(Long adminId);

    List<UmsRole> list();

}
