package com.java.se.initClass;

class Son extends Parent{
    private static  int sa=1;
    private static  int sb;
    private int sc=initc2();
    static {
        sb=1;
        System.out.println("2.子类静态代码块：赋值sb成功");
        System.out.println("2.子类静态代码块：sa的值"+sa);
    }
    int initc2(){
        System.out.println("5.子类成员变量赋值--->：sc的值"+sc);
        this.sc=12;
        return sc;
    }
    public Son(){
        System.out.println("6.子类构造方式开始执行---> sa:"+sa+",sb:"+sb);
        System.out.println("6.子类构造方式开始执行---> sc:"+sc);
    }
}