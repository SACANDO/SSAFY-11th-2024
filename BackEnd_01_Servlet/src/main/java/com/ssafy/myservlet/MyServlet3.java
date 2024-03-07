package com.ssafy.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet3 extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	//doXXXX은 적어도 한개는 만들어야 해
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 요청을 받음");
		
		
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		writer.write("<html><body><h1>hello</h1></body></html>");
		System.out.println("출력 완료");

	}
	

}
