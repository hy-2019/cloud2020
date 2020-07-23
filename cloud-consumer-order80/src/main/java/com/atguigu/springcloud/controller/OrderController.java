package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.lb.LoadBalancer;
import com.atguigu.springcloud.repository.domain.PaymentDomain;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.result.ResultEnum;
import com.atguigu.springcloud.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/18 13:51
 */
@RestController
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public CommonResult<PaymentDomain> create(@RequestBody PaymentDomain paymentDomain) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", paymentDomain, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<PaymentDomain> query(@PathVariable("id") Long id) {
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return commonResult;
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<PaymentDomain> getPaymentEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (commonResultResponseEntity.getStatusCode().is2xxSuccessful()) {
            return commonResultResponseEntity.getBody();
        } else {
            return ResultUtil.Fail(ResultEnum.FAIL);
        }

    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBalancer.instances(instances);
        URI uri = instance.getUri();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri + "payment/lb", String.class);

        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return "调用失败";
        }

    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject(  "http://localhost:8001//payment/zipkin", String.class);
    }
}
