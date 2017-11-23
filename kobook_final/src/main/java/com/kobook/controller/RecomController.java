package com.kobook.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.alarm.domain.AlarmVO;
import com.kobook.alarm.service.AlarmService;


@Controller
public class RecomController {

	@Inject
	private AlarmService service;
	
	@RequestMapping(value="/recom", method = RequestMethod.GET)
	public String alarmList(Model model, HttpServletRequest request) throws Exception {
		System.out.println("controller - recom");
		request.getAttribute("alarmList");
		return "/main";
	}

}
