package com.java.designmode.工厂类模式.简单工厂模式;

import com.java.designmode.工厂类模式.运动员;

public class 俱乐部 {

	private static 运动员 守门员;
	private static 运动员 后卫;
	private static 运动员 前锋;
	public static void main(String[] args) {
		守门员=球员联盟.注册足球运动员();
		后卫=球员联盟.注册足球运动员();
		前锋=球员联盟.注册足球运动员();
		前锋.跑();
	}
}
