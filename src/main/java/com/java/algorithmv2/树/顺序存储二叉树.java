package com.java.algorithmv2.树;

/**
 *           1
 *        2    3
 *      4  5 6   7
 */
public class 顺序存储二叉树 {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        SeqStoreTree seqStoreTree=new SeqStoreTree(arr);
        seqStoreTree.prePrint(0);//1,2,4,5,3,6,7
        seqStoreTree.midPrint(0);//4,2,5,1,6,3,7
        seqStoreTree.postPrint(0);//4，5，2，6，7，3，1
    }
    static class SeqStoreTree{
        private int[] arr;
        public SeqStoreTree(int[] arr){
            this.arr=arr;
        }
        //前序遍历
        public void prePrint(int index){
            if(this.arr==null||index<0){
                System.out.println("数组为空");
                return;
            }
            System.out.println(arr[index]);
            //递归遍历左节点
            if(2*index+1<arr.length){
                prePrint(2*index+1);
            }
            //递归遍历右节点
            if(2*index+2<arr.length){
                prePrint(2*index+2);
            }
        }
        //中序遍历
        public void midPrint(int index){
            if(this.arr==null||index<0){
                System.out.println("数组为空");
                return;
            }
            //递归遍历左节点
            if(2*index+1<arr.length){
                midPrint(2*index+1);
            }
            System.out.println(arr[index]);
            //递归遍历右节点
            if(2*index+2<arr.length){
                midPrint(2*index+2);
            }
        }
        //后序遍历
        public void postPrint(int index){
            if(this.arr==null||index<0){
                System.out.println("数组为空");
                return;
            }
            //遍历左节点
            if(2*index+1<arr.length){
                postPrint(2*index+1);
            }
            //遍历右节点
            if(2*index+2<arr.length){
                postPrint(2*index+2);
            }
            System.out.println(arr[index]);
        }
    }





}
