package com.java.classloader;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DiskClassLoader extends ClassLoader{

	private String libPath;
	
	public DiskClassLoader(String libPath) {
		this.libPath=libPath;
	}
	
	/**
	 * 如果appClassLoader没有在项目环境里加载到类文件时，会请求父加载器加载libPath下指定的.class文件
	 * 如果在项目里找到要加载的文件则不调用该方法
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = getFileName(name);
		Path path=Paths.get(this.libPath,fileName);
		try {
			SeekableByteChannel seekableByteChannel = Files.newByteChannel(path,StandardOpenOption.READ);
			ByteBuffer buffer=ByteBuffer.allocate((int) seekableByteChannel.size());
			seekableByteChannel.read(buffer);
			return defineClass(name,buffer.array(), 0, buffer.array().length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.findClass(name);
	}
	
	/**
	 * name是class文件的包名和类名,如：com.classloader.Test
	 * 方法返回Test.class
	 * @param name
	 * @return
	 */
	public String getFileName(String name){
		int index = name.lastIndexOf(".");
		if(index==-1){
			return name+".class";
		}else{
			return name.substring(index+1)+".class";
		}
	}
}
