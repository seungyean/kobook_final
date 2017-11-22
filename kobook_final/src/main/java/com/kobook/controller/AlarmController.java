package com.kobook.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.board.service.BoardService;


@Controller
public class AlarmController {

	@Inject
	private BoardService service;
	
	@RequestMapping(value="/alarmCheck", method=RequestMethod.POST)
	public void alarmList(Model model) throws Exception {
		
	}

}
