package com.kled.dao;

import com.kled.dto.OmsOrderQueryParam;
import com.kled.dto.OmsOrderReturnApplyResult;
import com.kled.dto.OmsReturnApplyQueryParam;
import com.kled.mbg.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请自定义Dao
 */
public interface OmsOrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam orderQueryParam);
    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}
