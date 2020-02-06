package com.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
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
public class t1两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target=9;
        //暴力法
        //int[] ints = twoSum1(nums,target);
        int[] ints1 = twoSum(nums, target);
        System.out.println(Arrays.toString(ints1));
    }

    //方法一、暴力法
    public static int[] twoSum1(int[] nums, int target) {
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
            int left=nums[i];
            int right=target-left;
            for(int j=i+1;j<nums.length;j++){
                if(right==nums[j]){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }

    /**
     * 方法一、缓存法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (map.get(dif) != null) {
                res[0] = map.get(dif);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }



}


