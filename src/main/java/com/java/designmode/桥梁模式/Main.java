package com.java.designmode.桥梁模式;

public class Main {

	public static void main(String[] args) {
		MessageImplementor implementor=new MessageSMS();
		AbstractMessage message = new CommonMessage(implementor);
		message.sendMessage("请喝杯茶", "小李");
		//创建紧急的消息
		message=new UrgencyMessage(implementor);
		message.sendMessage("请喝杯茶", "小李");
		
		//把发送方式切换成Email
		implementor=new MessageEmail();
		message = new CommonMessage(implementor);
		message.sendMessage("请喝杯茶", "小李");
		//创建紧急的消息
		message=new UrgencyMessage(implementor);
		message.sendMessage("请喝杯茶", "小李");
	}
}
