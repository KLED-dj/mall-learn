package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.mbg.model.OmsOrderReturnReason;
import com.kled.service.OmsOrderReturnReasonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 退货原因管理Controller
 */
@RestController
@Api(tags = "OmsOrderReturnReasonController", description = "退货原因管理")
@RequestMapping("/returnReason")
public class OmsOrderReturnReasonController {
    @Autowired
    private OmsOrderReturnReasonService returnReasonService;

    @ApiOperation("分页查询退货原因")
    @GetMapping("/list")
    public CommonResult<CommonPage<OmsOrderReturnReason>> list(@RequestParam("pageSize") Integer pageSize,
                                                               @RequestParam("pageNum") Integer pageNum) {
        List<OmsOrderReturnReason> returnReasonList = returnReasonService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(returnReasonList));
    }

    @ApiOperation("添加退货原因")
    @PostMapping("/create")
    public CommonResult create(@RequestBody OmsOrderReturnReason orderReturnReason) {
        int count = returnReasonService.create(orderReturnReason);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("更改可用状态")
    @PostMapping("/update/status")
    public CommonResult updateStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("status") Integer status) {
        int count = returnReasonService.updateStatus(ids, status);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取指定的详细信息")
    @GetMapping("/{id}")
    public CommonResult<OmsOrderReturnReason> getItem(@PathVariable Long id) {
        OmsOrderReturnReason reason = returnReasonService.getItem(id);
        return CommonResult.success(reason);
    }

    @ApiOperation("根据id更改详细信息")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id,
                               @RequestBody OmsOrderReturnReason returnReason) {
        int count = returnReasonService.update(id, returnReason);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = returnReasonService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
