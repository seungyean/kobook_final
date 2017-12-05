package com.kobook.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.login.DTO.LoginDTO;
import com.kobook.person.service.PersonService;
import com.kobook.today.service.TodayService;
import com.kobook.person.domain.PersonVO;

@Controller
@RequestMapping("/person/*")
public class PersonController {

	@Inject
	private PersonService service;
	
	@Inject
	private TodayService todayService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) throws Exception {

	}
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpServletRequest request, Model model) throws Exception {
		PersonVO vo = service.login(dto);

		if(vo == null){
			return ;
		}
		
		model.addAttribute("PersonVO", vo);
	}
	
	@RequestMapping(value = "/loginFail", method = RequestMethod.GET)
	public String loginFail() throws Exception {
		return "/person/loginFail";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("logout");
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		todayService.todayAllRemoveByPersonId(person_id);
		
		session.removeAttribute("person_id");
		session.removeAttribute("person_email");
		session.removeAttribute("person_pwd");
		 
		session.invalidate();
		

		return "redirect:/";
	}
	

}
