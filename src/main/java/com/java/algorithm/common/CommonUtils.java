package com.java.algorithm.common;

import java.util.Arrays;

public class CommonUtils {

	public static void print(Object[] arr){
	    Arrays.stream(arr)
	    .forEach(e->{
	    	System.out.print(e+" ");
	    });
	   
	}
	
	public static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
