package com.java.designmode.建造者模式.汽车组装;

public class CarDirector {

	public void buildCar(CarBuilder carBuilder){
		carBuilder.buildHead();
		carBuilder.buildBody();
		carBuilder.buildTail();
	}
}
