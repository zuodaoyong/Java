package com.test;


import java.util.*;

public class Test {



    public static void main(String[] args)  throws Exception{




    }


    public static boolean canPlaceFlowersV2(int[] flowerbed, int n){
        int i=0;
        while (i<flowerbed.length){
           if(flowerbed[i]==0&&(i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0)){
               flowerbed[i]=1;
               n--;
           }
           i++;
        }
        return n<=0;
    }





}




