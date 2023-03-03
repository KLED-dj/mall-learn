package com.kled.service.impl;

import com.kled.mbg.mapper.CmsPrefrenceAreaMapper;
import com.kled.mbg.model.CmsPrefrenceArea;
import com.kled.mbg.model.CmsPrefrenceAreaExample;
import com.kled.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
