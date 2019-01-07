package com.java.designmode.组合模式.文件目录;

public class Main {

	public static void main(String[] args) {
		Root root1=new Folder("c://");
		Root root2=new Folder("d://");
		Root win=new Folder("windows");
		Root sys=new Folder("system");
		Root hw=new File("Hello.java");
		root1.addFile(win);
		root1.addFile(sys);
		win.addFile(hw);
		root1.display();
		root2.display();
	}
}
