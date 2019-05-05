package com.java.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockQueueProdConsumer {
    public static void main(String[] args) {
        Data3 data3=new Data3(new ArrayBlockingQueue<String>(10));
        new Thread(()->{
            data3.prod();
        },"a").start();
        new Thread(()->{
            data3.consumer();
        },"b").start();
        try {
            Thread.sleep(10000);
            data3.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Data3{
    private volatile boolean flag=true;//默认开启，生产+消费
    private AtomicInteger atomicInteger=new AtomicInteger();
    private BlockingQueue<String> blockingQueue=null;
    public Data3(BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
        System.out.println(Thread.currentThread().getName());
    }

    public void prod(){
        String data=null;
        boolean result=false;
        while(flag){
            data=atomicInteger.incrementAndGet()+"";
            result=this.blockingQueue.offer(data);
            if(result){
                System.out.println(Thread.currentThread().getName()+"插入队列"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"插入队列"+data+"失败");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("停止生产");
    }

    public void consumer(){
        String result=null;
        while (flag){
            try {
                result=this.blockingQueue.poll(2L, TimeUnit.SECONDS);
                if(result!=null){
                    System.out.println(Thread.currentThread().getName()+"消费"+result+"成功");
                }else{
                    System.out.println(Thread.currentThread().getName()+"停止消费");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
         this.flag=false;
    }
}
