package com.java.classloader.contextclassloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.java.classloader.DiskClassLoader;

public class ContextClassLoaderTest {

	public static void main(String[] args) throws Exception {
		//loadClass1();
		//子线程加载
		//threadLoadClass_error();
		threadLoadClass_success();
	}

	private static void threadLoadClass_success() {
		final DiskClassLoader classLoader=new DiskClassLoader("E:\\Study\\java\\classloader\\lib");
		new Thread(new Runnable() {
			
			public void run() {
				try {
					Thread.currentThread().setContextClassLoader(classLoader);
					ClassLoader cl = Thread.currentThread().getContextClassLoader();
					Class<?> clazz = cl.loadClass("com.java.classloader.contextclassloader.SpeakTest");
					Method method=clazz.getDeclaredMethod("speak", null);
					method.invoke(clazz.newInstance(), null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	private static void threadLoadClass_error() {
		new Thread(new Runnable() {
			
			public void run() {
				try {
					//子线程的ContextClassLoader是AppClassLoader
					//AppClassLoader加载不了父线程当中已经加载的SpeakTest.class内容。
					ClassLoader cl = Thread.currentThread().getContextClassLoader();
					Class<?> clazz = cl.loadClass("com.java.classloader.contextclassloader.SpeakTest");
					Method method=clazz.getDeclaredMethod("speak", null);
					method.invoke(clazz.newInstance(), null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private static void loadClass1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {
		DiskClassLoader classLoader=new DiskClassLoader("E:\\Study\\java\\classloader\\lib");
		Class<?> clazz = classLoader.loadClass("com.java.classloader.contextclassloader.SpeakTest");
		Method method=clazz.getDeclaredMethod("speak", null);
		method.invoke(clazz.newInstance(), null);
	}
}
