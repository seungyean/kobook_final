package com.kobook.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.admin.domain.MonthPayVO;
import com.kobook.admin.domain.VisitVO;
import com.kobook.admin.persistence.VisitDAO;
import com.kobook.admin.service.PayService;
import com.kobook.admin.service.VisitService;
import com.kobook.board.domain.BoardVO;



@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger =
			LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private VisitService visitservice;
	
	@Inject
	private PayService payservice;
	

	private static int count;
	
	public static int getCount(){
		return count;
	}

	 
	@RequestMapping("/adminMain")
	public String visitCount(Model model) throws Exception {
		
		//총 접속자
/*		model.addAttribute("visit",visitservice.visitCount());*/
		return "admin/adminMain";
	}
	
	@RequestMapping(value="/adminChart")
	public String adminChart() {
		return "admin/adminMain";
	}
	
	@RequestMapping(value="/notiList", method=RequestMethod.GET)
	public void notiListGET(Model model)throws Exception{
	}
	
	@RequestMapping(value="/notiList", method=RequestMethod.POST)
	public String notiListPOST(Model model)throws Exception {
		
		return "admin/notiList";
	}
	
	@RequestMapping(value="/payList", method=RequestMethod.GET)
	public void payListGET(Model model)throws Exception{
	}
	
	@RequestMapping(value="/payList", method=RequestMethod.POST)
	public String payListPOST(Model model)throws Exception {
		
		
		return "admin/payList";
	}
	
	@RequestMapping(value="/analyze", method=RequestMethod.GET)
	public void analyzeGET(Model model)throws Exception{
	}
	
	@RequestMapping(value="/analyze", method=RequestMethod.POST)
	public String analyzePOST(Model model)throws Exception {
		
		System.out.println();
		
		return "admin/analyze";
	}
	

}

