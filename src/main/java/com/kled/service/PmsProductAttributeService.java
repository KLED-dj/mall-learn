package com.kled.service;

import com.kled.mbg.model.PmsProductAttribute;

import java.util.List;

/**
 * 商品属性管理
 */
public interface PmsProductAttributeService {
    /**
     * 根据分类分页获取商品属性
     */
    List<PmsProductAttribute> getList(Long cid,Integer type,Integer pageSize,Integer pageNum);

}
