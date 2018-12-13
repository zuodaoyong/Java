package com.java.designmode.原型模式.v1;

/**
 * 广告信
 * @author zdy48195
 *
 */
public class AdvTemplate {

	
	private String advSubject="XX银行信用卡抽奖活动";
	private String advContext="国庆抽奖活动通知：只要刷卡就送1百万";
	public String getAdvSubject() {
		return advSubject;
	}
	public void setAdvSubject(String advSubject) {
		this.advSubject = advSubject;
	}
	public String getAdvContext() {
		return advContext;
	}
	public void setAdvContext(String advContext) {
		this.advContext = advContext;
	}
	
}
