package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.common.TimeUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		Map<String,String> map=new TreeMap<>();
		map.put("1","1");
		map.put("2","2");
		System.out.println(map);
	}
}
