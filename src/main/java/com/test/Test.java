package com.test;


import java.util.*;

public class Test {



    private static String a="123";
    public static void main(String[] args)  throws Exception{
        String a="456";
        System.out.println(a);


    }


    public static boolean isSubsequenceV2(String s, String t) {


        int index=-1;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            index=s.indexOf(chars[i],index+1);
            if(index==-1){
                return false;
            }
        }
        return true;
    }





}




