package com.kled.service.impl;

import com.github.pagehelper.PageHelper;
import com.kled.mbg.mapper.SmsFlashPromotionMapper;
import com.kled.mbg.model.SmsFlashPromotion;
import com.kled.mbg.model.SmsFlashPromotionExample;
import com.kled.service.SmsFlashPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SmsFlashPromotionServiceImpl implements SmsFlashPromotionService {
    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;

    @Override
    public List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        if(!StringUtils.isEmpty(keyword)){
            example.createCriteria().andTitleLike("%"+keyword+"%");
        }
        return flashPromotionMapper.selectByExample(example);
    }
}
