package com.test.threadPool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {


    private Deque<T> blockingQueue;

    private int capacity;//阻塞队列的容量

    private Lock lock=new ReentrantLock();

    //队列为空的条件状态
    private Condition emptyCondition=lock.newCondition();

    //队列为满的条件状态
    private Condition fullCondition=lock.newCondition();

    public BlockingQueue(int capacity){
        this.capacity=capacity;
        blockingQueue=new ArrayDeque<>(this.capacity);
    }

    /**
     * 向队列里放入元素
     * @param t
     */
    public void put(T t){
        lock.lock();
        try {
            while (blockingQueue.size()==this.capacity){
                try {
                    fullCondition.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            blockingQueue.addLast(t);
            emptyCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try{
            while (blockingQueue.isEmpty()){
                try{
                    emptyCondition.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            T t = blockingQueue.removeFirst();
            fullCondition.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    /**
     * 超时获取元素
     * @param timeout
     * @param timeUnit
     * @return
     */
    public T offer(long timeout, TimeUnit timeUnit){
        lock.lock();
        try{
            long nanos = timeUnit.toNanos(timeout);
            while (blockingQueue.isEmpty()){
                try{
                    if(nanos<=0){
                        return null;
                    }
                    nanos=emptyCondition.awaitNanos(nanos);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            T t = blockingQueue.removeFirst();
            fullCondition.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }




}
