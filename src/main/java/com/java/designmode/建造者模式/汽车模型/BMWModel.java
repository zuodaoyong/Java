package com.java.designmode.建造者模式.汽车模型;

public class BMWModel extends CarModel{

	@Override
	protected void start() {
		System.out.println("宝马start");
	}

	@Override
	protected void stop() {
		System.out.println("宝马stop");
	}

	@Override
	protected void alarm() {
		System.out.println("宝马alarm");
	}

	@Override
	protected void engineBoom() {
		System.out.println("宝马engineBoom");
	}

}
