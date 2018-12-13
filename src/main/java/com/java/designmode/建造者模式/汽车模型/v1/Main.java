package com.java.designmode.建造者模式.汽车模型.v1;

import java.util.ArrayList;
import java.util.List;

import com.java.designmode.建造者模式.汽车模型.BenzModel;
import com.java.designmode.建造者模式.汽车模型.CarModel;

public class Main {
	public static void main(String[] args) {
		CarModel model=new BenzModel();
		List<String> sequence=new ArrayList<>();
		sequence.add("start");
		sequence.add("alarm");
		sequence.add("engineBoom");
		model.setSequence(sequence);
		model.run();
	}
}
