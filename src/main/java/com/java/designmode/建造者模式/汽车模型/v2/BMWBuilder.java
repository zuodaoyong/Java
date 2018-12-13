package com.java.designmode.建造者模式.汽车模型.v2;

import java.util.List;

import com.java.designmode.建造者模式.汽车模型.BMWModel;
import com.java.designmode.建造者模式.汽车模型.CarModel;

public class BMWBuilder extends CarBuilder{

	CarModel bmw=new BMWModel();
	@Override
	void setSequence(List<String> sequence) {
		bmw.setSequence(sequence);
	}

	@Override
	CarModel getCarModel() {
		this.bmw.run();
		return this.bmw;
	}

}
