package com.atguigu.springcloud.web.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SendMessageController
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/20 19:24
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "/send/message")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
