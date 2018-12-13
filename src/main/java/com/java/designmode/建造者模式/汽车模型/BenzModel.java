package com.java.designmode.建造者模式.汽车模型;

public class BenzModel extends CarModel{

	@Override
	protected void start() {
		System.out.println("奔驰start");
	}

	@Override
	protected void stop() {
		System.out.println("奔驰stop");
	}

	@Override
	protected void alarm() {
		System.out.println("奔驰alarm");
	}

	@Override
	protected void engineBoom() {
		System.out.println("奔驰engineBoom");
	}

}
