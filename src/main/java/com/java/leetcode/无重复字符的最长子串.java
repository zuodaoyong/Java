package com.java.leetcode;

import java.util.*;

public class 无重复字符的最长子串 {

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
