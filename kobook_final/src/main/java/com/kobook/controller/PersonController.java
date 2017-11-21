package com.kobook.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.login.DTO.LoginDTO;
import com.kobook.login.service.PersonService;
import com.kobook.person.domain.PersonVO;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Inject
	private PersonService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {
		
	}
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		PersonVO vo = service.login(dto);
		
		if(vo == null){
			return ;
		}
		
		model.addAttribute("PersonVO", vo);
	}
}
