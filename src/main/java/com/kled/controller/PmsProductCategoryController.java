package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.dto.PmsProductCategoryParam;
import com.kled.dto.PmsProductCategoryWithChildrenItem;
import com.kled.mbg.model.PmsProductCategory;
import com.kled.service.PmsProductCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {
    @Autowired
    private PmsProductCategoryService productCategoryService;

    @PostMapping("/create")
    @ApiOperation("新建商品分类")
    public CommonResult create(@Validated @RequestBody PmsProductCategoryParam pmsProductCategoryParam) {
        int count = productCategoryService.create(pmsProductCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }

    }

    @GetMapping("/list/{parentId}")
    @ApiOperation("分页查询商品分类")
    public CommonResult<CommonPage<PmsProductCategory>> getList(@PathVariable Long parentId,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProductCategory> productCategoryList = productCategoryService.getList(parentId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productCategoryList));
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id获取商品分类")
    public CommonResult<PmsProductCategory> getItem(@PathVariable Long id) {
        PmsProductCategory productCategory = productCategoryService.getItem(id);
        return CommonResult.success(productCategory);
    }

    @ApiOperation("修改商品分类")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id,
                               @Validated
                               @RequestBody PmsProductCategoryParam productCategoryParam) {
        int count = productCategoryService.update(id, productCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


    @ApiOperation("查询所有一级分类及子分类")
    @GetMapping("/list/withChildren")
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> listWithChildren() {
        List<PmsProductCategoryWithChildrenItem> list = productCategoryService.listWithChildren();
        return CommonResult.success(list);
    }

    @PostMapping("/update/navStatus")
    @ApiOperation("修改导肮显示状态")
    public CommonResult updateNavStatus(@RequestParam("ids") List<Long> ids, @RequestParam("navStatus") Integer navStatus) {
        int count = productCategoryService.updateNavStatus(ids, navStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping("/update/showStatus")
    @ApiOperation("修改显示状态")
    public CommonResult updateShowStatus(@RequestParam("ids") List<Long> ids, @RequestParam("showStatus") Integer showStatus) {
        int count = productCategoryService.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}


