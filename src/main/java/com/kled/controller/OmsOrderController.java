package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.dto.OmsOrderQueryParam;
import com.kled.mbg.model.OmsOrder;
import com.kled.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "OmsOrderController",description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService orderService;


    @ApiOperation("查询订单列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<OmsOrder>> list(OmsOrderQueryParam orderQueryParam,
                                                   @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                                   @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
        List<OmsOrder> orderList = orderService.list(orderQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }
}
