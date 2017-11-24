package com.kobook.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kobook.alarm.service.AlarmService;


@RestController
public class AlCntController {

	@Inject
	private AlarmService service;

	@RequestMapping(value = "/alarmCount", method = RequestMethod.GET)
	public int alarmCount(HttpServletRequest request) throws Exception {
		System.out.println("controller - alarmCount");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		int alarm_new = service.alarmCount(person_id);
		System.out.println(alarm_new);
		return alarm_new;
	}
}
