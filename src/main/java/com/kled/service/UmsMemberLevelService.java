package com.kled.service;

import com.kled.mbg.model.UmsMemberLevel;

import java.util.List;

/**
 * 会员等级管理Service
 */
public interface UmsMemberLevelService {

    /**
     * 获取所有会员登记
     * @param defaultStatus 是否为默认会员
     * @return
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}
