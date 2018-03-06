package com.java.lambda;

import com.java.lambda.interfaces.EqualFunc;

public class InstanceMethodWithObjRef {

	static <T> int counter(T[] vals,EqualFunc<T> f,T v){
		int count=0;
		for(int i=0;i<vals.length;i++){
			if(f.func(vals[i],v)) count++;
		}
		return count;
	}
	
}
