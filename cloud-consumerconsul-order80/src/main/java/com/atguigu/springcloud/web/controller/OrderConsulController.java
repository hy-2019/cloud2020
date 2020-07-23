package com.atguigu.springcloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderConsulController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/18 20:10
 */
@RestController
public class OrderConsulController {

    private static final String INVOKE_URL = "http://consul-provider-payment";

    private RestTemplate restTemplate;

    @Autowired
    public OrderConsulController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/consumer/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }
}
