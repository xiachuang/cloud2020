package com.atguigu.springcloud.cloud_consumer_order_80.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @LoadBalanced  //启用自定义 负载均衡算法时 需要将该注解  注释掉
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
