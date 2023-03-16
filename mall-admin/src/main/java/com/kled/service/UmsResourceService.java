package com.kled.service;

import com.kled.mbg.model.UmsResource;

import java.util.List;

public interface UmsResourceService {
    /**
     * 添加资源
     */
    int create(UmsResource umsResource);

    /**
     * 查询全部资源
     */
    List<UmsResource> listAll();

    /**
     * 分页查询资源
     */
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);
}
