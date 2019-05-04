package com.java.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序调用,实现A->B->C三个线程启动，要求如下:
 * AA打印5次，BB打印10次，CC打印15次
 * 然后AA打印5次，BB打印10次，CC打印15次
 * 重复10轮
 */
public class 多Condition的ReentrantLock {
    public static void main(String[] args) {
        Data2 data2=new Data2();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                int temp=i;
                data2.print5(temp);
            }
        },"AA").start();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                int temp=i;
                data2.print10(temp);
            }
        },"BB").start();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                int temp=i;
                data2.print15(temp);
            }
        },"CC").start();

    }
}

class Data2{

    private volatile int num=1;//AA:1,BB:2,CC:3
    private Lock lock=new ReentrantLock();
    Condition condition_a=lock.newCondition();
    Condition condition_b=lock.newCondition();
    Condition condition_c=lock.newCondition();
    public void print5(int count){
       lock.lock();
       try {
           while (num!=1) {
               condition_a.await();
           }
           num++;
           System.out.println(Thread.currentThread().getName() + "打印5次,"+"count:"+count);
           condition_b.signal();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }finally {
           lock.unlock();
       }
    }

    public void print10(int count){
        lock.lock();
        try {
            while (num!=2) {
                condition_b.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "打印10次,"+"count:"+count);
            condition_c.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(int count){
        lock.lock();
        try {
            while (num!=3) {
                condition_c.await();
            }
            num=1;
            System.out.println(Thread.currentThread().getName() + "打印15次,"+"count:"+count);
            condition_a.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}