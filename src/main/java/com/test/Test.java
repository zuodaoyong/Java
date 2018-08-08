package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import com.common.TimeUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		HashMap<String,String> map=new HashMap<>();
		map.put("1","1");
		String string = StringUtils.substringBetween("2018-08-03 16:20:00", "", " ");
		System.out.println(string);
	}
	
}
