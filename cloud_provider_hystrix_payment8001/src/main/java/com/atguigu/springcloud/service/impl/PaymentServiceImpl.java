package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    public int serverPort=0;
    @Override
    public String paymentInfo_Ok(Integer id) {

        return "线程"+Thread.currentThread().getName()+" payment_id:"+id+" port: "+serverPort+"通过！！";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")//设置等待时间
    })
    public String paymentInfo_TimeOut(Integer id) {
        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        //int a=10/0;
        return "线程"+Thread.currentThread().getName()+" payment_id:"+id+" port: "+serverPort+"不通过"+"耗时3秒";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程"+Thread.currentThread().getName()+" payment_id:"+id+" port: "+serverPort+"请等下在试";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "8"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")// 失败率达到多少后跳闸

    })
    public String paymentInfoCircuitBreaker(@PathVariable("id") Integer id) {
        if(id<0){
            throw new RuntimeException("***不能小于0");
        }
        String serialName= IdUtil.randomUUID();
        return Thread.currentThread().getName()+"流水号："+serialName;
    }

    public String paymentInfoCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return Thread.currentThread().getName()+"  输入错误请稍后再试一试";
    }
    @Override
    public String orderInfoCircuitBreaker(Integer id) {
        return null;
    }
}
