package com.java.algorithmv2.线性结构;

public class ArrayStack<E> {

    private int top;
    private Object[] arr;

    public ArrayStack(int maxSize){
        this.top=-1;
        this.arr=new Object[maxSize];
    }

    /**
     * 入栈
     * @param data
     */
    public void push(E data){
        //先判断栈是否为栈满
        if(this.top==this.arr.length-1){
            System.out.println("栈满");
            return;
        }
        this.arr[++top]=data;
    }

    /**
     * 取出栈顶元素
     */
    public E pop(){
        //判断栈是否为空
        if(this.top==-1){
            System.out.println("栈空");
            return null;
        }
        return (E)this.arr[this.top--];
    }

    public void show(){
        if(this.top==-1){
            System.out.println("栈空");
            return;
        }
        int temp=this.top;
        while (temp>-1){
            System.out.println(this.arr[temp--]);
        }
    }

    public boolean isEmpty(){
        return this.top==-1?true:false;
    }

    /**
     * 取出栈顶数据，但是不出栈
     * @return
     */
    public E get(){
        return (E)this.arr[this.top];
    }

}
