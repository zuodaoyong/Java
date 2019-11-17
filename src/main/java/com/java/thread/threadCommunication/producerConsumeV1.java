package com.java.thread.threadCommunication;

public class producerConsumeV1 {

    private final Object lock=new Object();

    private int i=0;
    private boolean isProduced=false;
    public static void main(String[] args) {
        producerConsumeV1 v1=new producerConsumeV1();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    v1.produce();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    v1.consume();
                }
            }
        }.start();
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



