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


//알람 리스트 및 알람의 갯수 업데이트 하는 컨트롤러
//모든 알람 관련 정보는 이 컨트롤러로 넘어온다.

@Controller
public class AlarmController {
	
	@Inject
	private AlarmService service;
	
	
	//새로운 알림을 클릭했을 때 보여지는 알람 리스트 추출
	@RequestMapping(value="/alarmList", method=RequestMethod.GET)
	public String alarmView(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<AlarmVO> alarmList = service.alarmListService(person_id);
		request.setAttribute("alarmList", alarmList);
		
		return "/person/alarm";
	}
	
	
	//알림의 조회여부를 업데이트 하는 역할. 알림 갯수를 업데이트 한다.
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
