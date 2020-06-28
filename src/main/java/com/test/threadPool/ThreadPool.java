package com.test.threadPool;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class ThreadPool {


    private int coreSize;

    private int maxSize;

    private long blockingQueueTimeout;

    private TimeUnit blockingQueueTimeUnit;

    private BlockingQueue<Runnable> blockingQueue;

    private HashSet<Worker> workers=new HashSet<>();

    public ThreadPool(int coreSize,int maxSize,int blockQueueSize){
        this.coreSize=coreSize;
        this.maxSize=maxSize;
        this.blockingQueue=new BlockingQueue<>(blockQueueSize);
    }

    public ThreadPool(int coreSize,int maxSize,int blockQueueSize,long blockingQueueTimeout,TimeUnit blockingQueueTimeUnit){
        this.coreSize=coreSize;
        this.maxSize=maxSize;
        this.blockingQueue=new BlockingQueue<>(blockQueueSize);
        this.blockingQueueTimeout=blockingQueueTimeout;
        this.blockingQueueTimeUnit=blockingQueueTimeUnit;
    }

    public void execute(Runnable task){
        if(this.workers.size()<this.coreSize){
            Worker worker = new Worker(task);
            this.workers.add(worker);
            System.out.println("新建线程处理，task"+task);
            worker.start();
        }else{
            System.out.println("task进入阻塞队列，task="+task);
            this.blockingQueue.put(task);
        }
    }

    class Worker extends Thread{

        private Runnable task;

        public Worker(Runnable task){
            this.task=task;
        }
        @Override
        public void run() {
            while (this.task!=null||(this.task=blockingQueue.offer(blockingQueueTimeout,blockingQueueTimeUnit))!=null){
                try{
                    System.out.println("task正在运行,task="+this.task);
                    this.task.run();
                }finally {
                    this.task=null;
                }
            }
        }
    }
}
