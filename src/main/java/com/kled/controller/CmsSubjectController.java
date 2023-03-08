package com.kled.controller;

import com.kled.common.api.CommonPage;
import com.kled.common.api.CommonResult;
import com.kled.mbg.model.CmsSubject;
import com.kled.service.CmsSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "CmsSubjectController",description = "商品专题管理")
@RequestMapping("/subject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService subjectService;

    @ApiOperation("获取全部商品专题")
    @GetMapping("/listAll")
    public CommonResult<List<CmsSubject>> listAll(){
        List<CmsSubject> subjectList = subjectService.listAll();
        return CommonResult.success(subjectList);
    }

    @ApiOperation("分页获取专题")
    @GetMapping("/list")
    public CommonResult<CommonPage<CmsSubject>> list(@RequestParam(value = "keyword",required = false)String keyword,
                                                     @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                                     @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
        List<CmsSubject> subjectList = subjectService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(subjectList));

    }
}
