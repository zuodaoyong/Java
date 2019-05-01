package com.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class MyData {
    volatile int num=0;
    public void add(){
        this.num=60;
    }

    public void addadd(){
        this.num++;
    }

    AtomicInteger atomicInteger=new AtomicInteger();
    public void atomicAddAdd(){
        atomicInteger.getAndIncrement();
    }
}
