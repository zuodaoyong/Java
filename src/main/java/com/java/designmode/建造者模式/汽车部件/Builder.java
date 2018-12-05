package com.java.designmode.建造者模式.汽车部件;

public interface Builder {

	void buildPartA();
	void buildPartB();
	void buildPartC();
	Product getResult();
}
