package com.kled.service;

import com.kled.mbg.model.OmsCompanyAddress;

import java.util.List;

/**
 * 收货地址管理
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OmsCompanyAddress> list();
}
