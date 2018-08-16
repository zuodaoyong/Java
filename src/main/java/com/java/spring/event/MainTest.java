package com.java.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainTest {

	public static void main(String[] args) {
	    ApplicationContext context=new AnnotationConfigApplicationContext(MainConfig.class);
	    context.publishEvent(new EventTest(context,"a"));
	}
}
