package com.atguigu.springcloud.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(name = "HYSTRIX-PAYMENT-SERVICE",fallback = PaymentHystrixFallback.class)//fallback 当无法访问 微服务时 调用类中的方法显示
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id")Integer id);
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id);
    @GetMapping("/ticket/{id}")
    public String getPaymentTicket(@PathVariable("id") Integer id);
}
