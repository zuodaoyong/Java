package com.java.designmode.原型模式.v2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.java.designmode.原型模式.v1.AdvTemplate;

public class Mail implements Cloneable,Serializable{

	private String receiver;//收件人
	private String subject;//邮件名称
	private String appellation;//称谓
	private String context;//邮件内容
	private String tail;//邮件尾部
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Mail(AdvTemplate advTemplate){
		this.context=advTemplate.getAdvContext();
		this.subject=advTemplate.getAdvSubject();
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAppellation() {
		return appellation;
	}
	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getTail() {
		return tail;
	}
	public void setTail(String tail) {
		this.tail = tail;
	}
	
	@Override
	public Mail clone() throws CloneNotSupportedException {
		Mail mail=null;
		try {
			mail=(Mail) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mail;
	}
	
	public Mail deepClone() throws Exception{
		ByteArrayOutputStream bao=new ByteArrayOutputStream();
		ObjectOutputStream stream=new ObjectOutputStream(bao);
		stream.writeObject(this);
		ByteArrayInputStream inputStream=new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(inputStream);
		return (Mail) ois.readObject();
	}
}
