package com.java.algorithm.sort;

import com.java.algorithm.common.CommonUtils;

/**
 * 插入排序
 * @author zdy48195
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		Integer[] arr=new Integer[]{1,12,9,5,3};
		CommonUtils.print(arr);
		insertSort(arr);
		System.out.println();
		CommonUtils.print(arr);
	}
	
	public static void insertSort(Integer[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=i;j>0;j--){
				if(arr[j].compareTo(arr[j-1])<0){
					CommonUtils.swap(arr,j,j-1);
				}
			}
		}
	}
}
