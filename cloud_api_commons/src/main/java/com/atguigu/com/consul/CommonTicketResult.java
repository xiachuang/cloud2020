package com.atguigu.com.consul;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonTicketResult<T> {
    private Integer code;
    private String message;
    private T  data;
    public CommonTicketResult(Integer code,String message){
        this(code,message,null);
    }
}
