package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.impl.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@DefaultProperties(defaultFallback = "")
public class OrderController {
    @Resource
    private PaymentHystrixService paymentHystrixService;
    @GetMapping("/order/payment/hystrix/ok/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2500")
    })
    public String paymentInfoOk(@PathVariable("id")Integer id){
        return paymentHystrixService.paymentInfoOk(2);
    }
    @GetMapping("/order/payment/hystrix/timeout/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfoTimeOut(3);
    }
    @GetMapping("/order/ticket/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "8"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),// 失败率达到多少后跳闸
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })
    public String getPaymentTicket(@PathVariable("id") Integer id){
        return paymentHystrixService.getPaymentTicket(22);
    }
}
