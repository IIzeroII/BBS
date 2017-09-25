package com.bbs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSecureFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//强转为Http请求响应对象
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//获取请求地址
		String uri = req.getRequestURI();
		if(null != req.getSession().getAttribute("user") || uri.contains("login") || uri.contains("register") || uri.contains("error")){
			chain.doFilter(request, response);  //放行
			System.out.println("放行");
			return;
		}
		System.out.println("踢回登录页");	
		if(null == req.getSession().getAttribute("user")){  //用户没有登录----踢回登录页面
			//重定向要用绝对路径，跳回根目录 /bbs
			resp.sendRedirect(req.getContextPath());
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
