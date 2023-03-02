package com.kled.service;

import com.kled.dto.PmsProductQueryParam;
import com.kled.mbg.model.PmsProduct;

import java.util.List;

public interface PmsProductService {
    

    List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量上下架商品
     */
    int updatePublishStatus(List<Long> ids,Integer publishStatus);

    /**
     * 批量开启新品
     */
    int updateNewStatus(List<Long> ids,Integer newStatus);
    /**
     * 批量开启推荐
     */
    int updateRecommendStatus(List<Long> ids,Integer recommendStatus);

}
