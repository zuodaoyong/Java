package com.java.designmode.工厂类模式.工厂方法模式;

import com.java.designmode.工厂类模式.篮球运动员;
import com.java.designmode.工厂类模式.运动员;

public class 篮球联盟 implements 球员联盟 {

	@Override
	public 运动员 注册() {
		return new 篮球运动员();
	}

}
