package com.java.thread.pool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class CustomThreadPool {

    private final int default_thread_size=10;

    private final List<WorkTask> threads=new ArrayList<>();

    private final LinkedList<Runnable> tasks=new LinkedList<>();

    private ThreadGroup group=new ThreadGroup("pool_group");

    private final String thread_preffix="customPool_";

    public CustomThreadPool(){
        init(default_thread_size);
    }

    private void init(int poolSize){
        createThreadPool(poolSize);
    }

    private void createThreadPool(int poolSize){
        IntStream.range(1,poolSize).forEach(i->{
            new WorkTask(group, thread_preffix + i).start();
        });
    }

    public void submit(Runnable task){
         synchronized (tasks){
             tasks.addLast(task);
             tasks.notifyAll();
         }
    }

    private enum ThreadStatus{
        Free,Block,Running,Dead
    }

    private class WorkTask extends Thread{
        private ThreadStatus threadStatus;
        public WorkTask(ThreadGroup group,String name){
            super(group,name);
            this.threadStatus=ThreadStatus.Free;
        }
        @Override
        public void run() {
            OUT:
            while (this.threadStatus==ThreadStatus.Free){
                Runnable runnable=null;
                synchronized (tasks){
                     while (tasks.isEmpty()){
                         try {
                             this.threadStatus=ThreadStatus.Block;
                             tasks.wait();
                         } catch (InterruptedException e) {
                             break OUT;
                         }
                     }
                    //System.out.println("tasks="+tasks.size());
                     runnable = tasks.removeFirst();
                 }
                 if(runnable!=null){
                     this.threadStatus=ThreadStatus.Running;
                     runnable.run();
                     this.threadStatus=ThreadStatus.Free;
                 }
            }
        }

        public void close(){
            this.threadStatus=ThreadStatus.Dead;
        }

    }
}
