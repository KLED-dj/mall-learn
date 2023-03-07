package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.dto.OmsReturnApplyQueryParam;
import com.kled.dto.OmsUpdateStatusParam;
import com.kled.mbg.model.OmsOrderReturnApply;
import com.kled.service.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "OmsOrderReturnApplyController", description = "订单退货申请管理")
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {
    @Autowired
    private OmsOrderReturnApplyService returnApplyService;

    @ApiOperation("退货申请数据列表")
    @GetMapping("/list")
    public CommonResult list(OmsReturnApplyQueryParam returnApplyQueryParam,
                             @RequestParam("pageSize") Integer pageSize,
                             @RequestParam("pageNum") Integer pageNum){
        List<OmsOrderReturnApply> returnApplyList = returnApplyService.list(returnApplyQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(returnApplyList));
    }


    @ApiOperation("获取退货申请详情")
    @GetMapping("/{id}")
    public CommonResult getItem(@PathVariable Long id){
        OmsOrderReturnApply result = returnApplyService.getItem(id);
        return CommonResult.success(result);
    }

    @ApiOperation("修改退货申请状态")
    @PostMapping("/update/status/{id}")
    public CommonResult updateStatus(@PathVariable Long id,
                                     @RequestBody OmsUpdateStatusParam statusParam){
        int count = returnApplyService.updateStatus(id, statusParam);
        if (count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
