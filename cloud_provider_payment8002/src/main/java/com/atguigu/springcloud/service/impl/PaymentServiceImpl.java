package com.atguigu.springcloud.service.impl;

import com.atguigu.com.Payment;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int creatPayment(Payment payment) {
        return paymentDao.creatPayment(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }
}
