package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.mbg.model.SmsHomeRecommendProduct;
import com.kled.service.SmsHomeRecommendProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/recommendProduct")
@Api(tags = "SmsHomeRecommendProductController", description = "首页人气推荐管理")
public class SmsHomeRecommendProductController {
    @Autowired
    private SmsHomeRecommendProductService recommendProductService;

    @ApiOperation("分页查询首页人气列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<SmsHomeRecommendProduct>> list(@RequestParam(value = "productName", required = false) String productName,
                                                                  @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsHomeRecommendProduct> homeRecommendProductList = recommendProductService.list(productName, recommendStatus, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(homeRecommendProductList));
    }

    @ApiOperation("添加首页人气推荐商品")
    @PostMapping("/create")
    public CommonResult create(@RequestBody List<SmsHomeRecommendProduct> homeRecommendProductList) {
        int count = recommendProductService.create(homeRecommendProductList);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("更改人气商品排序")
    @PostMapping("/update/sort/{id}")
    public CommonResult updateSort(@PathVariable Long id,Integer sort){
        int count = recommendProductService.updateSort(id, sort);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量更新新品推荐状态")
    @PostMapping("/update/recommendStatus")
    public CommonResult updateRecommendStatus(@RequestParam("ids")List<Long> ids,
                                              @RequestParam("recommendStatus")Integer recommendStatus){
        int count = recommendProductService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除首页人气商品")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam List<Long> ids){
        int count = recommendProductService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
