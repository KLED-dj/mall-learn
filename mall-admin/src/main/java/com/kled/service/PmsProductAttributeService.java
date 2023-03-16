package com.kled.service;

import com.kled.dto.PmsProductAttributeParam;
import com.kled.dto.ProductAttrInfo;
import com.kled.mbg.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品属性管理
 */
public interface PmsProductAttributeService {
    /**
     * 添加商品属性分类
     */
    @Transactional
    int create(PmsProductAttributeParam pmsProductAttributeParam);

    /**
     * 更新商品属性分类
     */
    int update(Long id,PmsProductAttributeParam productAttributeParam);
    /**
     * 批量删除商品属性分类
     */
    @Transactional
    int delete(List<Long> ids);
    /**
     * 获取单个商品属性信息
     */
    PmsProductAttribute getItem(Long id);
    /**
     * 根据分类分页获取商品属性
     */
    List<PmsProductAttribute> getList(Long cid,Integer type,Integer pageSize,Integer pageNum);
    /**
     * 获取商品分类对应属性列表
     */
    List<ProductAttrInfo> getProductAttributeInfo(Long productCategoryId);
}
