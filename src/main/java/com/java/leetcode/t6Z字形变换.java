package com.java.leetcode;

import java.util.Arrays;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *  示例 1:
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * A C
 * B D
 */
public class t6Z字形变换 {


    public static void main(String[] args) {
        //String s="PAYPALISHIRING";
        String s="AB";
        String convert = convert(s, 1);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        if(numRows<=1){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder[] dp=new StringBuilder[numRows];
        for(int i=0;i<dp.length;i++){
            dp[i]=new StringBuilder("");
        }
        int index=0;
        boolean down=true;
        for(int i=0;i<chars.length;i++){
            if(down){
                if (index<numRows){
                    dp[index++].append(chars[i]);
                    if(index==numRows){
                        index--;
                        down=false;
                    }
                }
            }else if(!down){
                if(index<=(numRows-1)){
                    if (index>0){
                        dp[--index].append(chars[i]);
                    }
                    if(index==0){
                        down=true;
                        index++;
                    }
                }
            }

        }
        String res="";
        for(int i=0;i<dp.length;i++){
            res+=dp[i].toString();
        }
        return res;
    }
}
