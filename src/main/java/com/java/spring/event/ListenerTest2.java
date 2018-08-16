package com.java.spring.event;

import org.springframework.context.ApplicationListener;

public class ListenerTest2 implements ApplicationListener<EventTest>{

	@Override
	public void onApplicationEvent(EventTest event) {
		System.out.println("test2:"+event.getMessage());
	}

}
