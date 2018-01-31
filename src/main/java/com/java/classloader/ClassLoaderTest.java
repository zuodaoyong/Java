package com.java.classloader;

import java.lang.reflect.Method;

public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		DiskClassLoader diskClassLoader=new DiskClassLoader("E:\\\\Study\\\\java\\\\classloader\\\\lib");
		Class<?> loadClass = diskClassLoader.loadClass("com.classloader.Test");
		if(loadClass!=null){
			Object instance = loadClass.newInstance();
			//say是Test.class里的方法名
			Method method=loadClass.getDeclaredMethod("say",null);
			Object value = method.invoke(instance, null);
		}
	}
	
}
