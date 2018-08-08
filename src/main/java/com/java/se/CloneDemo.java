package com.java.se;

import com.alibaba.fastjson.JSON;

public class CloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneUser cloneUser=new CloneUser();
		cloneUser.setAge(1);
		cloneUser.setName("neo");
		A a = new A();
		a.setName("A");
		cloneUser.setA(a);
		Object clone = cloneUser.clone();
		System.out.println(JSON.toJSONString(cloneUser));
		a.setName("B");
		System.out.println(JSON.toJSONString(clone));
	}
	
}


class CloneUser implements Cloneable{
	private int age;
	private String name;
	private A a;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public A getA() {
		return a;
	}
	public void setA(A a) {
		this.a = a;
	}
	
	public Object clone() throws CloneNotSupportedException {
		CloneUser cloneUser=new CloneUser();
		A a = this.getA();
		A acopy=new A();
		acopy.setName(a.getName());
		cloneUser.setA(acopy);
		cloneUser.setName(this.getName());
		cloneUser.setAge(this.getAge());
		return cloneUser;
	}
}

class A{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}