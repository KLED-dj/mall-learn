package com.kled.service.impl;

import com.kled.mbg.mapper.CmsSubjectMapper;
import com.kled.mbg.model.CmsSubject;
import com.kled.mbg.model.CmsSubjectExample;
import com.kled.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品专题管理
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public List<CmsSubject> listAll() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }
}
