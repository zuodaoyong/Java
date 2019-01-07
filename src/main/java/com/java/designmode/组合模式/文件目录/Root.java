package com.java.designmode.组合模式.文件目录;

import java.util.List;

public interface Root {

	public boolean addFile(Root file);
	public boolean removeFile(Root file);
	public List<Root> getFile();
	public void display();
	
}
