package com.atguigu.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.repository.domain.PaymentDomain;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.result.ResultEnum;
import com.atguigu.springcloud.util.ResultUtil;

/**
 * @ClassName BlockingHandler
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/21 20:33
 */
public class BlockingHandler {

    public static CommonResult<PaymentDomain> blockingHandler(BlockException blockException, Long id) {
        return ResultUtil.Fail(ResultEnum.FAIL.getCode(), "BlockingHandler异常id:" + id);
    }
}
