package com.kled.service.impl;

import com.kled.mbg.mapper.UmsMemberLevelMapper;
import com.kled.mbg.model.UmsMemberExample;
import com.kled.mbg.model.UmsMemberLevel;
import com.kled.mbg.model.UmsMemberLevelExample;
import com.kled.service.UmsMemberLevelService;
import com.kled.service.UmsMemberService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;

    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
