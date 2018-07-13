package com.java.spring.propertiesutils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtils{
	
	/**
	 * 加载类路径下的properties文件
	 * @param propertiesName
	 * @return
	 * @throws IOException
	 */
	public static Properties loadClassPathProperties(String propertiesName) throws IOException{
		ClassLoader classLoader = PropertiesUtils.class.getClassLoader();
		Properties properties = PropertiesLoaderUtils.loadAllProperties(propertiesName, classLoader);
		return properties;
	}
	
	public static void main(String[] args) throws IOException {
		Properties properties = loadClassPathProperties("properties");
		//System.out.println(properties);
	}
}
