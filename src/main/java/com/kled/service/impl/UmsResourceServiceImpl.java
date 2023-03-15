package com.kled.service.impl;

import com.kled.mbg.mapper.UmsResourceMapper;
import com.kled.mbg.model.UmsResource;
import com.kled.mbg.model.UmsResourceExample;
import com.kled.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsResourceServiceImpl implements UmsResourceService {
    @Autowired
    private UmsResourceMapper resourceMapper;

    @Override
    public List<UmsResource> listAll() {
        return resourceMapper.selectByExample(new UmsResourceExample());
    }
}
