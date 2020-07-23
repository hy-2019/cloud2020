package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/19 16:10
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "$$$$$$$$$$$$$$$$$$$$$$paymentInfoOk,服务降级成功&&&&&&&&&&&&&&&&&&&&";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "%%%%%%%%%%%%%%%%%%%%%%paymentInfoTimeout服务降级成功%%%%%%%%%%%%%%%%%%%%%%%%%%%%%";
    }
}
