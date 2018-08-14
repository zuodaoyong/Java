package com.java.spring.type;

import java.util.ArrayList;

import org.springframework.core.ResolvableType;

public class ResolvableTypeTest {

	public static void main(String[] args) {
		forClass();
	}
	
	public static void forClass(){
		ResolvableType resolvableType = ResolvableType.forClass(ExtendsList.class);
		System.out.println(resolvableType);
		System.out.println(resolvableType.getType().equals(ExtendsList.class));
	}
}

class ExtendsList extends ArrayList<CharSequence> {
	
}
