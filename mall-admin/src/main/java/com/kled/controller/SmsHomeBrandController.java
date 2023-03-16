package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.mbg.mapper.SmsHomeBrandMapper;
import com.kled.mbg.model.SmsHomeBrand;
import com.kled.service.SmsHomeBrandService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/brand")
public class SmsHomeBrandController {
    @Autowired
    private SmsHomeBrandService homeBrandService;

    @ApiOperation("添加首页品牌推荐")
    @PostMapping("/create")
    public CommonResult create(@RequestBody List<SmsHomeBrand> homeBrand) {
        int count = homeBrandService.create((List<SmsHomeBrand>) homeBrand);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("分页查询品牌推荐")
    @GetMapping("/list")
    public CommonResult<CommonPage<SmsHomeBrand>> list(@RequestParam(value = "brandName", required = false) String brandName,
                                                       @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsHomeBrand> homeBrandList = homeBrandService.list(brandName, recommendStatus, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(homeBrandList));
    }

    @ApiOperation("按id修改首页品牌推荐状态")
    @PostMapping("/update/recommendStatus")
    public CommonResult updateRecommendStatus(@RequestParam List<Long> ids,
                                              @RequestParam Integer recommendStatus) {
        int count = homeBrandService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改品牌推荐排序")
    @PostMapping("/update/sort/{id}")
    public CommonResult updateSort(@PathVariable Long id, Integer sort) {
        int count = homeBrandService.updateSort(id, sort);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除品牌推荐")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam List<Long> ids) {
        int count = homeBrandService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
