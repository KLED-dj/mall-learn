package com.kled.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/advertise")
@Api(tags = "SmsHomeAdvertiseController",description = "首页轮播广告管理")
public class SmsHomeAdvertiseController {
}
