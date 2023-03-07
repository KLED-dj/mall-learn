package com.kled.service.impl;

import com.kled.mbg.mapper.SmsFlashPromotionSessionMapper;
import com.kled.mbg.model.SmsFlashPromotionSession;
import com.kled.mbg.model.SmsFlashPromotionSessionExample;
import com.kled.service.SmsFlashPromotionSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SmsFlashPromotionSessionServiceImpl implements SmsFlashPromotionSessionService {
    @Autowired
    private SmsFlashPromotionSessionMapper promotionSessionMapper;

    @Override
    public List<SmsFlashPromotionSession> list() {
        SmsFlashPromotionSessionExample example = new SmsFlashPromotionSessionExample();
        return promotionSessionMapper.selectByExample(example);
    }

    @Override
    public int create(SmsFlashPromotionSession promotionSession) {
        promotionSession.setCreateTime(new Date());
        return promotionSessionMapper.insert(promotionSession);
    }

    @Override
    public int update(Long id,SmsFlashPromotionSession promotionSession) {
        promotionSession.setId(id);
        return promotionSessionMapper.updateByPrimaryKey(promotionSession);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        SmsFlashPromotionSession flashPromotionSession = new SmsFlashPromotionSession();
        flashPromotionSession.setId(id);
        flashPromotionSession.setStatus(status);
        return promotionSessionMapper.updateByPrimaryKeySelective(flashPromotionSession);
    }

    @Override
    public int delete(Long id) {
        return promotionSessionMapper.deleteByPrimaryKey(id);
    }
}
