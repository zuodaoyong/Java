package com.test;

import com.common.TimeUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Long parseTime = TimeUtils.parseTime("2018-01-03 00:00:00");
		System.out.println(parseTime);
	}
}
