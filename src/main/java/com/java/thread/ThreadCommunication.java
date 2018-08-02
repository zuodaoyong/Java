package com.java.thread;

import com.common.ThreadUtils;

public class ThreadCommunication {

	public static void main(String[] args) {
		Business business =new Business();
		ThreadUtils.getExecutorService().submit(()->{
			for(int i=0;i<50;i++){
				try {
					business.sub(i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		for(int i=0;i<50;i++){
			try {
				business.main(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Business{
	boolean isSub=true;
	public synchronized void sub(int i) throws Exception{
		while(!isSub){
			this.wait();
		}
		for(int j=0;j<10;j++){
			System.out.println("sub第"+i+"遍，j="+j);
		}
		isSub=false;
		this.notify();
	}
	
	public synchronized void main(int i) throws Exception{
		while(isSub){
			this.wait();
		}
		for(int j=0;j<100;j++){
			System.out.println("main第"+i+"遍，j="+j);
		}
		isSub=true;
		this.notify();
	}
}