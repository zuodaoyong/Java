package com.java.designmode.建造者模式.汽车模型.v2;

import java.util.List;

import com.java.designmode.建造者模式.汽车模型.BenzModel;
import com.java.designmode.建造者模式.汽车模型.CarModel;

public class BenzBuilder extends CarBuilder{

	CarModel benz=new BenzModel();
	@Override
	void setSequence(List<String> sequence) {
		this.benz.setSequence(sequence);
	}

	@Override
	CarModel getCarModel() {
		return this.benz;
	}

}
