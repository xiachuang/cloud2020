package com.atguigu.springcloud.dao;

import com.atguigu.com.consul.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerDao {
    @Insert("insert into customer(comicName) values(#{comicName})")
    public int create(Customer customer);
    @Select("select * from customer where id=#{id}")
    public Customer getCustomerById(Long id);
}
