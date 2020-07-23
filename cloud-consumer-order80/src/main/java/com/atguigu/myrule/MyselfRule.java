package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyselfRule
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/18 20:56
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();//定义为随机
    }
}
