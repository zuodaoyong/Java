package com.java.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例1：
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例2：
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class t4寻找两个有序数组的中位数 {


    public static void main(String[] args) {
          int[] num1=new int[]{1,3};
          int[] num2=new int[]{2};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }






    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
         if(nums1!=null&&nums2==null){
             return singleArr(nums1);
         }
        if(nums1==null&&nums2!=null){
            return singleArr(nums2);
        }
        if(nums1!=null&&nums2!=null){
            if(nums1.length==0){
                return singleArr(nums2);
            }
            if(nums2.length==0){
                return singleArr(nums1);
            }
        }
        int num=nums1.length+nums2.length;
        int[] numArr=new int[num];
        int left=0;
        int right=numArr.length-1;
        int num1_left=0;
        int num1_right=nums1.length>0?nums1.length-1:0;
        int num2_left=0;
        int num2_right=nums2.length>0?nums2.length-1:0;
        while (left<=right){
            if((num1_left>=nums1.length&&num2_left<nums2.length)||(num1_left<nums1.length&&num2_left<nums2.length&&(nums1[num1_left]>=nums2[num2_left]))){
                if(num2_left<=num2_right){
                    numArr[left++]=nums2[num2_left++];
                }
            }else{
                if(num1_left<=num1_right){
                    numArr[left++]=nums1[num1_left++];
                }
            }

            if((num1_right>0&&num2_right<0)||(num1_right>=0&&num2_right>=0&&(nums1[num1_right]>=nums2[num2_right]))){
                if(num1_right>=num1_left){
                    numArr[right--]=nums1[num1_right--];
                }
            }else{
                if(num2_right>=num2_left){
                    numArr[right--]=nums2[num2_right--];
                }
            }
        }
        left=num%2==0?left:left-1;
        double res=(numArr[left]+numArr[right])/2.0;
        res = (double) Math.round(res * 10) / 10;
        return res;
    }

    private static double singleArr(int[] num){
        if(num.length%2==0){//偶数
            int index=num.length/2;
            int right=num[index];
            int left=num[index-1];
            double res=(left+right)/2.0;
            res = (double) Math.round(res * 10) / 10;
            return res;
        }else{//奇数
            int index=num.length/2;
            return num[index];
        }
    }
}
