package com.java.thread;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);//模拟3个停车位
        for(int i=1;i<=6;i++){//模拟6部车
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
