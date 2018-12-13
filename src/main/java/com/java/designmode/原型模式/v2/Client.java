package com.java.designmode.原型模式.v2;

import java.util.Random;

import com.java.designmode.原型模式.v1.AdvTemplate;
import com.java.designmode.原型模式.v2.Mail;

public class Client {

	private static int count=6;
	public static void main(String[] args) throws Exception{
		int i=0;
		//获取邮件模板
		Mail mail=new Mail(new AdvTemplate());
		Address address=new Address();
		address.setAddress("abc");
		mail.setAddress(address);
		mail.setTail("xxx银行版权所有");
		while(i<count){
			//Mail cloneMail=mail.clone();
			Mail cloneMail=mail.deepClone();
			cloneMail.getAddress().setAddress("def");
			cloneMail.setAppellation(getRandString(5)+"女士(先生)");
			cloneMail.setReceiver(getRandString(5)+"@"+getRandString(8)+".com");
			System.out.println(mail);
			//发送邮件
			sendMail(cloneMail);
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
