package com.java.designmode.建造者模式.汽车组装;

/**
 * 汽车组装抽象类
 * @author zdy48195
 *
 */
public abstract class CarBuilder {

	public abstract void buildHead();//组装车头
	public abstract void buildBody();//组装车身
	public abstract void buildTail();//组装车尾
	public abstract Car getCar();//获取组装好的车
}
