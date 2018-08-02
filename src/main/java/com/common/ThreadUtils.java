package com.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {
	private static ExecutorService threadPool = Executors.newFixedThreadPool(50);
    public static ExecutorService getExecutorService(){
    	return threadPool;
    }
}
