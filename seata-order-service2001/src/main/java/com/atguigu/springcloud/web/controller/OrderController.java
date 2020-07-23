package com.atguigu.springcloud.web.controller;

import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/23 9:09
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id) {
        return orderService.queryById(id);
    }

}
