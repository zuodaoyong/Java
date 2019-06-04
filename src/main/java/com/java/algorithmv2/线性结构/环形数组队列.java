package com.java.algorithmv2.线性结构;

public class 环形数组队列 {
    public static void main(String[] args) {
        CirleArrayQueue arrayQueue=new CirleArrayQueue(10);
        for(int i=0;i<20;i++){
            arrayQueue.add(i);
        }
        arrayQueue.showQueue();
        System.out.println(arrayQueue.pop()+"出队");
        arrayQueue.showQueue();
    }

}

class CirleArrayQueue{
    private int maxSize;//队列最大容量
    private int front;//队头
    private int rear;//队尾的后一个位置
    private int[] arr;

    public CirleArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        this.front=0;
        this.rear=0;
    }

    /**
     * 判断队列是否满
     * @return
     */
    private boolean isFull(){
        return (this.rear+1)%maxSize==this.front;
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
        arr[this.rear]=e;
        this.rear=(this.rear+1)%this.maxSize;
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
        int e=arr[this.front];
        this.front=(this.front+1)%this.maxSize;
        return e;
    }

    /**
     * 显示队列
     */
    public void showQueue(){
        for(int i=this.front;i<this.front+getRealLen();i++){
            System.out.print(arr[i%this.maxSize]+" ");
        }
    }

    private int getRealLen(){
       return  (this.rear+this.maxSize-this.front)%this.maxSize;
    }
}
