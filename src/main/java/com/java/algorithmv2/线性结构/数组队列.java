package com.java.algorithmv2.线性结构;

public class 数组队列 {

    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(10);
        for(int i=0;i<20;i++){
            arrayQueue.add(i);
        }
        arrayQueue.showQueue();
        System.out.println(arrayQueue.pop()+"出队");
        arrayQueue.showQueue();
    }


}

class ArrayQueue{
    private int maxSize;//队列最大容量
    private int front;//队头
    private int rear;//队尾
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        this.front=-1;
        this.rear=-1;
    }

    /**
     * 判断队列是否满
     * @return
     */
    private boolean isFull(){
        return this.rear==maxSize-1;
    }

    /**
     * 判断队列是否空
     * @return
     */
    private boolean isEmpty(){
        return this.front==this.rear;
    }

    /**
     * 添加元素到队列
     * @param e
     */
    public void add(int e){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[++this.rear]=e;
    }

    /**
     * 出队
     * @return
     */
    public Integer pop(){
        if(isEmpty()){
            System.out.println("队列为空");
            return null;
        }
        int e=arr[++this.front];
        return e;
    }

    /**
     * 显示队列
     */
    public void showQueue(){
        for(int i=this.front+1;i<=this.rear;i++){
            System.out.print(arr[i]+" ");
        }
    }
}