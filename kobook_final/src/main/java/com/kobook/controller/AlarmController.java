package com.kobook.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.kobook.alarm.domain.AlarmVO;
import com.kobook.alarm.service.AlarmService;


@Controller
public class AlarmController {

/*	@Autowired
	private JavaMailSender mailSender;*/
	
	@Inject
	private AlarmService service;
	
	@RequestMapping(value="/alarmList", method=RequestMethod.GET)
	public String alarmView(HttpServletRequest request) throws Exception {
		System.out.println("controller - view");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<AlarmVO> alarmList = service.alarmListService(person_id);
		request.setAttribute("alarmList", alarmList);
		
		return "/person/alarm";
	}
	
	@RequestMapping(value="/alarmUpdate", method=RequestMethod.GET)
	public String alarmUpdate(HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		System.out.println("controller - update");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<AlarmVO> alarmList = service.alarmListService(person_id);
		rttr.addFlashAttribute("alarmList", alarmList);
		
		service.alarmUpdateService(person_id);
		
		return "redirect:/recom";
	}
}
