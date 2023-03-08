package com.kled.controller;

import com.kled.common.api.CommonResult;
import com.kled.mbg.model.UmsRole;
import com.kled.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(tags = "UmsRoleController",description = "后台用户角色管理")
public class UmsRoleController {
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("获取所有角色")
    @GetMapping("/listAll")
    public CommonResult<List<UmsRole>> listAll(){
        List<UmsRole> roleList = roleService.list();
        return CommonResult.success(roleList);
    }
}
