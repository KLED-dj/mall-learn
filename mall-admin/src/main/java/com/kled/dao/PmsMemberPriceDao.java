package com.kled.dao;

import com.kled.mbg.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员价格管理自定义DAO
 */
public interface PmsMemberPriceDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list")List<PmsMemberPrice> memberPriceList);
}
