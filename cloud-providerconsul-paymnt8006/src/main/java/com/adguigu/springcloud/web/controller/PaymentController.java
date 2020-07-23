package com.adguigu.springcloud.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/18 20:00
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "springcloud with consul:" + serverport + "\t" + UUID.randomUUID().toString();
    }
}
