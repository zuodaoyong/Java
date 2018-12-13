package com.java.designmode.建造者模式.汽车模型;

import java.util.ArrayList;
import java.util.List;
/**
 * 建造者使用场景:
 * 1、相同的方法，不同的执行顺序，产生不同的结果
 * 2、多个部件装配到一个对象中，但是产生的运行结果又不相同时
 * 3、产品类复杂，产品类的调用顺序不同产生不同的效果
 * 最关键的是：“顺序”
 */
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
			String actionName = this.sequence.get(i);
			if(actionName.equals("start")){
				this.start();
			}else if(actionName.equals("stop")){
				this.stop();
			}else if(actionName.equals("alarm")){
				this.alarm();
			}else if(actionName.equals("engineBoom")){
				this.engineBoom();
			}
		}
	}
	
	final public void setSequence(List<String> sequence){
		this.sequence=sequence;
	}
}
