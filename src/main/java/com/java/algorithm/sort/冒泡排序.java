package com.java.algorithm.sort;


import com.java.algorithm.common.CommonUtils;
import com.java.functions.SortFunction;

import java.io.IOException;
import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) throws IOException {
        //Integer[] arr=new Integer[]{1,12,9,5,3,71,24};
        //0(n^2)
        SortFunction<Integer> sortFunction=(t)->{
            int temp;
            for(int i=1;i<t.length;i++){
                for(int j=0;j<t.length-1;j++){
                    if(t[j]>t[j+1]){
                        temp=t[j];
                        t[j]=t[j+1];
                        t[j+1]=temp;
                    }
                }
            }
        };

        CommonUtils.sortRandomNumber(sortFunction);
    }
}
