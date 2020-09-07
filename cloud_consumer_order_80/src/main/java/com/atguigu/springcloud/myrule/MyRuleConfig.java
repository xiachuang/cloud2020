package com.atguigu.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRuleConfig {
    /*
    设置Ribbon负载均衡算法的默认算法
    不再Component注解夏
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();//随机算法
    }
}
