package com.atguigu.springcloud.bean;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
@Data
public class MessageResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public MessageResult() {

    }
    public MessageResult(Integer code, String msg, T data) {
            this.code=code;
            this.msg=msg;
            this.data=data;
    }
    public MessageResult(Integer code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
