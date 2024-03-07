package com.safy.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/make")
public class MakeCookie extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		
		//쿠키 만들기
		Cookie cookie = new Cookie(key,value);

		
		//유효시간(만료단위) : 초단위
		cookie.setMaxAge(60);
		
		//쿠키는 remove메소드가 없다. 
//		cookie.setMaxAge(0); // 쿠키 삭제 방법
		
		//사용자에게 어떻게 돌려줘
		resp.addCookie(cookie);
		resp.sendRedirect(req.getContextPath()+"/02_CookieResult.jsp");
		
		
	}
}
