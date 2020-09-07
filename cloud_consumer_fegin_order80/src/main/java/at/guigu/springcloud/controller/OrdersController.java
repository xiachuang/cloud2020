package at.guigu.springcloud.controller;

import at.guigu.springcloud.service.OrdersService;
import com.atguigu.com.CommonResult;
import com.atguigu.com.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrdersController {
    @Resource
    private OrdersService ordersService;
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayById(@PathVariable("id")Integer id){
        return ordersService.getPayById(id);
    }
    @GetMapping("/consumer/payment/create")//@RequestBody
    public CommonResult<Payment> create( Payment payment){
        return ordersService.create(payment);
    }
    @GetMapping("/consumer/payment/fegin/timeout")
    public String TimeOut(){
        return ordersService.TimeOut();
    }
}
