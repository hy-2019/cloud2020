package com.atguigu.springcloud.service;

import com.atguigu.springcloud.repository.domain.PaymentDomain;
import com.atguigu.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @PostMapping("/payment/create")
    CommonResult create(@RequestBody PaymentDomain paymentDomain);

    @GetMapping("/payment/query")
    CommonResult query();

    @GetMapping("/payment/get/{id}")
    CommonResult get(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String feignTimeout();
}
