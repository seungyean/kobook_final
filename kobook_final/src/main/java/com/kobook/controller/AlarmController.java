package com.kobook.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.alarm.domain.AlarmVO;
import com.kobook.alarm.service.AlarmService;


@Controller
public class AlarmController {

	@Inject
	private AlarmService service;
	
	@RequestMapping(value="/alarmList", method=RequestMethod.GET)
	public void alarmList(Model model, HttpServletRequest request) throws Exception {
		System.out.println("controller - list");
		
		HttpSession session = request.getSession();
		int person_id = (int)session.getAttribute("person_id");
		
		List<AlarmVO> alarmList = service.alarmListService(person_id);
	}
	
	@RequestMapping(value="/alarmUpdate", method=RequestMethod.POST)
	public String alarmUpdate(AlarmVO alarmVO) throws Exception {
		System.out.println("controller - update");
		service.alarmUpdateService(alarmVO);
		
		return "redirect:/alarmList";
	}

}
