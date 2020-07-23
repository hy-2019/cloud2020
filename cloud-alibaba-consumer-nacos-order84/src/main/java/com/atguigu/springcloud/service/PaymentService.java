package com.atguigu.springcloud.service;

import com.atguigu.springcloud.repository.domain.PaymentDomain;
import com.atguigu.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentServiceImpl.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult<PaymentDomain> paymentSql(@PathVariable("id") Long id);
}
