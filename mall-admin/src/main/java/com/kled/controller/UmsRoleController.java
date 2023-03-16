package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.mbg.model.UmsAdmin;
import com.kled.mbg.model.UmsMenu;
import com.kled.mbg.model.UmsResource;
import com.kled.mbg.model.UmsRole;
import com.kled.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(tags = "UmsRoleController", description = "后台用户角色管理")
public class UmsRoleController {
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("获取所有角色")
    @GetMapping("/listAll")
    public CommonResult<List<UmsRole>> listAll() {
        List<UmsRole> roleList = roleService.list();
        return CommonResult.success(roleList);
    }

    @ApiOperation("分页查询角色")
    @GetMapping("/list")
    public CommonResult<CommonPage<UmsRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsRole> list = roleService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("添加角色")
    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsRole role) {
        int count = roleService.create(role);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取角色相关菜单")
    @GetMapping("/listMenu/{roleId}")
    public CommonResult<List<UmsMenu>> listMenu(@PathVariable Long roleId) {
        List<UmsMenu> roleList = roleService.listMenu(roleId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("给角色分配菜单")
    @PostMapping("/allocMenu")
    public CommonResult allocMenu(@RequestParam("roleId") Long roleId, @RequestParam("menuIds") List<Long> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        return CommonResult.success(count);
    }

    @ApiOperation("获取角色相关资源")
    @GetMapping("/listResource/{roleId}")
    public CommonResult<List<UmsResource>> listResource(@PathVariable Long roleId) {
        List<UmsResource> roleList = roleService.listResource(roleId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("给角色分配资源")
    @PostMapping("/allocResource")
    public CommonResult allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        int count = roleService.allocResource(roleId, resourceIds);
        return CommonResult.success(count);
    }

    @ApiOperation("修改角色")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody UmsRole role) {
        int count = roleService.update(id, role);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除角色")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = roleService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("更改角色启动状态")
    @PostMapping("/updateStatus/{id}")
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam("status") Integer status) {
        UmsRole role = new UmsRole();
        role.setStatus(status);
        int count = roleService.update(id, role);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
