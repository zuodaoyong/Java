package com.java.algorithm.sort;

import com.java.algorithm.common.CommonUtils;
import com.java.functions.SortFunction;

import java.io.IOException;
import java.util.Arrays;

public class 直接插入排序 {
    public static void main(String[] args) throws IOException {
        //Integer[] arr=new Integer[]{12,1,9,5,3,71,24};
        SortFunction<Integer> sortFunction=(arr)->{
            for(int i=1;i<arr.length;i++){
                int min=arr[i];
                int minIndex=i;
                for(int j=i-1;j>=0;j--){
                    if(min<arr[j]){
                        minIndex=j;
                        arr[j+1]=arr[j];
                    }
                }
                arr[minIndex]=min;
            }
        };
        CommonUtils.sortRandomNumber(sortFunction);
    }
}
