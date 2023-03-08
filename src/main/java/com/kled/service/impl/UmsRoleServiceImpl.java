package com.kled.service.impl;

import com.kled.dao.UmsRoleDao;
import com.kled.mbg.mapper.UmsRoleMapper;
import com.kled.mbg.model.UmsMenu;
import com.kled.mbg.model.UmsRole;
import com.kled.mbg.model.UmsRoleExample;
import com.kled.mbg.model.UmsRoleMenuRelation;
import com.kled.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleDao roleDao;
    @Autowired
    private UmsRoleMapper roleMapper;

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }

    @Override
    public List<UmsRole> list() {
        return roleMapper.selectByExample(new UmsRoleExample());
    }
}
