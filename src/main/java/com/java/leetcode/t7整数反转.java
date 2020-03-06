package com.java.leetcode;

import java.util.Arrays;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 如果反转后整数溢出那么就返回 0。
 */
public class t7整数反转 {


    public static void main(String[] args) {
        int reverse = reverse2(1534236469);
        System.out.println(reverse);
    }

    /**
     * 方案一
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if(x<10&&x>-10){
            return x;
        }
        String str=x+"";
        char[] chars;
        String res="";
        char sign='\001';
        if(str.charAt(0)=='-'){
            sign='-';
            chars=str.substring(1).toCharArray();
        }else{
            chars = str.toCharArray();
        }
        chars=reverseArr(chars);
        if(sign!='\001'){
            res+=sign;
        }
        res+=new String(chars);
        try {
            return Integer.parseInt(res);
        }catch (Exception e){
            return 0;
        }
    }

    private static char[] reverseArr(char[] chars){
        int left=0;
        int right=chars.length-1;
        char temp;
        while (left<=right){
           temp=chars[left];
           chars[left]=chars[right];
           chars[right]=temp;
           left++;
           right--;
        }
        return chars;
    }


    /**
     * 求余法
     * 123/10=12 余数 3
     * 321/10=32 余数 1
     * 456/10=45 余数 6
     * 654/10=65 余数 4
     * 78/10=7   余数 8
     * 7/10=0    余数 7
     * @param x
     * @return
     */
    public static int reverse2(int x){
        String str=x+"";
        char sign='\001';
        int y;
        int reminder;
        int res=0;
        if(str.charAt(0)=='-'){
            sign='-';
            y=Math.abs(Integer.valueOf(str.substring(1)));
        }else{
            y=x;
        }
        while (y>0){
            reminder=y%10;
            y=(y-reminder)/10;
            res=res*10+reminder;
        }
        str=res+"";
        if(sign=='-'){
            str=sign+str;
        }
        try {
            return Integer.parseInt(str);
        }catch (Exception e){
            return 0;
        }
    }

}
