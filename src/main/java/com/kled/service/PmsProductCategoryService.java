package com.kled.service;

import com.kled.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

public interface PmsProductCategoryService {

    /**
     * 以层级形式获取商品分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
