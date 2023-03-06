package com.kled.dao;

import com.kled.mbg.model.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品分类和属性关系自定义Dao
 */
public interface PmsProductCategoryAttributeRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list")List<PmsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
