package com.java.functions;

import java.io.IOException;

@FunctionalInterface
public interface SortFunction<T> {
    void sort(T[] arr) throws IOException;
}
