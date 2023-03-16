package com.kled.dao;

import com.kled.dto.OmsOrderDeliverParam;
import com.kled.dto.OmsOrderDetail;
import com.kled.dto.OmsOrderQueryParam;
import com.kled.mbg.model.OmsOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliverParam> orderDeliverParam);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
