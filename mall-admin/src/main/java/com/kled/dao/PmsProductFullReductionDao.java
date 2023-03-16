package com.kled.dao;

import com.kled.mbg.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 满减价格管理
 */
public interface PmsProductFullReductionDao {
    /**
     * 批量处理
     */
    int insertList(@Param("list")List<PmsProductFullReduction> productFullReductionList);
}
