package com.atguigu.springcloud.web.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.handler.BlockingHandler;
import com.atguigu.springcloud.handler.FallbackHandler;
import com.atguigu.springcloud.repository.domain.PaymentDomain;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.result.ResultEnum;
import com.atguigu.springcloud.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/21 19:53
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, PaymentDomain> map = new HashMap<>();

    static {
        map.put(1L, new PaymentDomain().setId(1L).setSerial(IdUtil.simpleUUID()));
        map.put(2L, new PaymentDomain().setId(2L).setSerial(IdUtil.simpleUUID()));
        map.put(3L, new PaymentDomain().setId(3L).setSerial(IdUtil.simpleUUID()));
    }

    @GetMapping(value = "/paymentSql/{id}")
    /*@SentinelResource(value = "paymentSql",
            blockHandlerClass = BlockingHandler.class, blockHandler = "blockingHandler",
            fallbackClass = FallbackHandler.class, fallback = "falback", exceptionsToIgnore = Exception.class)*/
    public CommonResult<PaymentDomain> paymentSql(@PathVariable("id") Long id) {
        log.info("server port:" + serverPort);
        PaymentDomain paymentDomain = map.get(id);
        Long id1 = paymentDomain.getId();
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, map.get(id));
    }
}
