package com.java.thread.lock;

import org.elasticsearch.action.support.ThreadedActionListener;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    public static void main(String[] args)  throws Exception{
        StampedLockTest stampedLockTest=new StampedLockTest(1);
        new Thread(()->{
            stampedLockTest.read(1);
        },"s1").start();
        Thread.sleep(500);
        new Thread(()->{
            stampedLockTest.read(0);
        },"s2").start();

    }
}

class StampedLockTest{
     private int data;
     private final StampedLock lock=new StampedLock();
     public StampedLockTest(int data){
         this.data=data;
     }

     public int read(int readTime) {
         long stamp = lock.tryOptimisticRead();
         try{
             Thread.sleep(readTime);
             if(lock.validate(stamp)){
                 return data;
             }
         }catch (Exception e){
             e.printStackTrace();
         }

         try {
             System.out.println("获取读锁");
             stamp = lock.readLock();
             Thread.sleep(readTime);
         }catch (Exception e){
         }finally {
             lock.unlockRead(stamp);
         }
         return data;
     }

     public void write(int newData){
         long stamp = lock.writeLock();
         try{
             Thread.sleep(2);
             this.data=newData;
         }catch (Exception e){
         }finally {
             lock.unlockWrite(stamp);
         }
     }
}
