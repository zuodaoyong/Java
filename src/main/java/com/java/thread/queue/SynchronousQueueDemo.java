package com.java.thread.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> synchronousQueue=new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"放入"+1);
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"放入"+2);
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"放入"+3);
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();
        new Thread(()->{
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"消费"+synchronousQueue.take());
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"消费"+synchronousQueue.take());
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"消费"+synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"b").start();
    }
}
