package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.dto.PmsProductAttributeCategoryItem;
import com.kled.mbg.model.PmsProductAttributeCategory;
import com.kled.service.impl.PmsProductAttributeCategoryServiceImpl;
import com.kled.service.impl.PmsProductAttributeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品属性分类管理Controller
 */
@RestController
@Api(tags = "PmsProductAttributeCategoryController", description = "商品属性分类管理")
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {
    @Autowired
    private PmsProductAttributeCategoryServiceImpl productAttributeCategoryService;

    @ApiOperation("分页获取所有商品属性分类")
    @GetMapping("/list")
    public CommonResult<CommonPage<PmsProductAttributeCategory>> getList(@RequestParam(defaultValue = "5")Integer pageSize,
                                                                         @RequestParam(defaultValue = "1")Integer pageNum){
        List<PmsProductAttributeCategory> productAttributeCategories = productAttributeCategoryService.getList(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productAttributeCategories));
    }

    @ApiOperation("获取所有商品属性分类及其下属性")
    @GetMapping("/list/withAttr")
    public CommonResult<List<PmsProductAttributeCategoryItem>> getListWithAttr(){
        List<PmsProductAttributeCategoryItem> productAttributeCategoryItemList = productAttributeCategoryService.getListWithAttr();
        return CommonResult.success(productAttributeCategoryItemList);
    }


}
