package com.common;

import java.util.regex.Pattern;

public class CommonUtils {

    public static boolean isNumber(String str){
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(str).matches();
    }
    public static boolean isNumber(char ch){
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(String.valueOf(ch)).matches();
    }
}
