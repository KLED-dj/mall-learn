package com.kled.controller;

import com.kled.common.api.CommonResult;
import com.kled.dto.OssCallbackResult;
import com.kled.dto.OssPolicyResult;
import com.kled.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss相关操作接口
 */
@RestController
@Api(tags = "OssController",description = "Oss管理")
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation(value = "oss上传签名生成")
    @GetMapping("/policy")
    public CommonResult<OssPolicyResult> policy(){
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }


    @ApiOperation(value = "oss上传成功回调")
    @PostMapping("/callbcak")
    public CommonResult<OssCallbackResult> callback(HttpServletRequest request){
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return CommonResult.success(ossCallbackResult);
    }
}
