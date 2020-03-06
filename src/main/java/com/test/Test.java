package com.test;


public class Test {

    public static void main(String[] args) {

        //模拟执行任务的第一个阶段的执行
        Thread stepOne = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : 第一阶段任务开始执行");
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " : 第一阶段任务执行结束");
            } catch (InterruptedException e) {
            }
        }, "firstStage");
    }


}

    
