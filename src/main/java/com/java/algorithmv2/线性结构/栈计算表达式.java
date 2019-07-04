package com.java.algorithmv2.线性结构;

import com.common.CommonUtils;

import java.util.Arrays;
import java.util.List;

// 表达式：3+2*6-2
public class 栈计算表达式 {

    private static ArrayStack<Integer> numStack;
    private static ArrayStack<String> operStack;
    public static void main(String[] args) {

        readExpression("30+2*6-2");
    }

    public static void readExpression(String expression){
        numStack=new ArrayStack(10);//数字栈
        operStack=new ArrayStack(10);//符号栈
        char[] chars = expression.toCharArray();
        for(int i=0;i<chars.length;i++){
            String ement=String.valueOf(chars[i]);
           if(CommonUtils.isNumber(ement)){//是数字则入数字栈
               numStack.push(Integer.valueOf(ement));
           }else{
               if(operStack.isEmpty()){
                   operStack.push(ement);
               }else{
                   boolean oldOperIsTriggerCalc = oldOperIsTriggerCalc(ement);
                   if(oldOperIsTriggerCalc){
                       operStack.push(ement);
                   }else{
                       boolean currOperIsTriggerCalc = currOperIsTriggerCalc(ement, chars, i);
                       if(currOperIsTriggerCalc){
                           i++;
                       }
                   }
               }
           }
        }
        //遍历操作栈和数字栈
        finalCalc();
        numStack.show();
    }


    private static void finalCalc(){
        while (!operStack.isEmpty()){
            String pop = operStack.pop();
            Integer right = numStack.pop();
            Integer left = numStack.pop();
            Integer calc = calc(left, right, pop);
            numStack.push(calc);
        }
    }

    /**
     * 栈中操作符是否触发计算
     * @return
     */
    private static boolean oldOperIsTriggerCalc(String currCh){
        //获取操作栈顶元素
        String pop = operStack.get();
        boolean isHighPriority = isHighPriority(pop);
        boolean currIsHighPriority = isHighPriority(currCh);
        boolean resultFlag=false;
        if(isHighPriority||!currIsHighPriority){
            pop = operStack.pop();
            Integer pop2 = numStack.pop();
            Integer pop1 = numStack.pop();
            Integer result= calc(pop1, pop2, pop);
            numStack.push(result);
            resultFlag=true;
        }
        return resultFlag;
    }

    /**
     * 是否要触发计算
     * @return
     */
    private static boolean currOperIsTriggerCalc(String ch,char[] chars,int i){

        boolean currIsHighPriority = isHighPriority(ch);
        if(currIsHighPriority){
            Integer left = numStack.pop();
            Integer right=Integer.valueOf(String.valueOf(chars[i+1]));
            Integer result= calc(left, right, ch);
            numStack.push(result);
        }
        return currIsHighPriority;
    }

    /**
     * 是否是高优先级
     * @param ch
     * @return
     */
    private static boolean isHighPriority(String ch){
        List<String> level1s= Arrays.asList(new String[]{"*","/"});
        return level1s.contains(ch);
    }

    private static Integer calc(int left,int right,String oper){
      switch (oper){
          case "*":
              return left*right;
          case "/":
              return left/right;
          case "+":
              return left+right;
          case "-":
              return left-right;
          default:
              return null;
      }
    }

    /**
     * 获取操作符的优先级
     * @param oper
     * @return
     */
    private static int getPriority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;
        }
    }
}

