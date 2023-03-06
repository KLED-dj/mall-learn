package com.kled.service;

import com.kled.dto.PmsProductCategoryWithChildrenItem;
import com.kled.mbg.model.PmsProductCategory;

import java.util.List;

public interface PmsProductCategoryService {
    /**
     * 分类获取商品分类
     */
    List<PmsProductCategory> getList(Long parentId,Integer pageSize,Integer pageNum);

    /**
     * 以层级形式获取商品分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
    /**
     * 根据ID获取商品分类
     */
    PmsProductCategory getItem(Long id);

    /**
     * 批量更新菜单状态
     */
    int updateNavStatus(List<Long> ids,Integer navStatus);

    /**
     * 批量更新展示状态
     */
    int updateShowStatus(List<Long> ids,Integer ShowStatus);
}
