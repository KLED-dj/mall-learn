package com.kled.service.impl;

import com.kled.mbg.mapper.UmsResourceCategoryMapper;
import com.kled.mbg.model.UmsResourceCategory;
import com.kled.mbg.model.UmsResourceCategoryExample;
import com.kled.service.UmsResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {
    @Autowired
    private UmsResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<UmsResourceCategory> listAll() {
        UmsResourceCategoryExample example = new UmsResourceCategoryExample();
        example.setOrderByClause("sort desc");
        return resourceCategoryMapper.selectByExample(example);
    }
}
