package com.kobook.controller;



import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.service.FavoriteService;



@Controller
public class RecomController {
	
	@Inject
	private FavoriteService service;
	
	@RequestMapping(value="/recom", method = RequestMethod.GET)
	public String alarmList(Model model, HttpServletRequest request) throws Exception {
		System.out.println("controller - recom");
		request.getAttribute("alarmList");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<FavoriteBookVO> favoriteList = service.getFavorite(person_id);
		
		request.setAttribute("list", favoriteList);
		
		return "/main";
	}

}
