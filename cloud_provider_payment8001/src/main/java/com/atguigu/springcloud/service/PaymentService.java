package com.atguigu.springcloud.service;

import com.atguigu.com.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int creatPayment(Payment payment);
    public Payment getPaymentById(@Param("id") Integer id);
    public String paymentInfo_Ok(Integer id);
    public String paymentInfo_TimeOut(Integer id);
}
