package com.java.algorithmv2.线性结构;


public class 二维数组和稀疏数组相互转化 {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[4][5] = 2;
        System.out.println("原始数组：");
        printArr(arr);
        int[][] arrToSparse = arrToSparse(arr, 3);
        System.out.println("原始数组转稀疏数组：");
        printArr(arrToSparse);
        System.out.println("稀疏数组转原始数组：");
        int[][] arr1 = sparseToArr(arrToSparse);
        printArr(arr1);
    }

    /**
     * 稀疏数组转二维数组
     * @param sparse
     * @return
     */
    private static int[][] sparseToArr(int[][] sparse){
        //获取二维数组的总行数和总列数，生成二维数组
        int[][] arr=new int[sparse[0][0]][sparse[0][1]];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
               for(int k=1;k<sparse.length;k++){
                   if((sparse[k][0]==i)&&(sparse[k][1]==j)){
                       arr[i][j]=sparse[k][2];
                   }
               }
            }
        }
        return arr;
    }
    /**
     * 二维数组转稀疏数组
     * @param arr
     * @return
     */
    private static int[][] arrToSparse(int[][] arr,int num){
        //计算二维数组的行数和列数
        int totalRow=arr.length;
        int totalCol=arr[0].length;
        int[][] sparse=new int[num+1][3];
        sparse[0][0]=totalRow;
        sparse[0][1]=totalCol;
        sparse[0][2]=num;
        int k=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    ++k;
                    sparse[k][0]=i;
                    sparse[k][1]=j;
                    sparse[k][2]=arr[i][j];
                }
            }
        }
        return sparse;
    }

    /**
     * 打印数组
     * @param arr
     */
    private static void printArr(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
