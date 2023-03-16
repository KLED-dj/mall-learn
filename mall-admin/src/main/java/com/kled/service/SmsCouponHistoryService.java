package com.kled.service;

import com.kled.mbg.model.SmsCouponHistory;

import java.util.List;

/**
 * 优惠券领取记录管理
 */
public interface SmsCouponHistoryService {
    /**
     * 分页查询优惠券领取记录
     */
    List<SmsCouponHistory> list(Long couponId,Integer useStatus,String orderSn,Integer pageSize,Integer pageNum);
}
