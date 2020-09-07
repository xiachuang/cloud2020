package com.atguigu.springcloud.cloud_consumer_order_80.controller;

import com.atguigu.com.CommonResult;
import com.atguigu.com.Payment;


import com.atguigu.springcloud.cloud_consumer_order_80.lb.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import java.net.URI;
import java.util.List;



@RestController
public class PaymentController {
    private  final static String PAYMENT_URL="http://CLOUD-PAYNAME-SERVER";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    private LoadBalance loadBalance;
    @GetMapping("/consumer/payment/create")//serial
    public CommonResult<Payment> create(Payment payment){
        System.out.println(payment);
        return restTemplate.postForObject(PAYMENT_URL +"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       // String uuid= UUID.randomUUID().toString().replace("_","");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
//        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity= restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败!!");
        }
    }
    @GetMapping("/consumer/payment/getEntityCreate")
    public CommonResult<Payment> create2(Payment payment){
        ResponseEntity<CommonResult> entity=restTemplate.postForEntity(PAYMENT_URL +"/payment/create",payment,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败!!");
        }
    }
    /*
        自定义的轮询方法使用在方法上时   必须加上
         List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYNAME-SERVER");
        if(instances==null||instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance=loadBalance.instances(instances);
        URI uri=serviceInstance.getUri();
     */
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYNAME-SERVER");
        if(instances==null||instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance=loadBalance.instances(instances);
        URI uri=serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);//发送请求给A模块
    }
    @GetMapping("/consumer/getService")
    public List<String> getService(){
        discoveryClient.getInstances("CLOUD-PAYNAME-SERVER");
        return null;
    }
}
