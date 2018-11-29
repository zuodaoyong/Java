package com.java.designmode.工厂类模式.抽象工厂模式;

public class AmdFactory implements AbstractFactory{

	@Override
	public Cpu createCpu() {
		return new AmdCpu(938);
	}

	@Override
	public MainBoard createMainBoard() {
		return new AmdMainBoard(938);
	}

}
