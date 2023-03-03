package com.kled.dao;

import com.kled.mbg.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品和专题自定义Dao
 */
public interface CmsSubjectProductRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list")List<CmsSubjectProductRelation> subjectProductRelationList);
}
