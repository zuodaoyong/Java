package com.java.jvm;

public class GCDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
