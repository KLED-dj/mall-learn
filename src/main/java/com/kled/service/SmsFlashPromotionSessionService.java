package com.kled.service;

import com.kled.mbg.model.SmsFlashPromotionSession;

import java.util.List;

public interface SmsFlashPromotionSessionService {
    /**
     * 根据启动状态获取场次列表
     */
    List<SmsFlashPromotionSession> list();
    /**
     * 添加场次
     */
    int create(SmsFlashPromotionSession promotionSession);
    /**
     * 更改场次
     */
    int update(Long id,SmsFlashPromotionSession promotionSession);
    /**
     * 修改启用状态
     */
    int updateStatus(Long id,Integer status);
    /**
     * 删除场次
     */
    int delete(Long id);
}
