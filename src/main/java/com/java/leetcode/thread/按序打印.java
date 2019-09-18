package com.java.leetcode.thread;

import com.common.ThreadUtils;

import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 按序打印 {

    public static void main(String[] args) throws InterruptedException {
        Foo foo=new Foo();
        foo.first(()->{
            System.out.println("first...");
        });
        foo.second(()->{
            System.out.println("second...");
        });
        foo.third(()->{
            System.out.println("third...");
        });
        while (Thread.activeCount()>2){
            System.out.println(Thread.activeCount());
        }
        System.out.printf("end");
    }
}

class Foo {

    Lock lock=new ReentrantLock();
    Condition firstCondition=lock.newCondition();
    Condition secondCondition=lock.newCondition();
    Condition thirdCondition=lock.newCondition();
    boolean a=false;
    boolean b=false;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        a=true;
        new Thread(printFirst).start();
        secondCondition.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while (!a){
            secondCondition.await();
        }
        b=true;
        new Thread(printSecond).start();
        //ThreadUtils.getExecutorService().submit(printSecond);
        thirdCondition.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while (!b){
            thirdCondition.await();
        }
        new Thread(printThird).start();
        //ThreadUtils.getExecutorService().submit(printThird);
        lock.unlock();
    }
}