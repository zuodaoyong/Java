package com.java.thread.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterDemo {

    public static void main(String[] args) {

        Student student=new Student();
        AtomicReferenceFieldUpdater updater=AtomicReferenceFieldUpdater.newUpdater(Student.class,String.class,"name");
        boolean bool = updater.compareAndSet(student, null, "neo");
        System.out.println(bool);
        System.out.println(student);
    }


    static class Student{
        volatile String name;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
