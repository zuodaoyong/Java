package com.java.algorithm.common;

import com.common.TimeUtils;
import com.java.functions.SortFunction;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

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


    public static void sortRandomNumber(SortFunction sortFunction) throws Exception{
		int len=8000000;
		Integer[] arr=new Integer[len];
		for(int i=0;i<len;i++){
			int v = Double.valueOf(Math.random() * len).intValue();
			arr[i]=v;
		}
		//System.out.println(Arrays.toString(arr));
		long startTime = System.currentTimeMillis();
		sortFunction.sort(arr);
		long endTime=System.currentTimeMillis();
		//System.out.println(Arrays.toString(arr));
		System.out.println("startTime="+TimeUtils.parseToFormatTime(new Date(startTime),TimeUtils.SECONDSTR));
		System.out.println("endTime="+TimeUtils.parseToFormatTime(new Date(endTime),TimeUtils.SECONDSTR));
	}
}
