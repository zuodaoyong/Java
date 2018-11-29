package com.java.designmode.工厂类模式.抽象工厂模式;

public class InterlCpu implements Cpu{

	private int pins=0;
	public InterlCpu(int pins){
		this.pins=pins;
	}
	@Override
	public void calculate() {
		System.out.println("intel cpu 针脚数："+pins);
	}

}
