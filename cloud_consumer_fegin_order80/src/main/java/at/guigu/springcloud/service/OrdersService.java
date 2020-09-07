package at.guigu.springcloud.service;

import com.atguigu.com.CommonResult;
import com.atguigu.com.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PAYNAME-SERVER")
public interface OrdersService {
    @GetMapping("/payment/get/{id}")
    public CommonResult getPayById(@PathVariable("id")Integer id);
    @PostMapping("/payment/create")//@RequestBody
    public CommonResult create(@RequestBody Payment payment);
    @GetMapping("/payment/fegin/timeout")
    public String TimeOut();
}
