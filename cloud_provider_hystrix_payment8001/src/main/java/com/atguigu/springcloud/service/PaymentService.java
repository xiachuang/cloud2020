package com.atguigu.springcloud.service;

public  interface PaymentService {
    public String paymentInfo_Ok(Integer id);
    public String paymentInfo_TimeOut(Integer id);
    public String paymentInfoCircuitBreaker(Integer id);
    public String orderInfoCircuitBreaker(Integer id);
}
