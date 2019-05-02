package com.java.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 重入锁 {
    public static void main(String[] args) {
        Phone phone=new Phone();
        new Thread(()->{
            phone.sendSMS();
            phone.get();
        },"a").start();

        new Thread(()->{
            phone.sendSMS();
            phone.get();
        },"b").start();
    }
}

class Phone{

    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName()+" send sms");
        sendMail();
    }
    public synchronized void sendMail(){
        System.out.println(Thread.currentThread().getName()+" send mail");
    }

    Lock lock=new ReentrantLock();
    public void get(){
        lock.lock();
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" get");
        set();
        lock.unlock();
        lock.unlock();
    }

    public void set(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" set");
        lock.unlock();
    }
}