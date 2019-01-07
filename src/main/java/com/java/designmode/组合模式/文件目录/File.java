package com.java.designmode.组合模式.文件目录;

import java.util.List;

public class File implements Root{

	String name;
	
	public File(String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean addFile(Root file) {
		return false;
	}

	@Override
	public boolean removeFile(Root file) {
		return false;
	}

	@Override
	public List<Root> getFile() {
		return null;
	}

	@Override
	public void display() {
		System.out.println("File:"+name);
	}

}
