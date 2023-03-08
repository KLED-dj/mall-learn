package com.kled.service;

import com.kled.mbg.model.SmsHomeBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SmsHomeBrandService {
    /**
     * 添加首页品牌推荐
     */
    @Transactional
    int create(List<SmsHomeBrand> homeBrandList);
    /**
     * 分页查询品牌推荐
     */
    List<SmsHomeBrand> list(String brandName,Integer recommendStatus,Integer pageSize,Integer pageNum);
}
