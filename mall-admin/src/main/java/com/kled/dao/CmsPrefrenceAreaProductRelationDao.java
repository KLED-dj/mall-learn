package com.kled.dao;

import com.kled.mbg.model.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 关联优选管理
 */
public interface CmsPrefrenceAreaProductRelationDao {
    /**
     * 批量处理
     */
    int insertList(@Param("list")List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}
