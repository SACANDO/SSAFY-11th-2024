package com.ssafy.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/hello")
public class HelloServlet2 extends HttpServlet {
	
	//적어도 응답을 처리하는 메서드 하나는 있어야 한다.
	//doGet doPost Service 중 하나
	
	//정적 서버 : 요청에 따른 파일을 보내주는 것
	//WAS : 요청에 따라서 응답을 매번 새로 생성
	
	private static final long serialVersionUID = 1L;

	
	//doGet 파라미터 -- 요청이 들어올 때 아래 객체를 만든다. 참조형으로. 프로그램을 실행항 때 이 두객체를 넘긴다. 그러면 응답이 변해 있고, 그 응답을 보내면 됨 
	// - request
	// - response 
	// 
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;characterset=URF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.write("""
				<html>
					<head><title>hello servlet</title></head>
					<body>hello</body>
				""");
	}
	
	
	
	
	
}
