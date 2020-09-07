package com.atguigu.springcloud.cloud_consumer_order_80.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//自定义负载均衡算法
@Component
public class MyLB implements LoadBalance {
    private AtomicInteger atomicInteger=new AtomicInteger(0);//原子性
        /*
        atomicInteger的值与expectedValue相比较，如果不相等，则返回false,
        atomicInteger原有值保持不变；如果两者相等，则返回true,atomicInteger的值更新为newValue
         */
    public final  int chose(){//算法选择
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current>=2147483647? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("访问次数"+next);
        return next;
    }



    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index=chose()%serviceInstances.size();//通过取模 获得服务起容器下标
        return serviceInstances.get(index);//获得当前服务器
    }
}
