package com.kobook.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.mypage.service.MyPageService;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {
	
	@Inject
	private MyPageService service;
	
	@RequestMapping(value="/sellList", method=RequestMethod.GET)
	public void sellList(int bno, Model model){
		System.out.println("판매내역 출력~~~~~~~~~~~");
		
		model.addAttribute("sellList", service.sellList(bno));
	}
	

}
