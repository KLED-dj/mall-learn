package com.kled.dao;

import com.kled.mbg.model.PmsProductLadder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 阶梯价格管理
 */
public interface PmsProductLadderDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list")List<PmsProductLadder> pmsProductLadderList);
}
