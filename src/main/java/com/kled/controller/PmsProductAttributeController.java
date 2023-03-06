package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.dto.ProductAttrInfo;
import com.kled.mbg.model.PmsProductAttribute;
import com.kled.service.PmsProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productAttribute")
@Api(tags = "PmsProductAttributeController",description = "商品属性管理")
public class PmsProductAttributeController {
    @Autowired
    PmsProductAttributeService productAttributeService;

    @ApiOperation("根据分类查询属性列表或参数列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "type",value = "0表示属性，1表示参数",required = true,paramType = "query",dataType = "integer")})
    @GetMapping("/list/{cid}")
    public CommonResult<CommonPage<PmsProductAttribute>> getList(@PathVariable Long cid,
                                                                 @RequestParam(value = "type")Integer type,
                                                                 @RequestParam(value = "pageSize" ,defaultValue = "5")Integer pageSize,
                                                                 @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
        List<PmsProductAttribute> productAttributeList = productAttributeService.getList(cid, type, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productAttributeList));
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @GetMapping("/attrInfo/{productCategoryId}")
    public CommonResult<List<ProductAttrInfo>> getAttrInfo(@PathVariable Long productCategoryId){
        List<ProductAttrInfo> productAttrInfoList = productAttributeService.getProductAttributeInfo(productCategoryId);
        return CommonResult.success(productAttrInfoList);
    }
}
