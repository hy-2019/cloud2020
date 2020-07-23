package com.atguigu.springcloud.web.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.result.ResultEnum;
import com.atguigu.springcloud.util.ResultUtil;

/**
 * @ClassName BlockingHandler
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/21 19:30
 */
public class BlockingHandler {
    public static CommonResult exception(BlockException exception) {
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, "限流方法111111111");
    }

    public static CommonResult exception2(BlockException exception) {
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, "限流方法$$$$$$$$$$$$2222");
    }
}
