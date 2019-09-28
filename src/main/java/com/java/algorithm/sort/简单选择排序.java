package com.java.algorithm.sort;

import com.java.algorithm.common.CommonUtils;
import com.java.functions.SortFunction;

import java.util.Arrays;

public class 简单选择排序 {

    public static void main(String[] args) {
        Integer[] arr=new Integer[]{1,12,9,5,3,71,24};
        int temp;
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                //交换
                temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }
    }
}
