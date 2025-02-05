package com.ssafy.board.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {
	//공장 세워서 계속 불러다 쓸꺼야!
	
	private static SqlSessionFactory factory;
	
	static {
		//공장을 세워야하는데 설정파일(자원) 위치
		String resource = "config/mybatis-config.xml";
		try(InputStream inputStream = Resources.getResourceAsStream(resource)) {
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("공장 건설 완료");
		} catch (IOException e) {
			System.out.println("공장 건설 실패");
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
