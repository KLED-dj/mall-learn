package com.kled.service;

import com.kled.mbg.model.UmsResourceCategory;

import java.util.List;

/**
 * 后台资源分类管理
 */
public interface UmsResourceCategoryService {

    /**
     * 获取所有资源分类
     */
    List<UmsResourceCategory> listAll();
}
