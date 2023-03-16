package com.kled.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Page;
import com.github.pagehelper.PageHelper;
import com.kled.mbg.mapper.SmsCouponHistoryMapper;
import com.kled.mbg.model.SmsCouponHistory;
import com.kled.mbg.model.SmsCouponHistoryExample;
import com.kled.service.SmsCouponHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsCouponHistoryServiceImpl implements SmsCouponHistoryService {
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    
    @Override
    public List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsCouponHistoryExample example = new SmsCouponHistoryExample();
        SmsCouponHistoryExample.Criteria criteria = example.createCriteria();
        if (couponId!=null){
            criteria.andCouponIdEqualTo(couponId);
        }
        if (useStatus!=null){
            criteria.andUseStatusEqualTo(useStatus);
        }
        if (!StrUtil.isEmpty(orderSn)){
            criteria.andOrderSnEqualTo(orderSn);
        }
        return couponHistoryMapper.selectByExample(example);
    }
}
