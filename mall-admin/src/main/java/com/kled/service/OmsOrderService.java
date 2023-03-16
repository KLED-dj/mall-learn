package com.kled.service;

import com.kled.dto.*;
import com.kled.mbg.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OmsOrderService {
    /**
     * 订单查询
     */
    List<OmsOrder> list(OmsOrderQueryParam omsOrderQueryParam,Integer pageSize,Integer pageNum);

    /**
     * 批量发货
     */
    @Transactional
    int delivery(List<OmsOrderDeliverParam> deliverParamList);

    /**
     * 批量删除订单
     */
    @Transactional
    int close(List<Long> ids,String note);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);

    /**
     * 获取指定订单详情
     */
    OmsOrderDetail detail(Long id);

    /**
     * 修改订单收货人信息
     */
    @Transactional
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * 修改订单费用信息
     */
    @Transactional
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     */
    @Transactional
    int updateNote(Long id,String note,Integer status);

}
