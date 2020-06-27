package com.java.thread.pool.custom;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

    private Deque<T> blockQueue=new ArrayDeque<>();

    private Lock lock=new ReentrantLock();

    private Condition emptyCondition=lock.newCondition();

    private Condition fullCondition=lock.newCondition();

    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 带有超时时间的阻塞队列
     * @param timeout
     * @param timeUnit
     * @return
     */
    public T poll(long timeout, TimeUnit timeUnit){
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (blockQueue.isEmpty()){
                try {
                    //emptyCondition会出现虚假唤醒，awaitNanos返回值是nanos的初始值-已经阻塞的时间
                    //即使是虚假唤醒，线程继续等待剩余的时间
                    if(nanos<=0){
                      return null;
                    }
                    nanos=emptyCondition.awaitNanos(nanos);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
           T t= blockQueue.removeFirst();
            fullCondition.signal();
           return t;
        }finally {
            lock.unlock();
        }
    }

    /**
     * 从阻塞队列里获取一个元素
     * @return
     */
    public T take(){
        T t;
        try{
            lock.lock();
            while (blockQueue.isEmpty()){
                try {
                    emptyCondition.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            t = blockQueue.removeFirst();
            fullCondition.signal();
        }finally {
            lock.unlock();
        }
        return t;
    }

    /**
     * 放入元素
     * @param t
     */
    public void put(T t){
        try {
            lock.lock();
            while (blockQueue.size()==capacity){
                try {
                    fullCondition.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            blockQueue.addLast(t);
            emptyCondition.signal();
        }finally {
            lock.unlock();
        }
    }


    /**
     * 超时时间添加元素
     * @param t
     * @param timeout
     * @param timeUnit
     * @return
     */
    public boolean offer(T t,long timeout,TimeUnit timeUnit){
        lock.lock();
        try{
            long nanos = timeUnit.toNanos(timeout);
            while (blockQueue.size()==capacity){
                try {
                    if(nanos<=0){
                        return false;
                    }
                    nanos=fullCondition.awaitNanos(nanos);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            blockQueue.addLast(t);
            emptyCondition.signal();
            return true;
        }finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            if(blockQueue.size()==capacity){
                rejectPolicy.reject(this,task);
            }else {//阻塞队列有空间
                blockQueue.addLast(task);
                emptyCondition.signal();
            }
        }finally {
            lock.unlock();
        }
    }
}
