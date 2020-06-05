package com.java.leetcode;


import java.util.Arrays;
import java.util.List;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class t345反转字符串中的元音字母 {

    static List<Character> vowels = Arrays.asList(new Character[]{'A','a','E','e','I','i','O','o','U','u'});
    public static void main(String[] args) {
        String hello = reverseVowels("hello");
        System.out.println(hello);
    }

    public static String reverseVowels(String s) {
        if(s==null||s.length()==1){
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        char temp;
        while (i <= j) {
            if (!vowels.contains(chars[i])) {
                i++;
            }else if (!vowels.contains(chars[j])) {
                j--;
            }else {
                temp=chars[j];
                chars[j]=chars[i];
                chars[i]=temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}
