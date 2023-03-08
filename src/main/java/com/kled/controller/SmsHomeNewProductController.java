package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.mbg.model.SmsHomeNewProduct;
import com.kled.service.SmsHomeNewProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/newProduct")
@Api(value = "SmsHomeNewProductController", description = "首页新品管理")
public class SmsHomeNewProductController {
    @Autowired
    private SmsHomeNewProductService productService;

    @ApiOperation("分页查询首页新品推荐列表")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "productName", required = false) String productName,
                             @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsHomeNewProduct> homeNewProductList = productService.list(productName, recommendStatus, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(homeNewProductList));
    }

    @ApiOperation("添加首页新品推荐")
    @PostMapping("/create")
    public CommonResult create(@RequestBody List<SmsHomeNewProduct> homeNewProductsList) {
        int count = productService.create(homeNewProductsList);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量更改首页新品推荐状态")
    @PostMapping("/update/recommendStatus")
    public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                              @RequestParam("recommendStatus") Integer recommendStatus) {
        int count = productService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("更改首页新品排序")
    @PostMapping("/update/sort/{id}")
    public CommonResult updateSort(@PathVariable Long id,
                                   @RequestParam Integer sort) {
        int count = productService.updateSort(id, sort);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam List<Long> ids) {
        int count = productService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
