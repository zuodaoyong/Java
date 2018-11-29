package com.java.designmode.工厂类模式.抽象工厂模式;

public class ComputerEngineer {

	public void prepare(AbstractFactory af){
		Cpu cpu = af.createCpu();
		MainBoard mainBoard = af.createMainBoard();
		cpu.calculate();
		mainBoard.installCPU();
	}
}
