package com.java.designmode.工厂类模式.抽象工厂模式;

public class AmdCpu implements Cpu{

	private int pins=0;
	public AmdCpu(int pins){
		this.pins=pins;
	}
	
	@Override
	public void calculate() {
		System.out.println("amd cpu 针脚数："+pins);
	}

}
