package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import com.common.TimeUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		Random random=new Random();
		for(int i=0;i<30;i++){
			System.out.print(random.nextInt(100)+",");
		}
		
	}
	
}
