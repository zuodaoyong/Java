package com.java.designmode.建造者模式.汽车模型;

import java.util.ArrayList;
import java.util.List;

public abstract class CarModel {

	//执行顺序
	private List<String> sequence=new ArrayList<>();
	//开始
	protected abstract void start();
	//停止
	protected abstract void stop();
	//报警
	protected abstract void alarm();
	//引擎声音
	protected abstract void engineBoom();
	
	//模型运动
	final public void run(){
		//循环执行
		for(int i=0;i<sequence.size();i++){
			
		}
	}
}
