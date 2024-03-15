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
public class MyFilter1 extends HttpFilter implements Filter {

	public FilterConfig fConfig;

	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 서버에 가기 전 필요한 코드 작성
		System.out.println("서블릿 전1");
		String encoding = this.getFilterConfig().getInitParameter("encoding");

		/// 다음 필터로 전달!
		// 다음 필터가 없으면 서블릿으로 간다.
		// doFilter은 꼭 써야 된다.
		chain.doFilter(request, response);

		// 사용자에게 가기전 필요한 코드 작성
		System.out.println("서블릿 후1");
	}

	public void destroy() {
	}
}
