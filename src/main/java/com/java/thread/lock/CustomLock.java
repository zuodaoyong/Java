package com.java.thread.lock;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CustomLock {

    private volatile boolean boolValue=false;
    private ConcurrentLinkedQueue<Thread> blockQueue=new ConcurrentLinkedQueue<>();

    private Thread currentThread;
    public synchronized void lock() throws InterruptedException{
        while (boolValue){
            this.wait();
            blockQueue.add(Thread.currentThread());
        }
        this.boolValue=true;
        currentThread=Thread.currentThread();
        Optional.of(currentThread+" have lock")
                .ifPresent(System.out::println);
        blockQueue.remove(Thread.currentThread());
    }

    public void lock(long mills){

    }

    public synchronized void unlock(){
        while (currentThread==Thread.currentThread()){
            this.boolValue=false;
            Optional.of(currentThread+" release lock")
                    .ifPresent(System.out::println);
            this.notifyAll();
            break;
        }
    }

    public void getBlockList(){

    }

    public static void main(String[] args) {
        CustomLock lock=new CustomLock();
        Arrays.asList("T1","T2","T3","T4","T5").stream().forEach(e->{
            new Thread(()->{
                try {
                    lock.lock();
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }finally {
                    lock.unlock();
                }
            },e).start();
        });
    }
}
