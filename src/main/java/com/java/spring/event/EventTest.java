package com.java.spring.event;

import org.springframework.context.ApplicationEvent;

public class EventTest extends ApplicationEvent{

	private String message;
	public EventTest(Object source,String message) {
		super(source);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
