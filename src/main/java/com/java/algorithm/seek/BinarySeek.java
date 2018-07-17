package com.java.algorithm.seek;
/**
 * 二分查找
 * @author zdy48195
 *
 */
public class BinarySeek {

    public static void main(String[] args) {
    	int[] arr={1,2,3,4,5,6,7};
    	int n=0;
		int head=0;
		int tail=arr.length;
		int middle=0;
		while(head<=tail){
			n++;
			middle=(head+tail)/2;
			if(arr[middle]==7){
				System.out.println(middle+":"+n);
			    break;
			}else if(arr[middle]>7){
				tail=middle-1;
			}else if(arr[middle]<7){
				head=middle+1;
			}
		}
	}
}
