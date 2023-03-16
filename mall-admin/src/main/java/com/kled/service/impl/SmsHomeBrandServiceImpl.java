package com.kled.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.kled.mbg.mapper.SmsHomeBrandMapper;
import com.kled.mbg.model.SmsHomeBrand;
import com.kled.mbg.model.SmsHomeBrandExample;
import com.kled.service.SmsHomeBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsHomeBrandServiceImpl implements SmsHomeBrandService {
    @Autowired
    private SmsHomeBrandMapper homeBrandMapper;

    @Override
    public int create(List<SmsHomeBrand> homeBrandList) {
        for (SmsHomeBrand smsHomeBrand : homeBrandList) {
            smsHomeBrand.setRecommendStatus(1);
            smsHomeBrand.setSort(0);
            homeBrandMapper.insert(smsHomeBrand);
        }
        return homeBrandList.size();
    }

    @Override
    public List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        SmsHomeBrandExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(brandName)){
            criteria.andBrandNameLike("%"+brandName+"%");
        }
        if (recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return homeBrandMapper.selectByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andIdIn(ids);
        SmsHomeBrand homeBrand = new SmsHomeBrand();
        homeBrand.setRecommendStatus(recommendStatus);
        return homeBrandMapper.updateByExampleSelective(homeBrand,example);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeBrand homeBrand = new SmsHomeBrand();
        homeBrand.setId(id);
        homeBrand.setSort(sort);
        return homeBrandMapper.updateByPrimaryKeySelective(homeBrand);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andIdIn(ids);
        return homeBrandMapper.deleteByExample(example);
    }
}
