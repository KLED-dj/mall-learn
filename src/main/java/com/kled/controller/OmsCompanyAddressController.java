package com.kled.controller;

import com.kled.common.api.CommonResult;
import com.kled.mbg.model.OmsCompanyAddress;
import com.kled.service.OmsCompanyAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "OmsCompanyAddressController",description = "收货地址管理")
@RestController
@RequestMapping("/companyAddress")
public class OmsCompanyAddressController {
    @Autowired
    private OmsCompanyAddressService companyAddressService;

    @ApiOperation("获取所有收货地址")
    @GetMapping("/list")
    public CommonResult<List<OmsCompanyAddress>> list(){
        List<OmsCompanyAddress> companyAddressList = companyAddressService.list();
        return CommonResult.success(companyAddressList);
    }
}
