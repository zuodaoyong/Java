package com.java.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("召唤神龙。。。");
        });

        for(int i=1;i<=7;i++){
            int temp=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"获得第"+temp+"颗龙珠");
                try{
                    cyclicBarrier.await();
                }catch (Exception e){
                    e.getStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
