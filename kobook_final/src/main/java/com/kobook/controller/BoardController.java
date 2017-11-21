package com.kobook.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.board.domain.BoardVO;
import com.kobook.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService service;
	
	@RequestMapping(value="/noti_insert",method=RequestMethod.GET)
	public void notiGET(BoardVO board, Model model)throws Exception{
	}
	
}
