package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentTicketService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
@Service
@DefaultProperties(defaultFallback = "fallback")
public class PaymentTicketServiceImpl implements PaymentTicketService {
    @Resource
    private PaymentTicketService paymentTicketService;
    @Override
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
    public String getPaymentTicketServiceById(Integer id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程："+Thread.currentThread().getName()+"服务短线失败了！请稍后再试！"+id);
        return ("线程："+Thread.currentThread().getName()+"不通过"+id);
    }
    @Override
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "8"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")// 失败率达到多少后跳闸
    })
    public String updateTicket(@PathVariable("name") String name) {
        if(!name.equals("xia")){
            int a=10/0;
            System.out.println("线程："+Thread.currentThread().getName()+"更改信息错误请重新再试一试");
            return ("线程："+Thread.currentThread().getName()+"更改信息错误");
        }
        String uuid= IdUtil.randomUUID();
        System.out.println("访问成功！！"+uuid);
        return ("访问成功！！"+uuid);
    }
    public String fallback(){
        return "请稍后再试！服务器繁忙";
    }
}
