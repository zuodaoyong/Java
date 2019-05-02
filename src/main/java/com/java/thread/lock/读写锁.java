package com.java.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 读写锁 {
    public static void main(String[] args) {
        MyCache myCache=new MyCache();
        for(int i=1;i<=5;i++){
            final int temp=i;
            new Thread(()->{
                myCache.put(temp+"",temp);
            },String.valueOf(i)).start();
        }

        for(int i=1;i<=5;i++){
            final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    private ReadWriteLock lock=new ReentrantReadWriteLock();
    public void put(String key,Object value){
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+":在写入"+key);
        map.put(key,value);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":写入完成");
        lock.writeLock().unlock();
    }

    public void get(String key){
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+":读取"+key);
        Object value = map.get(key);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":读取完成value="+value);
        lock.readLock().unlock();
    }
}