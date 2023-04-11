package com.mybatis.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtil {
	public static Properties getProperties(String propertyFilePath) throws Exception {
		Properties configuration = new Properties();
		ClassLoader contextClassLoader = null;
		InputStream inputStream = null;
		
		try {
			contextClassLoader = Thread.currentThread().getContextClassLoader();
			inputStream = contextClassLoader.getResourceAsStream(propertyFilePath);
			configuration.load(inputStream);
		} catch (IOException e) {
			throw e;
		} finally {
			try{inputStream.close();} catch(Exception e) {}
		}
		
		return configuration;
	}
}
