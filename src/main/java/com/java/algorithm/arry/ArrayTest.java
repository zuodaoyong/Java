package com.java.algorithm.arry;

public class ArrayTest {

	public static void main(String[] args) {
		int[][] arry_a={{2,3},{4,1}};
		int[][] arry_b={{5,7},{6,8}};
		int[][] arry_c=new int[2][2];
		int n=arry_a.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					arry_c[i][j]+=arry_a[i][k]*arry_b[k][j];
				}
			}
		}
		for(int i=0;i<arry_c.length;i++){
			for(int j=0;j<arry_c.length;j++){
				System.out.println(arry_c[i][j]);
			}
		}
	}
}
