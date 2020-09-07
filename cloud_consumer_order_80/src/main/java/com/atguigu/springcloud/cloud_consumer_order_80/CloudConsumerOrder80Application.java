package com.atguigu.springcloud.cloud_consumer_order_80;

import com.atguigu.springcloud.myrule.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "CLOUD-PAYNAME-SERVER",configuration = MyRuleConfig.class) // 启用自定义负载均衡算法时  需要将该注解注释

public class CloudConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80Application.class, args);
    }

}
