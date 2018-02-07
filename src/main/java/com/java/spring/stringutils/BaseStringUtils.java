package com.java.spring.stringutils;

import org.springframework.util.StringUtils;

public class BaseStringUtils {

	public static void main(String[] args) {
	    //System.out.println(containsWhitespace(builder));
		StringBuilder builder=new StringBuilder("absdfasdajkassdagdkjsg");
		System.out.println(deleteAny(builder, "sda"));
	}
	/**
	 * 判断sequence是否建有空格(sequence可以可以是String 也可以是StringBuild,StringBuffer)
	 * @param sequence
	 * @return
	 */
	public static boolean containsWhitespace(CharSequence sequence){
		return StringUtils.containsWhitespace(sequence);
	}
	
	/**
	 * 清除首尾空格(sequence可以可以是String 也可以是StringBuild,StringBuffer)
	 * @param sequence
	 * @return
	 */
	public static CharSequence trimWhitespace(CharSequence sequence){
		return StringUtils.trimWhitespace(sequence.toString());
	}
	
	/**
	 * 清除所有空格
	 * @param sequence
	 * @return
	 */
	public static CharSequence trimAllWhitespace(CharSequence sequence){
		return StringUtils.trimAllWhitespace(sequence.toString());
	}
	
	/**
	 * 清除字符串首部空格
	 * @param sequence
	 * @return
	 */
	public static CharSequence trimLeadingWhitespace(CharSequence sequence){
		return StringUtils.trimLeadingWhitespace(sequence.toString());
	}
	
	/**
	 * 清除字符串尾部空格
	 * @param sequence
	 * @return
	 */
	public static CharSequence trimTrailingWhitespace(CharSequence sequence){
		return StringUtils.trimTrailingWhitespace(sequence.toString());
	}
	
	/**
	 * 从字符串里删除指定的字符，且指定字符是字符串的首位
	 * @param sequence
	 * @return
	 */
	public static CharSequence trimLeadingCharacter(CharSequence sequence,char leadingCharacter){
		return StringUtils.trimLeadingCharacter(sequence.toString(),leadingCharacter);
	}
	
	/**
	 * 从字符串里删除指定的字符，且指定字符是字符串的尾位
	 * @param sequence
	 * @param leadingCharacter
	 * @return
	 */
	public static CharSequence trimTrailingCharacter(CharSequence sequence,char leadingCharacter){
		return StringUtils.trimTrailingCharacter(sequence.toString(),leadingCharacter);
	}
	
	/**
	 * 判断字符串的首位是否是指定字符串（不区分大小写）
	 * @param sequence
	 * @param prefix
	 * @return
	 */
	public static boolean startsWithIgnoreCase(CharSequence sequence,CharSequence prefix){
		return StringUtils.startsWithIgnoreCase(sequence.toString(),prefix.toString());
	}
	
	/**
	 * 判断字符串的尾位是否是指定字符串（不区分大小写）
	 * @param sequence
	 * @param prefix
	 * @return
	 */
	public static boolean endsWithIgnoreCase(CharSequence sequence,CharSequence prefix){
		return StringUtils.endsWithIgnoreCase(sequence.toString(),prefix.toString());
	}
	
	/**
	 * 从父串指定位置查找是否包含子串
	 * @param sequence
	 * @param sub
	 * @return
	 */
	public static boolean substringMatch(CharSequence sequence,int index,CharSequence sub){
		return StringUtils.substringMatch(sequence.toString(),index,sub.toString());
	}
	
	/**
	 * 字串在父串出现的次数
	 * @param sequence
	 * @param sub
	 * @return
	 */
	public static int countOccurrencesOf(CharSequence sequence,CharSequence sub){
		return StringUtils.countOccurrencesOf(sequence.toString(), sub.toString());
	}
	
	/**
	 * newPattern替换sequence中的oldPattern
	 * @param sequence
	 * @param oldPattern
	 * @param newPattern
	 * @return
	 */
	public static CharSequence replace(CharSequence sequence,CharSequence oldPattern,CharSequence newPattern){
		return StringUtils.replace(sequence.toString(), oldPattern.toString(), newPattern.toString());
	}
	
	/**
	 * 删除sequence中所有匹配上pattern字符串
	 * @param sequence
	 * @param pattern
	 * @return
	 */
	public static CharSequence delete(CharSequence sequence,CharSequence pattern){
		return StringUtils.delete(sequence.toString(), pattern.toString());
	}
	
	/**
	 * 从sequence删除匹配上charsToDelete的任意字符（即是没有全部匹配也删除）
	 * 例:sequence:abcasd   charsToDelete:asd 那么结果：bc
	 * @param sequence
	 * @param charsToDelete
	 * @return
	 */
	public static CharSequence deleteAny(CharSequence sequence, CharSequence charsToDelete){
		return StringUtils.deleteAny(sequence.toString(), charsToDelete.toString());
	}
}
