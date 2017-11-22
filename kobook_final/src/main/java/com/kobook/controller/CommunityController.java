package com.kobook.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.community.domain.BlackVO;
import com.kobook.community.service.BlackService;

@Controller
@RequestMapping("/community/*")
public class CommunityController {
	
	@Inject
	private BlackService service;
	
	@RequestMapping(value="blackRegist", method=RequestMethod.GET)
	public void blackRegistGet()throws Exception{
		
	}
	
	@RequestMapping(value="blackRegist", method=RequestMethod.POST)
	public void blackRegistPost(BlackVO vo, Model model)throws Exception{
		System.out.println("try");
		service.blackRegist(vo);
		System.out.println("success");
		
	}
	
}
