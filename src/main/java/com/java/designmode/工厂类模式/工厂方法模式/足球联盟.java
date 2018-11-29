package com.java.designmode.工厂类模式.工厂方法模式;

import com.java.designmode.工厂类模式.足球运动员;
import com.java.designmode.工厂类模式.运动员;

public class 足球联盟  implements 球员联盟{

	@Override
	public 运动员 注册() {
		return new 足球运动员();
	}

}
