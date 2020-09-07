package com.atguigu.springcloud.controller;

import com.atguigu.com.consul.CommonTicketResult;
import com.atguigu.com.consul.Customer;
import com.atguigu.springcloud.bean.MessageResult;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CustomerServerController {
    private final static String INVOKE_URL="http://cloud-zookeeper-payment";
    @Resource
    private  RestTemplate  restTemplate;
    @Resource
    DiscoveryClient discoveryClient;
    @GetMapping("/consumer/customer/get/{id}")
    public MessageResult payCustomer(@PathVariable("id")Long id){
        return restTemplate.getForObject(INVOKE_URL+"/customer/get/"+id,MessageResult.class);
    }
    @GetMapping("/consumer/customer/create")
    public MessageResult create(Customer customer){
        return restTemplate.postForObject(INVOKE_URL+"/customer/create",customer,MessageResult.class);
    }
    @GetMapping("/customer/getService")
    public  Object getService(){
        return this.discoveryClient;
    }
}
