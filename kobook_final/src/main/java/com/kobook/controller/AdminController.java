package com.kobook.controller;



import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


import com.kobook.admin.domain.VisitVO;
import com.kobook.admin.service.VisitService;



@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger =
			LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private VisitService service;
	
	 
	@RequestMapping("/adminMain")
	public String admin()throws Exception {
		return "/admin/adminMain";
	}
	

}
