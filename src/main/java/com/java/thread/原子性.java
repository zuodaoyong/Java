package com.java.thread;

public class 原子性 {
    public static void main(String[] args) {
        MyData myData=new MyData();
        //noAtomic(myData);
        atomic(myData);
        //保证子线程全部执行完
        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+":"+myData.atomicInteger);
    }

    private  static void atomic(MyData myData){
        for (int i = 1; i <=20 ; i++) {
            new Thread(()->{
                for (int j = 1; j <=1000; j++) {
                    myData.atomicAddAdd();
                }
            },String.valueOf(i)).start();
        }
    }
    private static void noAtomic(MyData myData) {
        for (int i = 1; i <=20 ; i++) {
            new Thread(()->{
                for (int j = 1; j <=1000; j++) {
                    myData.addadd();
                }
            },String.valueOf(i)).start();
        }
    }
}
