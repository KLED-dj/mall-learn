package com.kled.service;

import com.kled.dto.OmsOrderQueryParam;
import com.kled.mbg.model.OmsOrder;

import java.util.List;

public interface OmsOrderService {
    /**
     * 订单查询
     */
    List<OmsOrder> list(OmsOrderQueryParam omsOrderQueryParam,Integer pageSize,Integer pageNum);
}
