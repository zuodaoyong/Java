package com.java.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTest1 implements ApplicationListener<EventTest>{

	@Override
	public void onApplicationEvent(EventTest event) {
		 System.out.println("test1:" + event.getMessage());
	}

}
