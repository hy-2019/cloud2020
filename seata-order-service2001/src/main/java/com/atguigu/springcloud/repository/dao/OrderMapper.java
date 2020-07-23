package com.atguigu.springcloud.repository.dao;

import com.atguigu.springcloud.repository.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName OrderMapper
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/23 9:11
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {
}
