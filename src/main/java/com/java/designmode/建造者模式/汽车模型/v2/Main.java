package com.java.designmode.建造者模式.汽车模型.v2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		CarBuilder bmw=new BMWBuilder();
		List<String> sequence=new ArrayList<>();
		sequence.add("start");
		sequence.add("alarm");
		sequence.add("engineBoom");
		bmw.setSequence(sequence);
		bmw.getCarModel();
	}
}
