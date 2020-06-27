package com.java.thread.pool.custom;

import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {

        ThreadPool threadPool=new ThreadPool(10,2,1000, TimeUnit.MILLISECONDS,(queue,task)->{
            //1、死等
            queue.put(task);
            //2、超时等待
            //queue.offer(task,100,TimeUnit.MILLISECONDS);
            //3、不处理
            //4、抛异常
            //throw new RuntimeException("阻塞队列满");
            //5、调用者执行
            //task.run();
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
