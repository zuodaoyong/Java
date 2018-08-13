package com.java.se.generic;

public class GenericDemo {

	public static void main(String[] args) {
		Generic<Integer> generic = new Generic<Integer>();
		generic.show_2("a");
		generic.show_2(1);
		generic.show1(2);
		generic.show3("6");
	}
}

class Generic<T>{
	public <T> void show_2(T t){
        System.out.println(t.toString());
    }
	
	public void show1(T t){
		System.out.println(t.toString());
	}
	
	/*public static void show3(T t){
		System.out.println(t.toString());
	}*/
	public static <T> void show3(T t){
		System.out.println(t.toString());
    }
}


