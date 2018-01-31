package com.java.reflect;

import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) throws Exception {
		ReflectUser reflectUser=new ReflectUser();
		reflectUser.setName("neo");
		Class<? extends ReflectUser> clazz = reflectUser.getClass();
		Method method = clazz.getDeclaredMethod("getName", null);
		//反射调用private方法时报错，添加setAccessible解除java虚拟机的安全校验，即可调用
		method.setAccessible(true);
		Object value=method.invoke(reflectUser, null);
		System.out.println(value);
	}
}
