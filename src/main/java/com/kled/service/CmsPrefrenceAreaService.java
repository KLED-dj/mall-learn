package com.kled.service;

import com.kled.mbg.model.CmsPrefrenceArea;

import java.util.List;

/**
 * 商品优选管理
 */
public interface CmsPrefrenceAreaService {
    /**
     * 获取所有优选专区
     */
    List<CmsPrefrenceArea> listAll();
}
