package com.java.thread.lock;

import java.util.concurrent.atomic.AtomicReference;

public class 自旋锁 {
    static  AtomicReference<Thread> atomicReference=new AtomicReference<>();
    public static void main(String[] args) {

        new Thread(()->{
            myLock();
            System.out.println(Thread.currentThread().getName()+" get lock");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myUnLock();
            System.out.println(Thread.currentThread().getName()+" leave lock");
        },"a").start();

        new Thread(()->{
            myLock();
            System.out.println(Thread.currentThread().getName()+" get lock");
            myUnLock();
            System.out.println(Thread.currentThread().getName()+" leave lock");
        },"b").start();
    }

    public static void myLock(){
        Thread thread=Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)){
        }
    }

    public static void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
    }
}

