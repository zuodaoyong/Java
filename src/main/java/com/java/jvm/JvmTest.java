package com.java.jvm;

public class JvmTest {

	/**
	 * 参数调整:-Xms1024m -Xmx1024m -XX:+PrintGCDetails 
	 * @param args
	 */
	public static void main(String[] args) {
		long maxMemory = Runtime.getRuntime().maxMemory();//最大内存量
		long totalMemory = Runtime.getRuntime().totalMemory();//内存总量即初始内存大小
		System.out.println("maxMemory 字节数："+maxMemory+",maxMemory兆数："+maxMemory/(double)(1024*1024));
		System.out.println("totalMemory 字节数："+totalMemory+",totalMemory兆数："+totalMemory/(double)(1024*1024));
		System.out.println(314560/1024+699072/1024);
		testOutOfMemoryError();
	}
	
	private static void testOutOfMemoryError(){
		String str="123";
		while(true){
			str+=str;
		}
	}
}
