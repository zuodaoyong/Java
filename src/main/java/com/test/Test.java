package com.test;


public class Test {

    public static void main(String[] args) {

        boolean odd = isOdd(10);
        System.out.println(odd);

    }


    private static boolean isOdd(int i){
        return  (i&1)==1;
    }

}


