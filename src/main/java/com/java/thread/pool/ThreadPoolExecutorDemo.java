package com.java.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ExecutorService threadPool=new ThreadPoolExecutor(2,
                5,10L,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for(int i=1;i<=5;i++){
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+":办理业务");
            });
        }

    }

    private void jdk(){
        ExecutorService threadPool= Executors.newFixedThreadPool(5);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
    }
}
