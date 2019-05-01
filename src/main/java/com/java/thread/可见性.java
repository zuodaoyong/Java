package com.java.thread;

public class 可见性 {
    public static void main(String[] args) {
        MyData myData=new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
            System.out.println(myData.num);
        },"a").start();

        while (myData.num==0){

        }
        System.out.println(Thread.currentThread().getName()+":num="+myData.num);
    }
}
