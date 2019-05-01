package com.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:比较并交换
 */
public class CAS {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019)+",curr data:"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2018)+",curr data:"+atomicInteger.get());
    }
}
