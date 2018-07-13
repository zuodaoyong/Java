package com.java.lambda;


import com.java.lambda.interfaces.ConstructorFunc;
import com.java.lambda.interfaces.MyNumber;
import com.java.lambda.interfaces.MyNumberSingleParam;
import com.java.lambda.interfaces.SomeFunc;

public class LambdaDemo {

	private String name;
	public static void main(String[] args) {
		//test();
		//testVariable();
		//testStaticRef();
		//testObjRef();
		//testInstanceMethodWithObjRef();
		//testConstructorRef();
		
	}
	
	public static void testConstructorRef(){
		ConstructorFunc constructorFunc=HighTemp::new;
		System.out.println(constructorFunc.func(10).gethTemp());
	}
	
	public static void testInstanceMethodWithObjRef(){
		int count=0;
		HighTemp[] highTemps={new HighTemp(89),new HighTemp(82),
				new HighTemp(90),new HighTemp(89),
				new HighTemp(89),new HighTemp(91),
				new HighTemp(84),new HighTemp(83)};
		count=InstanceMethodWithObjRef.counter(highTemps,HighTemp::sameTemp,new HighTemp(89));
		System.out.println(count);
	}
	
	public static void testObjRef(){
		StringOps ops=new StringOps();
		print(ops::concat2, "abc");
	}
	
	public static void testStaticRef(){
		print(StringOps::concat, "abc");
	}
	
	public static void testVariable(){
		LambdaDemo demo=new LambdaDemo();
		demo.name="1";
		System.out.println("a="+demo.name);
		MyNumber myNumber;
		int num=0;
		myNumber=()->{
			demo.name="2";
			System.out.println(demo.name);
			return num;};
		System.out.println(myNumber.getValue());
	}
	
	public static void print(SomeFunc<String> strFunc,String str){
		System.out.println(strFunc.func(str));
	}
	
	public static void test(){
		MyNumber myNumber;
		myNumber= ()->123.45;
		System.out.println(myNumber.getValue());
		myNumber=()->Math.random()*100;
		System.out.println(myNumber.getValue());
		MyNumberSingleParam singleParam;
		singleParam=n->(n%2)==0;
		System.out.println(singleParam.judge(10));
		SomeFunc<Integer> intFunc;
		intFunc=(n)->n*2;
		System.out.println(intFunc.func(10));
		SomeFunc<String> strFunc;
		print(strFunc=(s)->{
			if(s.indexOf("&")!=-1){
				String[] strs = s.split("&");
				return strs[0];
			}else{
				return s;
			}
		},"b&c");
	}
	
}

