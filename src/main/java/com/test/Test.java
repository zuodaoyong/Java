package com.test;


import com.common.ArrayUtils;
import com.java.algorithm.common.CommonUtils;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws Exception {

        Integer[] arr = ArrayUtils.arr;
        System.out.println(Arrays.toString(arr));
        int temp;
        int index;
        for(int gap=arr.length/2;gap>0;gap=gap/2){
              for(int i=gap;i<arr.length;i++){
                  int j=i;
                  temp=arr[j];
                  if(arr[j]<arr[j-gap]){
                      while (j-gap>=0&&temp<arr[j-gap]){
                          arr[j]=arr[j-gap];
                          j-=gap;
                      }
                  }
                  arr[j]=temp;
              }
        }
        System.out.println(Arrays.toString(arr));
    }





}
