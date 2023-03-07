package com.kled.service;

import com.kled.dto.OmsReturnApplyQueryParam;
import com.kled.mbg.model.OmsOrderReturnApply;

import java.util.List;

/**
 * 退货申请管理
 */
public interface OmsOrderReturnApplyService {
    /**
     * 分页查询申请
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam returnApplyQueryParam,Integer pageSize,Integer pageNum);
    /**
     * 获取指定申请详情
     */
    OmsOrderReturnApply getItem(Long id);
}
