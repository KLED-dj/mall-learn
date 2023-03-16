package com.kled.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.kled.mbg.mapper.SmsHomeRecommendSubjectMapper;
import com.kled.mbg.model.SmsHomeRecommendSubject;
import com.kled.mbg.model.SmsHomeRecommendSubjectExample;
import com.kled.service.SmsHomeRecommendSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsHomeRecommendSubjectServiceImpl implements SmsHomeRecommendSubjectService {
    @Autowired
    private SmsHomeRecommendSubjectMapper recommendSubjectMapper;

    @Override
    public List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        SmsHomeRecommendSubjectExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(subjectName)){
            criteria.andSubjectNameLike("%"+subjectName+"%");
        }
        if (recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return recommendSubjectMapper.selectByExample(example);
    }

    @Override
    public int create(List<SmsHomeRecommendSubject> homeRecommendSubjectList) {
        for (SmsHomeRecommendSubject smsHomeRecommendSubject : homeRecommendSubjectList) {
            smsHomeRecommendSubject.setRecommendStatus(1);
            smsHomeRecommendSubject.setSort(0);
            recommendSubjectMapper.insert(smsHomeRecommendSubject);
        }
        return homeRecommendSubjectList.size();
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andIdIn(ids);
        SmsHomeRecommendSubject record = new SmsHomeRecommendSubject();
        record.setRecommendStatus(recommendStatus);
        return recommendSubjectMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendSubject smsHomeRecommendSubject = new SmsHomeRecommendSubject();
        smsHomeRecommendSubject.setId(id);
        smsHomeRecommendSubject.setSort(sort);
        return recommendSubjectMapper.updateByPrimaryKeySelective(smsHomeRecommendSubject);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andIdIn(ids);
        return recommendSubjectMapper.deleteByExample(example);
    }
}
