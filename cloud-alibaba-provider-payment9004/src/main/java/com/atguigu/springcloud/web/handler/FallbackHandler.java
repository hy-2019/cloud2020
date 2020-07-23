package com.atguigu.springcloud.web.handler;

import com.atguigu.springcloud.repository.domain.PaymentDomain;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.result.ResultEnum;
import com.atguigu.springcloud.util.ResultUtil;

/**
 * @ClassName FallbackHandler
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/21 20:33
 */
public class FallbackHandler {

    public static CommonResult<PaymentDomain> falback(Long id) {
        return ResultUtil.Fail(ResultEnum.FAIL.getCode(), "FallbackHandler异常id:" + id);
    }
}
