package com.java.designmode.建造者模式.汽车组装;

/**
 * 汽车
 * @author zdy48195
 *
 */
public class Car {

	private String head;//车头
	private String body;//车身
	private String tail;//车尾
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTail() {
		return tail;
	}
	public void setTail(String tail) {
		this.tail = tail;
	}
	
}
