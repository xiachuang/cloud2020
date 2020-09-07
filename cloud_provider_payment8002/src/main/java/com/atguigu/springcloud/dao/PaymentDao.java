package com.atguigu.springcloud.dao;

import com.atguigu.com.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaymentDao {
    @Insert("insert into payment(serial)  values(#{serial})")
    public int creatPayment(Payment payment);
    @Select(" select * from payment where id=#{id}")
    public Payment getPaymentById(@Param("id") Integer id);
}
