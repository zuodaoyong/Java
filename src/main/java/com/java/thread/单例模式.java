package com.java.thread;

public class 单例模式 {

    private static volatile 单例模式 instance;

    private 单例模式(){

    }

    //DCL(双端检测机制)
    public static 单例模式 getInstance(){
        if(null==instance){
            synchronized (单例模式.class){
                if(null==instance){
                    instance=new 单例模式();
                }
            }
        }
        return instance;
    }
}
