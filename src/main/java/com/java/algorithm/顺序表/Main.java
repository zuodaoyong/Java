package com.java.algorithm.顺序表;

public class Main {

	public static void main(String[] args) {
		SLType slType=new SLType();
		initSLType(slType);
		DATA data1=new DATA();
		data1.name="a";
		addData(slType, 0, data1);
		DATA data2=new DATA();
		data2.name="b";
		addData(slType, 0, data2);
		print(slType);
	}
	
	/**
	 * 初始化
	 * @param slType
	 */
	private static void initSLType(SLType slType){
		slType.listLen=0;
	}
	
	/**
	 * 计算顺序表的长度
	 * @param slType
	 * @return
	 */
	private static int getSLTypeLen(SLType slType){
		return slType.listLen;
	}
	
	/**
	 * 新增
	 * @param slType
	 * @param index
	 * @param data
	 */
	private static void addData(SLType slType,int index,DATA data){
		if(index>SLType.MAX_NUM){
			System.out.println("插入位置错误");
			return;
		}else{
			for(int i=slType.listLen;i>=index;i--){
				slType.list[i+1]=slType.list[i];
			}
			slType.list[index]=data;
			slType.listLen++;
		}
	}
	
	private static void print(SLType slType){
		DATA[] list = slType.list;
		for(int i=0;i<slType.listLen;i++){
			System.out.print(list[i].name+" ");
		}
	}
}
