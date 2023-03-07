package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.dto.OmsOrderDeliverParam;
import com.kled.dto.OmsOrderDetail;
import com.kled.dto.OmsOrderQueryParam;
import com.kled.mbg.model.OmsOrder;
import com.kled.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "OmsOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService orderService;


    @ApiOperation("查询订单列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<OmsOrder>> list(OmsOrderQueryParam orderQueryParam,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = orderService.list(orderQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation("批量发货")
    @PostMapping("/update/delivery")
    public CommonResult delivery(@RequestBody List<OmsOrderDeliverParam> orderDeliverParams) {
        int count = orderService.delivery(orderDeliverParams);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除订单")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam List<Long> ids) {
        int count = orderService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取指定订单详情:订单信息、商品信息、操作记录")
    @GetMapping("/{id}")
    public CommonResult detail(@PathVariable Long id) {
        OmsOrderDetail detail = orderService.detail(id);
        return CommonResult.success(detail);
    }

    @ApiOperation("修改备注订单")
    @PostMapping("/update/note")
    public CommonResult updateNote(@RequestParam("id") Long id,
                                   @RequestParam("note") String note,
                                   @RequestParam("status") Integer status) {
        int count = orderService.updateNote(id, note, status);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


}
