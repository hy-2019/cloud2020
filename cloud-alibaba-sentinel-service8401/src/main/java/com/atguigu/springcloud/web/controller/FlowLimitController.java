package com.atguigu.springcloud.web.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FlowLimitController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/21 14:23
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "###############testA";
    }

    @GetMapping("testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "8************testBB");
        return "%%%%%%%%%%%%testB";
    }

    @GetMapping("testD")
    public String testD() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName()+"8************testD测试RT");*/
        int age = 10 / 0;
        log.info("testD异常比列");
        return "%%%%%%%%%%%%testD";
    }

    @GetMapping("testE")
    public String testE() {
        log.info("testD异常数");
        int age = 10 / 0;
        return "%%%%%%%%%%%%testB";
    }

    @GetMapping(value = "/testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "dealTestHotkey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int age = 10 / 0;
        return "---------------testHotkey";
    }

    public String dealTestHotkey(String p1, String p2, BlockException exception) {
        return "------deal_testHotkey,&&&&&&&&&";
    }
}
