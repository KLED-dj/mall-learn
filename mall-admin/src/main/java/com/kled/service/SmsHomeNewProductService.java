package com.kled.service;

import com.kled.mbg.model.SmsHomeNewProduct;
import io.swagger.models.auth.In;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SmsHomeNewProductService {
    /**
     * 分页查询首页新品列表
     */
    List<SmsHomeNewProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);
    /**
     * 添加首页推荐
     */
    @Transactional
    int create(List<SmsHomeNewProduct> homeNewProductList);
    /**
     * 批量修改推荐状态
     */
    int updateRecommendStatus(List<Long> ids,Integer recommendStatus);
    /**
     * 更改首页新品排序状态
     */
    int updateSort(Long id,Integer sort);
    /**
     * 批量删除首页新品推荐
     */
    int delete(List<Long> ids);
}
