package com.test;


import java.util.*;

public class Test {



    public static void main(String[] args)  throws Exception{




    }


    public static int maxProfitv2(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int max=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
            }else{
                max=Math.max(max,prices[i]-min);
            }
        }
        return max;
    }





}




