package com.test;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Test {

	public static void main(String[] args) throws Exception {
		MultiValueMap<String,String> map=new LinkedMultiValueMap<>();
		map.add("a","1");
		map.add("a","2");
		System.out.println(map.get("a"));
		
		
	}
	
}
