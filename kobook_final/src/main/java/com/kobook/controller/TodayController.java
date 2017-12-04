package com.kobook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kobook.today.service.TodayService;

@Controller
@RequestMapping("/include/*")
public class TodayController {
	
	@Inject
	private TodayService todayService;
	
	@ResponseBody
	@RequestMapping(value="todayDonateViewList")
	public List<HashMap<String, Object>> todayDonateViewList(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		List<HashMap<String, Object>> list = todayService.todayDonateViewList(person_id);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("todayBookViewList")
	public List<HashMap<String, Object>> todayBookViewList(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<HashMap<String, Object>> list = todayService.todayBookViewList(person_id);
		System.out.println(list);
		return list;
	}
	
}
