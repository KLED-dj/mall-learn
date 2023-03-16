package com.kled.controller;

import com.kled.common.api.CommonResult;
import com.kled.mbg.model.CmsPrefrenceArea;
import com.kled.service.CmsPrefrenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品优选管理
 */
@RestController
@Api(tags = "CmsPrefrenceAreaController" ,description = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {
    @Autowired
    private CmsPrefrenceAreaService prefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @GetMapping("/listAll")
    public CommonResult<List<CmsPrefrenceArea>> listAll(){
        List<CmsPrefrenceArea> prefrenceAreasList = prefrenceAreaService.listAll();
        return CommonResult.success(prefrenceAreasList);
    }
}
