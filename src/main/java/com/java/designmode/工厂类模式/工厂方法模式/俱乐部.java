package com.java.designmode.工厂类模式.工厂方法模式;

import com.java.designmode.工厂类模式.运动员;

public class 俱乐部 {

	public static void main(String[] args) {
		    球员联盟 苏州球员协会=new 足球联盟();
		    运动员 前锋 = 苏州球员协会.注册();
		  前锋.跑();
	}
}
