package com.java.designmode.建造者模式.汽车部件;

/**
 * 建造者
 * @author zdy48195
 *
 */
public class Director {

	private Builder builder;
	
	public Director(Builder builder) {
		this.builder=builder;
	}
	
	public void construct(){
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
	}
}
