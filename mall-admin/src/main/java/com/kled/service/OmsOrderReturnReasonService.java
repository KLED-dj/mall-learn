package com.kled.service;

import com.kled.mbg.model.OmsOrderReturnReason;

import java.util.List;

public interface OmsOrderReturnReasonService {
    /**
     * 分页获取退货原因
     */
    List<OmsOrderReturnReason> list(Integer pageSize,Integer pageNum);

    /**
     * 添加退货原因
     */
    int create(OmsOrderReturnReason returnReason);

    /**
     * 更改可用状态
     */

    int updateStatus(List<Long> ids,Integer status);
    /**
     * 获取指定id信息
     */
    OmsOrderReturnReason getItem(Long id);

    /**
     * 更新
     */
    int update(Long id,OmsOrderReturnReason returnReason);
    /**
     * 批量删除
     */
    int delete(List<Long> ids);
}
