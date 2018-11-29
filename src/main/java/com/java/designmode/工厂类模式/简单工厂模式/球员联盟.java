package com.java.designmode.工厂类模式.简单工厂模式;

import com.java.designmode.工厂类模式.篮球运动员;
import com.java.designmode.工厂类模式.足球运动员;
import com.java.designmode.工厂类模式.运动员;

public class 球员联盟 {

	public static 运动员 注册足球运动员(){
		return new 足球运动员();
	}
	
	public static 运动员 注册篮球运动员(){
		return new 篮球运动员();
	}
}
