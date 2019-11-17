package com.java.thread.threadCommunication;

import java.util.stream.Stream;

/**
 * 多个线程有可能都wait了，解决方案看v3
 */
public class producerConsumeV2 {

    private final Object lock=new Object();

    private int i=0;
    private boolean isProduced=false;
    public static void main(String[] args) {
        producerConsumeV2 v1=new producerConsumeV2();
        Stream.of("p1","p2").forEach(n->
        new Thread(){
            @Override
            public void run() {
                while (true){
                    v1.produce();
                }
            }
        }.start());
        Stream.of("c1","c2").forEach(n->
        new Thread(){
            @Override
            public void run() {
                while (true){
                    v1.consume();
                }
            }
        }.start());
    }

    private void produce(){
        synchronized (lock){
            if(isProduced){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("produce>"+(++i));
                lock.notify();
                isProduced=true;
            }
        }
    }

    private void consume(){
        synchronized (lock){
            if(isProduced){
                System.out.println("consume>"+i);
                lock.notify();
                isProduced=false;
            }else{
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}



