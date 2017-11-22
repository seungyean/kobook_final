package com.kobook.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kobook.mypage.service.MyPageService;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {
	
	@Inject
	private MyPageService service;
	
	@RequestMapping(value="/sellList", method=RequestMethod.GET)
	public void sellList(int person_id, Model model){
//		public void sellList(@RequestParam("person_id") int person_id, Model model){
		System.out.println("판매내역 출력~~~~~~~~~~~");
		
		model.addAttribute("sellList", service.sellList(person_id));
	}
	
	@RequestMapping(value="/buyList", method=RequestMethod.GET)
	public void buyList(int person_id, Model model){
		System.out.println("구매내역 출력~~~~~~~~~~~");
		
		model.addAttribute("buyList", service.buyList(person_id));
	}
	
	

}
