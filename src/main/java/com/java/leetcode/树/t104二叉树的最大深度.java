package com.java.leetcode.树;

import java.util.Arrays;
import java.util.Comparator;

public class t104二叉树的最大深度 {

    private static int min=0;
    public static void main(String[] args) {


    }


    public static int minDepth(Integer[] arr,int k) {
        Integer count=0;
        Integer pre=0;
        Arrays.sort(arr,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<arr.length;i++){
            if(i==0||!(pre==arr[i])){
                pre=arr[i];
                count++;
            }
            if(count==k){
                return arr[i];
            }
        }
        return arr[k];
    }


}
