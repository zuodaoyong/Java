package com.java.thread.pool.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoin {
    private static Long end=100000000000L;
    public static void main(String[] args) throws Exception{
        test1();
        test2();
        test3();
    }

    /**
     * jdk8前
     */
    public static void test1() throws Exception{
        long startTime = System.currentTimeMillis();
        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinCalculate(0,end);
        //Long aLong = pool.invoke(task);
        ForkJoinTask<Long> submit = pool.submit(task);
        Long aLong = submit.get();
        System.out.println(aLong);
        long endTime = System.currentTimeMillis();
        System.out.println("用时="+(endTime-startTime));
    }

    /**
     * 普通的写法
     */
    public static void test2() {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0L; i <= end; i++)
        {
            sum += i;
        }
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println("耗费的时间为: " + (end - start));
    }

    /**
     * JDK8 的写法
     */
    public static void test3()
    {
        long start = System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0L, end).parallel().sum();
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println("耗费的时间为: " + (end - start));
    }
}
