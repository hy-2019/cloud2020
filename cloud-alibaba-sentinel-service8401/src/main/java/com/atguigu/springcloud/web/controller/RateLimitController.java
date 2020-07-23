package com.atguigu.springcloud.web.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.result.ResultEnum;
import com.atguigu.springcloud.util.ResultUtil;
import com.atguigu.springcloud.web.handler.BlockingHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RateLimitController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/21 19:27
 */
@RestController
public class RateLimitController {

    @GetMapping("/tateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = BlockingHandler.class, blockHandler = "exception")
    public CommonResult customerBlockHandler() {
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, "按照客户自定义");
    }
}
