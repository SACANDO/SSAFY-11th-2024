package com.ssafy.mvc.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;


/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter2 extends HttpFilter implements Filter {

	public FilterConfig fConfig;
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig=fConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 서버에 가기 전 필요한 코드 작성
		System.out.println("서블릿 전2");
		chain.doFilter(request, response);
		// 사용자에게 가기전 필요한 코드 작성
		System.out.println("서블릿 후2");

	}

	public void destroy() {
	}
}
