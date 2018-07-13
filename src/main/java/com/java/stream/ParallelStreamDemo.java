package com.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Stream;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		List<Double> list=new ArrayList<>();
		list.add(10.0);
		list.add(3.0);
		list.add(12.0);
		list.add(1.0);
		Stream<Double> parallelStream = list.parallelStream();
		/**
		 * 1.计算并行流中两个元素的平方根的乘积
		 */
		/*Double reduce = parallelStream.reduce(1.0,(a,b)->a*Math.sqrt(b),(a,b)->a*b);
		System.out.println(reduce);*/
		
		Spliterator<Double> spliterator = parallelStream.spliterator();
		/**
		 * 2.1迭代spliterator方式一
		 */
		//while(spliterator.tryAdvance((n)->System.out.println(n)));
		/**
		 * 2.2迭代spliterator方式二
		 */
		//spliterator.forEachRemaining((n)->System.out.println(n));
		/**
		 * 3.拆分流:适用于大数量的流，用于并行操作
		 */
		Spliterator<Double> spliterator2 = spliterator.trySplit();
		spliterator2.forEachRemaining((n)->System.out.print(n));
		System.out.println();
		spliterator.forEachRemaining((n)->System.out.print(n));
	}
	
	private static void printOptional(Optional optional){
		if(optional.isPresent()){
			System.out.println(optional.get());
		}
	}
}
