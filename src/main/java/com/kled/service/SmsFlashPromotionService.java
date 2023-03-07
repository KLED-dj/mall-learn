package com.kled.service;

import com.kled.mbg.model.SmsFlashPromotion;

import java.util.List;

/**
 * 限时购活动管理
 */
public interface SmsFlashPromotionService {
    /**
     * 分页查询活动
     */
    List<SmsFlashPromotion> list(String keyword,Integer pageSize,Integer pageNum);
}
