package com.kled.service;

import com.kled.dto.PmsProductAttributeCategoryItem;
import com.kled.mbg.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * 商品属性分类管理
 */
public interface PmsProductAttributeCategoryService {

    /**
     * 分页查询属性分类
     */
    List<PmsProductAttributeCategory> getList(Integer pageSize,Integer pageNum);
    /**
     * 获取包含属性的属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
