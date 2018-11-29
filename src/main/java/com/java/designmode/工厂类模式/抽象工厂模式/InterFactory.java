package com.java.designmode.工厂类模式.抽象工厂模式;

public class InterFactory implements AbstractFactory{

	@Override
	public Cpu createCpu() {
		return new InterlCpu(755);
	}

	@Override
	public MainBoard createMainBoard() {
		return new IntelMainBoard(755);
	}

}
