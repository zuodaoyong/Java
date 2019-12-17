package com.java.algorithm.sort;

import com.java.algorithm.common.CommonUtils;
import com.java.functions.SortFunction;


public class 希尔排序 {
    public static void main(String[] args) throws Exception {
        //Integer[] arr=new Integer[]{12,1,9,5,3,71,24};











        //change(arr);
        SortFunction<Integer> sortFunction=(arr)->{
for(int gap=arr.length/2;gap>0;gap=gap/2){
            for(int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
        }
            /*FileWriter writer=new FileWriter(new File("D:\\temp\\log.log"));
            StringBuffer msg=new StringBuffer("");
            for(int i=0;i<arr.length;i++){
                if(i%10==0){
                    writer.write(msg.toString());
                    writer.write("\r\n");
                    msg.delete(0,msg.length());
                }
                msg.append(arr[i]).append(" ");
            }*/
        };
        CommonUtils.sortRandomNumber(sortFunction);

        //System.out.println(Arrays.toString(arr));
    }

    private static void move(Integer[] arr){
        for(int gap=arr.length/2;gap>0;gap=gap/2){
            for(int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
        }
    }

    private static void change(Integer[] arr){
        int temp;
        for(int gap=arr.length/2;gap>0;gap=gap/2){
            for(int i=gap;i<arr.length;i++){
                //遍历各组中所有元素(共gap组)，步长gap
                for(int j=i-gap;j>=0;j-=gap){
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }
    }
}
