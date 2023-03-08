package com.kled.service;

import com.kled.mbg.model.CmsSubject;

import java.util.List;

/**
 * 商品专题管理
 */
public interface CmsSubjectService {
    /**
     * 查询所有专题
     */
    List<CmsSubject> listAll();
    /**
     * 分页查询专题
     */
    List<CmsSubject> list(String keyword,Integer pageSize,Integer pageNum);

}
