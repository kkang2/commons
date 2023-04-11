package com.mybatis.common;

import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqlSessionFactoryManager {
	SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactoryManager() throws Exception {
		Properties properties = CommonUtil.getProperties("config/config.properties");
		String resource = properties.getProperty("mybatis.db.config.dir");
		
		log.debug("resource : {}", resource);
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
