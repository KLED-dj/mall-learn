package com.kled.controller;

import com.kled.common.api.CommonResult;
import com.kled.mbg.model.UmsResource;
import com.kled.service.UmsResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resource")
@Api(tags = "umsResourceController",description = "后台资源管理")
public class UmsResourceController {
    @Autowired
    private UmsResourceService resourceService;


    @ApiOperation("查询所有后台资源")
    @GetMapping("/listAll")
    public CommonResult<List<UmsResource>> listAll(){
        List<UmsResource> resourceList = resourceService.listAll();
        return CommonResult.success(resourceList);
    }
}
