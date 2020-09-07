package com.atguigu.springcloud;



public class Derived {


    static boolean out(char c){
        System.out.println(c);
        Object o=new Object();

        return true;
    }
    public static void main(String[] argv){
        int i = 0;
        for(out('A');out('B') && (i<2);out('C')){
            i++;
            out('D');
        }
    }
  float fun0(){
        byte i=1;
        return i;

  }
}
