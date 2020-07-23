package com.atguigu.springcloud.repository.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName Order
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/23 9:13
 */
@Data
public class Order {
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    private Integer status;
}
