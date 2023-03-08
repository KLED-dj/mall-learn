package com.kled.service;

import com.kled.mbg.model.SmsHomeRecommendSubject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页专题推荐管理
 */
public interface SmsHomeRecommendSubjectService {
    /**
     * 分页查询专题推荐
     */
    List<SmsHomeRecommendSubject> list(String subjectName,Integer recommendStatus,Integer pageSize,Integer pageNum);
    /**
     * 添加首页专题推荐
     */
    @Transactional
    int create(List<SmsHomeRecommendSubject> homeRecommendSubjectList);
    /**
     * 批量更新推荐状态
     */
    int updateRecommendStatus(List<Long> ids,Integer recommendStatus);
    /**
     * 修改推荐排序
     */
    int updateSort(Long id, Integer sort);
    /**
     * 批量删除
     */
    int delete(List<Long> ids);
}
