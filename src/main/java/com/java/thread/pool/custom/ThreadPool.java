package com.java.thread.pool.custom;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    //阻塞队列
    private BlockingQueue<Runnable> taskQueue;
    //线程集合
    private HashSet<Worker> workers=new HashSet<>();
    //核心线程数
    private int coreSize;
    //获取任务的超时时间
    private long timeout;

    private TimeUnit timeUnit;

    private RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int capacity, int coreSize, long timeout, TimeUnit timeUnit,RejectPolicy<Runnable> rejectPolicy) {
        this.taskQueue = new BlockingQueue<>(capacity);
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.rejectPolicy=rejectPolicy;
    }

    /**
     * 执行任务
     * @param task
     */
    public void execute(Runnable task){
        synchronized (workers){
            if(workers.size()<coreSize){
                Worker worker = new Worker(task);
                workers.add(worker);
                System.out.println("新创建worker处理任务="+worker+",task="+task);
                worker.start();
            }else{
                System.out.println("核心线程处于繁忙，当前任务放入阻塞队列,task="+task);
                //taskQueue.put(task);
                //使用拒绝策略
                taskQueue.tryPut(rejectPolicy,task);
            }
        }
    }
    class Worker extends Thread{
        private Runnable task;
        public Worker(Runnable task){
            this.task=task;
        }

        @Override
        public void run() {
            //执行任务
            //1、当task不为空时执行任务
            //2、当task执行完成，查看阻塞队列里有没有任务
            while (this.task!=null||(this.task=taskQueue.poll(timeout,timeUnit))!=null){
                try {
                    System.out.println("正在执行task="+this.task);
                    this.task.run();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    this.task=null;
                }
            }
           //3、所有任务（包括阻塞队列的）都执行完成，
           synchronized (workers){
               System.out.println("worker被移除，worker="+this);
                workers.remove(this);
           }
        }
    }
}
