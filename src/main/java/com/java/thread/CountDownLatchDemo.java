package com.java.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        //test1();
        countDownLatchTest();
    }

    private static void countDownLatchTest(){
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for(int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println("第"+Thread.currentThread().getName()+"个同学离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(countDownLatch.getCount());
        System.out.println("班长离开教室");


    }
    private static void test1(){
        for(int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println("第"+Thread.currentThread().getName()+"个同学离开教室");
            },String.valueOf(i)).start();
        }
        System.out.println("班长离开教室");
    }
}
