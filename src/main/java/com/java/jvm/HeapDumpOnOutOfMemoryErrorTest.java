package com.java.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapDumpOnOutOfMemoryErrorTest {

	public static void main(String[] args) throws InterruptedException {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
	static class OOMObject {
    }
}
