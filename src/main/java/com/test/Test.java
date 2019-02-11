package com.test;


public class Test {

	public static void main(String[] args) throws Exception {
		int[] arr={49,38,65,97,76,13,27,10,54};
		sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	private static void sort(int[] arr){
		int[] brr=new int[arr.length];
		merge(arr, brr, 0, arr.length-1);
	}
	
	private static void merge(int[] arr,int[] brr,int left,int right){
		if(left<right){
			int middle=(left+right)>>1;
		    merge(arr, brr, left, middle);
		    merge(arr, brr, middle+1, right);
		    mergeSort(arr,brr,left,middle,right);
		}
	}

	private static void mergeSort(int[] arr, int[] brr, int left, int middle, int right) {
		int i=left;
		int j=middle+1;
		int k=left;
		while(i<=middle&&j<=right){
			if(arr[i]<=arr[j]){
				brr[k++]=arr[i++];
			}else{
				brr[k++]=arr[j++];
			}
		}
		while(i<=middle){
			brr[k++]=arr[i++];
		}
		while(j<=right){
			brr[k++]=arr[j++];
		}
		while(left<=right){
			arr[left]=brr[left++];
		}
	}
}
