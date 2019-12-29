package com.java.thread.pool.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ForkJoinTest {
    private static final int[] arr={1,2,3,4,5,6,7,8,9,10};
    public static void main(String[] args) {
        //accumulatorRecursiveTask();
        accumulatorRecursiveAction();
    }

    private static void accumulatorRecursiveAction(){
        AccumulatorRecursiveAction action=new AccumulatorRecursiveAction(0,arr.length,arr);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        forkJoinPool.invoke(action);
        Integer value = AccumulatorRecursiveAction.AccumulatorHelper.getValue();
        System.out.println("res="+value);

    }

    private static void accumulatorRecursiveTask(){
        AccumulatorRecursiveTask task=new AccumulatorRecursiveTask(0,arr.length,arr);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        Integer invoke = forkJoinPool.invoke(task);
        System.out.println("res="+invoke);
    }
}

class AccumulatorRecursiveTask extends RecursiveTask<Integer>{

    private final int start;
    private final int end;
    private final int[] data;
    private final int limit=3;

    public AccumulatorRecursiveTask(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Integer compute() {
        if((end-start)<=limit){
            int res=0;
            for(int i=start;i<end;i++){
                res+=data[i];
            }
            return res;
        }
        int mid=(start+end)/2;
        AccumulatorRecursiveTask left=new AccumulatorRecursiveTask(start,mid,data);
        left.fork();
        AccumulatorRecursiveTask right=new AccumulatorRecursiveTask(mid,end,data);
        Integer compute = right.compute();
        Integer join = left.join();
        return compute+join;
    }
}

class AccumulatorRecursiveAction extends RecursiveAction{

    private final int start;
    private final int end;
    private final int[] data;
    private final int limit=3;

    public AccumulatorRecursiveAction(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        System.out.println("=="+end+"&"+start);
        if((end-start)<=limit){
            for(int i=start;i<end;i++){
                AccumulatorHelper.setValue(data[i]);
            }
        }else{
            int mid=(start+end)/2;
            AccumulatorRecursiveAction left=new AccumulatorRecursiveAction(start,mid,data);
            AccumulatorRecursiveAction right=new AccumulatorRecursiveAction(mid,end,data);
            left.fork();
            right.fork();
            left.join();
            right.join();
        }

    }

    static class AccumulatorHelper{
        private static AtomicInteger res=new AtomicInteger(0);
        static void setValue(int value){
            res.getAndAdd(value);
        }
        public static Integer getValue(){
            return res.get();
        }
    }
}