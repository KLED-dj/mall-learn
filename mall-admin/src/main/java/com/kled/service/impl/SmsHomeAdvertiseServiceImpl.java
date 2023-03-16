package com.kled.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.kled.mbg.mapper.SmsHomeAdvertiseMapper;
import com.kled.mbg.model.SmsHomeAdvertise;
import com.kled.mbg.model.SmsHomeAdvertiseExample;
import com.kled.service.SmsHomeAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.hash.DecoratingStringHashMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@Service
public class SmsHomeAdvertiseServiceImpl implements SmsHomeAdvertiseService {
    @Autowired
    private SmsHomeAdvertiseMapper homeAdvertiseMapper;

    @Override
    public int create(SmsHomeAdvertise advertise) {
        advertise.setClickCount(0);
        advertise.setOrderCount(0);
        return homeAdvertiseMapper.insert(advertise);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andIdIn(ids);
        return homeAdvertiseMapper.deleteByExample(example);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        SmsHomeAdvertise homeAdvertise = new SmsHomeAdvertise();
        homeAdvertise.setId(id);
        homeAdvertise.setStatus(status);
        return homeAdvertiseMapper.updateByPrimaryKeySelective(homeAdvertise);
    }

    @Override
    public SmsHomeAdvertise getItem(Long id) {
        return homeAdvertiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id, SmsHomeAdvertise advertise) {
        advertise.setId(id);
        return homeAdvertiseMapper.updateByPrimaryKeySelective(advertise);
    }

    @Override
    public List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        SmsHomeAdvertiseExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        if (!StrUtil.isEmpty(endTime)) {
            String startStr = endTime + " 00:00:00";
            String endStr = endTime + " 23:59:59";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = null;
            try {
                start = sdf.parse(startStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date end = null;
            try {
                end = sdf.parse(endStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (start != null && end != null){
                criteria.andEndTimeBetween(start,end);
            }
        }
        example.setOrderByClause("sort desc");
        return homeAdvertiseMapper.selectByExample(example);
    }
}
