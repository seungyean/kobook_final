package com.kobook.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.admin.domain.VisitVO;
import com.kobook.admin.service.VisitService;
import com.kobook.board.domain.BoardVO;
import com.kobook.board.service.BoardService;
import com.kobook.book.domain.PageMaker;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.person.domain.PersonVO;


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
	
	@RequestMapping("/visitTotal")
	public void visitTotal(VisitVO vo)throws Exception {
		service.visitTotal(vo);
	}

}
