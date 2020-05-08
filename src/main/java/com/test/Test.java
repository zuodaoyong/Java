package com.test;



import org.openjdk.jol.info.ClassLayout;


public class Test {

    public static void main(String[] args) {
        Object o=new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

    }


    private static boolean isOdd(int i){
        return  (i&1)==1;
    }

}


