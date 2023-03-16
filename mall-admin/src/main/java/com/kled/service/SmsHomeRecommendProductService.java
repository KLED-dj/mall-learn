package com.kled.service;

import com.kled.mbg.model.SmsHomeRecommendProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SmsHomeRecommendProductService {
    /**
     * 分页查询推荐
     */
    List<SmsHomeRecommendProduct> list(String productName,Integer recommendStatus,Integer pageSize,Integer pageNum);
    /**
     * 添加首页人气推荐商品
     */
    @Transactional
    int create(List<SmsHomeRecommendProduct> homeRecommendProductList);
    /**
     * 修改推荐排序
     */
    int updateSort(Long id,Integer sort);
    /**
     * 批量更改推荐状态
     */
    int updateRecommendStatus(List<Long> ids,Integer recommendStatus);
    /**
     * 批量删除
     */
    int delete(List<Long> ids);

}
