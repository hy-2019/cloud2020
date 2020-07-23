package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @ClassName IMessageProviderImpl
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/20 19:18
 */
@EnableBinding(Source.class)   //定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {
    @Autowired
    private MessageChannel output;    //消息发送管道

    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("########################seria" + serial);
        return serial;
    }
}
