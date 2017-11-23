package com.kobook.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("auth - pre");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("person_id") != null){
			
			response.sendRedirect("/home");		//수정 부분!!!
			return false;
		}
		//saveDest(request);
		return true;
	}

	
}
