package com.java.thread.pool.custom;

import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {

        ThreadPool threadPool=new ThreadPool(10,2,1000, TimeUnit.MILLISECONDS,(queue,task)->{
            queue.put(task);
        });

        for(int i=0;i<5;i++){
            int j=i;
            Runnable task=()->{
                System.out.println("j="+j+",在运行");
            };
            threadPool.execute(task);
        }
    }
}
