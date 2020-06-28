package com.test.threadPool;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {

        ThreadPool threadPool=new ThreadPool(2,3,2,100, TimeUnit.MILLISECONDS);

        for(int i=0;i<10;i++){
            int j=i;
            Runnable task=()->{
                System.out.println(j+"任务在执行");
            };
            threadPool.execute(task);
        }

    }
}
