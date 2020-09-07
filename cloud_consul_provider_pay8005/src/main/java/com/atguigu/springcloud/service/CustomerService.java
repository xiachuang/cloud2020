package com.atguigu.springcloud.service;

import com.atguigu.com.consul.Customer;

public interface CustomerService {
    public int create(Customer customer);
    public Customer getCustomerById(Long id);
}
