package com.kled.service;

import com.kled.dto.PmsProductParam;
import com.kled.dto.PmsProductQueryParam;
import com.kled.dto.PmsProductResult;
import com.kled.mbg.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductService {
    /**
     * 新增
     * @TODO 新增商品
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int create(PmsProductParam productParam);
    /**
     * 分页查询
     */
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
    /**
     * 根据商品编号获取更新信息
     */
    PmsProductResult getUpdateInfo(Long id);

}
