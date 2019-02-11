package com.java.algorithm.sort;

public class 快速排序 {

	public static void main(String[] args) {
		int[] arr={15,22,13,27,12,10,20,25,8};
		quickSort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	private static void quickSort(int[] arr,int left,int right){
		if(left>=right){
			return;
		}
		//int index=partSort1(arr, left, right);//左右指针
		//int index=partSort2(arr, left, right);//挖坑
		int index=partSort3(arr, left, right);//前后指针法	
		quickSort(arr, left,index-1);
		quickSort(arr, index+1,right);
	}
	
	/**
	 * 前后指针法
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partSort3(int[] arr,int left,int right){
		if(left<right){
			int key=arr[right];
			int cur=left;
			int pre=cur-1;
			while(cur<right){
				while(arr[cur]<key&&++pre!=cur){
					swap(arr, cur, pre);
				}
				++cur;
			}
			swap(arr, ++pre, right);
			return pre;
		}
		return -1;
	}
	
	/**
	 * 挖坑法
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partSort2(int[] arr,int left,int right){
		int key=arr[right];
		while(left<right){
			while(left<right&&arr[left]<=key){
				++left;
			}
			arr[right]=arr[left];
			while(left<right&&arr[right]>=key){
				--right;
			}
			arr[left]=arr[right];
		}
		arr[right]=key;
		return right;
	}
	
	/**
	 * 左右指针法
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
    private static int partSort1(int[] arr,int left,int right){
		int key=arr[right];
		int key_index=right;
		while(left<right){
			while(left<right&&arr[left]<=key){
				++left;
			}
			while(left<right&&arr[right]>=key){
				--right;
			}
			swap(arr, left, right);
		}
		swap(arr, left, key_index);
		return left;
	}
    
    private static void swap(int[] arr,int item1,int item2){
    	int t=arr[item1];
    	arr[item1]=arr[item2];
    	arr[item2]=t;
    }
}
