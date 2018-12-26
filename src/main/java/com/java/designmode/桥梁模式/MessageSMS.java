package com.java.designmode.桥梁模式;

public class MessageSMS implements MessageImplementor{

	@Override
	public void send(String message, String toUser) {
		System.out.println("站内短消息，message="+message+",toUser="+toUser);
	}

}
