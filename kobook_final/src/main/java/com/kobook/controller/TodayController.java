package com.kobook.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kobook.sidebar.service.TodayService;

@Controller
@RequestMapping("/include/*")
public class TodayController {
	
	@Inject
	private TodayService todayService;
	
	//무료나눔 오늘 본 상품 리스트 출력
	@ResponseBody
	@RequestMapping(value="todayDonateViewList")
	public List<HashMap<String, Object>> todayDonateViewList(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		List<HashMap<String, Object>> list = todayService.todayDonateViewList(person_id);
		return list;
	}
	
	//도서관련 오늘 본 상품 리스트 출력
	@ResponseBody
	@RequestMapping("todayBookViewList")
	public List<HashMap<String, Object>> todayBookViewList(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<HashMap<String, Object>> list = todayService.todayBookViewList(person_id);
		System.out.println(list);
		return list;
	}
	
	//오늘 본 상품 삭제
	@ResponseBody
	@RequestMapping(value="todayRemove/{today_id}", method=RequestMethod.GET)
	public String todayRemove(@PathVariable("today_id") int today_id) throws Exception {
		todayService.todayRemove(today_id);		
		return "success"; 
	}
	
}
