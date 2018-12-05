package com.java.designmode.建造者模式.汽车部件;

/**
 * 建造工具
 * @author zdy48195
 *
 */
public class ConcreteBuilder implements Builder{

	private Part partA,partB,partC;
	@Override
	public void buildPartA() {
		System.out.println("建造A");
	}

	@Override
	public void buildPartB() {
		System.out.println("建造B");
	}

	@Override
	public void buildPartC() {
		System.out.println("建造C");
	}

	@Override
	public Product getResult() {
		return null;
	}

}
