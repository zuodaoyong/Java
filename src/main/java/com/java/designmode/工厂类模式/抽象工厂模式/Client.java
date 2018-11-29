package com.java.designmode.工厂类模式.抽象工厂模式;

public class Client {

	public static void main(String[] args) {
		ComputerEngineer engineer=new ComputerEngineer();
		AbstractFactory abstractFactory=new InterFactory();
		engineer.prepare(abstractFactory);
	}
}
