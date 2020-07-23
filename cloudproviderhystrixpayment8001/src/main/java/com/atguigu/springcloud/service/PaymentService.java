package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName OrderHystrixService
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/19 13:42
 */
@Service
public class PaymentService {
    //服务降级
    public String paymentInfoOk(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_ok,id:" + id + "\t" + "O(∩_∩)O哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // int a = 10 / 0;
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_timeout,id:" + id + "\t" + "O(∩_∩)O哈哈,超时";
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "8001系统出错,服务降级,运行异常,id:" + id + "\t" + "超时了";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("***********id不能为负数************");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号:" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        if (id < 0) {
            throw new RuntimeException("***********id不能为负数************");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "id不能为负数,请稍后重试****************";
    }


}
