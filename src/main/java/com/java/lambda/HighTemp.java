package com.java.lambda;

public class HighTemp {

	private int hTemp;
	public HighTemp(int ht) {
		this.hTemp=ht;
	}
	boolean sameTemp(HighTemp ht2){
		return hTemp==ht2.hTemp;
	}
	boolean lessThanTemp(HighTemp ht2){
		return hTemp<ht2.hTemp;
	}
	public int gethTemp() {
		return hTemp;
	}
	public void sethTemp(int hTemp) {
		this.hTemp = hTemp;
	}
	
}
