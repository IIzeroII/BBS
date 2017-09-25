package com.bbs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterFilter implements Filter{
	String charset;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
//      request.setCharacterEncoding("utf-8");这里的设置编码写死了  
		request.setCharacterEncoding(charset); //更灵活，可在xml中配置编码
		response.setCharacterEncoding(charset);
		
		chain.doFilter(request, response);   //放行，不然将拦截在这里
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		charset=config.getInitParameter("charset");  
	}

}
