package com.kled.service.impl;

import com.kled.dao.PmsProductCategoryDao;
import com.kled.dto.PmsProductCategoryWithChildrenItem;
import com.kled.mbg.model.PmsProductCategory;
import com.kled.service.PmsProductCategoryService;
import com.kled.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {
    @Autowired()
    private PmsProductCategoryDao productCategoryDao;
    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }
}
