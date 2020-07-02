package com.java.jvm;

import org.openjdk.jol.info.ClassLayout;

public class GCDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(ClassLayout.parseClass(String.class).toPrintable());
    }
}
