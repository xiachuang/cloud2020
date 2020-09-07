package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class PaymentJsp {

    public ModelAndView show(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv=new ModelAndView();
        return mv;
    }
}
