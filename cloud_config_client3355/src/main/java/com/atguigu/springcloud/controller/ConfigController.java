package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//启动自动刷新配置功能
public class ConfigController {
    @Value("${config}")
    public String configInfo;
    @Value("${server.port}")
    public String serverPort;
    @GetMapping("/config")
    public String getConfigInfo(){
        return configInfo+"\n  端口为："+serverPort;
    }
}
