package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.mbg.model.SmsHomeAdvertise;
import com.kled.service.SmsHomeAdvertiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/advertise")
@Api(tags = "SmsHomeAdvertiseController", description = "首页轮播广告管理")
public class SmsHomeAdvertiseController {
    @Autowired
    private SmsHomeAdvertiseService advertiseService;

    @ApiOperation("分页查询广告")
    @GetMapping("/list")
    public CommonResult<CommonPage<SmsHomeAdvertise>> list(@RequestParam(value = "name", required = false) String name,
                                                           @RequestParam(value = "type", required = false) Integer type,
                                                           @RequestParam(value = "endTime", required = false) String endTime,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsHomeAdvertise> homeAdvertiseList = advertiseService.list(name, type, endTime, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(homeAdvertiseList));
    }

    @ApiOperation("批量删除")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam List<Long> ids) {
        int count = advertiseService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改上下线状态")
    @PostMapping("/update/status/{id}")
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam Integer status) {
        int count = advertiseService.updateStatus(id, status);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取广告详情")
    @GetMapping("/{id}")
    public CommonResult<SmsHomeAdvertise> getItem(@PathVariable Long id) {
        SmsHomeAdvertise advertiseServiceItem = advertiseService.getItem(id);
        return CommonResult.success(advertiseServiceItem);
    }

    @ApiOperation("更新广告")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody SmsHomeAdvertise Advertise) {
        int count = advertiseService.update(id, Advertise);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("添加广告")
    @PostMapping("/create")
    public CommonResult create(@RequestBody SmsHomeAdvertise advertise){
        int count = advertiseService.create(advertise);
        if (count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
