package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.component.DynamicSecurityMetadataSource;
import com.kled.mbg.model.UmsResource;
import com.kled.service.UmsResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
@Api(tags = "umsResourceController", description = "后台资源管理")
public class UmsResourceController {
    @Autowired
    private UmsResourceService resourceService;
    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;


    @ApiOperation("查询所有后台资源")
    @GetMapping("/listAll")
    public CommonResult<List<UmsResource>> listAll() {
        List<UmsResource> resourceList = resourceService.listAll();
        return CommonResult.success(resourceList);
    }

    @ApiOperation("分页查询后台资源")
    @GetMapping("/list")
    public CommonResult<CommonPage<UmsResource>> list(@RequestParam(value = "categoryId", required = false) Long categoryId,
                                                      @RequestParam(value = "nameKeyword", required = false) String nameKeyword,
                                                      @RequestParam(value = "urlKeyword", required = false) String urlKeyword,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsResource> resourceList = resourceService.list(categoryId, nameKeyword, urlKeyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(resourceList));
    }

    @ApiOperation("添加资源")
    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsResource umsResource) {
        int count = resourceService.create(umsResource);
//        dynamicSecurityMetadataSource.clearDataSource();
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
