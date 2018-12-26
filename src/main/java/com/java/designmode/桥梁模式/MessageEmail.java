package com.java.designmode.桥梁模式;

public class MessageEmail implements MessageImplementor{

	@Override
	public void send(String message, String toUser) {
		System.out.println("Email短消息，message="+message+",toUser="+toUser);
	}

}
