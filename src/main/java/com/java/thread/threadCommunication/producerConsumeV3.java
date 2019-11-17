package com.java.thread.threadCommunication;

import java.util.stream.Stream;


public class producerConsumeV3 {

    private final Object lock=new Object();

    private int i=0;
    private boolean isProduced=false;
    public static void main(String[] args) {
        producerConsumeV3 v1=new producerConsumeV3();
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
            while (isProduced){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("produce>"+(++i));
            lock.notifyAll();
            isProduced=true;
        }
    }

    private void consume(){
        synchronized (lock){
            while (isProduced){
                System.out.println("consume>"+i);
                lock.notifyAll();
                isProduced=false;
            }
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}



