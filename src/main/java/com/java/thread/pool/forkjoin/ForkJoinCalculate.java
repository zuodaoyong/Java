package com.java.thread.pool.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;
    private final long THRESHOLD=25000000000L;//临界值

    ForkJoinCalculate(long start,long end){
        this.start=start;
        this.end=end;
    }

    @Override
    protected Long compute() {
        long lenth=end-start;
        if(lenth<=THRESHOLD){
           long sum=0;
           for(long i=start;i<=end;i++){
                sum+=i;
           }
           return sum;
        }else{//拆分任务
            long middle=(start+end)/2;
            ForkJoinCalculate left=new ForkJoinCalculate(start,middle);
            left.fork();
            ForkJoinCalculate right=new ForkJoinCalculate(middle+1,end);
            right.fork();
            return left.join()+right.join();
        }
    }
}
