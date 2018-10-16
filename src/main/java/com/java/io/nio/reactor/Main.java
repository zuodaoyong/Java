package com.java.io.nio.reactor;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reactor reactor=new Reactor(1234);
		Thread thread=new Thread(reactor);
		thread.start();
		
	}
}
