package com.java.designmode.单例模式;

/**
 * 需要使用单例模式的场景:
 * 1.要求唯一序列的环境
 * 2.在整个项目中需要访问一个共享访问点或共享数据
 * 3.创建一个对象需要消耗的资源过多，如访问I/O，访问数据库
 * 4.需要定义大量静态常量和静态方法的环境
 * @author zdy48195
 *
 */
public class 一种更好的单例实现 {

	/**
	 * 类级内部类是与外部类无关，
	 * 项目启动的时候不会立即加载，
	 * 而是用到这个内部类才加载
	 */
	//静态初始化器有jvm保证线程安全
	private static class SingletonHolder{
		private static 一种更好的单例实现 instance=new 一种更好的单例实现();
	}
	
	private 一种更好的单例实现(){}
	
	public static 一种更好的单例实现 getInstance(){
		return SingletonHolder.instance;
	}
}
