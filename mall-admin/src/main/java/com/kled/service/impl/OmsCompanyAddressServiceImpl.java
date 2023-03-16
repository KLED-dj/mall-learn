package com.kled.service.impl;

import com.kled.mbg.mapper.OmsCompanyAddressMapper;
import com.kled.mbg.model.OmsCompanyAddress;
import com.kled.mbg.model.OmsCompanyAddressExample;
import com.kled.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;

    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
