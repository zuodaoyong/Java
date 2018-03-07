package com.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SequentialStreamDemo {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(12);
		list.add(1);
		Stream<Integer> stream = list.stream();
		/**
		 * 1.取最小值
		 */
		/*Optional<Integer> min = stream.min(Integer::compare);
		if(min.isPresent()){
			System.out.println(min.get().intValue());
		}*/
		/**
		 * 取最大值
		 */
		/*Optional<Integer> max = stream.max(Integer::compareTo);
		if(max.isPresent()){
			System.out.println(max.get().intValue());
		}*/
		/**
		 * 3.排序并打印
		 */
		/*Stream<Integer> sorted = stream.sorted();
		sorted.forEach(System.out::println);*/
		/**
		 * 4.排序后过滤
		 */
		/*Stream<Integer> filter = stream.sorted().filter(n->n%2==1);
		filter.forEach(System.out::println);*/
		/**
		 * 5.遍历流中元素执行reduce的运算
		 */
		/*Optional<Integer> reduce = stream.reduce((a,b)->a*b);
		printOptional(reduce);*/
		/**
		 * 6.  reduce的第一个参数是初始值，遍历流中第一个元素和初始值运算成新值再和流中第二个元素运算
		 */
		/*Integer integer = stream.reduce(2,(a,b)->a*b);
		System.out.println(integer);*/
		
	}
	
	private static void printOptional(Optional optional){
		if(optional.isPresent()){
			System.out.println(optional.get());
		}
	}
}

