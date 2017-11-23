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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.alarm.domain.AlarmVO;
import com.kobook.alarm.service.AlarmService;


@Controller
public class AlarmController {

	@Inject
	private AlarmService service;
	
	@RequestMapping(value="/alarmList", method=RequestMethod.GET)
	public String alarmList(HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		System.out.println("controller - list");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<AlarmVO> alarmList = service.alarmListService(person_id);
		
		rttr.addFlashAttribute("alarmList", alarmList);
		
		return "redirect:/recom";
	}
	
	@RequestMapping(value="/alarmUpdate", method=RequestMethod.POST)
	public String alarmUpdate(HttpServletRequest request) throws Exception {
		System.out.println("controller - update");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		service.alarmUpdateService(person_id);
		
		return "redirect:/alarmList";
	}

}
