package com.atguigu.springcloud.web.controller;

import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName CircleBreakerController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/21 20:08
 */
@RestController
public class CircleBreakerController {
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private PaymentService paymentService;


    @GetMapping("/query/{id}")
    public CommonResult query(@PathVariable("id") Long id) {
        return paymentService.paymentSql(id);
    }
}
