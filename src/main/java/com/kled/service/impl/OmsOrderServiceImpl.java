package com.kled.service.impl;

import com.github.pagehelper.PageHelper;
import com.kled.dao.OmsOrderDao;
import com.kled.dto.OmsOrderQueryParam;
import com.kled.mbg.model.OmsOrder;
import com.kled.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderDao orderDao;

    @Override
    public List<OmsOrder> list(OmsOrderQueryParam omsOrderQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return orderDao.getList(omsOrderQueryParam);
    }
}
