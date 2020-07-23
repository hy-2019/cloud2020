package com.atguigu.springcloud.service;

import com.atguigu.springcloud.repository.domain.PaymentDomain;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.result.ResultEnum;
import com.atguigu.springcloud.util.ResultUtil;
import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/21 21:11
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<PaymentDomain> paymentSql(Long id) {
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, new PaymentDomain().setId(0L).setSerial("fallback"));
    }
}
