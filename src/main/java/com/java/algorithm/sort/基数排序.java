package com.java.algorithm.sort;


import com.common.ArrayUtils;

import java.util.Arrays;


public class 基数排序 {
    public static void main(String[] args) throws Exception {
        Integer[] arr = ArrayUtils.arr;
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(Integer[] arr){
       //获得数组中最大数的位数
       int max=arr[0];
       for(int i=0;i<arr.length;i++){
           if(arr[i]>max){
               max=arr[i];
           }
       }
       //得到最大数是几位数
       int maxLength=(max+"").length();
       //定义一个二位数组，表示10个桶，每个桶就是一维数组
        //为了防止在放入书的时候数据溢出，则每个桶大小定为arr.length
        int[][] bucket=new int[10][arr.length];
        //为了记录每个桶中实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts=new int[10];
        //bucketElementCounts[0]表示bucket[0]存放的数据个数
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            //针对每个元素的对应位进行排序处理，第一次是个位，第二次是十位，第三次是百位
            for(int j=0;j<arr.length;j++){
                //取出每个元素的对应位的值
                int digitOfElement=arr[j]/n%10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index=0;
            //遍历每一个桶并将桶中数据放入原数组
            for(int k=0;k<bucketElementCounts.length;k++){
                //如果桶中，有数据，我们才放入到原数组
                if(bucketElementCounts[k]!=0){
                    //循环该桶即第k个桶
                    for(int l=0;l<bucketElementCounts[k];l++){
                        arr[index++]=bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个bucketElementCounts[k]=0
                bucketElementCounts[k]=0;
            }
        }
    }
}
