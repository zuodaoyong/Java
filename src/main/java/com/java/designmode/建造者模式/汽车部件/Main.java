package com.java.designmode.建造者模式.汽车部件;

public class Main {

	public static void main(String[] args) {
		Builder concreteBuilder=new ConcreteBuilder();
		Director director=new Director(concreteBuilder);
		director.construct();
		Product product=concreteBuilder.getResult();
		
	}
}
