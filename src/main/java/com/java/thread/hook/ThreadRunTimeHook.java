package com.java.thread.hook;

public class ThreadRunTimeHook {
    public static void main(String[] args) {
        //当Thread终止结束了或者遇到异常被终止，则会调用addShutdownHook里面的方法
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("end");
        }));

        new Thread(()->{
            while (true){
                System.out.println("working...");
            }
        }).start();
    }
}
