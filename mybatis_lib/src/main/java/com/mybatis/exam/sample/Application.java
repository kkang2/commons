package com.mybatis.exam.sample;

import java.util.Map;

import com.mybatis.exam.sample.domain.Shop;

public class Application extends SqlMapper {
	public Shop view(Map<String, Object> parameters) throws Exception {
		return selectOne("select", parameters, "org.mybatis.domain.Shop");
	}
}
