package com.atguigu.springcloud.controller;

import com.atguigu.com.consul.CommonTicketResult;
import com.atguigu.com.consul.Customer;
import com.atguigu.springcloud.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @Resource
    DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private   String serverPort;

    @GetMapping("/customer/get/{id}")
    public CommonTicketResult getCustomerById(@PathVariable("id") Long id){
        System.out.println(serverPort);
        Customer customer =customerService.getCustomerById(id);
        System.out.println(customer);
        if(customer!=null){
            return new CommonTicketResult(200,"查询正确"+id+" "+serverPort,customer);
        }else{
            return  new CommonTicketResult(444,"查询错误"+id+" "+serverPort,null);
        }
    }
    @PostMapping("/customer/create")
    public CommonTicketResult create(@RequestBody Customer customer){
        int result=customerService.create(customer);
        if(result>0){
            return new CommonTicketResult(200,"保存完成 "+serverPort,customer);
        }else{
            return new CommonTicketResult(405,"保存失败"+serverPort,null);
        }
    }
    @GetMapping("/customer/getServer")
    public Object getDiscoveryClient(){
        return this.discoveryClient;
    }
}
