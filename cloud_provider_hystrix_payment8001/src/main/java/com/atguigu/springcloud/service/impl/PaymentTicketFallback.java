package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentTicketService;
import org.springframework.stereotype.Component;

//@Component
public class PaymentTicketFallback implements PaymentTicketService {
    static {

    }
    static {}
    @Override
    public String getPaymentTicketServiceById(Integer id) {
        System.out.println("---------PaymentTicketServiceFallback-----------"+id);
        return ("---------PaymentTicketServiceFallback-----------"+id);
    }

    @Override
    public String updateTicket(String name) {
        System.out.println("访问繁忙+熔断器启动......");

        return ("访问繁忙+熔断器启动......");
    }

}
