package com.java.thread;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class 原子引用 {
    public static void main(String[] args) {
        //fun1();
        //aba();
        solveABA();
    }

    private static void solveABA(){
        AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(100,1);
        new Thread(()->{
            int stamp=atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+",版本号:stamp="+stamp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean bool1=atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+",版本号:stamp="+atomicStampedReference.getStamp()+",bool1="+bool1);
            boolean bool2=atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+",版本号:stamp="+atomicStampedReference.getStamp()+",bool2="+bool2);
        },"a").start();
        new Thread(()->{
            int stamp=atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+",版本号:stamp="+stamp);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean bool = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+",当前修改是否成功 bool="+bool+",当前stamp="+stamp+",实际值stamp="+atomicStampedReference.getStamp());
        },"b").start();
    }
    private static void aba(){
        AtomicReference<Integer> atomicReference=new AtomicReference<>(100);
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"1").start();
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019)+",curr="+atomicReference.get());
        },"b").start();
    }
    private static void fun1() {
        User u1=new User("z3",20);
        User u2=new User("ls",25);
        AtomicReference<User> atomicReference=new AtomicReference<>();
        atomicReference.set(u1);
        System.out.println(atomicReference.compareAndSet(u1, u2)+",curr user="+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(u1, u2)+",curr user="+atomicReference.get().toString());
    }
}

class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}