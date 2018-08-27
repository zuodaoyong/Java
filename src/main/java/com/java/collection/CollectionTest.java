package com.java.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CollectionTest {

	public static void main(String[] args) {
		Set<Integer> set=new HashSet<>();
		set.add(1);
		set.add(2);
		Set<Integer> unmodifiableSet = Collections.unmodifiableSet(set);
		System.out.println(unmodifiableSet);
		unmodifiableSet.add(3);
		System.out.println(unmodifiableSet);
	}
}
