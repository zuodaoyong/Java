package com.java.algorithmv2.线性结构;

import java.util.Stack;

public class 栈计算表达式修订版 {

    static Stack<Double> numStack=null;
    static Stack<Character> operStack=null;
    public static void main(String[] args) {
        //String expression = "7*2*2-5+1-5+3-4";
        String expression = "72*2*2-53+1-5+3-4";
        //创建两个栈，一个是数栈，一个是符号栈
        numStack=new Stack<>();
        operStack=new Stack<>();
        paeseExpression(expression);
    }

    private static void paeseExpression(String expression){
        int len=expression.length();
        int i=0;
        String keepNum="";
        while (i<len){
            //获取每个字符
            char ch = expression.charAt(i++);
            //判断是否是操作符
            if(isOper(ch)){
                //判断符号栈是否是空栈
                if(operStack.isEmpty()){
                    //放入操作符栈
                    operStack.push(ch);
                }else{
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
                    //在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if(priority(ch)<=priority(operStack.peek())){
                        double right = numStack.pop();
                        double left = numStack.pop();
                        Character oper = operStack.pop();
                        double calc = calc(left, right, oper);
                        numStack.push(calc);
                    }
                    operStack.push(ch);
                }
            }else{//如果是数，直接入栈
                keepNum+=ch;
                //判断是否到了最后一位
                if(i==expression.length()){
                    numStack.push(Double.valueOf(keepNum));
                    keepNum="";
                }else{
                    //判断ch下一位是不是数字，如果是数字则继续拼接在keepNum后
                    //获取ch的下一位
                    Character nextCh=expression.charAt(i);
                    if(isOper(nextCh)){
                        numStack.push(Double.valueOf(keepNum));
                        keepNum="";
                    }
                }
            }
        }
        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
        while(true) {
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if(operStack.isEmpty()) {
                break;
            }
            double right = numStack.pop();
            double left = numStack.pop();
            Character oper = operStack.pop();
            double res =calc(left, right, oper);
            numStack.push(res);//入栈
        }
        //将数栈的最后数，pop出，就是结果
        double res2 = numStack.pop();
        System.out.printf("表达式 %s = %.1f", expression, res2);
    }

    private static boolean isOper(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    //数字越大，则优先级就越高.
    private static int priority(Character oper) {
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有 +, - , * , /
        }
    }

    //计算方法
    private static double calc(double left, double right, int oper) {
        double res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = left + right;
                break;
            case '-':
                res = left - right;// 注意顺序
                break;
            case '*':
                res = left * right;
                break;
            case '/':
                res = left / right;
                break;
            default:
                break;
        }
        return res;
    }
}
