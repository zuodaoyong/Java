package com.java.designmode.建造者模式.汽车模型.v2;

import java.util.List;

import com.java.designmode.建造者模式.汽车模型.CarModel;

public abstract class CarBuilder {

	abstract void setSequence(List<String> sequence);
	
	abstract CarModel getCarModel();
}
