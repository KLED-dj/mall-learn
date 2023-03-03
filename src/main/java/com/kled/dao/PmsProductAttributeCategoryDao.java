package com.kled.dao;

import com.kled.dto.PmsProductAttributeCategoryItem;
import com.kled.service.impl.PmsProductAttributeCategoryServiceImpl;

import java.util.List;

/**
 * 商品属性分类管理自定义DAO
 */
public interface PmsProductAttributeCategoryDao {
    /**
     * 获取包含属性的商品属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
