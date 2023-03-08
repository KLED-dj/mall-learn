package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.dto.SmsCouponParam;
import com.kled.mbg.model.SmsCoupon;
import com.kled.service.SmsCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
@Api(tags = "SmsCouponController", description = "优惠券管理")
public class SmsCouponController {
    @Autowired
    private SmsCouponService couponService;

    @ApiOperation("根据优惠券名称和类型分页获取优惠券列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<SmsCoupon>> list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                    @RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "type", required = false) Integer type) {
        List<SmsCoupon> couponList = couponService.list(pageSize, pageNum, name, type);
        return CommonResult.success(CommonPage.restPage(couponList));
    }

    @ApiOperation("添加优惠券")
    @PostMapping("/create")
    public CommonResult add(@RequestBody SmsCouponParam couponParam) {
        int count = couponService.create(couponParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取单个优惠券的详细信息")
    @GetMapping("/{id}")
    public CommonResult<SmsCouponParam> getItem(@PathVariable Long id){
        SmsCouponParam couponParam = couponService.getItem(id);
        return CommonResult.success(couponParam);
    }


}
