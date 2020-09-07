package com.atguigu.springcloud.service.impl;

import com.atguigu.com.consul.Customer;
import com.atguigu.springcloud.dao.CustomerDao;
import com.atguigu.springcloud.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;
    @Override
    public int create(Customer customer) {
        return customerDao.create(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }
}
