package com.java.designmode.单例模式;

public class 懒汉模式双重检查加锁 {

	private static 懒汉模式双重检查加锁 instance=null;
	
	private 懒汉模式双重检查加锁(){
	}
	
	public static 懒汉模式双重检查加锁 getInstance(){
		//先检查实例是否存在，不存在再进入同步块
		if(instance==null){
			synchronized(懒汉模式双重检查加锁.class){
				//进入同步块后再检查实例是否存在
				if(instance==null){
					instance=new 懒汉模式双重检查加锁();
				}
			}
		}
		return instance;
	}
}
