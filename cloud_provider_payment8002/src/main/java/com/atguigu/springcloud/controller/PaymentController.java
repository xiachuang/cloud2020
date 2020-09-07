package com.atguigu.springcloud.controller;

import com.atguigu.com.CommonResult;
import com.atguigu.com.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Transactional
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
    int result=    paymentService.creatPayment(payment);
    if(result>0){
        return new CommonResult(200,"插入成功!!"+serverPort,result);
    }else {
        return new CommonResult(444,"插入失败id为："+payment.getId(),null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public  CommonResult getPayById(@PathVariable("id")Integer id){
        Payment payment=paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败id:"+id,null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentPort(){
//        discoveryClient.getInstances()
        return serverPort;
    }
    @GetMapping("/payment/fegin/timeout")
    public String TimeOut(){
        int time=3;
        try{
            TimeUnit.SECONDS.sleep(time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
