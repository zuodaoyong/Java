package com.java.designmode.原型模式.v1;

import java.util.Random;

public class Client {

	private static int count=6;
	public static void main(String[] args) {
		int i=0;
		//获取邮件模板
		Mail mail=new Mail(new AdvTemplate());
		mail.setTail("xxx银行版权所有");
		while(i<count){
			mail.setAppellation(getRandString(5)+"女士(先生)");
			mail.setReceiver(getRandString(5)+"@"+getRandString(8)+".com");
		    //发送邮件
			sendMail(mail);
			i++;
		}
	}
	
	private static void sendMail(Mail mail){
		System.out.println("标题："+mail.getSubject()+",收件人："+mail.getReceiver()+"发送成功");
	}
	
	private static String getRandString(int length){
		String source="abcdefghijkmlnopqrstuvwxyz";
		StringBuffer buffer=new StringBuffer();
		Random random=new Random();
		for(int i=0;i<length;i++){
			buffer.append(source.charAt(random.nextInt(source.length())));
		}
		return buffer.toString();
	}
}
