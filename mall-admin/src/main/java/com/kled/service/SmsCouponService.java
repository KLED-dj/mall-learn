package com.kled.service;

import com.kled.dto.SmsCouponParam;
import com.kled.mbg.model.SmsCoupon;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SmsCouponService {
    /**
     * 分页查询优惠券列表
     */
    List<SmsCoupon> list(Integer pageSize, Integer pageNum, String name,Integer type);
    /**
     * 新增优惠券
     */
    @Transactional
    int create(SmsCouponParam couponParam);
    /**
     * 根据id获取优惠券详情
     */
    SmsCouponParam getItem(Long id);
    /**
     * 更新优惠券信息
     */
    int update(Long id,SmsCouponParam couponParam);
    /**
     * 根据id删除优惠券
     */
    int delete(Long id);
}
