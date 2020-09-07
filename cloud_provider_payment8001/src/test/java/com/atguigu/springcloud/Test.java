package com.atguigu.springcloud;

public class Test {
    public static void main(String[] args) {
        Test test=new Test();
        test.mystery(1234);
    }
    public void mystery (int x)
    {
        System.out.print(x % 10);

        if ((x / 10) != 0)
        {
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }

}
