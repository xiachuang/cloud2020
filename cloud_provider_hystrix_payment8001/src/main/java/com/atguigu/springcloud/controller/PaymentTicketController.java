package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentTicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentTicketController {
    @Resource
    PaymentTicketService paymentTicketService;
    @GetMapping("/ticket/{id}")
    public String getPaymentTicket(@PathVariable("id") Integer id){
    return     paymentTicketService.getPaymentTicketServiceById(id);
    }
    @GetMapping("/ticket/create/{name}")
    public String update(@PathVariable("name") String name){
        return paymentTicketService.updateTicket(name);
    }
}
