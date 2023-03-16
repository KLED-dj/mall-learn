package com.kled.controller;

import com.kled.common.api.CommonResult;
import com.kled.mbg.model.PmsSkuStock;
import com.kled.service.PmsSkuStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品SKU库存管理Controller
 */
@RestController
@RequestMapping("/sku")
@Api(tags = "PmsSkuStockController",description = "sku商品库存管理")
public class PmsSkuStockController {
    @Autowired
    private PmsSkuStockService skuStockService;

    @GetMapping("/{pid}")
    @ApiOperation("根据商品ID及sku编码模糊搜索sku库存")
    public CommonResult<List<PmsSkuStock>> getList(@PathVariable Long pid,
                                                   @RequestParam(value = "keyword",required = false) String keyword){
        List<PmsSkuStock> skuStockList = skuStockService.getList(pid, keyword);
        return CommonResult.success(skuStockList);
    }

    @PostMapping("/update/{pid}")
    @ApiOperation("批量更新sku库存信息")
    public CommonResult update(@PathVariable Long pid,@RequestBody List<PmsSkuStock> skuStockList){
        int count = skuStockService.update(pid, skuStockList);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

}
