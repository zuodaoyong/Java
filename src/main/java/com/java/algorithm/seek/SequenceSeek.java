package com.java.algorithm.seek;

public class SequenceSeek {

	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6,7};
		int t=4;
		int i;
		for(i=arr.length-1;arr[i]!=t;i--);
		System.out.println(i);
	}
}
