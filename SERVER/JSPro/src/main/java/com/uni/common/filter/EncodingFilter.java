package com.uni.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(filterName="encodingFilter", urlPatterns="/*") //어노테이션으로도 가능하다.
public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("인토딩 필터 동작 ");
		
		//post 인 경우에만 request set 인코딩 해주면 된다.
		// 서블릿이 실행되기전에 실행할 내용작성
		if(((HttpServletRequest)request).getMethod().equalsIgnoreCase("post")) {
			System.out.println("post방식요청됨");
			request.setCharacterEncoding("utf-8"); //인코딩 처리
		}
		
		//실행이 되고나서 서블릿이 호출되는것은 chain.doFilter 이후.
		chain.doFilter(request, response);
		
		System.out.println("===서블릿이 다동작하고 나서 출력됨"); // 다른 필터가 없다면 바로 서블릿이 동작 된다.
	}

}
