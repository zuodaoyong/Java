package com.java.leetcode;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 */
public class t392判断子序列 {

    public static void main(String[] args) {

        String s="axc";
        String t="ahbgdc";
        boolean subsequenceV2 = isSubsequenceV2(s, t);
        System.out.println(subsequenceV2);
    }

    public static boolean isSubsequence(String s, String t) {
        if(s==null||t==null){
            return false;
        }
        int i=0;
        int j=0;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        while (i<sArr.length&&j<tArr.length){
            if(sArr[i]==tArr[j]){
                i++;
            }
            j++;
        }
        if(i>=sArr.length){
            return true;
        }
        return false;
    }

    public static boolean isSubsequenceV2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            //indexOf（a, b）这里的意思是从指定位置b开始索引，查找字符a第一次出现的位置，
            //然后从这个位置作为开始索引点去查第二个字符的位置，查不到索引结果为-1
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
