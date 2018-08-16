package com.java.spring.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

	@Bean
	public ListenerTest1 listenerTest1(){
		return new ListenerTest1();
	}
	
	@Bean
	public ListenerTest2 listenerTest2(){
		return new ListenerTest2();
	}
}
