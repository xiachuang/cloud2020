package com.atguigu.springcloud.service.impl;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallback implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {

        return "-----------------paymentOut----------成功了";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return  "线程"+Thread.currentThread().getName()+"请稍后再试一试谢谢"+id;
    }

    @Override
    public String getPaymentTicket(Integer id) {
        return "线程"+Thread.currentThread().getName()+"请稍后再试一试"+id;
    }
}
