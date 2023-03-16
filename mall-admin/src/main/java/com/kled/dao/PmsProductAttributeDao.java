package com.kled.dao;

import com.kled.dto.ProductAttrInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品属性管理自定义DAO
 */
public interface PmsProductAttributeDao {
    /**
     * 获取商品属性信息
     */
    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);
}
