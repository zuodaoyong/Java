package com.java.leetcode;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 */
public class t680验证回文字符串 {
    public static void main(String[] args) {


        boolean result = validPalindrome("acba");
        System.out.println(result);

    }

    public static boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return isPalindrome(s,i,j-1)||isPalindrome(s,i+1,j);
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isPalindrome(String s,int i,int j){
        while (i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
