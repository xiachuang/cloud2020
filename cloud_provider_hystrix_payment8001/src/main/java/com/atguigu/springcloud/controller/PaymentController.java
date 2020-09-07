package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id")Integer id){

     return   paymentService.paymentInfo_Ok(id)+serverPort;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_TimeOut(id)+serverPort;
    }
    @GetMapping("/payment/hystrix/breaker/{id}")
    public String paymentHystrixBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentInfoCircuitBreaker(id)+"--->"+serverPort;
    }
    public  void show(){
        Integer i=42;
        Long l=42l;
        Double d=42.0;
        System.out.println(i.equals(l));
        System.out.println(l.equals(d));
        System.out.println(i.equals(d));
        System.out.println(l.equals(42L));
    }
}
