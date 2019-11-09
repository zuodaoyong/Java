package com.java.algorithm.sort;

import com.java.algorithm.common.CommonUtils;
import com.java.functions.SortFunction;

import java.util.Arrays;

public class 快速排序v2 {
    public static void main(String[] args) throws Exception{
        //Integer[] arr=new Integer[]{12,1,9,5,3,71,24};
        SortFunction<Integer> sortFunction=(arr)->{
            quickSort(arr,0,arr.length-1);
        };
        CommonUtils.sortRandomNumber(sortFunction);
        //System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(Integer[] arr,int left,int right){
        int lt=left;
        int rt=right;
        int temp;
        //找到中轴值
        int pivot=arr[(lt+rt)/2];
        //通过循环最终是比pivot小的在pivot左边，比pivot大的在pivot的右边
        while (lt<rt){
            while (arr[lt]<pivot){
                lt++;
            }
            while (arr[rt]>pivot){
                rt--;
            }
            //比pivot小的在pivot左边，比pivot大的在pivot的右边
            if(lt>=rt){
                break;
            }
            temp=arr[lt];
            arr[lt]=arr[rt];
            arr[rt]=temp;
            if(arr[lt]==pivot){
                rt--;
            }
            if(arr[rt]==pivot){
               lt++;
            }
        }
        if(lt==rt){
            lt++;
            rt--;
        }
        //左边递归
        if(left<rt){
            quickSort(arr,left,rt);
        }
        //右边递归
        if(right>lt){
            quickSort(arr,lt,right);
        }
    }
}
