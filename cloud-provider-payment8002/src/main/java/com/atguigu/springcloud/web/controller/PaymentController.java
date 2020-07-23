package com.atguigu.springcloud.web.controller;

import com.atguigu.springcloud.repository.domain.PaymentDomain;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.result.ResultEnum;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymenController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/18 10:30
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody PaymentDomain paymentDomain) {
        Integer result = paymentService.create(paymentDomain);
        return result > 0 ? ResultUtil.SUCCESS(ResultEnum.SUCCESS.getCode(), "插入数据库成功,serverPort:" + serverPort) : ResultUtil.Fail(ResultEnum.FAIL.getCode(), "插入数据库失败,serverPort:" + serverPort);
    }

    @GetMapping("/payment/query")
    public CommonResult query() {
        List<PaymentDomain> paymentDomainList = paymentService.query();
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS.getCode(), "查询成功,serverPort:" + serverPort, paymentDomainList);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        PaymentDomain paymentDomain = paymentService.getById(id);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS.getCode(), "查询成功,serverPort:" + serverPort, paymentDomain);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String feignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
