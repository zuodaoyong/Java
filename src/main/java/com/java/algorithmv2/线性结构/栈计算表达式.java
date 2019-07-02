package com.java.algorithmv2.线性结构;

import com.common.CommonUtils;

import java.util.Stack;

// 表达式：3+2*6-2
public class 栈计算表达式 {

    public static void main(String[] args) {


        readExpression("3+2*6-2");
    }

    public static void readExpression(String expression){
        ArrayStack<Integer> numStack=new ArrayStack(10);//数字栈
        ArrayStack<String> operStack=new ArrayStack(10);//符号栈
        char[] chars = expression.toCharArray();
        for(char ch:chars){
           if(CommonUtils.isNumber(ch)){//是数字则入数字栈
               numStack.push(Integer.valueOf(ch));
           }else{
               operStack.push(String.valueOf(ch));
           }
        }
    }
}

