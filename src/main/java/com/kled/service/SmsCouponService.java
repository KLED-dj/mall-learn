package com.kled.service;

import com.kled.mbg.model.SmsCoupon;

import java.util.List;

public interface SmsCouponService {
    /**
     * 分页查询优惠券列表
     */
    List<SmsCoupon> list(Integer pageSize, Integer pageNum, String name,Integer type);
}
