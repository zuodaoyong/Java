package com.java.leetcode;

import java.util.Scanner;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class 两数之和 {
    public static void main(String[] args) {
        while (true){
            Scanner in=new Scanner(System.in);
            System.out.println("请输入数组长度");
            int len=in.nextInt();
            System.out.println("请输入数组元素");
            int[] arr=new int[len];
            for(int i=0;i<len;i++){
                arr[i]=in.nextInt();
            }
            System.out.println("请输入target");
            int target=in.nextInt();
            printArr(arr);
            int[] ints = twoSum(arr, target);
            printArr(ints);
        }

    }

    private static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
       for(int i=0;i<nums.length;i++){
           int c=target-nums[i];
           int subscript = getSubscript(nums,c);
           if(subscript==-1){
               continue;
           }else{
               result[0]=i;
               result[1]=subscript;
               break;
           }
       }
       return result;
    }

    private static int getSubscript(int[] nums,int c){
         for(int i=0;i<nums.length;i++){
             if(nums[i]==c){
                 return i;
             }
         }
         return -1;
    }
}


