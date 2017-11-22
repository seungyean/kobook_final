package com.kobook.login.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kobook.login.service.PersonService;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Inject
	private PersonService service;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();

		String person_email = request.getParameter("person_email");
		String person_pwd = request.getParameter("person_pwd");
		

		int person_id = service.findPersonId(person_email);
		
		session.setAttribute("person_email", person_email);
		session.setAttribute("person_pwd", person_pwd);
		session.setAttribute("person_id", person_id);

		
/*		ModelMap modelMap = modelAndView.getModelMap();
		Object personVO = modelMap.get("personVO");*/
		
/*		if(personVO != null) {
			session.setAttribute("login", personVO);
			response.sendRedirect("/");
		}*/
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") != null){
			session.removeAttribute("login");
		}
		return true;
	}

	
}
