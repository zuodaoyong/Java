package com.java.leetcode;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 示例1:
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 *
 * 示例2:
 *
 * 输入: 3
 * 输出: False
 */
public class t633平方数之和 {
    public static void main(String[] args) {
        boolean b = judgeSquareSum(50);
        System.out.println(b);

    }

    public static boolean judgeSquareSum(int c) {
        if(c<0)
            return false;
         int left=0;
         int right=(int)Math.sqrt(c);
         while (left<=right){
             int v=left*left+right*right;
             if(c==v){
                 System.out.println(left+":"+right);
                 return true;
             }else if(v>c){
                 right--;
             }else if(v<c){
                 left++;
             }
         }
         return false;
    }
}
