package com.java.designmode.桥梁模式;

public class UrgencyMessage extends AbstractMessage{

	public UrgencyMessage(MessageImplementor impl) {
		super(impl);
	}

	public void sendMessage(String message,String toUser){
		message="加急："+message;
		super.sendMessage(message, toUser);
	}
}
