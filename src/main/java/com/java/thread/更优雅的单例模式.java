package com.java.thread;

public class 更优雅的单例模式 {

    private 更优雅的单例模式(){

    }

    private static class SingletonHolder{
        private final static 更优雅的单例模式 instance=new 更优雅的单例模式();
    }

    public static 更优雅的单例模式 getInstance(){
        return SingletonHolder.instance;
    }
}
