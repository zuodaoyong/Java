package com.java.designmode.组合模式.文件目录;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Root{

	String name;
	List<Root> folder;
    
	
	public Folder(String name) {
		super();
		this.name = name;
		this.folder =new ArrayList<>();
	}

	@Override
	public boolean addFile(Root file) {
		return folder.add(file);
	}

	@Override
	public boolean removeFile(Root file) {
		return folder.remove(file);
	}

	@Override
	public List<Root> getFile() {
		return folder;
	}

	@Override
	public void display() {
		System.out.println(name);
		for(Root f:folder){
			if(f instanceof Folder){
				System.out.println(" |");
			}
			f.display();
		}
	}

}
