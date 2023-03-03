package com.kled.service.impl;

import com.github.pagehelper.PageHelper;
import com.kled.dao.PmsProductCategoryDao;
import com.kled.dto.PmsProductCategoryWithChildrenItem;
import com.kled.mbg.mapper.PmsProductCategoryMapper;
import com.kled.mbg.model.PmsProductCategory;
import com.kled.mbg.model.PmsProductCategoryExample;
import com.kled.service.PmsProductCategoryService;
import com.kled.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {
    @Autowired
    private PmsProductCategoryDao productCategoryDao;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;


    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductCategoryExample productCategoryExample = new PmsProductCategoryExample();
        productCategoryExample.setOrderByClause("sort desc");
        productCategoryExample.createCriteria().andParentIdEqualTo(parentId);
        return productCategoryMapper.selectByExample(productCategoryExample);
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }
}
