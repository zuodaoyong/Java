package com.java.jvm.mat;

import java.util.ArrayList;
import java.util.List;

public class MatTest {

	/**
	 * -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
	 */
	private byte[] bs=new byte[1*1024*1024];
	
	public static void main(String[] args) {
		List<MatTest> list=new ArrayList<>();
		for(int i=0;i<100;i++){
			list.add(new MatTest());
		}
	}
}
