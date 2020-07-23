package com.atguigu.springcloud.web.controller;

import com.atguigu.springcloud.repository.domain.PaymentDomain;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderFeignController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/19 12:37
 */
@RestController
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<PaymentDomain> getPayment(@PathVariable("id") Long id) {
        CommonResult commonResult = paymentFeignService.get(id);
        return commonResult;
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String feignTimeout() {
        return paymentFeignService.feignTimeout();
    }
}
