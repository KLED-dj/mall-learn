package com.kled.service.impl;

import com.github.pagehelper.PageHelper;
import com.kled.dao.OmsOrderReturnApplyDao;
import com.kled.dto.OmsReturnApplyQueryParam;
import com.kled.mbg.model.OmsOrderReturnApply;
import com.kled.service.OmsOrderReturnApplyService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {
    @Autowired
    private OmsOrderReturnApplyDao returnApplyDao;

    @Override
    public List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam returnApplyQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return returnApplyDao.getList(returnApplyQueryParam);
    }

    @Override
    public OmsOrderReturnApply getItem(Long id) {
        return returnApplyDao.getDetail(id);
    }
}
