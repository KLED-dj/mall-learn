package com.kled.service;

import com.kled.dto.PmsProductCategoryParam;
import com.kled.dto.PmsProductCategoryWithChildrenItem;
import com.kled.mbg.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductCategoryService {
    /**
     * 创建商品分类
     */
    @Transactional
    int create(PmsProductCategoryParam pmsProductCategoryParam);

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
     * 修改商品分类
     */
    @Transactional
    int update(Long id, PmsProductCategoryParam productCategoryParam);

    /**
     * 批量更新菜单状态
     */
    int updateNavStatus(List<Long> ids,Integer navStatus);

    /**
     * 批量更新展示状态
     */
    int updateShowStatus(List<Long> ids,Integer ShowStatus);
    /**
     * 批量更改删除状态
     */
    int delete(Long id);
}
