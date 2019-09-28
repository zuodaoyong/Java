package com.java.functions;

@FunctionalInterface
public interface SortFunction<T> {
    void sort(T[] arr);
}
