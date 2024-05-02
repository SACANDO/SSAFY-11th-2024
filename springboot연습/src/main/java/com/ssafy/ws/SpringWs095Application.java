package com.ssafy.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication

@MapperScan(basePackages = "com.ssafy.ws.model.dao")
public class SpringWs095Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWs095Application.class, args);
	}

}
 