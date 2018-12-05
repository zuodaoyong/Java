package com.java.designmode.建造者模式.汽车组装;

public class Main {

	public static void main(String[] args) {
		CarDirector carDirector=new CarDirector();
		CarBuilder carBuilder=new JeepBuilder();
		carDirector.buildCar(carBuilder);
		Car car = carBuilder.getCar();
		System.out.println(car.getHead());
		System.out.println(car.getBody());
		System.out.println(car.getTail());
	}
}
