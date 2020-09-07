package com.atguigu.springcloud.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private int count;
    int j;
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(4);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
    }
    Test(int a) {
        System.out.println(j++);
    }
}
/*
/*

 */
