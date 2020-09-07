package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.impl.PaymentTicketFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

//@Component
//@FeignClient(fallback = PaymentTicketFallback.class)
public  interface PaymentTicketService {
    public String getPaymentTicketServiceById(Integer id);
    public String updateTicket(String name);
}
