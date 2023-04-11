package com.mybatis.exam.real;

import com.mybatis.common.SqlSessionFactoryManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
	public static void main(String[] args) throws Exception {
		SqlSessionFactoryManager manager = new SqlSessionFactoryManager();
		
		log.debug("{}", manager.getSqlSessionFactory());
	}
}