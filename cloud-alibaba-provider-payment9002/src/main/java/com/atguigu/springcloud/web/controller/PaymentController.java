package com.atguigu.springcloud.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/21 10:07
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getpayment(@PathVariable("id") Integer id) {
        return "nacos registry,server port:" + serverPort + "$$$$$$$$$$" + id;
    }
}
