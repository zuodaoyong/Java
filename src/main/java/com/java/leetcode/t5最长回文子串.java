package com.java.leetcode;

import java.util.Arrays;

/**
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class t5最长回文子串 {

    public static void main(String[] args) {
        String s="cbbd";
        //String s1 = longestPalindrome(s);
        String s1=动态规划(s);
        System.out.println(s1);
    }

    public static String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        int maxLen=1;//设置1的原因是  如果s="ab"   则中心扩散求解方法无法求解，所以最大回文子串是a
        int start=0;
        char[] chars = s.toCharArray();
        int[] init=new int[2];
        init[0]=maxLen;
        init[1]=start;
        for(int i=0;i<chars.length;i++){
            中心扩散求解(chars,i,i+1,init);//奇数 类似：aba
            中心扩散求解(chars,i-1,i+1,init);//偶数 类似：abba
        }
        return s.substring(init[1],init[0]+init[1]);
    }

    public static void 中心扩散求解(char[] arr,int left,int right,int[] init){
        int len=0;
        while (left>=0&&right<arr.length&&arr[left]==arr[right]){
            if((len=right-left+1)>init[0]){
                init[0]=len;
                init[1]=left;
            }
            left--;
            right++;
        }
    }

    //技巧是分类讨论。
    // 对状态空间进行分类，
    // 思考最优子结构到底是什么。即大问题的最优解如何由小问题的最优解得到。
    public static String 动态规划(String s){
        int len = s.length();
        if(len < 2)
            return s;
        int[][] dp = new int[len][len]; //定义二位数组存储值，dp值为1表示true，为0表示false
        int start = 0;  //回文串的开始位置
        int max = 1;   //回文串的最大长度
        for(int i = 0; i < len; i++){  //初始化状态
            dp[i][i] = 1;
            if(i < len - 1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                start = i;
                max = 2;
            }
        }

        for(int l = 3; l <= len; l++){  //l表示检索的子串长度，等于3表示先检索长度为3的子串
            for (int i = 0; i+l-1 < len; i++){
                int j = l+i-1;  //终止字符位置
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){  //状态转移
                    dp[i][j] = 1;  //是一，不是字母l
                    start = i;
                    max = l;
                }
            }
        }
        return s.substring(start,start + max);   //获取最长回文子串
    }


}
