package com.atguigu.springcloud.web.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/19 14:13
 */
@RestController
/*@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")*/
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        return paymentService.paymentInfoOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   /* @HystrixCommand(fallbackMethod = "paymentTimeout", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    /*@HystrixCommand*/
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        /*int a = 10 / 0;*/
        return paymentService.paymentInfoTimeout(id);
    }


    public String paymentTimeout(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙,请10秒后再重试" + "&&&&&&&&&&&&&" + id + "$$$$$$$$$$$$$$$$$$$$$$$$";
    }


    //全局fallback方法
    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息,请稍后重试";
    }
}
