package com.java.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程：交替运行，使变量num一个加1，一个减1,往返5次
 *        sync （v1.0版）      lock(v2.0版)
 *      *     *               *     *
 *     *       *     ===>    *       *
 *    *         *           *         *
 *   wait * * notify      await * * signal
 */
public class 传统ProdConsumer {
    public static void main(String[] args) {
        Data data=new Data();
        new Thread(()->{
            try {
                for (int i=1;i<=5;i++){
                    data.increment();
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"a").start();
        new Thread(()->{
            try {
                for (int i=1;i<=5;i++){
                    data.decrement();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"b").start();
    }
}

class Data{
    private volatile int num=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    //增加
    public void increment() throws Exception{
        lock.lock();
        while (num!=0){//使用while判断防止虚假唤醒
            condition.await();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"加1:"+num);
        condition.signalAll();
        lock.unlock();
    }

    public void decrement() throws Exception{
        lock.lock();
        while (num==0){
            condition.await();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"减1:"+num);
        condition.signalAll();
        lock.unlock();
    }
}