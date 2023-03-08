package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.mbg.model.SmsCouponHistory;
import com.kled.service.SmsCouponHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 优惠券领取记录管理SmsCouponHistoryController
 */
@RestController
@RequestMapping("/couponHistory")
@Api(tags = "SmsCouponHistoryController",description = "优惠券领取记录管理")
public class SmsCouponHistoryController {
    @Autowired
    private SmsCouponHistoryService historyService;

    @ApiOperation("根据优惠券id，使用状态，订单编号分页获取优惠券领取记录")
    @GetMapping("/list")
    public CommonResult<CommonPage<SmsCouponHistory>> list(@RequestParam(value = "couponId",required = false)Long couponId,
                                                           @RequestParam(value = "useStatus",required = false)Integer useStatus,
                                                           @RequestParam(value = "orderSn",required = false)String orderSn,
                                                           @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                                           @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
        List<SmsCouponHistory> historyList = historyService.list(couponId, useStatus, orderSn, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(historyList));
    }
}
