package com.kobook.login.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kobook.person.service.PersonService;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Inject
	private PersonService service;
	
	public void saveDest(HttpServletRequest request) {
		System.out.println("saveDest");
		String uri = request.getHeader("referer");
		String query = request.getQueryString();
		
		if(query == null || query.equals("null")){
			query = "";
		}else {
			query = "?" + query;
		}
		
		
		request.getSession().setAttribute("dest", uri+query);
		
		if(request.getMethod().equals("GET")){
			
		}
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("===================post시작");
		
		HttpSession session = request.getSession();

		String person_email = request.getParameter("person_email");
		String person_pwd = request.getParameter("person_pwd");

		String person_emailCheck = service.loginCheck(person_email).getPerson_email();
		String person_pwdCheck = service.loginCheck(person_email).getPerson_pwd();
		
		
		if(service.loginCheck(person_email) != null) {
			System.out.println("login Check");
			String person_id = service.findPersonId(person_email)+"";
			
			session.setAttribute("person_email", person_email);
			session.setAttribute("person_pwd", person_pwd);
			session.setAttribute("person_id", person_id);
			
			
			
			if(person_email.equals("admin@kobook.com") && person_pwd.equals("0000")){
				session.setAttribute("person_id", person_id);
			}
			
			else if(person_email.equals(person_emailCheck) && person_pwd.equals(person_pwdCheck)){
				session.setAttribute("person_id", person_id);
				Object dest = session.getAttribute("dest");
				System.out.println((String)dest);
				//response.sendRedirect(dest != null ? (String)dest:"/");

			}else{
				response.sendRedirect("/person/loginFail");
			}
		}
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("==================pre시작");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") != null){
			session.removeAttribute("login");
		}
		return true;
	}

	
}
