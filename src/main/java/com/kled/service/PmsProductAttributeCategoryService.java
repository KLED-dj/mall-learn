package com.kled.service;

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
}
