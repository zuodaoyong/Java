package com.java.spring.type;

import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import com.java.algorithm.common.CommonUtils;


public class TypeTest {

	public static void main(String[] args) throws Exception{
		//parameterizedTypeTest();
		TypeVariableTest();
	}
	
	public static void TypeVariableTest() throws NoSuchFieldException, SecurityException{
		Super<Integer> super1=new Super<Integer>();
        Field field = super1.getClass().getDeclaredField("t");
        Type type = field.getGenericType();
        TypeVariable typeVariable=(TypeVariable)type;
        Type[] bounds = typeVariable.getBounds();//Object
        CommonUtils.print(bounds);
        String name = typeVariable.getName();//T
        System.out.println(name);
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();//Super
	    System.out.println(genericDeclaration);
	}
	
	public static void parameterizedTypeTest(){
		Foo<Integer> foo=new Foo<Integer>();
        Type fooType = foo.getClass().getGenericSuperclass();//获取foo的直接父类
        ParameterizedType pt=(ParameterizedType) fooType;
        Type type2 = pt.getActualTypeArguments()[0];
        System.out.println(type2);
	}
}

class Foo<Integer> extends Super<Integer>{
}

class Super<T extends Object>{
	private T t;
}