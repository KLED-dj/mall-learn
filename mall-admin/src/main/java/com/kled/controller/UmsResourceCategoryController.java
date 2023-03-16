package com.kled.controller;

import com.kled.common.api.CommonResult;
import com.kled.mbg.model.UmsResourceCategory;
import com.kled.service.UmsResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "UmsResourceCategoryController",description = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService resourceCategoryService;

    @ApiOperation("获取所有资源分类")
    @GetMapping("/listAll")
    public CommonResult<List<UmsResourceCategory>> listAll(){
        List<UmsResourceCategory> resourceCategoryList = resourceCategoryService.listAll();
        return CommonResult.success(resourceCategoryList);
    }
}
