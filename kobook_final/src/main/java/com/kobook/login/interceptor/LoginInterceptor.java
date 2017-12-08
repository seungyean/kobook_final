package com.kobook.login.interceptor;



import java.util.Hashtable;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kobook.admin.service.VisitService;
import com.kobook.person.service.PersonService;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Inject
	private PersonService service;
	
	@Inject
	private VisitService visitservice;

	private static Hashtable loginPersons = new Hashtable();
		
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("===================post����");
		
		String parentURI = request.getParameter("parentURI");
		
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
				System.out.println("login admin");
				response.sendRedirect("/admin/adminMain");
			}
			
			else if(person_email.equals(person_emailCheck) && person_pwd.equals(person_pwdCheck)){
				session.setAttribute("person_id", person_id);
				
				visitservice.visitRegist(Integer.parseInt(person_id));
				System.out.println("로그인한 회원번호: "+person_id);
				
				if(!parentURI.equals("http://localhost:8081/#")){
					response.sendRedirect(parentURI != null ? parentURI:"/");
				}

			}else{
				response.sendRedirect("/person/loginFail");
			}
		}
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("==================pre����");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") != null){
			session.removeAttribute("login");
		}
		return true;
	}
	
}
