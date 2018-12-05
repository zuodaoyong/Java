package com.java.designmode.建造者模式.汽车组装;

public class JeepBuilder extends CarBuilder{

	Car car=new Car();
	@Override
	public void buildHead() {
		car.setHead("Jeep Head");
	}

	@Override
	public void buildBody() {
		car.setBody("Jeep Body");
	}

	@Override
	public void buildTail() {
		car.setTail("Jeep Tail");
	}

	@Override
	public Car getCar() {
		return car;
	}

}
