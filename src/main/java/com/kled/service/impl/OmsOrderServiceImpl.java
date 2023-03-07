package com.kled.service.impl;

import com.github.pagehelper.PageHelper;
import com.kled.dao.OmsOrderDao;
import com.kled.dao.OmsOrderOperateHistoryDao;
import com.kled.dto.OmsOrderDeliverParam;
import com.kled.dto.OmsOrderDetail;
import com.kled.dto.OmsOrderQueryParam;
import com.kled.mbg.mapper.OmsOrderMapper;
import com.kled.mbg.mapper.OmsOrderOperateHistoryMapper;
import com.kled.mbg.model.OmsOrder;
import com.kled.mbg.model.OmsOrderExample;
import com.kled.mbg.model.OmsOrderOperateHistory;
import com.kled.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderDao orderDao;
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OmsOrderOperateHistoryMapper orderOperateHistoryMapper;
    @Autowired
    private OmsOrderOperateHistoryDao orderOperateHistoryDao;

    @Override
    public List<OmsOrder> list(OmsOrderQueryParam omsOrderQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return orderDao.getList(omsOrderQueryParam);
    }

    @Override
    public int delivery(List<OmsOrderDeliverParam> deliverParamList) {
        //批量发货
        int count = orderDao.delivery(deliverParamList);
        //添加操作记录
        List<OmsOrderOperateHistory> operateHistories = deliverParamList.stream()
                .map(orderDeliverParam -> {
                    OmsOrderOperateHistory history = new OmsOrderOperateHistory();
                    history.setOrderId(orderDeliverParam.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan("后台管理员");
                    history.setOrderStatus(2);
                    history.setNote("完成发货");
                    return history;
                }).collect(Collectors.toList());
        orderOperateHistoryDao.insertList(operateHistories);
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        OmsOrder record = new OmsOrder();
        record.setDeleteStatus(1);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        return orderMapper.updateByExampleSelective(record,example);
    }

    @Override
    public OmsOrderDetail detail(Long id) {
        return orderDao.getDetail(id);
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        OmsOrder order = new OmsOrder();
        order.setId(id);
        order.setNote(note);
        order.setStatus(status);
        int count = orderMapper.updateByPrimaryKeySelective(order);
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setNote("修改备注信息："+note);
        history.setOrderStatus(status);
        orderOperateHistoryMapper.insert(history);
        return count;
    }
}
