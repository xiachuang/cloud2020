package com.atguigu.springcloud.controller;

import com.atguigu.com.consul.Customer;
import com.atguigu.springcloud.bean.MessageResult;
import com.atguigu.springcloud.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @Resource
    DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/customer/get/{id}")
    public MessageResult getCustomerById(@PathVariable("id") Long id){
        Customer customer=customerService.getCustomerById(id);
        if(customer!=null){
            return new MessageResult(200,"查询成功"+serverPort,customer);
        }else {
            return new MessageResult(444,"查询失败 id:"+id+" "+serverPort,null);
        }
    }
    @PostMapping("/customer/create")
    public MessageResult create(Customer customer){
     int result= customerService.create(customer);
     if(result>0){
         return new MessageResult(200,"保存成功"+serverPort,customer);
     }else {
         return new MessageResult(413,"保存失败"+serverPort,null);
     }

    }
    @GetMapping("/customer/getService")
    public  Object getService(){
        return this.discoveryClient;
    }
}
