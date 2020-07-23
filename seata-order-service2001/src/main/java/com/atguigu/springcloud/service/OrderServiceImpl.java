package com.atguigu.springcloud.service;

import com.atguigu.springcloud.repository.dao.OrderMapper;
import com.atguigu.springcloud.repository.domain.Order;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.result.ResultEnum;
import com.atguigu.springcloud.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/23 9:09
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;


    @Override
    public CommonResult queryById(Long id) {
        Order order = orderMapper.selectById(id);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, order);
    }

    @Override
    public CommonResult create(Order order) {
        log.info("------------------->开始新建订单");
        orderMapper.insert(order);
        log.info("---------------订单微服务开始调用库存,做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------------------------->订单微服务开始调用库存,做扣减结束");

        log.info("---------------订单微服务开始调用用户账户,做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
}
