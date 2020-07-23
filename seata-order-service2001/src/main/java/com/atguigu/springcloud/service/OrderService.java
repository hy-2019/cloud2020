package com.atguigu.springcloud.service;

import com.atguigu.springcloud.repository.domain.Order;
import com.atguigu.springcloud.result.CommonResult;

public interface OrderService {

    CommonResult queryById(Long id);

    CommonResult create(Order order);
}
