package com.test;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Test {

	public static void main(String[] args) throws Exception {
		int[] a={1,2,3,4,5,6,7};
		int low=0;
		int high=a.length;
		int middle=(low+high)>>1;
		int t=3;
		while(low<=high){
			middle=(low+high)>>1;
			if(a[middle]==t){
				System.out.println(a[middle]+":"+middle);
				break;
			}else if(a[middle]>t){
				high=middle-1;
			}else if(a[middle]<t){
				low=middle+1;
			}
		}
		
		
	}
	
}
