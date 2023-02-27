package com.kled.service.impl;

import com.kled.dao.UmsRoleDao;
import com.kled.mbg.model.UmsMenu;
import com.kled.mbg.model.UmsRole;
import com.kled.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleDao roleDao;

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }
}
