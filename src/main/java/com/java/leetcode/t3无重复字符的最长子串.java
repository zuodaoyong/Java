package com.java.leetcode;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class t3无重复字符的最长子串 {
    public static void main(String[] args) {
        String str="dvdf";
        //String str="bbbbb";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        StringBuffer bf=null;
        int max=0;
        String bfStr;
        int index;
        String newStr;
        for(char ch:chars){
            if(bf==null){
                bf=new StringBuffer();
                bf.append(ch);
                if(max==0){
                    max=1;
                }
                continue;
            }
            bfStr=bf.toString();
            if((index=bfStr.indexOf(ch))!=-1){
                newStr=bfStr.substring(index+1);
                bf=new StringBuffer();
                bf.append(newStr).append(ch);
            }else{
                bf.append(ch);
            }
            if(bf.toString().length()>max){
                max=bf.toString().length();
            }
        }
        return max;
    }
}
