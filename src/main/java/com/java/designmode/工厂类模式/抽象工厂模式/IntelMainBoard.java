package com.java.designmode.工厂类模式.抽象工厂模式;

public class IntelMainBoard implements MainBoard{

	private int cpuHoles=0;
	
	public IntelMainBoard(int cpuHoles){
		this.cpuHoles=cpuHoles;
	}
	
	@Override
	public void installCPU() {
		System.out.println("Intel 主板的CPU插槽孔数："+cpuHoles);
	}

}
