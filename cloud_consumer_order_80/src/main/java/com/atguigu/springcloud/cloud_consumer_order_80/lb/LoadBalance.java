package com.atguigu.springcloud.cloud_consumer_order_80.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
